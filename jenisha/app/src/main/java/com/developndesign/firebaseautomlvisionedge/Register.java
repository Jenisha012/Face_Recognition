package com.developndesign.firebaseautomlvisionedge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {
    EditText emailID, password;
    Button btnSignUP;
    TextView tvlogin;
//    private FirebaseAuth mAuth;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFirebaseAuth = FirebaseAuth.getInstance();
        emailID = findViewById(R.id.EmailAddress);
        password = findViewById(R.id.Password);
        btnSignUP = findViewById(R.id.signupbtn);
        tvlogin = findViewById(R.id.loginaccount);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if(mFirebaseUser != null)
                {
                    Toast.makeText(Register.this, "Registration Unsuccessful", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Register.this, MainActivity.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(Register.this, "Please SignUp", Toast.LENGTH_SHORT).show();
                }
            }
        };

        btnSignUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailID.getText().toString();
                String pwd = password.getText().toString();

                if(email.isEmpty())
                {
                    emailID.setError("Please enter email id");
                    emailID.requestFocus();
                }
                else if (pwd.isEmpty()) {
                    password.setError("Please enter your password");
                    password.requestFocus();
                }
                else if (email.isEmpty() && pwd.isEmpty())
                {
                    Toast.makeText(Register.this, "Fields are Empty", Toast.LENGTH_SHORT).show();
                }
                else if (!(email.isEmpty() && pwd.isEmpty()))
                {
                    mFirebaseAuth.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task)
                        {
                            if (!task.isSuccessful())
                            {
                                Toast.makeText(Register.this, "SignUp Unsuccessful, Try Again", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                startActivity(new Intent(Register.this, MainActivity.class));
                            }
                        }
                    });
                }

                else {
                    Toast.makeText(Register.this, "Error Occurred!", Toast.LENGTH_SHORT).show();

                }
            }
        });

        tvlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Register.this, Login.class);
                startActivity(i);
            }
        });
    }
}