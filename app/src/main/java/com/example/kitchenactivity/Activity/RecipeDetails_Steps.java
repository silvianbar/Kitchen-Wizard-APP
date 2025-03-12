//package com.example.kitchenactivity.Activity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.kitchenwizard2.R;
//import com.google.gson.Gson;
//
//import Recipes_Domain.Recipes;
//
//public class RecipeDetails_Steps extends AppCompatActivity {
//    private Button backButton;
//    private TextView textView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.reteta_pasi); // Ensure this layout file exists
//
//        // Setup back button
//        backButton = findViewById(R.id.button_homeREC1);
//        backButton.setOnClickListener(v -> startActivity(new Intent(this, RecipesAll.class)));
//        // JSON data string
//
//
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//        // Parse JSON data
////        TextView recipeName = findViewById(R.id.recipeName);
////        String naame=getIntent().getStringExtra("name");
////        TextView recipeSteps = findViewById(R.id.recipeSteps);
////        ImageView recipeImage = findViewById(R.id.pozafundal);
////        // Retrieve data from the intent
////        if (recipeName == null || recipeSteps == null || recipeImage == null) {
////            Log.e("RecipeDetails_Steps", "Referințele la componentele UI sunt invalide");
////            return;
////        }
////        JSONObject jsonObject = null;
////        try {
////            jsonObject = new JSONObject(jsonData);
////        } catch (JSONException e) {
////            throw new RuntimeException(e);
////        }
////        String message = null;
////        try {
////            message = jsonObject.getString("name");
////        } catch (JSONException e) {
////            throw new RuntimeException(e);
////        }
////        recipeName.setText(message);
////
////
////
////
////
////            // Log for debugging
////
////        }
////    }
////
