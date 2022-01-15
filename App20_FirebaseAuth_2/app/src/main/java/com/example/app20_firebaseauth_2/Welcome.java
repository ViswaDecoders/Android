package com.example.app20_firebaseauth_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Welcome extends AppCompatActivity {
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        b1 = findViewById(R.id.button5);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Welcome.this, "Logged ouyt successfully", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Welcome.this,Login.class);
                startActivity(i);
                finish();
            }
        });
    }
}