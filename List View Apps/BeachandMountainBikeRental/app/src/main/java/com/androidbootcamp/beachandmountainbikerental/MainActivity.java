package com.androidbootcamp.beachandmountainbikerental;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.net.URI;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] bicycles = {"Beach Bike Rentals", "Mountain Bike Rentals", "Bike Rental Website"};
        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_main, R.id.bikes,
                bicycles));
    }
    protected void onListItemClick(ListView l, View v, int position, long id){
        switch (position) {
            case 0:
                startActivity(new Intent(MainActivity.this, BeachRentals.class));
                break;
            case 1:
                startActivity(new Intent(MainActivity.this, MountainBikeRentals.class));
                break;
            case 2:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://campusbikeshop.com")));
                break;
        }
    }
}