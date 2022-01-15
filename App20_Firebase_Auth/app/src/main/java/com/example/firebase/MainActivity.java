package com.example.firebase;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    Button b1;
    EditText e1,e2;
    ProgressBar p1;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 =(EditText)findViewById(R.id.editText);
        e2 =(EditText)findViewById(R.id.editText2);
        e2.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
        b1 =(Button)findViewById(R.id.button);
        p1 =(ProgressBar)findViewById(R.id.progressBar);
        firebaseAuth = FirebaseAuth.getInstance();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=e1.getText().toString();
                String pass=e2.getText().toString();
                if(email.isEmpty()) {
                    e1.setError("Fill email");
                    return;
                }
                else if(pass.isEmpty()) {
                    e2.setError("Fill password");
                    return;
                }
                p1.setVisibility(view.VISIBLE);
                firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                            Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();

                        else
                            Toast.makeText(MainActivity.this, "Registration Unsuccessful", Toast.LENGTH_SHORT).show();

                        p1.setVisibility(view.INVISIBLE);
                    }
                });
            }
        });
    }
}