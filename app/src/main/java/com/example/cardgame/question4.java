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

public class question4 extends AppCompatActivity {

    private int mScore4;
    private final String Score_KEY4 = "score4";
    private String mAnswer4;
    private final String Answer_KEY = "answer4";
    private TextView mShowAnswerTextView;
    // Shared preferences object
    private SharedPreferences mPreferences;

    // Name of shared preferences file
    private String sharedPrefFile =
            "com.example.android.cardgamesharedprefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);

        // Initialize views, color, preferences
        mShowAnswerTextView = findViewById(R.id.showanswer);

        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        // Restore preferences
        mScore4= mPreferences.getInt(Score_KEY4, 0);
        mAnswer4 = mPreferences.getString(Answer_KEY, "The answer you select will be shown here. Click the next button at the bottom to proceed to the next question.");
        mShowAnswerTextView.setText(mAnswer4);

        Button next=(Button) findViewById(R.id.next); //Instantiate button to open next question page
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(question4.this, com.example.cardgame.question5.class)); //Open next question page on-click
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
        mAnswer4=answer;
        if (mAnswer4.equals("Jefferson Davis")) {
            mScore4=1;
        }
        else {
            mScore4 = 0;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putString(Answer_KEY, mAnswer4);
        preferencesEditor.putInt(Score_KEY4, mScore4);
        preferencesEditor.apply();
    }
    ;}