package com.example.neeru.app8_combined1_7;

import android.content.Intent;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ToggleButton;

public class Sixth extends AppCompatActivity {
    Button b1,b2;
    ImageButton i1,i2,i3;
    ToggleButton tb;
    CameraManager cm;
    private boolean flash=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);
        b1 = (Button)findViewById(R.id.button12);
        b2 = (Button)findViewById(R.id.button13);
        i1 = (ImageButton)findViewById(R.id.imageButton14);
        i2 = (ImageButton)findViewById(R.id.imageButton13);
        i3 = (ImageButton)findViewById(R.id.imageButton15);
        tb = (ToggleButton)findViewById(R.id.toggleButton3);
        cm = (CameraManager)getSystemService(CAMERA_SERVICE);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String s = cm.getCameraIdList()[0];
                    cm.setTorchMode(s,true);
                }
                catch(CameraAccessException e){

                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String s = cm.getCameraIdList()[0];
                    cm.setTorchMode(s,false);
                }
                catch (CameraAccessException e){

                }
            }
        });
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flash)
                    flashoff();
                else
                    flashon();
            }
        });
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(b){
                    try{
                        String s = cm.getCameraIdList()[0];
                        cm.setTorchMode(s,true);
                    }
                    catch(CameraAccessException e){

                    }
                }
                else {
                    try{
                        String s = cm.getCameraIdList()[0];
                        cm.setTorchMode(s,false);
                    }
                    catch (CameraAccessException e){

                    }
                }
            }
        });
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Sixth.this,First.class);
                startActivity(i);
                finish();
            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Sixth.this,Fifth.class);
                startActivity(i);
                finish();
            }
        });
    }
    private void flashon(){
        try{
            String s = cm.getCameraIdList()[0];
            cm.setTorchMode(s,true);
            flash=true;
            i3.setImageResource(R.drawable.on2);
        }
        catch (CameraAccessException e){

        }
    }

    private void flashoff(){
        try{
            String s = cm.getCameraIdList()[0];
            cm.setTorchMode(s,false);
            flash=false;
            i3.setImageResource(R.drawable.off2);
        }
        catch (CameraAccessException e){

        }
    }
}
