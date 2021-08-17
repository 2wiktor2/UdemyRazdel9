package com.wiktor.udemyrazdel9all.lessons.lesson63;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.wiktor.udemyrazdel9all.R;

import java.util.ArrayList;
import java.util.Locale;

public class Lesson63 extends AppCompatActivity {

    //android:onClick="onClickAnswer" --- при клике ответить


    private TextView textViewQuestion;
    private TextView textViewScore;
    private TextView textViewTimer;
    private TextView textViewVar0;
    private TextView textViewVar1;
    private TextView textViewVar2;
    private TextView textViewVar3;

    private ArrayList<TextView> options = new ArrayList<>();

    private String question; // вопрос
    private int rightAnswer; // правильный ответ
    private int answerPosition; // позиция правильного ответа
    private boolean isPositive; // Знак +/- положительное ли число
    // пределы чисел
    private int min = 5;
    private int max = 30;

    private int countOfQuestions = 0;
    private int countOfRightAnswers = 0;

    private boolean gameOver = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson63);

        textViewQuestion = findViewById(R.id.textView_question);
        textViewScore = findViewById(R.id.textView_score);
        textViewTimer = findViewById(R.id.textView_timer);
        textViewVar0 = findViewById(R.id.textView0);
        textViewVar1 = findViewById(R.id.textView1);
        textViewVar2 = findViewById(R.id.textView2);
        textViewVar3 = findViewById(R.id.textView3);

        options.add(textViewVar0);
        options.add(textViewVar1);
        options.add(textViewVar2);
        options.add(textViewVar3);

        playNext();

        CountDownTimer timer = new CountDownTimer(6000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textViewTimer.setText(getTime(millisUntilFinished));

                if (millisUntilFinished < 10000) {
                    textViewTimer.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                }
            }

            @Override
            public void onFinish() {
                gameOver = true;
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                int max = preferences.getInt("max", 0);
                if (countOfRightAnswers > max) {
                    preferences.edit().putInt("max", countOfRightAnswers).apply();
                }
                Intent intent = new Intent(Lesson63.this, ScoreActivityLesson63.class);
                intent.putExtra("result", countOfRightAnswers);
                startActivity(intent);
            }
        };

        timer.start();

  /*        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        // Складываем данные в SharedPreferences
        preferences.edit().putInt("test", 5).apply();
        // забираем данные из SharedPreferences
        int test = preferences.getInt("test", 0);
        Toast.makeText(this, Integer.toString(test), Toast.LENGTH_SHORT).show();*/
    }

    private void playNext() {
        generateQuestion();
        for (int i = 0; i < options.size(); i++) {
            if (i == answerPosition) {
                options.get(i).setText(Integer.toString(rightAnswer));
            } else {
                options.get(i).setText(Integer.toString(generateWrongAnswer()));
            }
        }
        String score = String.format("%s / %s", countOfRightAnswers, countOfQuestions);
        textViewScore.setText(score);
    }

    private String getTime(long millis) {
        int seconds = (int) (millis / 1000);
        int minutes = (int) (seconds / 60);
        seconds = seconds % 60;
        return String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
    }


    private void generateQuestion() {
        int a = (int) (Math.random() * (max - min + 1) + min);
        int b = (int) (Math.random() * (max - min + 1) + min);
        int mark = (int) (Math.random() * 2);
        isPositive = mark == 1;
        if (isPositive) {
            rightAnswer = a + b;
            question = String.format("%s + %s", a, b);
        } else {
            rightAnswer = a - b;
            question = String.format("%s - %s", a, b);
        }
        textViewQuestion.setText(question);
        answerPosition = (int) (Math.random() * 4);
    }

    private int generateWrongAnswer() {
        int result;
        do {
            result = (int) ((Math.random() * max * 2 + 1) - (max - min));
        } while (result == rightAnswer);
        return result;
    }

    public void onClickAnswer(View view) {
        if (!gameOver) {
            TextView textView = (TextView) view;
            String answer = textView.getText().toString();
            int chosenAnswer = Integer.parseInt(answer);
            if (chosenAnswer == rightAnswer) {
                countOfRightAnswers++;
                Toast.makeText(this, "Верно", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "Неверно", Toast.LENGTH_SHORT).show();
            }
            countOfQuestions++;
            playNext();
        }
    }
}