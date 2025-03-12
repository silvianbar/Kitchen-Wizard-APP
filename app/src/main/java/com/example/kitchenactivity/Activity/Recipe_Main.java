package com.example.kitchenactivity.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kitchenwizard2.R;

import Recipes_Domain.Recipes;


public class Recipe_Main extends AppCompatActivity {

    private Recipes recipe;
    private TextView contentTextView;
    private ImageView fundal;
private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_page);

        back = findViewById(R.id.button_homeREC1);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Recipe_Main.this, RecipesAll.class));
            }
        });
        fundal = findViewById(R.id.pozafundal);
        String imageName = getIntent().getStringExtra("image"); // This should be the actual drawable name as a string

        if (imageName != null) {  // Check if the string is not null
            // Get the drawable resource ID from the image name
            int drawableId = getResources().getIdentifier(imageName, "drawable", getPackageName());

            if (drawableId != 0) {  // Ensure the resource ID is valid
                // Set the image resource to the ImageView
                fundal.setImageResource(drawableId);
            } else {
                // Handle the case where the drawable resource ID is not found
                // You could set a default image or log an error message
                // Example:
                fundal.setImageResource(R.drawable.ic_launcher_background);

            }
        }

        contentTextView = findViewById(R.id.textnuj);

     TextView nume=findViewById(R.id.recipeName);

        String recipeName = getIntent().getStringExtra("recipeName");
        String ingredients = getIntent().getStringExtra("recipeIngredients");
        String steps = getIntent().getStringExtra("recipeSteps");
        nume.setText(recipeName);
        setTitle(recipeName);

      Button ingredientsButton = findViewById(R.id.button1);
        Button instructionsButton = findViewById(R.id.button2);

        // Set default to show ingredients
          showIngredients(ingredients);
        ingredientsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showIngredients(ingredients);
            }
        });

        instructionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInstructions(steps);
            }
        });
    }

    private void showIngredients(String ingredients) {
        StringBuilder content = new StringBuilder("Ingredients:\n");
        String[] ingredientsArray = ingredients.split(","); // or "\n"
        for (String ingredient : ingredientsArray) {
            content.append("- ").append(ingredient).append("\n");
        }
        contentTextView.setText(content.toString());
    }

    private void showInstructions(String steps) {
        StringBuilder content = new StringBuilder("Instructions:\n");

        // Split the steps string into parts
        String[] stepsArray = steps.split(","); // or "\n"

        for (String step : stepsArray) {
            content.append("- ").append(step).append("\n");
        }

        contentTextView.setText(content.toString());
    }
}
