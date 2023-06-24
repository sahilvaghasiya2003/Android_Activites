package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.example.recycleview.MyAdapter;
import com.example.recycleview.R;
import com.example.recycleview.modle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<modle> list = new ArrayList<>();

    EditText t1,t2,t3_f,t4_f;
    Button btn,f_btn;
    FloatingActionButton floatingActionButton;
    RecyclerView recyclerView;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = findViewById(R.id.name);
        t2 = findViewById(R.id.Phone_no);
        btn = findViewById(R.id.add);
        recyclerView =findViewById(R.id.RE);
        floatingActionButton = findViewById(R.id.btn_f);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.add(new modle(t1.getText().toString().trim(),t2.getText().toString().trim()));
                 adapter = new MyAdapter(list);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(adapter);
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.activity_dialogbox);

                f_btn = dialog.findViewById(R.id.btn_floatingAdd);
                t3_f = dialog.findViewById(R.id.dialoge_name);
                t4_f = dialog.findViewById(R.id.dialoge_Ph);


                f_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        list.add(new modle(t3_f.getText().toString().trim(), t4_f.getText().toString().trim()));
                       adapter.notifyItemInserted(list.size()-1);
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

    }
}


