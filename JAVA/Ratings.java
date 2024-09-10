package com.example.mobilemechanics;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

public class Ratings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratings);

        RateUsDialog rateUsDialog = new RateUsDialog(Ratings.this);
        rateUsDialog.getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
        rateUsDialog.setCancelable(false);
        rateUsDialog.show();
    }
}