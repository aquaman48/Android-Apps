package com.androidbootcamp.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    int intWeight, intHeight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText weight = (EditText) findViewById(R.id.txtWeight);
        final EditText height = (EditText) findViewById(R.id.txtHeight);

        Button compute = (Button) findViewById(R.id.btnCompute);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intWeight = Integer.parseInt(weight.getText().toString());
                intHeight = Integer.parseInt(height.getText().toString());
                //Store user inputs
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("key1", intWeight);
                editor.putInt("key2", intHeight);
                editor.commit();
                //Opens the new "activity"
                startActivity(new Intent(MainActivity.this, Compute.class));

            }
        });
    }
}