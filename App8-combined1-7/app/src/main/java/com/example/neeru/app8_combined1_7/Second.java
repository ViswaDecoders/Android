package com.example.neeru.app8_combined1_7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Second extends AppCompatActivity {
    Button b1,b2,b3,b4;
    ImageButton i1,i2;
    EditText e1,e2;
    TextView t1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        e1=(EditText)findViewById(R.id.editText2);
        e2=(EditText)findViewById(R.id.editText3);
        t1=(TextView)findViewById(R.id.textView2);
        b1=(Button)findViewById(R.id.button2);
        b2=(Button)findViewById(R.id.button3);
        b3=(Button)findViewById(R.id.button4);
        b4=(Button)findViewById(R.id.button5);
        i1 = (ImageButton)findViewById(R.id.imageButton4);
        i2 = (ImageButton)findViewById(R.id.imageButton3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float i1 = Float.parseFloat(e1.getText().toString());
                Float i2 = Float.parseFloat(e2.getText().toString());
                Float i3 = i1 + i2;
                String s3 = Float.toString(i3);
                t1.setText(s3);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                Float i1 = Float.parseFloat(s1);
                Float i2 = Float.parseFloat(s2);
                Float i3 = i1 - i2;
                String s3 = Float.toString(i3);
                t1.setText(s3);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                Float i1 = Float.parseFloat(s1);
                Float i2 = Float.parseFloat(s2);
                Float i3 = i1 * i2;
                String s3 = Float.toString(i3);
                t1.setText(s3);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                Float i1 = Float.parseFloat(s1);
                Float i2 = Float.parseFloat(s2);
                Float i3 = i1 / i2;
                String s3 = Float.toString(i3);
                t1.setText(s3);
            }
        });
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Second.this,Third.class);
                startActivity(i);
                finish();
            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Second.this,First.class);
                startActivity(i);
                finish();
            }
        });
    }
}
