package com.example.neeru.app8_combined1_7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 =(Button)findViewById(R.id.button14);
        b2 =(Button)findViewById(R.id.button15);
        b3 =(Button)findViewById(R.id.button16);
        b4 =(Button)findViewById(R.id.button17);
        b5 =(Button)findViewById(R.id.button18);
        b6 =(Button)findViewById(R.id.button19);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,First.class);
                startActivity(i);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Second.class);
                startActivity(i);
                finish();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Third.class);
                startActivity(i);
                finish();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Fourth.class);
                startActivity(i);
                finish();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Fifth.class);
                startActivity(i);
                finish();
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Sixth.class);
                startActivity(i);
                finish();
            }
        });
    }
}
