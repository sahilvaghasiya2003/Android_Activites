package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class Music extends AppCompatActivity {
    private Button play,pause;
    private MediaPlayer mediaPlayer;
    private SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        play = findViewById(R.id.play_btn);
        pause = findViewById(R.id.Pause_btn);
        seekBar = findViewById(R.id.sbar);


   mediaPlayer = MediaPlayer.create(Music.this, R.raw.music1);

   play.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           mediaPlayer.start();
       }
   });

   seekBar.setMax(mediaPlayer.getDuration());

   seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
       @Override
       public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

           if(fromUser){
               mediaPlayer.seekTo(progress);
           }
       }

       @Override
       public void onStartTrackingTouch(SeekBar seekBar) {

       }

       @Override
       public void onStopTrackingTouch(SeekBar seekBar) {

       }
   });

   pause.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           mediaPlayer.pause();
       }
   });

    }
}