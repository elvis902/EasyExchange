package com.example.easyexchangetest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

/* Adapter class. FirebaseRecycler Adapter dependency is used to populate UI with Adds */
//This adapter is used for both MyAllAdd Activity(which shows all adds of current user) and MainActivity(It is basically home and it shows all available adds)
//It extends  FirebaseRecyclerAdapter
public class MyAdapter extends FirebaseRecyclerAdapter<HomeModal, MyAdapter.MyViewHolder> {


    public MyAdapter(@NonNull FirebaseRecyclerOptions<HomeModal> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull HomeModal model) {
            holder.pEmail.setText(model.email);
            holder.pDes.setText(model.pDescription);
            holder.pName.setText(model.pName);

            Glide.with(holder.pimg.getContext()).load(model.getpUrl()).into(holder.pimg);

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow, parent, false);
        return new MyViewHolder(view);
    }

    //ViewHolder class is implemented here within
    static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView pimg;
        TextView pName, pDes, pEmail;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
           pimg = (ImageView)itemView.findViewById(R.id.img1);
            pName = (TextView)itemView.findViewById(R.id.pname_tv);
           pDes = (TextView)itemView.findViewById(R.id.pdes_tv);
            pEmail = (TextView)itemView.findViewById(R.id.pemail_tv);


        }
    }
}
