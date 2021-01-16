package com.example.easyexchangetest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

//@Comment: Here in this app MainActivity is used as Home Activity, which shows all adds available to user

public class MainActivity extends AppCompatActivity {

    RecyclerView recview;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recview = (RecyclerView)findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<HomeModal> options =
                new FirebaseRecyclerOptions.Builder<HomeModal>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Adds"), HomeModal.class)
                        .build();

        adapter = new MyAdapter(options);

        //@Comment: RecyclerView is set with adapter
        recview.setAdapter(adapter);
    }

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