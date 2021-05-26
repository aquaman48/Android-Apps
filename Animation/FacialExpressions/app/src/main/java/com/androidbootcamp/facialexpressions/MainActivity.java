package com.androidbootcamp.facialexpressions;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    AnimationDrawable faceAnimation;
    int start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imgFrame = (ImageView) findViewById(R.id.imgFaces);
        imgFrame.setBackgroundResource(R.drawable.animation);
        faceAnimation = (AnimationDrawable)imgFrame.getBackground();

        Button btnStart = (Button) findViewById(R.id.btnFaces);
        start = 0;
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (start) {
                    case 0:
                        faceAnimation.start();
                        start = 1;
                        break;
                    case 1:
                        faceAnimation.stop();
                        start = 0;
                        break;
                }
                //faceAnimation.start();
            }
        });
    }
}