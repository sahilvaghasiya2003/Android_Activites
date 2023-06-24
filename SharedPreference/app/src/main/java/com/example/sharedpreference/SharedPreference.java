package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SharedPreference extends AppCompatActivity {
    EditText e1,e2;
    Button btn;
    SharedPreferences sharedPreference;

    public static final String Sp = "sharedpre";
    public static final String name = "namekey";
    public static final  String ph_number = "phkey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);

        e1 = findViewById(R.id.name1);
        e2 = findViewById(R.id.name2);
        btn = findViewById(R.id.submit_btn);

        sharedPreference = (SharedPreferences) getSharedPreferences(Sp, Context.MODE_PRIVATE);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n =e1.getText().toString();
                String Ph= e2.getText().toString();
                SharedPreferences.Editor editor = sharedPreference.edit();
                editor.putString(name, n);
                editor.putString(ph_number, Ph);
                editor.commit();
            }
        });
    }


}

