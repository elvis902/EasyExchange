package com.example.easyexchangetest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

//@Comment: This activity is used to diaplay all adds by the current user

public class MyAllAdds extends AppCompatActivity {

    RecyclerView recview;
    MyAdapter adapter;
    FirebaseUser user;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_all_adds);

        recview = (RecyclerView)findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        //@Comment: Current user email is found out to display all adds of current user
       user = FirebaseAuth.getInstance().getCurrentUser();
       email = user.getEmail();

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference ref = db.getReference();
        Query query = FirebaseDatabase.getInstance().getReference().child("Adds")
                .orderByChild("email")
                .equalTo(email);


        //@Comment:  HomeModal class, which is the modal class of an add, is passed to Adapter using FirebaseRecyclerOptions
        FirebaseRecyclerOptions<HomeModal> options =
                new FirebaseRecyclerOptions.Builder<HomeModal>()
                        .setQuery(query, HomeModal.class)
                        .build();

        adapter = new MyAdapter(options);
        recview.setAdapter(adapter);
    }

    //@Comment: Required by Adapter to listen on start and stop listening on stop
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}