package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {
    EditText e6,e7;
    TextView t2;
    Button b14,b15,b16,b17;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        e6 = (EditText) findViewById(R.id.editText6);
        e7 = (EditText) findViewById(R.id.editText7);
        t2 = (TextView) findViewById(R.id.textView2);
        b14 = (Button) findViewById(R.id.button14);
        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e6.getText().toString();
                String s2 = e7.getText().toString();
                Float f1 = Float.parseFloat(s1);
                Float f2 = Float.parseFloat(s2);
                Float f3 = f1 + f2;
                String s3 = Float.toString(f3);
                t2.setText(s3);
                Toast.makeText(Calculator.this, "The Answer is" + s3, Toast.LENGTH_SHORT).show();
            }
        });
        b15 = (Button) findViewById(R.id.button15);
        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e6.getText().toString();
                String s2 = e7.getText().toString();
                Float f1 = Float.parseFloat(s1);
                Float f2 = Float.parseFloat(s2);
                Float f3 = f1 - f2;
                String s3 = Float.toString(f3);
                t2.setText(s3);
                Toast.makeText(Calculator.this, "The Answer is" + s3, Toast.LENGTH_SHORT).show();
            }
        });
        b16 = (Button) findViewById(R.id.button16);
        b16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e6.getText().toString();
                String s2 = e7.getText().toString();
                Float f1 = Float.parseFloat(s1);
                Float f2 = Float.parseFloat(s2);
                Float f3 = f1 * f2;
                String s3 = Float.toString(f3);
                t2.setText(s3);
                Toast.makeText(Calculator.this, "The Answer is" + s3, Toast.LENGTH_SHORT).show();
            }
        });
        b17=(Button)findViewById(R.id.button17);
        b17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e6.getText().toString();
                String s2 = e7.getText().toString();
                Float f1 = Float.parseFloat(s1);
                Float f2 = Float.parseFloat(s2);
                Float f3 = f1 / f2;
                String s3 = Float.toString(f3);
                t2.setText(s3);
                Toast.makeText(Calculator.this, "The Answer is" + s3, Toast.LENGTH_SHORT).show();
            }
        });
    }
}