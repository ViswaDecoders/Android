package com.example.androidproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MediaPlayer extends AppCompatActivity {
    VideoView v1;
    MediaController m1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);
        v1=(VideoView)findViewById(R.id.videoView);
        m1=new MediaController(this);
        v1.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.shapeofyou);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        v1.setMediaController(m1);
        m1.setAnchorView(v1);
        v1.start();
    }
}