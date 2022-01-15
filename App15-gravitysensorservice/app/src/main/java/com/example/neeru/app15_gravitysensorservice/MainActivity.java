package com.example.neeru.app15_gravitysensorservice;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    ImageView i;
    SensorManager sm;
    Sensor s1;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i=(ImageView)findViewById(R.id.imageView);
        mp = MediaPlayer.create(this, R.raw.faded);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        s1 = sm.getDefaultSensor(Sensor.TYPE_GRAVITY);
        sm.registerListener(this, s1, SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.values[0]>1) {
            mp.pause();
            i.setImageResource(R.drawable.pic);
        }
        else {
            mp.start();
            i.setImageResource(R.drawable.scene);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
