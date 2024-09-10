package com.example.mobilemechanics;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddMechanicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mechanic);


        EditText fullName = findViewById(R.id.fullname);
        EditText emailTxt = findViewById(R.id.email);
        EditText numberTxt = findViewById(R.id.phone);
        EditText stationTxt = findViewById(R.id.station);
        EditText specializationTxt = findViewById(R.id.specialization);
        Button add = findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = fullName.getText().toString();
                String email = emailTxt.getText().toString();
                String number = numberTxt.getText().toString();
                String station = stationTxt.getText().toString();
                String specialization = specializationTxt.getText().toString();

                Intent intent = new Intent(AddMechanicActivity.this, MechanicInfoActivity.class);
                intent.putExtra("NAME", name);
                intent.putExtra("E-MAIL ADDRESS", email);
                intent.putExtra("PHONE NUMBER", number);
                intent.putExtra("STATION", station);
                intent.putExtra("AREA OF SPECIALIZATION", specialization);
                startActivity(intent);
            }
        });
    }
}