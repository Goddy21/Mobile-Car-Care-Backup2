package com.example.mobilemechanics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MechanicInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mechanic_info);

        Intent intent = getIntent();
        String name = intent.getStringExtra("NAME");
        String email = intent.getStringExtra("E-MAIL ADDRESS");
        String phone = intent.getStringExtra("PHONE NUMBER");
        String station = intent.getStringExtra("STATION");
        String specialization = intent.getStringExtra("AREA OF SPECIALIZATION");

        TextView mResultTv = findViewById(R.id.resultTv);
        mResultTv.setText("NAME: "+ name + " \nEMAIL: "+ email + "\nPHONE NUMBER: "+ phone + "\nSTATION: "+
                station + "\nAREA OF SPECIALIZATION: "+ specialization);
    }
}