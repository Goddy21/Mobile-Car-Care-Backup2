package com.example.mobilemechanics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MechanicsDashboardActivity extends AppCompatActivity {

    FirebaseAuth auth;
    TextView textView;
    FirebaseUser user;
    ImageView logout;
    ImageView manuals;
    ImageView Add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mechanics_dashboard);

        auth = FirebaseAuth.getInstance();
        manuals = findViewById(R.id.mech_manuals);
        logout = findViewById(R.id.leave);
        Add = findViewById(R.id.addmechanic);

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddMechanicActivity.class);
                startActivity(intent);
            }
        });

        manuals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), manualsActivity.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), ServiceSignInActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

   public void location(View v){
        Intent i = new Intent(getApplicationContext(), GoogleMapsActivity.class);
        startActivity(i);
   }
    public void tutorials(View v){
        Intent i = new Intent(getApplicationContext(), tutorialsActivity.class);
        startActivity(i);
    }
}