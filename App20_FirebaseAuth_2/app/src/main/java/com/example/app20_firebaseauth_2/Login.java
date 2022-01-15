package com.example.app20_firebaseauth_2;

import android.content.Intent;
import android.os.Bundle;
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

public class Login extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2;
    ProgressBar p1;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        b1 = findViewById(R.id.button3);
        b2 = findViewById(R.id.button4);
        e1 = findViewById(R.id.editTextTextPersonName3);
        e2 = findViewById(R.id.editTextTextPersonName4);
        p1 = findViewById(R.id.progressBar2);
        firebaseAuth = FirebaseAuth.getInstance();
        b1.setOnClickListener(view -> {
            String email =e1.getText().toString();
            String pass =e2.getText().toString();
            if(email.isEmpty()){
                e1.setError("Fill the email");
                return;
            }
            else if(pass.isEmpty()){
                e2.setError("fill the password");
                return;
            }
            p1.setVisibility(View.VISIBLE);
            firebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(Login.this, "Logged in Succefully", Toast.LENGTH_SHORT).show();
                        Intent i =new Intent(Login.this,Welcome.class);
                        startActivity(i);
                        finish();
                    }
                    else{
                        Toast.makeText(Login.this, "email/password mismatch", Toast.LENGTH_SHORT).show();
                    }
                    p1.setVisibility(View.INVISIBLE);
                }
            });
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k= new Intent(Login.this,Registration.class);
                startActivity(k);
                finish();
            }
        });
    }
}