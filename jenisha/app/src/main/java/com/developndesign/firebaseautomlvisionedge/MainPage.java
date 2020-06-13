package com.developndesign.firebaseautomlvisionedge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainPage extends AppCompatActivity {
    Button btnLogin1;
    Button btnSignUP1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        btnSignUP1 = findViewById(R.id.Mainsignupbtn);
        btnLogin1 = findViewById(R.id.mainloginbtn);


        btnSignUP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotosignup = new Intent(MainPage.this, Register.class);
                startActivity(gotosignup);
            }
        });

        btnLogin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotologin = new Intent(MainPage.this, Login.class);
                startActivity(gotologin);
            }
        });

    }
}


