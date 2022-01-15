package com.example.app2_firebaseauth_otp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

public class Otp extends AppCompatActivity {
    EditText e1;
    Button b1;
    FirebaseAuth firebaseAuth;
    String phone,otpid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        phone = getIntent().getStringExtra("phone").toString();
        e1 = (EditText) findViewById(R.id.editTextTextPersonName2);
        b1 = (Button) findViewById(R.id.button2);
        firebaseAuth = FirebaseAuth.getInstance();
        getotp();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (e1.getText().toString().isEmpty())
                    Toast.makeText(Otp.this, "Fill the OTP please", Toast.LENGTH_SHORT).show();
                else {
                    if (e1.getText().toString().length() != 6)
                        Toast.makeText(Otp.this, "Invalid OTP", Toast.LENGTH_SHORT).show();
                    else {
                        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(otpid, e1.getText().toString());
                        signinwithPhoneauthCredintial(credential);
                    }
                }
            }
        });
    }
    private void getotp(){
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phone,
                60,
                TimeUnit.SECONDS,
                this,
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onCodeSent(@NonNull  String s, @NonNull @org.jetbrains.annotations.NotNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        super.onCodeSent(s, forceResendingToken);
                        otpid=s;
                    }

                    @Override
                    public void onVerificationCompleted(@NonNull  PhoneAuthCredential phoneAuthCredential) {
                        signinwithPhoneauthCredintial(phoneAuthCredential);
                    }

                    @Override
                    public void onVerificationFailed(@NonNull  FirebaseException e) {
                        Toast.makeText(Otp.this, "Failed to register", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
    private void signinwithPhoneauthCredintial(PhoneAuthCredential credential){
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Otp.this, "Successfully logged in", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Otp.this,Welcome.class);
                    startActivity(i);
                    finish();
                }
                else{
                    Toast.makeText(Otp.this, "Sorry, failed please retry", Toast.LENGTH_SHORT).show();
                    Intent j = new Intent(Otp.this,Registration.class);
                    startActivity(j);
                    finish();
                }

            }
        });
    }
}