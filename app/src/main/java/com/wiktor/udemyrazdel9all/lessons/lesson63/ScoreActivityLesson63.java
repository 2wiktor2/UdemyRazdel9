package com.wiktor.udemyrazdel9all.lessons.lesson63;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

import com.wiktor.udemyrazdel9all.R;

public class ScoreActivityLesson63 extends AppCompatActivity {

    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_lesson63);

        textViewResult = findViewById(R.id.textViewResult);


        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("result")) {
            int result = intent.getIntExtra("result", 0);
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            int max = sharedPreferences.getInt("max", 0);
            String score = String.format("Ваш результат: %s\nМаксимальный результат: %s ", result, max);
            textViewResult.setText(score);
        }
    }

    public void onClickStartNewGame(View view) {
        Intent intent = new Intent(this, Lesson63.class);
        startActivity(intent);
    }
}