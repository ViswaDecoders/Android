package com.example.neeru.app8_combined1_7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class First extends AppCompatActivity {
    Button b1,b2;
    EditText e1;
    ImageButton i1,i2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        b1 = (Button)findViewById(R.id.button);
        b2 = (Button)findViewById(R.id.button1);
        e1 = (EditText)findViewById(R.id.editText);
        i1 = (ImageButton)findViewById(R.id.imageButton);
        i2 = (ImageButton)findViewById(R.id.imageButton2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = e1.getText().toString();
                Toast.makeText(First.this,s , Toast.LENGTH_SHORT).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(First.this,"Welcome to the App", Toast.LENGTH_SHORT).show();
            }
        });
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(First.this,Second.class);
                startActivity(i);
                finish();
            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(First.this,Sixth.class);
                startActivity(i);
                finish();
            }
        });
    }
}
