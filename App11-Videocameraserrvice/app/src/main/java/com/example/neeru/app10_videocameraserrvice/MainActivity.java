package com.example.neeru.app10_videocameraserrvice;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    Button b;
    VideoView v1;
    Uri u;
    MediaController m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (Button)findViewById(R.id.button);
        v1 = (VideoView)findViewById(R.id.videoView);
        m = new MediaController(this);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(i,56);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==56){
            u = data.getData();
            v1.setVideoURI(u);
            v1.setMediaController(m);
            m.setAnchorView(v1);
            v1.start();
        }
    }
}
