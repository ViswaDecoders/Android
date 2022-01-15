package com.example.neeru.app2_calci;

import android.hardware.camera2.params.StreamConfigurationMap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    TextView t1;
    Button b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        t1=(TextView)findViewById(R.id.textView);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                Integer i1 = Integer.parseInt(s1);    //Float f1 = Float.parseFloat(s1);
                Integer i2 = Integer.parseInt(s2);    //Float f2 = Float.parseFloat(s2);
                Integer i3 = i1 + i2;                 //Float f3 = f1 + f2;
                String s3 = Integer.toString(i3);
                t1.setText(s3);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                Integer i1 = Integer.parseInt(s1);      //Float f1 = Float.parseFloat(s1);
                Integer i2 = Integer.parseInt(s2);      //Float f2 = Float.parseFloat(s2);
                Integer i3 = i1 - i2;                   //Float f3 = f1 + f2;
                String s3 = Integer.toString(i3);
                t1.setText(s3);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                Integer i1 = Integer.parseInt(s1);          //Float f1 = Float.parseFloat(s1);
                Integer i2 = Integer.parseInt(s2);          //Float f2 = Float.parseFloat(s2);
                Integer i3 = i1 * i2;                       //Float f3 = f1 + f2;
                String s3 = Integer.toString(i3);
                t1.setText(s3);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                Integer i1 = Integer.parseInt(s1);          //Float f1 = Float.parseFloat(s1);
                Integer i2 = Integer.parseInt(s2);          //Float f2 = Float.parseFloat(s2);
                Integer i3 = i1 / i2;                       //Float f3 = f1 + f2;
                String s3 = Integer.toString(i3);
                t1.setText(s3);
            }
        });
    }
}
