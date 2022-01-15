package com.example.neeru.app6_torchservice;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    ImageButton ib;
    ToggleButton tb;
    CameraManager cm;
    private boolean flash=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button)findViewById(R.id.button);
        b2 = (Button)findViewById(R.id.button2);
        ib = (ImageButton)findViewById(R.id.imageButton);
        tb = (ToggleButton)findViewById(R.id.toggleButton);
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
        ib.setOnClickListener(new View.OnClickListener() {
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
    }
    private void flashon(){
        try{
            String s = cm.getCameraIdList()[0];
            cm.setTorchMode(s,true);
            flash=true;
            ib.setImageResource(R.drawable.on);
        }
        catch (CameraAccessException e){

        }
    }

    private void flashoff(){
        try{
            String s = cm.getCameraIdList()[0];
            cm.setTorchMode(s,false);
            flash=false;
            ib.setImageResource(R.drawable.off);
        }
        catch (CameraAccessException e){

        }
    }
}
