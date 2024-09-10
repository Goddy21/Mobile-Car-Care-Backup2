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

public class ServiceRegActivity extends AppCompatActivity {
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://client-service-acd4e-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_reg);
        final EditText phone = findViewById(R.id.phone);
        final EditText username = findViewById(R.id.username);
        final EditText email = findViewById(R.id.email);
        final EditText password1 = findViewById(R.id.pass);
        final EditText password2 = findViewById(R.id.password2);
        final Button submitBtn = findViewById(R.id.submit);
        final TextView login = findViewById(R.id.signin);
        final ProgressBar progressBar = findViewById(R.id.progressbar);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ServiceSignInActivity.class);
                startActivity(intent);
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                final String phoneTxt = phone.getText().toString();
                final String usernameTxt = username.getText().toString();
                final String emailTxt = email.getText().toString();
                final String password1Txt = password1.getText().toString();
                final String password2Txt = password2.getText().toString();


                if (phoneTxt.isEmpty() || usernameTxt.isEmpty() || emailTxt.isEmpty()){
                    Toast.makeText(ServiceRegActivity.this, "Fill in all the details", Toast.LENGTH_SHORT).show();
                }else if (!password2Txt.equals(password1Txt)){
                    Toast.makeText(ServiceRegActivity.this, "Passwords not similar", Toast.LENGTH_SHORT).show();
                }else{
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            progressBar.setVisibility(View.GONE);
                            if (snapshot.hasChild(phoneTxt)){
                                Toast.makeText(ServiceRegActivity.this, "Phone is already registered", Toast.LENGTH_SHORT).show();
                            }else {
                                if(isValid(password1Txt)){
                                    databaseReference.child("users").child(phoneTxt).child("username").setValue(usernameTxt);
                                    databaseReference.child("users").child(phoneTxt).child("email").setValue(emailTxt);
                                    databaseReference.child("users").child(phoneTxt).child("password").setValue(password1Txt);

                                    Toast.makeText(ServiceRegActivity.this, "User registered successfully!", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(getApplicationContext(), ServiceSignInActivity.class);
                                    startActivity(intent);
                                    finish();
                                }else {
                                    Toast.makeText(ServiceRegActivity.this, "Password must contain at least 8 characters, having letter, digit and a number!", Toast.LENGTH_SHORT).show();
                                }
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
    public static boolean isValid(String passworddhere){
        int f1=0,f2=0,f3=0;
        if(passworddhere.length() < 8){
            return false;
        }else{
            for(int p = 0; p < passworddhere.length(); p++){
                if(Character.isLetter(passworddhere.charAt(p))){
                    f1=1;
                }
            }
            for(int r = 0; r < passworddhere.length(); r++){
                if(Character.isDigit(passworddhere.charAt(r))){
                    f2=1;
                }
            }
            for(int s = 0; s < passworddhere.length(); s++){
                char c = passworddhere.charAt(s);
                if(c>=33&&c<=46 || c==64){
                    f3=1;
                }
            }
            if(f1==1 && f2==1 && f3==1)
                return true;
            return false;

        }
    }
}