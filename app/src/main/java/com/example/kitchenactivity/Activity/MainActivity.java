package com.example.kitchenactivity.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kitchenwizard2.Login;
import com.example.kitchenwizard2.R;

import java.util.ArrayList;

import Adaptor.CategoryAdaptor;
import Domain.CategoryDomain;

public class MainActivity extends AppCompatActivity implements CategoryAdaptor.OnItemClickListener{
    private CategoryAdaptor adapter;
    private RecyclerView recyclerViewCategoryList;

    private ConstraintLayout home_main;
    private ConstraintLayout recipes_main;
    private ConstraintLayout login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


       home_main=findViewById(R.id.home1);
       recipes_main=findViewById(R.id.home2);
       login=findViewById(R.id.home4);
       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(MainActivity.this, Login.class));
           }
       });
       home_main.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            startActivity(new Intent(MainActivity.this,MainActivity.class));
                                        }
                                    });

         recipes_main.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(MainActivity.this, RecipesAll.class));
             }
         });



       recyclerViewCategory();
    }


    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.Categorii);

        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);


        ArrayList<CategoryDomain> category= new ArrayList<>();
        category.add(new CategoryDomain("Salads", "ic_launcher_background"));
        category.add(new CategoryDomain("Deserts", "ic_launcher_background"));
        category.add(new CategoryDomain("Drinks", "ic_launcher_background"));

        adapter=new CategoryAdaptor(category, this);
        recyclerViewCategoryList.setAdapter(adapter);

    }

    @Override
    public void onItemClick(int position) {
        // Retrieve the category based on position
        CategoryDomain category = adapter.getCategory(position);

        // Get the title of the clicked category
        String categoryName = category.GetTitle();

        // Determine the activity to start based on the category name
        Intent intent;
        switch (categoryName) {
            case "Salads":
                intent = new Intent(MainActivity.this,IntroActivity.class);
                break;
            case "Deserts":
                intent = new Intent(MainActivity.this, MainActivity.class);
                break;
            case "Drinks":
                intent = new Intent(MainActivity.this, MainActivity.class);
                break;
            default:
                intent = new Intent(MainActivity.this, MainActivity.class);
                break;
        }

        // Start the appropriate activity
        startActivity(intent);
    }



}