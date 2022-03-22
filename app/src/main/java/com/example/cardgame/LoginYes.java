package com.example.cardgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cardgame.R;

public class LoginYes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_yes);

        Button begin=(Button) findViewById(R.id.begin); //Instantiate button to open register page
        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginYes.this, com.example.cardgame.question1.class)); //Open register page on-click
            }
        });
    }
}