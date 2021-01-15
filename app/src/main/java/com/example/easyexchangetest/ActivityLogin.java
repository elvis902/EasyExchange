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

public class ActivityLogin extends AppCompatActivity {

    //All required variables
    EditText  mName, mEmail, mPassword;
    Button mRegister;
    ProgressBar bar;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mEmail = (EditText)findViewById(R.id.lemail_et);
        mPassword = (EditText)findViewById(R.id.lpass_et);
        bar = (ProgressBar)findViewById(R.id.progressBar2);
        mAuth = FirebaseAuth.getInstance();
    }

    //Firebase Authentication for login of existing user
    public void onLogin(View view) {
        String email = mEmail.getText().toString();
        String password = mPassword.getText().toString();
        bar.setVisibility(View.VISIBLE);

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                //On Successful login, User is directed to Dashboard page
                                bar.setVisibility(View.INVISIBLE);
                                Intent intent = new Intent(ActivityLogin.this, ActivityDashboard.class);
                                intent.putExtra("email",mAuth.getCurrentUser().getEmail());
                                intent.putExtra("uid", mAuth.getCurrentUser().getUid());
                                startActivity(intent);

                            } else {
                               bar.setVisibility(View.INVISIBLE);
                               mEmail.setText("");
                               mPassword.setText("");
                                Toast.makeText(getApplicationContext(),"Incorrect Username/Password",Toast.LENGTH_LONG).show();
                            }

                        }
                    });

    }
}