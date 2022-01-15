package com.example.app22_firebaseauth_gmail;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class MainActivity extends AppCompatActivity {
    SignInButton signin;
    FirebaseAuth firebaseAuth;
    GoogleSignInClient googleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signin = findViewById(R.id.signin);
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken("773654213757-7eklcitdj484epmmph6t64r472e1n7bs.apps.googleusercontent.com").requestEmail().build();
        googleSignInClient = GoogleSignIn.getClient(MainActivity.this,googleSignInOptions);
        signin.setOnClickListener(view -> {
            Intent intent=googleSignInClient.getSignInIntent();
            startActivityForResult(intent,20);
        });
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser != null){
            Intent i = new Intent(MainActivity.this,Welcome.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
            finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 20){
            Task<GoogleSignInAccount> signInAccountTask = GoogleSignIn.getSignedInAccountFromIntent(data);
            GoogleSignInAccount googleSignInAccount = signInAccountTask.getResult();
            AuthCredential authCredential = GoogleAuthProvider.getCredential(googleSignInAccount.getIdToken(),null);
            firebaseAuth.signInWithCredential(authCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Toast.makeText(MainActivity.this, "Sign in succesful", Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "Registation done", Toast.LENGTH_SHORT).show();
                Intent j =new Intent(MainActivity.this,Welcome.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(j);
                finish();
                }
            });
        }
        else {
            Toast.makeText(MainActivity.this, "Sign in succesful", Toast.LENGTH_SHORT).show();
        }
    }
}