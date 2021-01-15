package com.example.easyexchangetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;


public class ActivityDashboard extends AppCompatActivity {

    TextView mEmail, mId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        mEmail = (TextView)findViewById(R.id.email_tv);
        mId = (TextView)findViewById(R.id.uid_tv);

        mEmail.setText(getIntent().getStringExtra("email").toString());
        mId.setText("UId: "+getIntent().getStringExtra("uid").toString());

    }

    public void onLogout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(ActivityDashboard.this, ActivityRegister.class));
    }
}