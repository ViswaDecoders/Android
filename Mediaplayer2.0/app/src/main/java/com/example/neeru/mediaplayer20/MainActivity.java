package com.example.neeru.mediaplayer20;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
    int[] myMusic = {R.raw.baby, R.raw.bigbang, R.raw.iphone};
    int mNext ;
    MediaPlayer.OnCompletionListener mListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            mp.release();
            startNextFile();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNext = 0;
        startNextFile();
    }

    void startNextFile() {
        if (mNext < myMusic.length) {
            MediaPlayer mp = MediaPlayer.create(this, myMusic[mNext++]);
            mp.setOnCompletionListener(mListener);
            mp.start();
        }
    }
}







