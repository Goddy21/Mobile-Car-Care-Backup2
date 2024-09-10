package com.example.mobilemechanics;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class servicesActivity extends AppCompatActivity {
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://client-service-acd4e-default-rtdb.firebaseio.com");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        final EditText phone = findViewById(R.id.phone);
        final EditText username = findViewById(R.id.username);
        final EditText email = findViewById(R.id.email);
        final EditText password1 = findViewById(R.id.pass);
        final EditText password2 = findViewById(R.id.password2);
        final Button submintBtn = findViewById(R.id.submit);
        final TextView login = findViewById(R.id.signin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ServiceLogActivity.class);
                startActivity(intent);
            }
        });

        submintBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String phoneTxt = phone.getText().toString();
                final String usernameTxt = username.getText().toString();
                final String emailTxt = email.getText().toString();
                final String password1Txt = password1.getText().toString();
                final String password2Txt = password2.getText().toString();


                if (phoneTxt.isEmpty() || usernameTxt.isEmpty() || emailTxt.isEmpty()){
                    Toast.makeText(servicesActivity.this, "Fill in all the deatils", Toast.LENGTH_SHORT).show();
                }else if (!password2Txt.equals(password1Txt)){
                    Toast.makeText(servicesActivity.this, "Passwords not similar", Toast.LENGTH_SHORT).show();
                }else{
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.hasChild(phoneTxt)){
                                Toast.makeText(servicesActivity.this, "Phone is already registered", Toast.LENGTH_SHORT).show();
                            }else {
                                databaseReference.child("users").child(phoneTxt).child("username").setValue(username);
                                databaseReference.child("users").child(phoneTxt).child("email").setValue(email);
                                databaseReference.child("users").child(phoneTxt).child("password").setValue(password1);

                                Toast.makeText(servicesActivity.this, "User registered succesfully!", Toast.LENGTH_SHORT).show();
                                finish();
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