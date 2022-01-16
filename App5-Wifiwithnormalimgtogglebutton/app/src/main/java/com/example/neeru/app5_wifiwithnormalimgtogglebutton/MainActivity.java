package com.example.neeru.app5_wifiwithnormalimgtogglebutton;

import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    ImageButton ib;
    ToggleButton tb;
    WifiManager wm;
    private boolean wifi=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button)findViewById(R.id.button);
        b2 = (Button)findViewById(R.id.button2);
        ib = (ImageButton)findViewById(R.id.imageButton);
        tb = (ToggleButton)findViewById(R.id.toggleButton);
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
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wifi){
                    wm.setWifiEnabled(true);
                    wifi=false;
                    ib.setImageResource(R.drawable.off);
                }
                else{
                    wm.setWifiEnabled(false);
                    wifi=true;
                    ib.setImageResource(R.drawable.on);
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
    }
}
