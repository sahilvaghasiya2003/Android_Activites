package com.example.formvalidation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Validation_page extends AppCompatActivity {
    private EditText name1,name2,email,pwd;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validation_page);

        name1 = findViewById(R.id.name1);
        name2 = findViewById(R.id.name2);
        email = findViewById(R.id.email);
        pwd = findViewById(R.id.password);
        submit = findViewById(R.id.submit_btn);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name1.getText().toString().isEmpty()){
                    Toast.makeText(Validation_page.this, "Fill first name", Toast.LENGTH_SHORT).show();
                }else if(name2.getText().toString().isEmpty()){
                    Toast.makeText(Validation_page.this, "Fill Second name", Toast.LENGTH_SHORT).show();
                }else if(email.getText().toString().isEmpty()){
                    Toast.makeText(Validation_page.this, "Fill Email ", Toast.LENGTH_SHORT).show();
                }else if(pwd.getText().toString().isEmpty()||pwd.getText().toString().length()<8){
                    Toast.makeText(Validation_page.this, "Enter valid password", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(Validation_page.this, "Thank you", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Validation_page.this, second.class);
                    intent.putExtra("message","hello sahil bvaghasiya kese ho");
                    intent.putExtra("message2",12);
                    startActivity(intent);


                }


            }
        });

    }



}
