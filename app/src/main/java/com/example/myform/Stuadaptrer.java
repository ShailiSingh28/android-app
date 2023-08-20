package com.example.myform;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Stuadaptrer extends RecyclerView.Adapter<Stuadaptrer.Viewholder> {
    Context ctx;
    ArrayList<modelclass> arr;
    sqlite sqlite;
    public Stuadaptrer(Context ctx , ArrayList<modelclass> arr) {
this.ctx=ctx;
this.arr=arr;
sqlite=new sqlite(ctx);
    }

    @NonNull
    @Override
    public Stuadaptrer.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(ctx).inflate(R.layout.custom,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.name.setText(":"+arr.get(position).getName());
        holder.dob.setText(":"+arr.get(position).getDob());
        holder.fname.setText(":"+arr.get(position).getFname());
        holder.mname.setText(":"+arr.get(position).getMname());
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView name,dob,fname,mname;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            dob=itemView.findViewById(R.id.dob);
            fname=itemView.findViewById(R.id.fname);
            mname=itemView.findViewById(R.id.mname);
        }
    }
}
