package com.example.neeru.app8_combined1_7;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Third extends AppCompatActivity {
    Button b1,b2;
    MediaPlayer m;
    ImageButton i1,i2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        b1 = (Button)findViewById(R.id.button6);
        b2 = (Button)findViewById(R.id.button7);
        m = MediaPlayer.create(this,R.raw.faded);
        i1 = (ImageButton)findViewById(R.id.imageButton6);
        i2 = (ImageButton)findViewById(R.id.imageButton5);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m.start();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m.pause();
            }
        });
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Third.this,Fourth.class);
                startActivity(i);
                finish();
            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Third.this,Second.class);
                startActivity(i);
                finish();
            }
        });
    }
}
