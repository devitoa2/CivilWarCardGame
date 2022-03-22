package com.example.cardgame;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class question1 extends AppCompatActivity {

    private int mScore1=0;
    private final String Score_KEY1 = "score1";
    private String mAnswer1;
    private final String Answer_KEY = "answer1";
    private TextView mShowAnswerTextView;
    // Shared preferences object
    private SharedPreferences mPreferences;

    // Name of shared preferences file
    private String sharedPrefFile =
            "com.example.android.cardgamesharedprefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question1);

        // Initialize views, color, preferences
        mShowAnswerTextView = findViewById(R.id.showanswer);

        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        // Restore preferences
        mScore1= mPreferences.getInt(Score_KEY1, 0);
        mAnswer1 = mPreferences.getString(Answer_KEY, "The answer you select will be shown here. Click the next button at the bottom to proceed to the next question.");
        mShowAnswerTextView.setText(mAnswer1);

        Button next=(Button) findViewById(R.id.next); //Instantiate button to open next question page
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(question1.this, com.example.cardgame.question2.class)); //Open next question page on-click
            }
        });
    }

    public void answer(View v) {
        Button button= (Button) v;
        Toast.makeText(getApplicationContext(), "You have made a selection," +
                        "please review this before moving on to the next question.",
                Toast.LENGTH_SHORT).show();
        String answer= ((Button) v).getText().toString();
        mShowAnswerTextView.setGravity(Gravity.CENTER);
        mShowAnswerTextView.setText(answer);
        mAnswer1=answer;
        if (mAnswer1.equals("2%")) {
            mScore1=1;
        }
        else {
            mScore1=0;
        }
            }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putString(Answer_KEY, mAnswer1);
        preferencesEditor.putInt(Score_KEY1, mScore1);
        preferencesEditor.apply();
    }
;}
