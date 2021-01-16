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
    Button myAddBtn, newAddBtn, allAddsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        mEmail = (TextView)findViewById(R.id.email_tv);
        mId = (TextView)findViewById(R.id.uid_tv);
        myAddBtn = (Button)findViewById(R.id.myadds_btn);
        newAddBtn = (Button)findViewById(R.id.newadd_btn);
        allAddsBtn = (Button)findViewById(R.id.allAdd_btn);


        String email = getIntent().getStringExtra("email").toString();
        String id = getIntent().getStringExtra("uid").toString();

        mEmail.setText(email);
        mId.setText("UId: " +id);

        //Onclick Listener for New Add
        newAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityDashboard.this, ActivityAdd.class);
                startActivity(intent);
            }
        });

        allAddsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityDashboard.this, MainActivity.class));
            }
        });

        myAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityDashboard.this, MyAllAdds.class));
            }
        });


    }

    public void onLogout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(ActivityDashboard.this, ActivityRegister.class));
    }
}