package com.example.myform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
ArrayList<modelclass> stulist;
sqlite sq;
RecyclerView recycle;
FloatingActionButton floating;
Context context = this;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recycle=findViewById(R.id.recycle);
        floating=findViewById(R.id.floating);
        stulist=new ArrayList<>();
        sq=new sqlite(this);

        stulist=sq.getstudentdetails();
       // LinearLayoutManager linear=new LinearLayoutManager(this);



        Stuadaptrer stuadapter=new Stuadaptrer(context,stulist);
        recycle.setHasFixedSize(true);
        recycle.setLayoutManager(new LinearLayoutManager(this));
        recycle.setAdapter(stuadapter);

        floating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}