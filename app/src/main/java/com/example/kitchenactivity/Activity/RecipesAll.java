package com.example.kitchenactivity.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kitchenwizard2.Login;
import com.example.kitchenwizard2.R;

import java.util.List;

import Recipes_Domain.RecipeAdaptor;
import Recipes_Domain.RecipeUtils;
import Recipes_Domain.Recipes;

public class RecipesAll extends AppCompatActivity implements RecipeAdaptor.OnItemClickListener {

    private RecyclerView recyclerView;
    private RecipeAdaptor recipeAdaptor;
    private ConstraintLayout home;
    private ConstraintLayout recipes;
    private ConstraintLayout login;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.recipes_all);
        ////////////////////////////////////////////////////////////////
        home=findViewById(R.id.home1);
        recipes=findViewById(R.id.home2);
        login =findViewById(R.id.home4);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecipesAll.this,MainActivity.class));
            }
        });
        recipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecipesAll.this, RecipesAll.class));
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecipesAll.this, Login.class));
            }
        });
        ///////////////////////////////////////////////////////////////
        // Sample JSON data
        String jsonData = "{ \"recipes\": [ " +
                "{" +
                "\"name\": \"Supă de dovleac gatita lent\"," +
                "\"image\": \"supa_dovleac2\"," +
                "\"ingredients\": [" +
                "\"2 lingurite de ulei de rapita\"," +
                "\"3 cepe (480g), tocate\"," +
                "\"30g de ghimbir, decojit si tocat\"," +
                "\"3 catei mari de usturoi, tocati\"," +
                "\"1½-2 linguri de pudră de curry medie\"," +
                "\"1 lingurita de coriandru, macinat\"," +
                "\"½ lingurita de ardei iute uscat, zdrobit (optional)\"," +
                "\"1 kg de dovleac (doar miezul), taiat cubulete\"," +
                "\"1 lingurita de pudra de bullion de legume\"," +
                "\"400g lapte de cocos\"," +
                "\"180g linte rosie uscata\"," +
                "\"15g coriandru, tocat\"" +
                "]," +
                "\"steps\": \"Încingeti uleiul într-o tigaie mare la foc mediu și prăjiti ceapa și ghimbirul timp de 10 minute, amestecând din când în când până se înmoaie și încep să se coloreze. Adăugați usturoiul, pudra de curry, coriandrul măcinat și ardeiul iute uscat, dacă folosiți, și gătiți încă 1 minut. Puneți amestecul într-o oală mare cu fierbere lentă împreună cu toate ingredientele rămase, cu excepția coriandrului proaspăt. Adăugați 2 litri de apă. Gatiti 8 ore la foc mare sau peste noapte timp de 15 ore la foc mic. Amestecați bine folosind un tel până când se omogenizează. Se pune în boluri și se adaugă peste coriandrul proaspăt pentru a se servi.\"," +
                "\"calories\": 260," +
                "\"difficulty\": 2" +
                "}," +
                "{" +
                "\"name\": \"Cartofi frantuzesti la cuptor\"," +
                "\"image\": \"cartofi_frantuzesti2\"," +
                "\"ingredients\": [" +
                "\"1,2kg cartofi spalati si periati bine\"," +
                "\"4 ouă\"," +
                "\"3 linguri unt\"," +
                "\"2 linguri parmesan raz\"," +
                "\"1/2 lingurite piper negru macinat\"," +
                "\"sare dupa gust\"," +
                "\"1 cană smântână dulce slabă (15% grăsime)\"," +
                "\"100g brânză frământată, cașcaval, brânză burduf (optional)\"," +
                "\"100g de afumatură taiată felioare subțiri (optional)\"" +
                "]," +
                "\"steps\": \"Cartofii întregi, cu tot cu coajă, spălați bine, se pun la fiert în 2 litri de apă cu o linguriță de sare. După circa 40 de minute, se verifică dacă sunt fierți cu o furculiță, dacă aceasta intră ușor, sunt gata. Se iau de pe foc, se răcesc sub jet de apă rece, apoi se curăță de coajă. În timp ce cartofii fierb, se pun și ouăle la fiert cu puțină sare și cu apă cât să le acopere. Se fierb 8-9 minute, apoi se scot și se răcesc sub jet de apă rece. Se curăță de coajă. Se unge vasul în care vom coace cartofii cu 2 linguri de unt. Se pornește cuptorul și se încinge la 180°C. Se taie atât cartofii cât și ouăle în felii de 0,5 cm. Se așează un strat de cartofi pe fundul vasului termorezistent uns bine cu unt, presărând sare și piper măcinat, apoi un strat de ouă feliate. Peste ouă, presărăm un strat subțire de brânză frământată. Se așează un nou strat de cartofi feliați, încă un strat de ouă, și un strat de brânză. După ce toate straturile sunt aranjate, deasupra se toarnă smântâna și se presară uniform parmezanul. Se introduce tava în cuptorul preîncins la 180°C pentru 30-35 minute, până când cartofii încep să se rumenească frumos pe deasupra.\"," +
                "\"calories\": 450," +
                "\"difficulty\": 1" +
                "}," +
                "{" +
                "\"name\": \"Supa crema de cartofi\"," +
                "\"image\": \"supa_crema_de_cartofi2\"," +
                "\"ingredients\": [" +
                "\"1300 g cartofi\"," +
                "\"1 buc morcov\"," +
                "\"1/2 buc ceapă\"," +
                "\"3 căței usturoi\"," +
                "\"40 g unt\"," +
                "\"după necesitate apă caldă\"," +
                "\"350 g smântână de gătit\"," +
                "\"după gust sare și piper\"," +
                "\"după preferințe crutoane condimentate\"" +
                "]," +
                "\"steps\": \"Se taie morcovul în rondele, ceapa și usturoiul mărunțite. Se pun într-o oală cu unt și se lasă până se cristalizează ușor. Cartofii se taie cuburi. După ce ingredientele încep să se cristalizeze, se adaugă apă până când acoperă toate ingredientele. Se lasă să fiarbă și între timp se pregătesc crutoanele și se taie pătrunjelul. Crutoanele se condimentează după gust. Când legumele au fiert, se adaugă smântână și se amestecă. Se lasă pe foc încă un minut. Dacă lichidul este prea mult, se poate elimina, sau se adaugă mai mult dacă e prea puțin. Se scoate pătrunjelul din oală. Se pasează compoziția cu un blender de mână până se omogenizează. Se adaugă sare și piper după gust.\"," +
                "\"calories\": 244," +
                "\"difficulty\": 2" +
                "}," +
                "{" +
                "\"name\": \"Musaca de vinete si cartofi\"," +
                "\"image\": \"musaca_de_vinete_si_cartofi\"," +
                "\"ingredients\": [" +
                "\"800 g carne tocată (mix vită și porc)\"," +
                "\"1 ceapă mare albă\"," +
                "\"1/2 pahar vin alb demisec (cca 70 ml)\"," +
                "\"4 ouă medii\"," +
                "\"2-3 linguri ulei de masline\"," +
                "\"după gust sare și piper\"," +
                "\"4-5 cartofi mari roșii\"," +
                "\"2 vinete mari\"," +
                "\"3 roșii mari\"," +
                "\"ulei de floarea-soarelui\"" +
                "]," +
                "\"steps\": \"Intr-o tigaie antiaderenta, punem 2-3 linguri de ulei de masline. Cand uleiul este incins, adaugam o ceapa tocata foarte marunt si o sotam pana devine translucida. Adaugam carnea tocată, o amestecăm cu ceapa și o lasăm pe foc mic până ce își schimbă culoarea. Adăugăm vinul alb demisec și lăsăm până când alcoolul se evaporă complet. Potrivim de sare și piper, stingem focul, și lăsăm carnea să se răcească complet. Curățăm cartofii, îi spălăm, și îi tăiem în felii foarte subțiri. La fel și vinetele. Pudrăm cu sare feliile de cartofi și vinete și le prăjim în tigăi separate cu ulei abundent. După ce prăjim cartofii și vinetele, îi punem pe hârtie absorbantă pentru a elimina excesul de ulei. Amestecăm carnea rece cu 4 ouă bătute ușor. Formăm un strat de cartofi prăjiți într-o formă de 25×30 cm. Peste acesta, adăugăm carnea tocată, apoi feliile de vinete, și feliile de roșii. Se coace la 180°C timp de 45 de minute. După ce scoatem musacaua din cuptor, putem elimina uleiul în exces.\"," +
                "\"calories\": 285," +
                "\"difficulty\": 3" +
                "}," +
                "{" +
                "\"name\": \"Supa crema de legume\"," +
                "\"image\": \"musaca_de_vinete_si_cartofi\"," +
                "\"ingredients\": [" +
                "\"1 ceapă medie\"," +
                "\"4 morcovi medii\"," +
                "\"1 rădăcină pătrunjel\"," +
                "\"1 rădăcină păstârnac\"," +
                "\"1 tulpină țelină Apio (optional)\"," +
                "\"1 legătură mică pătrunjel\"," +
                "\"2 felii de rădăcină de țelină\"," +
                "\"10 roșii cherry/2 roșii medii\"," +
                "\"3 cartofi roșii medii\"," +
                "\"100 g mazăre (optional)\"," +
                "\"sare si piper macinat după gust\"," +
                "\"50 g unt (optional)\"" +
                "]," +
                "\"steps\": \"Curățăm legumele și le tăiem în bucăți potrivite. Umplem o oală cu 4 litri de apă, adăugăm legumele, și fierbem până când sunt complet pătrunse. Se scot legumele, se pasează, și se adaugă înapoi în oală, unde se fierb încă 10 minute. Între timp, se prepară crutoanele cu pâine rustică, ulei, și unt. Se prăjesc până când devin crocante și se condimentează după gust.\"," +
                "\"calories\": 140," +
                "\"difficulty\": 2" +
                "}," +
                "{" +
                "\"name\": \"Mancarica de cartofi cu piept de pui\"," +
                "\"image\": \"mancare_de_cartofi4\"," +
                "\"ingredients\": [" +
                "\"350 g piept de pui\"," +
                "\"8-9 cartofi\"," +
                "\"2 morcovi\"," +
                "\"1/2 ardei roșu\"," +
                "\"1/2 ardei galben\"," +
                "\"1 ceapă mare\"," +
                "\"180 ml bulion\"," +
                "\"după gust sare și piper\"" +
                "]," +
                "\"steps\": \"Se toacă mărunt ceapa, ardeii și morcovii, apoi se călesc într-o tigaie cu puțin ulei. Pieptul de pui și cartofii se taie cubulețe și se fierb până când sunt pătrunși. După 15 minute, adăugăm ceapa, ardeii și morcovii. Se fierb încă 10-12 minute, apoi se condimentează după gust și se presară pătrunjel verde tocat deasupra.\"," +
                "\"calories\": 205," +
                "\"difficulty\": 2" +
                "}," +
                "{" +
                "\"name\": \"Pulpe de pui la cuptor cu cartofi si morcov\"," +
                "\"image\": \"mancare_de_cartofi4\"," +
                "\"ingredients\": [" +
                "\"1 kg cartofi\"," +
                "\"2 cepe albe\"," +
                "\"2 morcovi\"," +
                "\"1 lingura boia de ardei dulce\"," +
                "\"0.25 lingurite piper negru\"," +
                "\"1 lingurita sare\"," +
                "\"1 lingurita oregano uscat\"," +
                "\"100 ml ulei de măsline\"," +
                "\"1 kg pulpe de pui\"" +
                "]," +
                "\"steps\": \"Carnea de pui se spală și se amestecă cu sare, piper negru, și boia. Legumele se spală, se curăță, și se taie în bucăți. Se pun în tava de cuptor, se adaugă mirodenii, și se coace timp de 1 oră la 200°C.\"," +
                "\"calories\": 345," +
                "\"difficulty\": 3" +
                "}," +
                "{" +
                "\"name\": \"Prajiturele cu fulgi de ovaz si zmeura\"," +
                "\"image\": \"prajiturele_cu_fulgi_de_ovaz_si_zmeura\"," +
                "\"ingredients\": [" +
                "\"2 albușuri\"," +
                "\"2 linguri făină neagră\"," +
                "\"50 g fulgi de ovăz\"," +
                "\"30 g zmeură\"," +
                "\"1 lingură fulgi de cocos\"," +
                "\"1 linguriță ulei de cocos\"," +
                "\"1 banană coaptă\"" +
                "]," +
                "\"steps\": \"Bate albușurile cu un mixer. Pasează banana și amestecă cu uleiul de cocos. Încorporează în albușuri fulgii de ovăz, făina, și banana amestecată cu ulei. Adaugă zmeura și amestecă ușor. Lăsă compoziția 30 minute la frigider, apoi coace la 160°C timp de 25 minute.\"," +
                "\"calories\": 166," +
                "\"difficulty\": 1" +
                "}," +
                "{" +
                "\"name\": \"Clatite cu zmeura\"," +
                "\"image\": \"clatite_zmeura\"," +
                "\"ingredients\": [" +
                "\"2 ouă\"," +
                "\"50 g unt\"," +
                "\"250 ml lapte\"," +
                "\"300 g făină\"," +
                "\"sirop de arțar\"," +
                "\"zmeură și afine\"" +
                "]," +
                "\"steps\": \"Se amestecă ouăle cu untul topit, laptele, și siropul de arțar. Se adaugă făina cernută și se continuă amestecarea până devine omogenă. Se coace în tigaie antiaderentă, se adaugă fructe, și se prăjește timp de 2-3 minute pe fiecare parte.\"," +
                "\"calories\": 295," +
                "\"difficulty\": 2" +
                "}," +
                "{" +
                "\"name\": \"Briose cu ciocolata si zmeura\"," +
                "\"image\": \"briose\"," +
                "\"ingredients\": [" +
                "\"200 g făină\"," +
                "\"50 g cacao\"," +
                "\"150 g ciocolată neagră\"," +
                "\"2 ouă\"," +
                "\"120 ml ulei\"," +
                "\"240 ml iaurt\"," +
                "\"150 g zahăr\"," +
                "\"2 lingurițe esență de vanilie\"," +
                "\"1 linguriță praf de copt\"," +
                "\"zmeură\"" +
                "]," +
                "\"steps\": \"Amestecă făina cu cacao, esența de vanilie, și praf de copt. Bate ouăle cu zahărul, uleiul, și iaurtul. Încorporează amestecul de făină și omogenizează. Toarnă în forme de brioșe și coace până când se rumenește, apoi lasă la răcit.\"," +
                "\"calories\": 456," +
                "\"difficulty\": 3" +
                "}" +
                "] }";// Add your JSON data here

        // Parse the JSON data to get the list of recipes
        List<Recipes> recipes = RecipeUtils.parseRecipes(jsonData);

        // Initialize the RecyclerView and set its layout manager
        recyclerView = findViewById(R.id.Recipes); // Update with correct ID
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        // Initialize the adapter with the recipe list and this activity as the click listener
        recipeAdaptor = new RecipeAdaptor(recipes, this);
        recyclerView.setAdapter(recipeAdaptor);
        List<Recipes> recipes1 = RecipeUtils.parseRecipes(jsonData);
        Log.d("RecipesAll", "Number of recipes: " + recipes.size());
    }

    @Override
    public void onItemClick(int position) {
        // Retrieve the selected recipe based on the clicked position
        Recipes recipe = recipeAdaptor.getRecipe(position);

        // Open a new activity to display recipe details
        Intent intent = new Intent(this, Recipe_Main.class);
        intent.putExtra("recipeName", recipe.getName());
        intent.putExtra("recipeIngredients", recipe.getIngredients());
        intent.putExtra("recipeSteps", recipe.getSteps());
        intent.putExtra("recipeCalories", recipe.getCalories());
        //intent.putExtra("recipeDifficulty", recipe.getDifficulty());
        intent.putExtra("image",recipe.getImag());
       // intent.putExtra("images",recipe.getImag_stanga1() );
        startActivity(intent);
    }
}
