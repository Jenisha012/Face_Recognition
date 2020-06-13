package com.developndesign.firebaseautomlvisionedge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    EditText emailID, password;
    Button btnLogin;
    TextView tvSignUp;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFirebaseAuth = FirebaseAuth.getInstance();
        emailID = findViewById(R.id.EmailAddress);
        password = findViewById(R.id.Password);
        btnLogin = findViewById(R.id.loginbtn);
        tvSignUp = findViewById(R.id.createaccount);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth)
            {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if(mFirebaseUser != null)
                {
                    Toast.makeText(Login.this, "Successfully logged in!!!!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Login.this, MainActivity.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(Login.this, "Please login", Toast.LENGTH_SHORT).show();
                }
            }
        };

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String email = emailID.getText().toString();
                String pwd = password.getText().toString();
                if(email.isEmpty())
                {
                    emailID.setError("Please enter email id");
                    emailID.requestFocus();
                }
                else if (pwd.isEmpty())
                {
                    password.setError("Please enter your password");
                    password.requestFocus();
                }
                else if (email.isEmpty() && pwd.isEmpty())
                {
                    Toast.makeText(Login.this, "Fields are Empty", Toast.LENGTH_SHORT).show();
                }
                else if (!(email.isEmpty() && pwd.isEmpty()))
                {
                    mFirebaseAuth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>()
                    {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful())
                            {
                                Toast.makeText(Login.this, "Login Error, Please Login Again", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Intent inToAI = new Intent(Login.this, MainActivity.class);
                                startActivity(inToAI);
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(Login.this, "Error Occurred", Toast.LENGTH_SHORT).show();
                }

            }
        });
        // for moving from login page to sign up page
        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intSignUp = new Intent(Login.this, Register.class);
                startActivity(intSignUp);
            }
        });
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }
}