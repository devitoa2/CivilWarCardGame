package com.example.cardgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Loginreg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginreg);

        Button register=(Button) findViewById(R.id.register); //Instantiate button to open register page
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Loginreg.this, com.example.cardgame.register.class)); //Open register page on-click
            }
        });

        Button login=(Button) findViewById(R.id.login); //Instantiate button to enable login
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText email = (EditText) findViewById(R.id.email);
                EditText password = (EditText) findViewById(R.id.password);

                String str1 = email.getText().toString();
                String str2 = password.getText().toString();

                if (str1.matches("") || str2.matches("")) {
                    Toast.makeText(getApplicationContext(), "All fields must be completed to enable login", Toast.LENGTH_LONG).show();
                } else if (!str1.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")) {
                    Toast.makeText(getApplicationContext(), "Email must follow valid format", Toast.LENGTH_LONG).show();
                } else if (str2.length() < 4) {
                    Toast.makeText(getApplicationContext(), "Password must be minimum 4 characters", Toast.LENGTH_LONG).show(); //Password must be more than 4 characters in length
            } else {startActivity(new Intent(Loginreg.this, com.example.cardgame.LoginYes.class)); //Open login page on-click
            }
        }});
    }
}