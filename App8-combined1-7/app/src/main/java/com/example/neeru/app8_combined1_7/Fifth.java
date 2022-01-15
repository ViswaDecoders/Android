package com.example.neeru.app8_combined1_7;

import android.content.Intent;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ToggleButton;

public class Fifth extends AppCompatActivity {
    Button b1,b2;
    ImageButton i1,i2,i3;
    ToggleButton tb;
    WifiManager wm;
    private boolean wifi=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        b1 = (Button)findViewById(R.id.button10);
        b2 = (Button)findViewById(R.id.button11);
        i1 = (ImageButton)findViewById(R.id.imageButton11);
        i2 = (ImageButton)findViewById(R.id.imageButton10);
        i3 = (ImageButton)findViewById(R.id.imageButton12);
        tb = (ToggleButton)findViewById(R.id.toggleButton2);
        wm = (WifiManager)getSystemService(WIFI_SERVICE);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wm.setWifiEnabled(true);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wm.setWifiEnabled(false);
            }
        });
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wifi){
                    wm.setWifiEnabled(false);
                    wifi=false;
                    i3.setImageResource(R.drawable.wifi_off);
                }
                else{
                    wm.setWifiEnabled(true);
                    wifi=true;
                    i3.setImageResource(R.drawable.wifi_on);
                }
            }
        });
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(b)
                    wm.setWifiEnabled(true);
                else
                    wm.setWifiEnabled(false);
            }
        });
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Fifth.this,Sixth.class);
                startActivity(i);
                finish();
            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Fifth.this,Fourth.class);
                startActivity(i);
                finish();
            }
        });
    }
}
