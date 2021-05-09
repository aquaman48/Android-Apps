package com.androidbootcamp.healthysnacks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Integer[] Snacks = {R.drawable.snack1, R.drawable.snack2, R.drawable.snack3, R.drawable.snack4,
            R.drawable.snack5};
    ImageView smallSnack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView grid = (GridView)findViewById(R.id.gridView);
        final ImageView smallSnack = (ImageView) findViewById(R.id.imgBigSnack);
        grid.setAdapter(new ImageAdapter(this));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                smallSnack.setImageResource(Snacks[position]);
            }
        });
    }
    public class ImageAdapter extends BaseAdapter {
        private Context context;

        public ImageAdapter(Context c) {
            context = c;
        }

        @Override
        public int getCount() {
            return Snacks.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            smallSnack = new ImageView(context);
            smallSnack.setImageResource(Snacks[position]);
            smallSnack.setScaleType(ImageView.ScaleType.FIT_XY);
            smallSnack.setLayoutParams(new GridView.LayoutParams(500,200));
            return smallSnack;
        }
    }
}