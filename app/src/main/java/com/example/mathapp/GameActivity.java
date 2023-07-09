package com.example.mathapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

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

        textObjectPartA = (TextView) findViewById(R.id.textPartA);
        textObjectPartB = (TextView) findViewById(R.id.textPartB);
        textObjectScore = (TextView)findViewById(R.id.textScore);
        textObjectLevel = (TextView)findViewById(R.id.textLevel);
        buttonObjectChoice1 = (Button) findViewById(R.id.buttonChoice1);
        buttonObjectChoice2 = (Button) findViewById(R.id.buttonChoice2);
        buttonObjectChoice3 = (Button) findViewById(R.id.buttonChoice3);

        buttonObjectChoice1.setOnClickListener(this);
        buttonObjectChoice2.setOnClickListener(this);
        buttonObjectChoice3.setOnClickListener(this);
        setQuestion();
    }

    @Override
    public void onClick(View view){
        int answerGiven = 0;
        if(view.getId() == R.id.buttonChoice1){
            answerGiven = Integer.parseInt("" + buttonObjectChoice1.getText());
        } else if(view.getId() == R.id.buttonChoice2){
            answerGiven = Integer.parseInt("" + buttonObjectChoice2.getText());
        } else if(view.getId() == R.id.buttonChoice3){
            answerGiven = Integer.parseInt("" + buttonObjectChoice3.getText());
        }
        updateScoreAndLevel(answerGiven);
        setQuestion();
    }

    void setQuestion() {
        int numberRange = currentLevel * 3;
        Random randInt = new Random();
        int partA = randInt.nextInt(numberRange);
        partA++;
        int partB = randInt.nextInt(numberRange);
        partB++;
        correctAnswer = partA * partB;
        int wrongAnswer1 = correctAnswer-2;
        int wrongAnswer2 = correctAnswer+2;
        textObjectPartA.setText(String.valueOf(partA));
        textObjectPartB.setText(String.valueOf(partB));
        int buttonLayout = randInt.nextInt(3);
        switch (buttonLayout){
            case 0:
                buttonObjectChoice1.setText(String.valueOf(correctAnswer));
                buttonObjectChoice2.setText(String.valueOf(wrongAnswer1));
                buttonObjectChoice3.setText(String.valueOf(wrongAnswer2));
                break;
            case 1:
                buttonObjectChoice2.setText(String.valueOf(correctAnswer));
                buttonObjectChoice3.setText(String.valueOf(wrongAnswer1));
                buttonObjectChoice1.setText(String.valueOf(wrongAnswer2));
                break;
            case 2:
                buttonObjectChoice3.setText(String.valueOf(correctAnswer));
                buttonObjectChoice1.setText(String.valueOf(wrongAnswer1));
                buttonObjectChoice2.setText(String.valueOf(wrongAnswer2));
                break;
        }
    }
    void updateScoreAndLevel(int answerGiven) {
        if(isCorrect(answerGiven)){
            for(int i = 1; i <= currentLevel; i++){
                currentScore = currentScore + i;
            }
            currentLevel++;
        } else {
            currentScore = 0;
            currentLevel = 1;
        }
        textObjectScore.setText(String.format("Score: %s", String.valueOf(currentScore)));
        textObjectLevel.setText(String.format("Level: %s", String.valueOf(currentLevel)));
    }
    boolean isCorrect(int answerGiven) {
        boolean correctTrueOrFalse;
        if(answerGiven == correctAnswer) {
            Toast.makeText(getApplicationContext(), "Well done!",
                    Toast.LENGTH_LONG).show();
            correctTrueOrFalse=true;
        } else {
            Toast.makeText(getApplicationContext(), "Sorry",
                    Toast.LENGTH_LONG).show();
            correctTrueOrFalse=false;
        }
        return correctTrueOrFalse;
    }
}