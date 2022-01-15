package com.example.neeru.app12_intentshareddata;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class Third extends AppCompatActivity {
    Button b1,b2;
    TextView t1;
    TextToSpeech t,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        b1 = (Button)findViewById(R.id.button3);
        t1 = (TextView)findViewById(R.id.textView);
        b2= (Button)findViewById(R.id.button4);
        t = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                t.setLanguage(Locale.KOREAN);
                t.setSpeechRate(.9f);
            }
        });
        t2 = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                t.setLanguage(Locale.ENGLISH);
                t.setSpeechRate(.9f);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = (String)getIntent().getExtras().get("sum");  //or getIntent.getStringExtra("sum")
                t1.setText(s);
                t.speak("The sum is "+s,TextToSpeech.QUEUE_FLUSH,null);
                t2.speak("The sum is "+s,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Third.this,First.class);
                startActivity(i);
                finish();
            }
        });
    }
}
