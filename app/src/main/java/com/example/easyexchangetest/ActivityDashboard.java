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

        //@Comment: Uid and email of user is received from intent
        String email = getIntent().getStringExtra("email").toString();
        String id = getIntent().getStringExtra("uid").toString();

        //@Comment: Email and id text view is set
        mEmail.setText(email);
        mId.setText("UId: " +id);

        //@Comment: Onclick Listener for New Addition of adds by user. So user is directed to a ActivityAdd for creating the add
        newAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityDashboard.this, ActivityAdd.class);
                startActivity(intent);
            }
        });

        //@Comment: Onclick Listener for showing All Adds available. Here is User is directed to MainActivity(Which is like home) and where all adds are displayed
        allAddsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityDashboard.this, MainActivity.class));
            }
        });

        //@Comment: onclickListener for showing all adds given by the user. Here User is directed to MyAllAdds activity.
        myAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityDashboard.this, MyAllAdds.class));
            }
        });


    }

    //@Comment: Button for logout of user
    public void onLogout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(ActivityDashboard.this, ActivityRegister.class));
    }
}