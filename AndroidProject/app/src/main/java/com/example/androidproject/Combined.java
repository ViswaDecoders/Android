package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Combined extends AppCompatActivity {
     Button b6,b7,b8,b9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combined);
        b6=(Button)findViewById(R.id.button6);
        b7=(Button)findViewById(R.id.button7);
        b8=(Button)findViewById(R.id.button8);
        b9=(Button)findViewById(R.id.button9);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Combined.this,MediaPlayer.class);
                startActivity(i);
                finish();
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(Combined.this,Calculator.class);
                startActivity(j);
                finish();
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k=new Intent(Combined.this,Camera.class);
                startActivity(k);
                finish();
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent l=new Intent(Combined.this,TextToSpeech.class);
                startActivity(l);
                finish();
            }
        });
    }
}