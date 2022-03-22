package com.example.cardgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cardgame.R;

public class register extends AppCompatActivity {

    public void register() { //Function called when pressing register button on the register activity screen

        EditText fname = (EditText) findViewById(R.id.firstname);   //Instantiating every text field as a variable
        EditText famname = (EditText) findViewById(R.id.familyname);
        EditText dob = (EditText) findViewById(R.id.dateofbirth);
        EditText email = (EditText) findViewById(R.id.emailreg);
        EditText password = (EditText) findViewById(R.id.passwordreg);
        TextView feedback = (TextView) findViewById(R.id.feedback);

        String field1 = fname.getText().toString(); //Transforming each text field user input into a string for validation
        String field2 = famname.getText().toString();
        String field3 = dob.getText().toString();
        String field4 = email.getText().toString();
        String field5 = password.getText().toString();

        if (field1.matches("") || field2.matches("") || field3.matches("") || field4.matches("") || field5.matches("")) {
            Toast.makeText(getApplicationContext(), "One or more fields is empty, please fill out all fields.", Toast.LENGTH_LONG).show();
            feedback.setText("One or more fields is empty, please fill out all fields."); //If any fields are blank, send error message
        } else if (field1.length() < 3) {
            Toast.makeText(getApplicationContext(), "First name must be minimum 3 characters.", Toast.LENGTH_LONG).show();
            feedback.setText("First name must be minimum 3 characters"); //If first name less than 3 characters, send error message
        } else if (field1.length() > 30) {
            Toast.makeText(getApplicationContext(), "First name may be a maximum of 30 characters.", Toast.LENGTH_LONG).show();
            feedback.setText("First name may be a maximum of 30 characters"); //If first name greater than 30 characters, send error message
        } else if (field2.length() < 3) {
            Toast.makeText(getApplicationContext(), "Family name must be minimum 3 characters.", Toast.LENGTH_LONG).show();
            feedback.setText("Family name must be minimum 3 characters"); //If family name less than 3 characters, send error message
        } else if (field2.length() > 30) {
            Toast.makeText(getApplicationContext(), "Family name may be a maximum of 30 characters.", Toast.LENGTH_LONG).show();
            feedback.setText("Family name may be a maximum of 30 characters"); //If family name greater than 30 characters, send error message
        } else if (!field3.matches("\\d{2}\\d{2}\\d{4}")) {
            Toast.makeText(getApplicationContext(), "Date must be in the format MMDDYYYY.", Toast.LENGTH_LONG).show();
            feedback.setText("Date must be in the format MMDDYYYY"); //Date must be in specified format
        } else if (!field4.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")) {
            Toast.makeText(getApplicationContext(), "Must enter a valid email address.", Toast.LENGTH_LONG).show();
            feedback.setText("Must enter a valid email address"); //Email must be in standardized format
        } else if (field5.length() < 4) {
            Toast.makeText(getApplicationContext(), "Password must be minimum 4 characters.", Toast.LENGTH_LONG).show();
            feedback.setText("Password must be minimum 4 characters"); //Password must be more than 4 characters in length
        } else {
            startActivity(new Intent(register.this, Loginreg.class));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) { //Action when register button is clicked
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button reg=(Button) findViewById(R.id.regbutton); //Instantiate register button to call register function once clicked
        reg.setOnClickListener(v -> {register();
    });
    }
}