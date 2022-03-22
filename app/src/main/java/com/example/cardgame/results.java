package com.example.cardgame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class results extends AppCompatActivity {

    private int mScore;
    private final String Score_KEY = "score";
    private int mScore1;
    private final String Score_KEY1 = "score1";
    private int mScore2;
    private final String Score_KEY2 = "score2";
    private int mScore3;
    private final String Score_KEY3 = "score3";
    private int mScore4;
    private final String Score_KEY4 = "score4";
    private int mScore5;
    private final String Score_KEY5 = "score5";
    private TextView mShowScoreTextView;
    // Shared preferences object
    private SharedPreferences mPreferences;

    // Name of shared preferences file
    private String sharedPrefFile =
            "com.example.android.cardgamesharedprefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

            // Initialize views, color, preferences
            mShowScoreTextView = findViewById(R.id.score);

            mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

            // Restore preferences
            mScore1 = mPreferences.getInt(Score_KEY1, 0);
            mScore2 = mPreferences.getInt(Score_KEY2, 0);
            mScore3 = mPreferences.getInt(Score_KEY3, 0);
            mScore4 = mPreferences.getInt(Score_KEY4, 0);
            mScore5 = mPreferences.getInt(Score_KEY5, 0);
            mScore = mScore1+mScore2+mScore3+mScore4+mScore5;
            //String FScore= Integer.toString(mScore);
            mShowScoreTextView.setText(mScore+"/5");

            Button repeat=(Button) findViewById(R.id.repeat); //Instantiate button to retake quiz from the beginning
            repeat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(results.this, com.example.cardgame.LoginYes.class)); //Open beginning of quiz on-click
                    // Clear preferences
                    SharedPreferences.Editor preferencesEditor = mPreferences.edit();
                    preferencesEditor.clear();
                    preferencesEditor.apply();}
            });
        }

        @Override
        protected void onPause() {
            super.onPause();

            SharedPreferences.Editor preferencesEditor = mPreferences.edit();
            preferencesEditor.putInt(Score_KEY, mScore);
            preferencesEditor.apply();
        }
        ;}