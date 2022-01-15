package com.example.neeru.app17_quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class Main extends AppCompatActivity {
    Button b1;
    static Class set[] = {First.class,Second.class,Third.class};
//    static Class sets[] = set;
    static int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 =(Button)findViewById(R.id.button5);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score =0;
                Random generator = new Random();
                int number = generator.nextInt(3)+0;
                Intent i = new Intent(Main.this, set[number]);
                startActivity(i);
                finish();
            }
        });
    }
    @Override
    protected void onResume(){
        super.onResume();
        set[0] = First.class;
        set[1] = Second.class;
        set[2] = Third.class;
    }
}
