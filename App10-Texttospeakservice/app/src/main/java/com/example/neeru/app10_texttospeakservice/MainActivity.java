package com.example.neeru.app10_texttospeakservice;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button b;
    EditText e;
    TextToSpeech t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=(Button)findViewById(R.id.button);
        e=(EditText)findViewById(R.id.editText);
        t = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                t.setLanguage(Locale.ENGLISH);
                t.setSpeechRate(0.9f);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                  String s = e.getText().toString();
                  t.speak(s,TextToSpeech.QUEUE_FLUSH,null);
             }
        });
    }
}
