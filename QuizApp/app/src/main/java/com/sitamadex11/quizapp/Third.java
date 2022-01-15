package com.sitamadex11.quizapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Third extends AppCompatActivity {
    Button b1;
    RadioButton r1,r2,r3,r4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        b1 = (Button)findViewById(R.id.button3);
        r1 = (RadioButton)findViewById(R.id.radioButton9);
        r2 = (RadioButton)findViewById(R.id.radioButton10);
        r3 = (RadioButton)findViewById(R.id.radioButton11);
        r4 = (RadioButton)findViewById(R.id.radioButton12);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(r1.isChecked()){
                    Main.score++;
                }
                else{
                    Main.score--;
                }
                for(int j = 0; j < Main.set.size(); j++){
                    if(Main.set.get(j) == Third.class){
                        List<Class> tempList = new ArrayList<Class>(Main.set);
                        tempList.remove(j);
                        // Main.set = tempList.toArray(new Class[0]);
                        Main.set.clear();
                        Main.set.addAll(tempList);
                        break;
                    }
                }
                if(Main.set.size() != 0){
                    Random generator = new Random();
                    int number = generator.nextInt(Main.set.size())+0;
                    Intent i= new Intent(Third.this, Main.set.get(number));
                    startActivity(i);
                    finish();
                }
                else{
                    Intent i= new Intent(Third.this,Fourth.class);
                    startActivity(i);
                    finish();
                }
            }
        });
    }
}
