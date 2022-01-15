package com.example.neeru.app4_bluetoothwithnormalimgtogglebutton;

import android.bluetooth.BluetoothAdapter;
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
    BluetoothAdapter ba;
    private boolean bluetooth=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 =(Button)findViewById(R.id.button);
        b2 =(Button)findViewById(R.id.button2);
        ib = (ImageButton)findViewById(R.id.imageButton);
        tb =(ToggleButton)findViewById(R.id.toggleButton);
        ba = BluetoothAdapter.getDefaultAdapter();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { ba.enable(); }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ba.disable();
            }
        });
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bluetooth){
                    ba.disable();
                    bluetooth=false;
                    ib.setImageResource(R.drawable.off);
                }
                else{
                    ba.enable();
                    bluetooth=true;
                    ib.setImageResource(R.drawable.on);
                }
            }
        });
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(b)
                    ba.enable();
                else
                    ba.disable();
            }
        });


    }
}
