package com.example.androidproject;

import android.bluetooth.BluetoothAdapter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class ombSensor extends AppCompatActivity {

    ImageView i1,i2,i3,i4;
    TextToSpeech t;
    TextView t1,t2,t3;
    SensorManager sm;
    Sensor s;
    CameraManager cm;
    WifiManager wm;
    BluetoothAdapter ba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_omb_sensor);
        i1 =(ImageView)findViewById(R.id.imageView);
        i2 =(ImageView)findViewById(R.id.imageView3);
        i3 =(ImageView)findViewById(R.id.imageView4);
        i4 =(ImageView)findViewById(R.id.imageView5);
        t1 =(TextView)findViewById(R.id.textView);
        t2 =(TextView)findViewById(R.id.textView3);
        t3 =(TextView)findViewById(R.id.textView4);
        wm = (WifiManager)getApplicationContext().getSystemService(WIFI_SERVICE);
        cm =(CameraManager)getSystemService(CAMERA_SERVICE);
        ba = BluetoothAdapter.getDefaultAdapter();
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        s = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener((SensorEventListener) this,s,SensorManager.SENSOR_DELAY_NORMAL);
        t=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                t.setLanguage(Locale.ENGLISH);
                t.setSpeechRate(0.9f);
            }
        });
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        float x = event.values[1];
        float y = event.values[2];
        float z = event.values[3];
        String s1 = Float.toString(x);
        String s2 = Float.toString(y);
        String s3 = Float.toString(z);
        t1.setText(s1);
        t2.setText(s2);
        t3.setText(s3);
        if((int)x!=0){
            ba.enable();
            i1.setImageResource(R.drawable.bluetooth);
            wm.setWifiEnabled(true);
            i3.setImageResource(R.drawable.wifi);
            try{
                String s = cm.getCameraIdList()[0];
                cm.setTorchMode(s,true);
            }
            catch(CameraAccessException e){

            }
            i2.setImageResource(R.drawable.on2);
            t.speak("areh mujhe seedhe karo bhai",TextToSpeech.QUEUE_FLUSH,null);
            i4.setImageResource(R.drawable.speak);

        }
        else {
            ba.disable();
            i1.setImageResource(R.drawable.bluetoothoff);
            wm.setWifiEnabled(false);
            i3.setImageResource(R.drawable.wifi_off);
            try{
                String s = cm.getCameraIdList()[0];
                cm.setTorchMode(s,false);
            }
            catch(CameraAccessException e){

            }
            i2.setImageResource(R.drawable.off2);
            t.speak("areh mujhe teda karo reah",TextToSpeech.QUEUE_FLUSH,null);
            i4.setImageResource(R.drawable.mute);
        }
    }
    }
}