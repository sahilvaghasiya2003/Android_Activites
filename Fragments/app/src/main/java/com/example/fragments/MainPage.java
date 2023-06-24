package com.example.fragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainPage extends AppCompatActivity {
    Button btn1,btn2,btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        btn1 = findViewById(R.id.Button1);
        btn2 = findViewById(R.id.Button2);
        btn3 = findViewById(R.id.Button3);
        Fragment first = new frg1();
        Fragment second = new frg2();
        Fragment Third = new frg3();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.f1,first);
                fragmentTransaction.commit();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm2 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm2.beginTransaction();
                fragmentTransaction.replace(R.id.f1,second);
                fragmentTransaction.commit();

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm3 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm3.beginTransaction();
                fragmentTransaction.replace(R.id.f1,Third);
                fragmentTransaction.commit();
            }
        });
    }
}