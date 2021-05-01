package com.androidbootcamp.animalsounds;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button cows, pigs;
    MediaPlayer mpCow, mpPig;
    int playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize the variables cows <-> btnCow and pigs <-> btnPig
        cows = (Button) findViewById(R.id.btnCow);
        pigs = (Button) findViewById(R.id.btnPig);
        cows.setOnClickListener(bCowMoo);
        pigs.setOnClickListener(bPigOink);
        //initializes mp3 files in the R.raw folder to variables mpCow and mpPig
        mpCow = new MediaPlayer();
        mpCow = MediaPlayer.create(this, R.raw.cows);
        mpPig = new MediaPlayer();
        mpPig = MediaPlayer.create(this, R.raw.pigs);
        playing = 0;
    }

    Button.OnClickListener bCowMoo= new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (playing) {
                case 0:
                    mpCow.start();
                    playing = 1;
                    cows.setText("SHHHH COWS!!!");
                    pigs.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpCow.pause();
                    playing = 0;
                    cows.setText("LISTEN TO THE COWS");
                    pigs.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };

    Button.OnClickListener bPigOink= new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (playing) {
                case 0:
                    mpPig.start();
                    playing = 1;
                    pigs.setText("SHHHH PIGGIES!!!");
                    cows.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpPig.pause();
                    playing = 0;
                    pigs.setText("LISTEN TO THE PIGS");
                    cows.setVisibility(View.VISIBLE);
                    break;
            }

        }
    };
}