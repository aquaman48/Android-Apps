package com.androidbootcamp.photoprints;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double small = .19;
    double medium = .49;
    double large = .79;
    double printsEntered;
    double finalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        final EditText prints = (EditText) findViewById(R.id.txtNumber);
        final RadioButton smallestPrice = (RadioButton) findViewById(R.id.radSmall);
        final RadioButton middlePrice = (RadioButton) findViewById(R.id.radMedium);
        final RadioButton highestPrice = (RadioButton) findViewById(R.id.radLarge);
        final TextView result = (TextView) findViewById(R.id.txtResult);
        Button order = (Button) findViewById(R.id.btnOrder);

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printsEntered=Double.parseDouble(prints.getText().toString());
                DecimalFormat penny = new DecimalFormat("$###.##");
                if(smallestPrice.isChecked()) {
                    if (printsEntered <= 50) {
                        finalPrice = printsEntered * small;
                        result.setText("The order cost is " + penny.format(finalPrice));
                    } else {
                        Toast.makeText(MainActivity.this, "Do not enter more than 50 prints.",
                                Toast.LENGTH_LONG).show();
                    }
                }
                if(middlePrice.isChecked()) {
                    if (printsEntered <= 50) {
                        finalPrice = printsEntered * medium;
                        result.setText("The order cost is " + penny.format(finalPrice));
                    } else {
                        Toast.makeText(MainActivity.this, "Do not enter more than 50 prints.",
                                Toast.LENGTH_LONG).show();
                    }
                }
                if(highestPrice.isChecked()) {
                    if (printsEntered <= 50) {
                        finalPrice = printsEntered * large;
                        result.setText("The order cost is " + penny.format(finalPrice));
                    } else {
                        Toast.makeText(MainActivity.this, "Do not enter more than 50 prints.",
                                Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
}