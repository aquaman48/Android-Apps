package com.androidbootcamp.appalachiantrailfestivaltabletapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private TextView reservation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reservation = (TextView) findViewById(R.id.txtReservation);
        Button btDate = (Button) findViewById(R.id.btnDate);
        btDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this, d, c.get(java.util.Calendar.YEAR), c.get(java.util.Calendar.MONTH), c.get(java.util.Calendar.DAY_OF_MONTH)).show();
            }
        });
    }
    java.util.Calendar c = java.util.Calendar.getInstance();
    java.text.DateFormat fmtDate = DateFormat.getDateInstance();
    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            c.set(java.util.Calendar.YEAR, year);
            c.set(java.util.Calendar.MONTH, month);
            c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            reservation.setText("Thank you! Your reservation was made for " + fmtDate.format(c.getTime()));
        }
    };
}