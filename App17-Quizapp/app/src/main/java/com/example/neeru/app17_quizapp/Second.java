package com.example.neeru.app17_quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Second extends AppCompatActivity {
    Button b1;
    RadioButton r1,r2,r3,r4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        b1 = (Button)findViewById(R.id.button2);
        r1 = (RadioButton)findViewById(R.id.radioButton5);
        r2 = (RadioButton)findViewById(R.id.radioButton6);
        r3 = (RadioButton)findViewById(R.id.radioButton7);
        r4 = (RadioButton)findViewById(R.id.radioButton8);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(r1.isChecked()){
                    Main.score++;
                }
                else{
                    Main.score--;
                }
                for(int j = 0; j < Main.set.length; j++){
                    if(Main.set[j] == Second.class){
                        List<Class> tempList = new ArrayList<Class>(Arrays.asList(Main.set));
                        tempList.remove(j);
                        Main.set = tempList.toArray(new Class[0]);
                        break;
                    }
                }
                if(Main.set.length != 0){
                    Random generator = new Random();
                    int number = generator.nextInt(Main.set.length)+0;
                    Intent i= new Intent(Second.this,Main.set[number]);
                    startActivity(i);
                    finish();
                }
                else{
                    Intent i= new Intent(Second.this,Fourth.class);
                    startActivity(i);
                    finish();
                }
            }
        });
    }
}
