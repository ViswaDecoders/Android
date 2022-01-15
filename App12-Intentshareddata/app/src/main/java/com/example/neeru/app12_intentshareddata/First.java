package com.example.neeru.app12_intentshareddata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class First extends AppCompatActivity {
    Button b1;
    EditText e1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        b1 = (Button)findViewById(R.id.button);
        e1 = (EditText)findViewById(R.id.editText);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = e1.getText().toString();
                Intent i = new Intent(First.this,Second.class);
                i.putExtra("first_num",s);
                startActivity(i);
            }
        });
    }
}
