package com.example.easyexchangetest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class ActivityRegister extends AppCompatActivity {

    //All required variables
    EditText  mEmail, mPassword;
    Button mRegister;
    ProgressBar bar;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        mEmail = (EditText)findViewById(R.id.remail_et);
        mPassword = (EditText)findViewById(R.id.rpass_et);
        bar = (ProgressBar)findViewById(R.id.progressBar);


    }

    //Directing to Login Activity
    public void alreadyRegistered(View view) {
        startActivity(new Intent(ActivityRegister.this, ActivityLogin.class));
    }

    //Firebase Authentication for new User done here Done here
    public void onRegister(View view) {
        mAuth = FirebaseAuth.getInstance();
        bar.setVisibility(View.VISIBLE);
        String email = mEmail.getText().toString();
        String password = mPassword.getText().toString();

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(ActivityRegister.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    //On successful Register, Directing User to Login Activity
                                    bar.setVisibility(View.INVISIBLE);
                                    mEmail.setText("");
                                    mPassword.setText("");
                                    Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(ActivityRegister.this,ActivityLogin.class));


                                } else {
                                    bar.setVisibility(View.INVISIBLE);
                                    mEmail.setText("");
                                    mPassword.setText("");
                                    Toast.makeText(getApplicationContext(), "Process Error", Toast.LENGTH_SHORT).show();

                                }


                            }
                        });
    }


}