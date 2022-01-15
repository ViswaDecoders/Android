package com.example.neeru.app3_mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    MediaPlayer m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button)findViewById(R.id.button);
        b2 = (Button)findViewById(R.id.button2);
        m = MediaPlayer.create(this,R.raw.summerof69);
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


    }
}
