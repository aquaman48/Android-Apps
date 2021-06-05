package com.androidbootcamp.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Compute extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compute);
        TextView bmiCalculation = (TextView) findViewById(R.id.txtCalcWeight);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        int intWeight = sharedPref.getInt("key1", 0);
        int intHeight = sharedPref.getInt("key2", 0);
        float bmi;
        float sqrHeight = (intHeight * intHeight);

        bmi = intWeight * 703 / sqrHeight;
        DecimalFormat tenth = new DecimalFormat("#.#");
        bmiCalculation.setText("Your Body Mass Index is " + tenth.format(bmi));
    }
}