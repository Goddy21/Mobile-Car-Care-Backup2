package com.example.mobilemechanics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class manualsActivity extends AppCompatActivity {

    ImageView engine;
    ImageView oil;
    ImageView suspension;
    ImageView brakes;
    ImageView bearing;
    ImageView manual;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manuals);
        engine = findViewById(R.id.engine);
        oil = findViewById(R.id.oil_change);
        suspension = findViewById(R.id.suspension);
        brakes = findViewById(R.id.brakes);
        bearing = findViewById(R.id.bearing);
        manual = findViewById(R.id.manualDrive);

        manual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.howacarworks.com/basics/how-manual-gearboxes-work#:~:text=Modern%20cars%20with%20manual%20transmissions,well%20as%20a%20neutral%20position.&text=The%20gear%20turns%20freely%20on,the%20mainshaft%2C%20rests%20near%20by.&text=The%20fork%20moves%20the%20synchromesh%20towards%20the%20selected%20gear.");
            }
        });
        bearing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.autopartspro.co.uk/tips-advice/replace-wheel-bearing-manual-guide-2615");
            }
        });

        brakes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.autozone.com/diy/brakes/how-to-replace-brake-pads-and-rotors");
            }
        });
        suspension.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://club.autodoc.co.uk/manuals/suspension-and-arms");
            }
        });

        engine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.ingenieriaymecanicaautomotriz.com/ic-engine-components-and-their-functions-types-and-terminology/");
            }
        });

        oil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.autozone.com/diy/motor-oil/easy-steps-to-change-your-oil");
            }
        });
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}