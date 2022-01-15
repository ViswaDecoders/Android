package com.example.app18_videoplayer;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    VideoView v1;
    MediaController mc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        v1 =(VideoView)findViewById(R.id.videoView);
        mc = new MediaController(this);
        v1.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.faded);
        v1.setMediaController(mc);
        mc.setAnchorView(v1);
        v1.start();
    }
}