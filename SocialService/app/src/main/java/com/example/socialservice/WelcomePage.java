package com.example.socialservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class WelcomePage extends AppCompatActivity {
Button btn_backhome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
        getSupportActionBar().hide();

        btn_backhome = findViewById(R.id.btn_backHome);
        Intent intent = new Intent(getApplicationContext(), BottomNevigation.class);
        startActivity(intent);
    }
}