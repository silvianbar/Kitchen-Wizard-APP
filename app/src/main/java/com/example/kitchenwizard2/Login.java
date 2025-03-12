package com.example.kitchenwizard2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.kitchenactivity.Activity.MainActivity;

import java.util.ArrayList;

public class Login extends AppCompatActivity {
    private Button home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        ViewPager2 viewPager = findViewById(R.id.viewPager); // Ensure the correct ViewPager2 ID
        home=findViewById(R.id.button_homeREC1);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, MainActivity.class));
            }
        });

        AuthenticationPagerAdapter pagerAdapter = new AuthenticationPagerAdapter(this); // Correct initialization
        pagerAdapter.addFragment(new LoginFragment()); // Corrected method name
        pagerAdapter.addFragment(new fragment_register()); // Ensure proper fragment class name
        viewPager.setAdapter(pagerAdapter); // Set the adapter to ViewPager2
    }

    static class AuthenticationPagerAdapter extends FragmentStateAdapter {
        private final ArrayList<Fragment> fragmentList = new ArrayList<>();

        // Constructor for FragmentStateAdapter
        public AuthenticationPagerAdapter(FragmentActivity fa) {
            super(fa); // Correct initialization
        }

        @Override
        @NonNull
        public Fragment createFragment(int position) {
            return fragmentList.get(position); // Return the fragment at the given position
        }

        @Override
        public int getItemCount() {
            return fragmentList.size(); // Return the total number of fragments
        }

        public void addFragment(Fragment fragment) { // Corrected method name
            fragmentList.add(fragment); // Add a fragment to the list
        }
    }
}
