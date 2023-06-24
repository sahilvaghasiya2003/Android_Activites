package com.example.implicitintentpassing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button call,msg,mail,share;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        call = findViewById(R.id.call);
        mail = findViewById(R.id.email);
        msg = findViewById(R.id.message);
        share = findViewById(R.id.Share);


        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent icall = new Intent(Intent.ACTION_DIAL);
                icall.setData(Uri.parse("tel: +911231231231"));
                startActivity(icall);
            }
        });


        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent imsg = new Intent(Intent.ACTION_SENDTO);
                imsg.setData(Uri.parse("smsto:"+Uri.encode("911231231231")));
                startActivity(imsg);
            }
        });


        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iemail = new Intent(Intent.ACTION_SEND);
                iemail.setType("message/rfc822");
                iemail.putExtra(Intent.EXTRA_EMAIL,new String[]{"abc@gmail.com","xyz@gmail.com"});
                iemail.putExtra(Intent.EXTRA_SUBJECT,"QUERES");
                iemail.putExtra(Intent.EXTRA_TEXT, "PLEASE RESOLVE THIS ISSUE!");
                startActivity(Intent.createChooser(iemail,"Email Via"));
            }
        });


        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ishare = new Intent(Intent.ACTION_SEND );
                ishare.setType("Text/plain");
                ishare.putExtra(Intent.EXTRA_TEXT, "downlode this amazing app,https://www.youtube.com/watch?v=r-JNSsrIBds&t=1725s");
                startActivity(Intent.createChooser(ishare,"Share Via"));

            }
        });


    }
}