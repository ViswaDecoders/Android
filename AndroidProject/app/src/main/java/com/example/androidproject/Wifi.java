package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Wifi extends AppCompatActivity {
    Button b10,b12;
    WifiManager w1;
    ImageButton ib;
    private boolean wifi=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);
        b10=(Button)findViewById(R.id.button10);
        b12=(Button)findViewById(R.id.button12);
        w1=(WifiManager)getApplicationContext().getSystemService(WIFI_SERVICE);
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                w1.setWifiEnabled(true);
            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                w1.setWifiEnabled(false);
            }
        });
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(wifi==false)
                {
                    w1.setWifiEnabled(true);
                    wifi=true;
                    ib.setImageResource(R.drawable.wifi1);
                }
                else
                {
                    w1.setWifiEnabled(false);
                    wifi=false;
                    ib.setImageResource(R.drawable.wifi1);
                }
            }
        });
    }
}