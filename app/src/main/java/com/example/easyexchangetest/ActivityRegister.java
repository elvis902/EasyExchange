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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ActivityRegister extends AppCompatActivity {

    //All required variables
    EditText  mEmail, mPassword;
    ProgressBar bar;
    private FirebaseAuth mAuth;
    EditText mName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        mEmail = (EditText)findViewById(R.id.remail_et);
        mPassword = (EditText)findViewById(R.id.rpass_et);
        bar = (ProgressBar)findViewById(R.id.progressBar);
        mName = (EditText)findViewById(R.id.rname_et);


    }

    // @Comment:   Directing to Login Activity if already registered
    public void alreadyRegistered(View view) {
        startActivity(new Intent(ActivityRegister.this, ActivityLogin.class));
    }


    // @Comment:  Firebase Authentication for new User done here
    public void onRegister(View view) {
        mAuth = FirebaseAuth.getInstance();
        bar.setVisibility(View.VISIBLE);
        String email = mEmail.getText().toString();
        String password = mPassword.getText().toString();
        String name = mName.getText().toString();

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(ActivityRegister.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    // @Comment:  On successful Register, Directing User to Login Activity
                                    bar.setVisibility(View.INVISIBLE);
                                    mEmail.setText("");
                                    mPassword.setText("");
                                    mName.setText("");


                                    // @Comment: Name and email of the newly registered user is added to database
                                    addToDatabase(name, email);


                                    // @Comment: Registered Successful, User is directed to Login Activity for Login
                                    Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(ActivityRegister.this,ActivityLogin.class));


                                }
                                else {

                                    //@Comment: On unsuccessful Register, Notifying user about Process Error
                                    bar.setVisibility(View.INVISIBLE);
                                    mEmail.setText("");
                                    mPassword.setText("");
                                    Toast.makeText(getApplicationContext(), "Process Error", Toast.LENGTH_SHORT).show();

                                }


                            }
                        });
    }

    // @Comment:  Name and email of the newly registered user is added to database
    private void addToDatabase(String name, String email) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference().child("Users");
        Users user = new Users(name, email);

        ref.push().setValue(user);

    }


}