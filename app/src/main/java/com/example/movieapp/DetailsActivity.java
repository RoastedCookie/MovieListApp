package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ImageView imageView = findViewById(R.id.mPoster);
        TextView title = findViewById(R.id.mtitle);
        TextView rate = findViewById(R.id.mRate);
        TextView des = findViewById(R.id.mDesc);



        if (getIntent().hasExtra("title") && getIntent().hasExtra("ratings") && getIntent().hasExtra("desc") && getIntent().hasExtra("poster")){
            String mTitle = getIntent().getStringExtra("title");
            double mRatings = getIntent().getDoubleExtra("ratings", 1);
            String mDesc = getIntent().getStringExtra("desc");
            String poster = getIntent().getStringExtra("poster");

            title.setText(mTitle);
            rate.setText(String.valueOf(mRatings));
            des.setText(mDesc);
            Glide.with(this).load(poster).into(imageView);
        }

    }
}