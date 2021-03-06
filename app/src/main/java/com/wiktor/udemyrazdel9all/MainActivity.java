package com.wiktor.udemyrazdel9all;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wiktor.udemyrazdel9all.lessons.ActivityStopWatch;
import com.wiktor.udemyrazdel9all.lessons.ActivityTimer;
import com.wiktor.udemyrazdel9all.lessons.Lesson56;
import com.wiktor.udemyrazdel9all.lessons.Lesson57;
import com.wiktor.udemyrazdel9all.lessons.Lesson58;
import com.wiktor.udemyrazdel9all.lessons.Lesson60;
import com.wiktor.udemyrazdel9all.lessons.Lesson61;
import com.wiktor.udemyrazdel9all.lessons.Lesson62;
import com.wiktor.udemyrazdel9all.lessons.lesson63.Lesson63;
import com.wiktor.udemyrazdel9all.lessons.lesson64.Lesson64;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonStopWatch; //Секундомер
    private Button buttonTimer;
    private Button buttonLesson56;
    private Button buttonLesson57;
    private Button buttonLesson58;
    private Button buttonLesson60;
    private Button buttonLesson61;
    private Button buttonLesson62;
    private Button buttonLesson63;
    private Button buttonLesson64;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonStopWatch = findViewById(R.id.button_stopwatch);
        buttonStopWatch.setOnClickListener(this);
        buttonTimer = findViewById(R.id.button_timer);
        buttonTimer.setOnClickListener(this);
        buttonLesson56 = findViewById(R.id.button_lesson_56);
        buttonLesson56.setOnClickListener(this);
        buttonLesson57 = findViewById(R.id.button_lesson_57);
        buttonLesson57.setOnClickListener(this);
        buttonLesson58 = findViewById(R.id.button_lesson_58);
        buttonLesson58.setOnClickListener(this);
        buttonLesson60 = findViewById(R.id.button_lesson_60);
        buttonLesson60.setOnClickListener(this);
        buttonLesson61 = findViewById(R.id.button_lesson_61);
        buttonLesson61.setOnClickListener(this);
        buttonLesson62 = findViewById(R.id.button_lesson_62);
        buttonLesson62.setOnClickListener(this);
        buttonLesson63 = findViewById(R.id.button_lesson_63);
        buttonLesson63.setOnClickListener(this);
        buttonLesson64 = findViewById(R.id.button_lesson_64);
        buttonLesson64.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_stopwatch:
                Intent intent0 = new Intent(this, ActivityStopWatch.class);
                startActivity(intent0);
                break;
            case R.id.button_timer:
                Intent intent00 = new Intent(this, ActivityTimer.class);
                startActivity(intent00);
                break;
            case R.id.button_lesson_56:
                Intent intent = new Intent(this, Lesson56.class);
                startActivity(intent);
                break;
            case R.id.button_lesson_57:
                Intent intent1 = new Intent(this, Lesson57.class);
                startActivity(intent1);
                break;
            case R.id.button_lesson_58:
                Intent intent2 = new Intent(this, Lesson58.class);
                startActivity(intent2);
                break;
            case R.id.button_lesson_60:
                Intent intent3 = new Intent(this, Lesson60.class);
                startActivity(intent3);
                break;
            case R.id.button_lesson_61:
                Intent intent4 = new Intent(this, Lesson61.class);
                startActivity(intent4);
                break;
            case R.id.button_lesson_62:
                Intent intent5 = new Intent(this, Lesson62.class);
                startActivity(intent5);
                break;
            case R.id.button_lesson_63:
                Intent intent6 = new Intent(this, Lesson63.class);
                startActivity(intent6);
                break;
            case R.id.button_lesson_64:
                Intent intent7 = new Intent(this, Lesson64.class);
                startActivity(intent7);
                break;
        }

    }
}