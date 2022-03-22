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

public class question3 extends AppCompatActivity {

    private int mScore3;
    private final String Score_KEY3 = "score3";
    private String mAnswer3;
    private final String Answer_KEY = "answer3";
    private TextView mShowAnswerTextView;
    // Shared preferences object
    private SharedPreferences mPreferences;

    // Name of shared preferences file
    private String sharedPrefFile =
            "com.example.android.cardgamesharedprefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);

        // Initialize views, color, preferences
        mShowAnswerTextView = findViewById(R.id.showanswer);

        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        // Restore preferences
        mScore3= mPreferences.getInt(Score_KEY3, 0);
        mAnswer3 = mPreferences.getString(Answer_KEY, "The answer you select will be shown here. Click the next button at the bottom to proceed to the next question.");
        mShowAnswerTextView.setText(mAnswer3);

        Button next=(Button) findViewById(R.id.next); //Instantiate button to open next question page
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(question3.this, com.example.cardgame.question4.class)); //Open next question page on-click
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
        mAnswer3=answer;
        if (mAnswer3.equals("Reconstruction")) {
            mScore3=1;
        }
        else {
            mScore3=0;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putString(Answer_KEY, mAnswer3);
        preferencesEditor.putInt(Score_KEY3, mScore3);
        preferencesEditor.apply();
    }
    ;}