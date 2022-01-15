package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public abstract class TextToSpeech extends AppCompatActivity {
    Button b18;
    EditText e4;
    TextToSpeech ts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_speech);
        b18=(Button)findViewById(R.id.button18);
        e4=(EditText)findViewById(R.id.editText4);
        ts = new TextToSpeech(this, new android.speech.tts.TextToSpeech.OnInitListener {
            @Override
            public void onInit(int i) {
                ts.Language(Locale.ENGLISH);
                ts.SpeechRate(0.9f);
            }
        };
        b18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e4.getText().toString();
                ts.speak(s1,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
    }

    public abstract void onInit(int i);
}