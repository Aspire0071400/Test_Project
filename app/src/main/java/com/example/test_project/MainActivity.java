package com.example.test_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnStart,btnAbout;
    EditText edtName;
    String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btnStart);
        btnAbout = findViewById(R.id.btnAbout);
        edtName = findViewById(R.id.edtName);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtName.getText().equals(null)){
                    Toast.makeText(MainActivity.this,"Enter Your Name",Toast.LENGTH_SHORT).show();
                }else{
                Intent intent = new Intent(getApplicationContext(),GameActivity.class);
                name = edtName.getText().toString();
                intent.putExtra("name",name);
                startActivity(intent);
            }}
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AboutActivity.class);
                startActivity(intent);
            }
        });

    }
}