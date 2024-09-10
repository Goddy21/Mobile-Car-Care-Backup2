package com.example.mobilemechanics;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ServiceSignInActivity extends AppCompatActivity {
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://client-service-acd4e-default-rtdb.firebaseio.com");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_sign_in);

        final EditText phone = findViewById(R.id.phone);
        final EditText password = findViewById(R.id.pass);
        final Button submit = findViewById(R.id.submit);
        final TextView signup = findViewById(R.id.sign_up);
        final ProgressBar progressBar = findViewById(R.id.progressbar);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ServiceRegActivity.class);
                startActivity(intent);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String mobileTxt = phone.getText().toString();
                String passwordTxt = password.getText().toString();

                if (mobileTxt.isEmpty() || passwordTxt.isEmpty()){
                    Toast.makeText(ServiceSignInActivity.this, "Enter Username or Password", Toast.LENGTH_SHORT).show();
                }else{
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            progressBar.setVisibility(View.GONE);
                            if(snapshot.hasChild(mobileTxt)){
                                final String getPassword = snapshot.child(mobileTxt).child("password").getValue(String.class);
                                if (getPassword.equals(passwordTxt)){
                                    Toast.makeText(ServiceSignInActivity.this, "Success", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), SpecializationActivity.class);
                                    startActivity(intent);
                                }else{
                                    Toast.makeText(ServiceSignInActivity.this, "Wrong password", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(ServiceSignInActivity.this, "Wrong mobile number", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });

    }
}