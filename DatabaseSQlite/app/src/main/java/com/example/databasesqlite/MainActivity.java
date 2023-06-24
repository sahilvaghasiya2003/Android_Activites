package com.example.databasesqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText name,Ph_no,email,pwd;
    Button Add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        Ph_no = findViewById(R.id.Ph_no);
        email = findViewById(R.id.Email);
        pwd = findViewById(R.id.password);
        Add = findViewById(R.id.btn_add);

        MyDatabase md = new MyDatabase(MainActivity.this);


/*   FETCH DATA FROM DATABASE

        ArrayList<ContactModel> Arr_data = md.fetchData();
        for (int i = 0 ; i < Arr_data.size(); i++){

            Log.d("CONTACT_INFO", "Name : "+Arr_data.get(i).name +"\nPhone_no : "+Arr_data.get(i).phone_no+"\nE-mail : "+Arr_data.get(i).email+"\nPassword : "+Arr_data.get(i).pwd);
        }
 */


 /*   UPDATE DATA TO DATABASE


        ContactModel contactModel = new ContactModel();
        contactModel.phone_no = "8767876786";
        contactModel.pwd = "9313561001";



        md.updateContact(contactModel);

        ArrayList<ContactModel> Arr_data = md.fetchData();
        for (int i = 0 ; i < Arr_data.size(); i++){

            Log.d("CONTACT_INFO", "Name : "+Arr_data.get(i).name +"\nPhone_no : "+Arr_data.get(i).phone_no+"\nE-mail : "+Arr_data.get(i).email+"\nPassword : "+Arr_data.get(i).pwd);
        }
 */



        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = name.getText().toString();
                String phone = Ph_no.getText().toString();
                String Email = email.getText().toString();
                String password = pwd.getText().toString();

                if (Name.isEmpty() && phone.isEmpty() && Email.isEmpty() && password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                md.addNewCourse(Name,phone,Email,password);
                Toast.makeText(MainActivity.this, "Course has been added.", Toast.LENGTH_SHORT).show();
                name.setText("");
                Ph_no.setText("");
                email.setText("");
                pwd.setText("");
            }
        });


//   ************* DELETE DATA FEOM DATABASE

        ContactModel contactModel = new ContactModel();
        contactModel.pwd = "4";
         md.deleteContact(contactModel);
        ArrayList<ContactModel> Arr_data = md.fetchData();
        for (int i = 0 ; i < Arr_data.size(); i++){

            Log.d("CONTACT_INFO", "Name : "+Arr_data.get(i).name +"\nPhone_no : "+Arr_data.get(i).phone_no+"\nE-mail : "+Arr_data.get(i).email+"\nPassword : "+Arr_data.get(i).pwd);
        }

    }
}