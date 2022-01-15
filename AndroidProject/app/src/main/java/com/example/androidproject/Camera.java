package com.example.androidproject;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Camera extends AppCompatActivity {
    Button b11;
    ImageView i2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        b11=(Button)findViewById(R.id.button11);
        i2=(ImageView)findViewById(R.id.imageView2);
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,99);
                finish();

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==99)
        {
            Bitmap bm=(Bitmap)data.getExtras().get("data");
            i2.setImageBitmap(bm);
        }
       else
        {
            Toast.makeText(Camera.this,"Your camera isn't working",Toast.LENGTH_SHORT).show();
        }
    }
}