package com.nouckelson.books;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myviewholder> {
    ArrayList<Model> data;
    Context context;
    public  myAdapter(ArrayList<Model> data, Context context){
        this.data=data;
        this.context=context;
    }
    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       LayoutInflater inflater=LayoutInflater.from(parent.getContext());
       View view=inflater.inflate(R.layout.singlerow,parent,false);
       return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        final Model temp=data.get(position);
        holder.t1.setText(data.get(position).getName());
           holder.t2.setText(data.get(position).getAuthor());
           holder.img.setImageResource(data.get(position).getLogo());
           holder.img.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
//                   Intent intent=new Intent(context,InfoActivity.class);
//                   Bundle bundle = new Bundle();
//                   bundle.putSerializable("LIST",(Serializable) holder);
//                   intent.putExtras(bundle);
//                   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                   context.startActivity(intent);
               }
           });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
