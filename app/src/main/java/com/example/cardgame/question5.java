package com.example.cardgame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class question5 extends AppCompatActivity {

    private int mScore5;
    private final String Score_KEY5 = "score5";
    private String mAnswer5;
    private final String Answer_KEY = "answer5";
    private TextView mShowAnswerTextView;
    // Shared preferences object
    private SharedPreferences mPreferences;

    // Name of shared preferences file
    private String sharedPrefFile =
            "com.example.android.cardgamesharedprefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);

        // Initialize views, color, preferences
        mShowAnswerTextView = findViewById(R.id.showanswer);

        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        // Restore preferences
        mScore5= mPreferences.getInt(Score_KEY5, 0);
        mAnswer5 = mPreferences.getString(Answer_KEY, "The answer you select will be shown here. Click the next button at the bottom to proceed to the next question.");
        mShowAnswerTextView.setText(mAnswer5);

        Button next=(Button) findViewById(R.id.next); //Instantiate button to open results page
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(question5.this, com.example.cardgame.results.class)); //Open results page on-click
            }
        });
    }

    public void answer(View v) {
        Button button= (Button) v;
        Toast.makeText(getApplicationContext(), "You have made a selection," +
                        " please review this before moving on to the next question.",
                Toast.LENGTH_SHORT).show();
        String answer= ((Button) v).getText().toString();
        mShowAnswerTextView.setGravity(Gravity.CENTER);
        mShowAnswerTextView.setText(answer);
        mAnswer5=answer;
        if (mAnswer5.equals("Kentucky")) {
            mScore5=1;
        }
        else {
            mScore5 = 0;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putString(Answer_KEY, mAnswer5);
        preferencesEditor.putInt(Score_KEY5, mScore5);
        preferencesEditor.apply();
    }
    ;}