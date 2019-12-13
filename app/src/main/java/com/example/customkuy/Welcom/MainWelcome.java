package com.example.customkuy.Welcom;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.customkuy.LoginActivity;
import com.example.customkuy.R;
import com.example.customkuy.RegisterActivity;

public class MainWelcome extends AppCompatActivity {

    private final AppCompatActivity activity = MainWelcome.this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_welcome);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new CustomAdapter(this));
        getSupportActionBar().hide();
    }

    public void pindah(View view){
        Intent menuutama= new Intent(activity, LoginActivity.class);
        startActivity(menuutama);
    }

    public void pindah2(View view){
        Intent menuutama= new Intent(activity, RegisterActivity.class);
        startActivity(menuutama);
    }


}
