package com.example.neeru.app13_lightsensorservice;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.MediaController;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    ImageView i;
    MediaPlayer mp;
    SensorManager sm;
    Sensor s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i = (ImageView)findViewById(R.id.imageView);
        mp =MediaPlayer.create(this, R.raw.faded);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        s = sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        sm.registerListener(this,s,SensorManager.SENSOR_DELAY_NORMAL);


    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.values[0]>1){
            mp.start();
            i.setImageResource(R.drawable.scene);
        }
        else{
            mp.pause();
            i.setImageResource(R.drawable.pic);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
