package com.example.myform;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText e1,e2,e3,e4;
Button but;
Spinner spin;
modelclass modelclass;
sqlite sqlite;
String array[]={"MALE","FEMALE","OHTERS"};
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        e3=findViewById(R.id.e3);
        e4=findViewById(R.id.e4);
        but=findViewById(R.id.but);
        spin=findViewById(R.id.spin);

        modelclass=new modelclass();
        sqlite=new sqlite(this);
        ArrayAdapter adapter=new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_dropdown_item,array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (validation())
                {
                modelclass.setName(e1.getText().toString().trim());
                modelclass.setDob(e2.getText().toString().trim());
                modelclass.setFname(e3.getText().toString().trim());
                modelclass.setMname(e4.getText().toString().trim());
                modelclass.setGender(spin.getSelectedItem().toString().trim());
                sqlite.data(modelclass);
                Toast.makeText(MainActivity.this, "data Inserted.!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }}

            private boolean validation() {
                if (e1.getText().toString().trim().length()==0)
                {
                    e1.setError("required");
                    e1.requestFocus();
                    return false;
                }
                if (e2.getText().toString().trim().length()==0)
                {
                    e2.setError("required");
                    e2.requestFocus();
                    return false;
                }
                if (e3.getText().toString().trim().length()==0)
                {
                    e3.setError("required");
                    e3.requestFocus();
                    return false;
                }
                if (e4.getText().toString().trim().length()==0)
                {
                    e4.setError("required");
                    e4.requestFocus();
                    return false;
                }
                if (spin.getSelectedItem().toString().trim()=="pick one")
                {

                }
                return true;
            }
        });

    }
}