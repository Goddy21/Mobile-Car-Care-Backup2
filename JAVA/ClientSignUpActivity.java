package com.example.mobilemechanics;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class ClientSignUpActivity extends AppCompatActivity {
    TextInputEditText editTextEmail, editTextPassword;
    Button buttonReg;
    FirebaseAuth mAuth;
    ProgressBar progressBar;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_sign_up);
        mAuth = FirebaseAuth.getInstance();
        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);
        buttonReg = findViewById(R.id.btn_register);
        progressBar = findViewById(R.id.progressbar);
        textView = findViewById(R.id.login_now);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ClientLoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                String email, password;
                email = String.valueOf(editTextEmail.getText());
                password = String.valueOf(editTextPassword.getText());

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(ClientSignUpActivity.this, "Enter E-mail", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    Toast.makeText(ClientSignUpActivity.this, "Enter password", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    Toast.makeText(ClientSignUpActivity.this, "Account created.",
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), ClientLoginActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(ClientSignUpActivity.this, Objects.requireNonNull(task.getException()).getLocalizedMessage(),
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });
    }
}