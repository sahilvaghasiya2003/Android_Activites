package com.example.roomlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
EditText name,price;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.e1);
        price = findViewById(R.id.e2);
        btn = findViewById(R.id.btn_add);


        DatabaseHelper databaseHelper = DatabaseHelper.getDB(this);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = name.getText().toString();
                String amount = price.getText().toString();
                databaseHelper.expenseDao().addTx(new Expense(title, amount));

                ArrayList<Expense> arrayList = (ArrayList<Expense>) databaseHelper.expenseDao().getAllExpense();
                for(int i=0 ; i<arrayList.size();i++){
                    Log.d("data", "Titlt: "+arrayList.get(i).getName() +"\namount "+arrayList.get(i).getPrice());
                }
            }
        });

    }
}