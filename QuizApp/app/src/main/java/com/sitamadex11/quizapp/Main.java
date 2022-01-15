package com.sitamadex11.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class Main extends AppCompatActivity {
    Button b1;
    //static Class set[] = {First.class,Second.class,Third.class};
    public static ArrayList<Class> set = new ArrayList<>();
    //    static Class sets[] = set;
    static int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        set.add(First.class);
        set.add(Second.class);
        set.add(Third.class);
        b1 = (Button) findViewById(R.id.button5);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score = 0;
                Random generator = new Random();
                int number = generator.nextInt(3) + 0;
                Intent i = new Intent(Main.this, set.get(number));
                startActivity(i);
                finish();
            }
        });
    }
}
