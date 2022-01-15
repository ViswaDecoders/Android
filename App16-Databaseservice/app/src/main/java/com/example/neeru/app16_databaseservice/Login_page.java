package com.example.neeru.app16_databaseservice;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_page extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        b1 =(Button)findViewById(R.id.button);
        b2 =(Button)findViewById(R.id.button2);
        e1 =(EditText)findViewById(R.id.editText);
        e2 =(EditText)findViewById(R.id.editText2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login_page.this, Sign_up_page.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                if (s1.equals("") || s2.equals("")) {
                    Toast.makeText(Login_page.this, "Can't leave the empty above", Toast.LENGTH_SHORT).show();
                } else {
                    SQLiteDatabase sql = openOrCreateDatabase("Data", MODE_PRIVATE, null);
                    sql.execSQL("create table if not exists credentials(name varchar, email varchar, " +
                            "password varchar)");
                    String s4 = "select * from credentials where email='"+s1+"' and password='"+s2+"'";
                    Cursor cs = sql.rawQuery(s4, null);
                    if(cs.getCount()>0){
                        Toast.makeText(Login_page.this, "Login succesfullly", Toast.LENGTH_SHORT).show();
                        Intent i =new Intent(Login_page.this,Welcome_page.class);
                        startActivity(i);
                        finish();
                    }
                    else{
                        Toast.makeText(Login_page.this, "Login failed, Username/password Mismatch", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
