package com.example.neeru.app9_cameraservice;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b;
    ImageView v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b =(Button)findViewById(R.id.button);
        v =(ImageView)findViewById(R.id.imageView);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,999);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==999){
            Bitmap bmp = (Bitmap)data.getExtras().get("data");
            v.setImageBitmap(bmp);
        }
        else
            Toast.makeText(MainActivity.this, "Camera not working", Toast.LENGTH_SHORT).show();
    }
}
