package com.example.app2_firebaseauth_otp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.hbb20.CountryCodePicker;

public class Registration extends AppCompatActivity {
    Button b1;
    EditText e1;
    CountryCodePicker ccp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        b1 = (Button)findViewById(R.id.button);
        e1 = (EditText)findViewById(R.id.editTextTextPersonName);
        ccp = (CountryCodePicker)findViewById(R.id.ccp);
        ccp.registerCarrierNumberEditText(e1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Registration.this,Otp.class);
                i.putExtra("phone",ccp.getFullNumberWithPlus().trim());
                startActivity(i);
            }
        });
    }
}