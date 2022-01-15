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

public class Sign_up_page extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2,e3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
        b1= (Button)findViewById(R.id.button3);
        b2= (Button)findViewById(R.id.button4);
        e1= (EditText)findViewById(R.id.editText3);
        e2= (EditText)findViewById(R.id.editText4);
        e3= (EditText)findViewById(R.id.editText5);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j= new Intent(Sign_up_page.this,Login_page.class);
                startActivity(j);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                if(s1.equals("")||s2.equals("")||s3.equals("")){
                    Toast.makeText(Sign_up_page.this, "Can't leave the empty above", Toast.LENGTH_SHORT).show();
                }
                else{
                    SQLiteDatabase sql=openOrCreateDatabase("Data",MODE_PRIVATE,null);
                    sql.execSQL("create table if not exists credentials(name varchar, email varchar, " +
                            "password varchar)");
                    String s4 = "select * from credentials where name='"+s1+"' and email='"+s2+"'";
                    Cursor cs = sql.rawQuery(s4,null);
                    if(cs.getCount()>0){
                        Toast.makeText(Sign_up_page.this, "User already exists", Toast.LENGTH_SHORT).show();
                        Toast.makeText(Sign_up_page.this, "Please Login", Toast.LENGTH_SHORT).show();
                        Intent i= new Intent(Sign_up_page.this,Login_page.class);
                        startActivity(i);
                        finish();
                    }
                    else{
                        sql.execSQL("insert into credentials values('"+s1+"','"+s2+"','"+s3+"')");
                        Toast.makeText(Sign_up_page.this, "Registration done", Toast.LENGTH_SHORT).show();
                        Toast.makeText(Sign_up_page.this, "Kidly Login and avail our services", Toast.LENGTH_SHORT).show();
                        Intent j=new Intent(Sign_up_page.this,Login_page.class);
                        startActivity(j);
                        finish();
                    }
                }
            }
        });
    }
}
