package com.example.neeru.app12_intentshareddata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Second extends AppCompatActivity {
    Button b1;
    EditText e1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        b1 = (Button)findViewById(R.id.button2);
        e1 = (EditText)findViewById(R.id.editText2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                Intent i1 = new Intent(Second.this,Third.class);
                String s2 = (String) getIntent().getExtras().get("first_num");   //or getIntent.getStringExtra("sum")
                float f1 = Float.parseFloat(s1);
                float f2 = Float.parseFloat(s2);
                float f3 = f1+f2;
                String s3 = Float.toString(f3);
                i1.putExtra("sum",s3);
                startActivity(i1);
            }
        });
    }
}
