package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class Main extends AppCompatActivity {

    Spinner spinner;
    AutoCompleteTextView autoCompleteTextView;
    ListView listView;

    ArrayList<String> list_spinner = new ArrayList<>();
    ArrayList<String> list_auto = new ArrayList<>();
    ArrayList<String> _list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        autoCompleteTextView = findViewById(R.id.auto);
        listView = findViewById(R.id.listview);

        //Adapters for listview

        ArrayAdapter<String> list = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,_list);
        listView.setAdapter(list);

        //Adapter for Spinner
        ArrayAdapter<String> Spinner_adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,list_spinner);
        spinner.setAdapter(Spinner_adapter);

        //Adapter for Auto
        ArrayAdapter<String> Auto_adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,_list);
        autoCompleteTextView.setAdapter(Auto_adapter);
        autoCompleteTextView.setThreshold(1);

        //Spinner
        list_spinner.add("Aadhar Id");
        list_spinner.add("Voting Id");
        list_spinner.add("School Id");
        list_spinner.add("Collage Id");

        //AutocComplete

        list_auto.add("c");
        list_auto.add("c++");
        list_auto.add("c#");
        list_auto.add("java");
        list_auto.add("Js");
        list_auto.add("Python");
        list_auto.add("PHP");
        list_auto.add("React");
        list_auto.add("NodeJS");
        list_auto.add("rubi");
        list_auto.add("HTML");


        //Listview

        list.add("Person 1");
        list.add("Person 2");
        list.add("Person 3");
        list.add("Person 4");
        list.add("Person 5");

    }



}
