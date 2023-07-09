package com.example.mathapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    int correctAnswer;
    Button buttonObjectChoice1;
    Button buttonObjectChoice2;
    Button buttonObjectChoice3;
    TextView textObjectPartA;
    TextView textObjectPartB;
    TextView textObjectScore;
    TextView textObjectLevel;
    int currentScore = 0;
    int currentLevel = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        TextView textObjectPartA = (TextView) findViewById(R.id.textPartA);
        TextView textObjectPartB = (TextView) findViewById(R.id.textPartB);
        textObjectScore = (TextView)findViewById(R.id.textScore);
        textObjectLevel = (TextView)findViewById(R.id.textLevel);
        buttonObjectChoice1 = (Button) findViewById(R.id.buttonChoice1);
        buttonObjectChoice2 = (Button) findViewById(R.id.buttonChoice2);
        buttonObjectChoice3 = (Button) findViewById(R.id.buttonChoice3);

        buttonObjectChoice1.setOnClickListener(this);
        buttonObjectChoice2.setOnClickListener(this);
        buttonObjectChoice3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        int answerGiven;
        if(view.getId() == R.id.buttonChoice1){
            answerGiven = Integer.parseInt("" + buttonObjectChoice1.getText());
        } else if(view.getId() == R.id.buttonChoice2){
            answerGiven = Integer.parseInt("" + buttonObjectChoice2.getText());
        } else if(view.getId() == R.id.buttonChoice3){
            answerGiven = Integer.parseInt("" + buttonObjectChoice3.getText());
        }
    }
}