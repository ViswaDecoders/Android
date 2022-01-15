package com.example.neeru.app7_intentdiffscreens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Second extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        b = (Button)findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Second.this,Third.class);
                startActivity(i);
                finish();
            }
        });
    }
}
