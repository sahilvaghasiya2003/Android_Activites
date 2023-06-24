package com.example.imagefromcamera;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
Button btn;
ImageView img;
int imgCODE = 1111;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.imgCamera);
        btn = findViewById(R.id.btn);

      btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
//              Intent icamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//              startActivityForResult(icamera, 1);

              Intent igalerry = new Intent(Intent.ACTION_PICK);
              igalerry.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
              startActivityForResult(igalerry,imgCODE);

          }
      });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//
//        if(requestCode == RESULT_OK){
//            if(requestCode == 1){
//                Bitmap imgcamera = (Bitmap)(data.getExtras().get("data"));
//                img.setImageBitmap(imgcamera);
//            }
//        }
        Log.d("data", "GAlerry image male che");
        if(requestCode==imgCODE){


                img.setImageURI(data.getData());

        }

    }
}