package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main extends AppCompatActivity {
private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,RESTART;
private String  b1,b2,b3,b4,b5,b6,b7,b8,b9;
int flage = 0;
int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        find();

    }

    public void find(){
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        RESTART = findViewById(R.id.btn_restart);
        RESTART.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1.setText("");
                btn2.setText("");
                btn3.setText("");
                btn4.setText("");
                btn5.setText("");
                btn6.setText("");
                btn7.setText("");
                btn8.setText("");
                btn9.setText("");
                count = 0;
                flage = 0;
            }
        });
    }

    public void settext(View view){
        Button btnCurrent = (Button) view;
        if(btnCurrent.getText().toString().isEmpty()) {
            count ++;
            if (flage == 0) {
                btnCurrent.setText("X");
                flage = 1;
            } else{
                btnCurrent.setText("o");
                flage = 0;
            }

            if(count > 4){
                b1 = btn1.getText().toString();
                b2 = btn2.getText().toString();
                b3 = btn3.getText().toString();
                b4 = btn4.getText().toString();
                b5 = btn5.getText().toString();
                b6 = btn6.getText().toString();
                b7 = btn7.getText().toString();
                b8 = btn8.getText().toString();
                b9 = btn9.getText().toString();

                if(b1.equals(b2) && b2.equals(b3) && !b1.equals("")){
                    Toast.makeText(this,btn1.getText() + "is Winner",Toast.LENGTH_LONG).show();
                    newGame();
                } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
                    Toast.makeText(this,btn4.getText()+ "is Winner",Toast.LENGTH_LONG).show();
                    newGame();

                } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
                    Toast.makeText(this,btn7.getText()+ "is Winner",Toast.LENGTH_LONG).show();
                    newGame();

                } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
                    Toast.makeText(this,btn1.getText()+ "is Winner",Toast.LENGTH_LONG).show();
                    newGame();

                }else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")){
                    Toast.makeText(this,btn2.getText()+ "is Winner",Toast.LENGTH_LONG).show();
                    newGame();

                } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
                    Toast.makeText(this,btn3.getText()+ "is Winner",Toast.LENGTH_LONG).show();
                    newGame();

                } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
                    Toast.makeText(this,btn1.getText()+ "is Winner",Toast.LENGTH_LONG).show();
                    newGame();

                } else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
                    Toast.makeText(this,btn3.getText()+ "is Winner",Toast.LENGTH_LONG).show();
                    newGame();

                } else if (!b1.equals("") && !b2.equals("") &&!b3.equals("") &&!b4.equals("") &&!b5.equals("") &&!b6.equals("") &&!b7.equals("") &&!b8.equals("") &&!b9.equals("")  ) {
                    Toast.makeText(this,"Game is Tie", Toast.LENGTH_LONG).show();
                    newGame();
                }
            }
        }
    }

    public void newGame(){
        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                btn1.setText("");
                btn2.setText("");
                btn3.setText("");
                btn4.setText("");
                btn5.setText("");
                btn6.setText("");
                btn7.setText("");
                btn8.setText("");
                btn9.setText("");
                count = 0;
                flage = 0;
            }
        },4000);

    }
}