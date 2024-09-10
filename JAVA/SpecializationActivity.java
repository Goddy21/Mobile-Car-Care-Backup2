package com.example.mobilemechanics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SpecializationActivity extends AppCompatActivity {

    FirebaseAuth auth;
    Button button;
    TextView textView;
    FirebaseUser user;
    String [] occupants = {"Client", "Mechanic"};

    AutoCompleteTextView autoCompleteTxt;
    ArrayAdapter<String> adapterItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialization);
        autoCompleteTxt = findViewById(R.id.autoCompleteTextView);

        adapterItems = new ArrayAdapter<String>(this, R.layout.occupants_list,occupants);
        autoCompleteTxt.setAdapter(adapterItems);




        autoCompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String occupant = adapterView.getItemAtPosition(i).toString();
                if (occupant == "Client"){
                    Intent intent = new Intent(getApplicationContext(), ClientDashboardActivity.class);
                    startActivity(intent);
                    finish();
                }else if (occupant == "Mechanic"){
                    Intent intent = new Intent(getApplicationContext(), MechanicsDashboardActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(), "Enter Occupation", Toast.LENGTH_SHORT).show();
                }
            }
        });
        /*auth = FirebaseAuth.getInstance();
        button = findViewById(R.id.logout);
        textView = findViewById(R.id.user_details);
        user = auth.getCurrentUser();
        if(user == null){
            Intent intent = new Intent(getApplicationContext(), UserLoginActivity.class);
            startActivity(intent);
            finish();
        }else{
            textView.setText(user.getEmail());
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), UserLoginActivity.class);
                startActivity(intent);
                finish();
            }
        });*/
    }

    public void client_login(View v){
        Intent intent = new Intent(this, Client_Login_Activity.class);
        startActivity(intent);
    }
    public void mech_login(View v){
        Intent intent = new Intent(this, MechanicsLoginActivity.class);
        startActivity(intent);
    }
}