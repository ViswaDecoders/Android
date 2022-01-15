package com.example.app19_smsandcallingservice;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class Call extends AppCompatActivity {
    Button b1;
    EditText e1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        b1 = (Button)findViewById(R.id.button);
        e1 = (EditText)findViewById(R.id.editTextTextPersonName3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callPhoneNumber();
            }
        });
    }
    public void callPhoneNumber()
    {
        String num = e1.getText().toString();
        try
        {
            if(Build.VERSION.SDK_INT > 22)
            {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(Call.this, new String[]{Manifest.permission.CALL_PHONE}, 101);
                    return;
                }

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + num));
                startActivity(callIntent);

            }
            else {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + num));
                startActivity(callIntent);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 101) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                callPhoneNumber();
            } else {
                Toast.makeText(Call.this, "Permission not Granted", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
