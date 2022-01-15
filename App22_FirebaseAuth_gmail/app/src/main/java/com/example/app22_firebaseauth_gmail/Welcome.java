package com.example.app22_firebaseauth_gmail;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Welcome extends AppCompatActivity {
   ImageView i1;
   TextView t1;
   Button b1;
   FirebaseAuth firebaseAuth;
   GoogleSignInClient googleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        i1 = findViewById(R.id.imageView);
        b1 = findViewById(R.id.button);
        t1 = findViewById(R.id.textView);
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser!=null){
            Glide.with(Welcome.this).load(firebaseUser.getPhotoUrl()).into(i1);
            t1.setText(firebaseUser.getDisplayName());
        }
        googleSignInClient = GoogleSignIn.getClient(Welcome.this, GoogleSignInOptions.DEFAULT_SIGN_IN);
        b1.setOnClickListener(view -> {
            googleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(Welcome.this, "Sign out succesful", Toast.LENGTH_SHORT).show();
                        firebaseAuth.signOut();
                        Intent i =new Intent(Welcome.this,MainActivity.class);
                        startActivity(i);
                        finish();
                    }
                }
            });
        });
    }
}