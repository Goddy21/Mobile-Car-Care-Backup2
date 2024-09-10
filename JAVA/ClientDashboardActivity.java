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

public class ClientDashboardActivity extends AppCompatActivity {

    FirebaseAuth auth;
    Button button;
    TextView textView;
    FirebaseUser user;
    ImageView leave;
    ImageView bodywork;
    ImageView wiring;
    ImageView mechanical;
    ImageView location;
    ImageView rating;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_dashboard);

        auth = FirebaseAuth.getInstance();
        leave = findViewById(R.id.logout);
        bodywork = findViewById(R.id.body);
        wiring = findViewById(R.id.wiring);
        mechanical = findViewById(R.id.mechanical);
        location = findViewById(R.id.currentlocation);
        rating = findViewById(R.id.rateMechanic);
        /*textView = findViewById(R.id.user_details);
        user = auth.getCurrentUser();
        if(user == null){
            Intent intent = new Intent(getApplicationContext(), UserLoginActivity.class);
            startActivity(intent);
            finish();
        }else{
            textView.setText(user.getEmail());
        }*/
        rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Ratings.class);
                startActivity(intent);
            }
        });
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GoogleMapsActivity.class);
                startActivity(intent);
            }
        });
        bodywork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LocationActivity.class);
                startActivity(intent);
            }
        });

        wiring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LocationActivity.class);
                startActivity(intent);
            }
        });

        mechanical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LocationActivity.class);
                startActivity(intent);
            }
        });

        leave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), ServiceSignInActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
