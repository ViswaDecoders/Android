package com.example.app19_smsandcallingservice;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Sms extends AppCompatActivity {
    Button b1;
    EditText e1,e2;
    SmsManager sms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        b1 = (Button) findViewById(R.id.button4);
        e1 = (EditText) findViewById(R.id.editTextTextPersonName);
        e2 = (EditText) findViewById(R.id.editTextTextPersonName2);
        sms = SmsManager.getDefault();
//        b1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String s1 = e1.getText().toString();
//                String s2 = e2.getText().toString();
//                sms.sendTextMessage(s1,null,s2,null,null);
//                Toast.makeText(Sms.this, "SMS send succesfully", Toast.LENGTH_SHORT).show();
//            }
//        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                Intent s = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:"+s1));
//                s.setDataAndType(Uri.parse("sms:"),"vnd.android-dir/mms-sms");
//                s.putExtra("address"  , "8848119275");
                s.putExtra("sms_body"  , s2);
                startActivity(s);
            }
        });
    }
}