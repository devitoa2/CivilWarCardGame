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

public class question2 extends AppCompatActivity {

    private int mScore2;
    private final String Score_KEY2 = "score2";
    private String mAnswer2;
    private final String Answer_KEY = "answer2";
    private TextView mShowAnswerTextView;
    // Shared preferences object
    private SharedPreferences mPreferences;

    // Name of shared preferences file
    private String sharedPrefFile =
            "com.example.android.cardgamesharedprefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        // Initialize views, color, preferences
        mShowAnswerTextView = findViewById(R.id.showanswer);

        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        // Restore preferences
        mScore2= mPreferences.getInt(Score_KEY2, 0);
        mAnswer2 = mPreferences.getString(Answer_KEY, "The answer you select will be shown here. Click the next button at the bottom to proceed to the next question.");
        mShowAnswerTextView.setText(mAnswer2);

        Button next=(Button) findViewById(R.id.next); //Instantiate button to open next question page
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(question2.this, com.example.cardgame.question3.class)); //Open next question page on-click
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
        mAnswer2=answer;
        if (mAnswer2.equals("South Carolina")) {
            mScore2=1;
        }
        else {
            mScore2=0;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putString(Answer_KEY, mAnswer2);
        preferencesEditor.putInt(Score_KEY2, mScore2);
        preferencesEditor.apply();
    }
    ;}
