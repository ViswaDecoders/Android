package com.sitamadex11.quizapp;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class Fourth extends AppCompatActivity {
    Button b1;
    TextView t1;
    TextToSpeech ts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        b1 = (Button)findViewById(R.id.button4);
        t1 = (TextView)findViewById(R.id.textView4);
        ts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                ts.setLanguage(Locale.ENGLISH);
                ts.setSpeechRate(0.9f);
            }
        });
        t1.setText("Your Score : "+Main.score);
        ts.speak("Your Score : "+Integer.toString(Main.score) ,TextToSpeech.QUEUE_FLUSH,null);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Fourth.this,Main.class);
                startActivity(i);
                finish();
            }
        });
    }
}
