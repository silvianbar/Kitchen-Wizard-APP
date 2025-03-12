package Recipes_Domain;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RecipeUtils {

    public static List<Recipes> parseRecipes(String jsonStr) {
        List<Recipes> recipes = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(jsonStr); // The root JSON object
            JSONArray jsonArray = jsonObject.getJSONArray("recipes"); // The array of recipes

            // Loop through each recipe in the array
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonRecipe = jsonArray.getJSONObject(i); // Get the recipe object

                // Extract data from JSON and create a Recipe object
                String name = jsonRecipe.getString("name");
             //   String images=jsonRecipe.getString("images");
                String image = jsonRecipe.getString("image"); // Default to empty string
                String ingredients = jsonRecipe.getString("ingredients");
                String steps = jsonRecipe.getString("steps");
                String calories = jsonRecipe.getString("calories");
             // int difficulty = jsonRecipe.getInt("difficulty");


                // Create a new Recipe object and add it to the list
                Recipes recipe = new Recipes(name, ingredients, steps, calories, image);
                recipes.add(recipe);
            }
        } catch (JSONException e) {
            e.printStackTrace(); // Handle JSON parsing errors
        }


        return recipes; // Return the list of recipes
    }
}
