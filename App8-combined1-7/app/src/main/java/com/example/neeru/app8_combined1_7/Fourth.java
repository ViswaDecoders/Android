package com.example.neeru.app8_combined1_7;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ToggleButton;

public class Fourth extends AppCompatActivity {
    Button b1,b2;
    ImageButton i1,i2,i3;
    ToggleButton tb;
    BluetoothAdapter ba;
    private boolean bluetooth=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        b1 =(Button)findViewById(R.id.button8);
        b2 =(Button)findViewById(R.id.button9);
        i1 = (ImageButton)findViewById(R.id.imageButton8);
        i2 = (ImageButton)findViewById(R.id.imageButton7);
        i3 = (ImageButton)findViewById(R.id.imageButton9);
        tb =(ToggleButton)findViewById(R.id.toggleButton);
        ba = BluetoothAdapter.getDefaultAdapter();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ba.enable();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ba.disable();
            }
        });
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bluetooth){
                    ba.disable();
                    bluetooth=false;
                    i3.setImageResource(R.drawable.bluetoothoff);
                }
                else{
                    ba.enable();
                    bluetooth=true;
                    i3.setImageResource(R.drawable.bluetoothon);
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
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Fourth.this,Fifth.class);
                startActivity(i);
                finish();
            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Fourth.this,Third.class);
                startActivity(i);
                finish();
            }
        });
    }
}
