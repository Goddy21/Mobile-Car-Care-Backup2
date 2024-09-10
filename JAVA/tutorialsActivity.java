package com.example.mobilemechanics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class tutorialsActivity extends AppCompatActivity {

    ImageView engine;
    ImageView oil;
    ImageView suspension;
    ImageView brakes;
    ImageView bearing;
    ImageView manual;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorials);
        engine = findViewById(R.id.engine);
        oil = findViewById(R.id.oil_change);
        suspension = findViewById(R.id.suspension);
        brakes = findViewById(R.id.brakes);
        bearing = findViewById(R.id.bearing);
        manual = findViewById(R.id.manualDrive);

        manual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.youtube.com/watch?v=TUpeMYTj1O8");
            }
        });
        bearing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.youtube.com/watch?v=6uMxUIVHQFc");
            }
        });

        brakes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.youtube.com/watch?v=6RQ9UabOIPg");
            }
        });
        suspension.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.youtube.com/watch?v=V_g1-WHD4rw");
            }
        });

        engine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.youtube.com/watch?v=x70VqMrXrbs");
            }
        });

        oil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.youtube.com/watch?v=O1hF25Cowv8");
            }
        });
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}