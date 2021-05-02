package com.androidbootcamp.floortilerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TextViewCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int area;
    int lengthGiven;
    int widthGiven;
    int totalTiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        final EditText length = (EditText) findViewById(R.id.txtLength);
        final EditText width = (EditText) findViewById(R.id.txtWidth);
        final RadioButton twelveInch = (RadioButton) findViewById(R.id.radTwelveInch);
        final RadioButton eighteenInch = (RadioButton) findViewById(R.id.radEighteenInch);
        final TextView result = (TextView) findViewById(R.id.txtResult);
        Button compute = (Button) findViewById(R.id.btnTiles);

        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lengthGiven = Integer.parseInt(length.getText().toString());
                widthGiven = Integer.parseInt(width.getText().toString());
                area = lengthGiven * widthGiven;
                if(twelveInch.isChecked()) {
                    totalTiles = area / 1;
                    result.setText("To cover " + area + " square feet, you will need " + totalTiles +
                            " 12 x 12 tiles. ");
                }
                if(eighteenInch.isChecked()) {
                    totalTiles = area / 2;
                    result.setText("To cover " + area + " square feet, you will need " + totalTiles +
                            " 18 x 18 tiles. ");
                }
            }
        });
    }
}