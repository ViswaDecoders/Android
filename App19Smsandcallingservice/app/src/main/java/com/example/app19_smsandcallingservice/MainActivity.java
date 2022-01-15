package com.example.app19_smsandcallingservice;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button)findViewById(R.id.button2);
        b2 = (Button)findViewById(R.id.button3);
        b1.setOnClickListener(view -> {
            Intent i =new Intent(MainActivity.this,Call.class);
            startActivity(i);
            finish();
        });
        b2.setOnClickListener(view -> {
            Intent i =new Intent(MainActivity.this,Sms.class);
            startActivity(i);
            finish();
        });
    }
}