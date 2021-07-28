package com.wiktor.udemyrazdel9all;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wiktor.udemyrazdel9all.lessons.Lesson56;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonLesson56;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLesson56 = findViewById(R.id.button_lesson_56);
        buttonLesson56.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_lesson_56:
                Intent intent = new Intent(this, Lesson56.class);
                startActivity(intent);
                break;
        }

    }
}