package com.example.neeru.app14_accelerometersensorservice;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    ImageView i;
    TextView t1,t2,t3;
    MediaPlayer mp;
    SensorManager sm;
    Sensor s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i= (ImageView)findViewById(R.id.imageView);
        t1=(TextView)findViewById(R.id.textView);
        t2=(TextView)findViewById(R.id.textView2);
        t3=(TextView)findViewById(R.id.textView3);
        mp = MediaPlayer.create(this,R.raw.faded);
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        s = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this,s,SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];
        int x1 = (int)x;
        int y1 = (int)y;
        int z1 = (int)z;
        t1.setText(Float.toString(x));
        t2.setText(Float.toString(y));
        t3.setText(Float.toString(z));
        if(x1!=0){
            mp.start();
            i.setImageResource(R.drawable.pic);
        }
        else{
            mp.pause();
            i.setImageResource(R.drawable.scene);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
