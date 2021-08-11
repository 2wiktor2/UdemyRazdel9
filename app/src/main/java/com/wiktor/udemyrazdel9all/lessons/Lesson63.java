package com.wiktor.udemyrazdel9all.lessons;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.widget.TextView;
import android.widget.Toast;

import com.wiktor.udemyrazdel9all.R;

public class Lesson63 extends AppCompatActivity {

    private TextView textViewTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson63);

        textViewTimer = findViewById(R.id.textViewTimer);

        // в параметры передать продолжительность таймера в миллисекундах и интервал
        CountDownTimer timer = new CountDownTimer(6000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // millisUntilFinished количество моллисекунд которые остались до завершения таймера
                int seconds = (int) (millisUntilFinished / 1000);
                seconds++;
                textViewTimer.setText(Integer.toString(seconds));
            }

            @Override
            public void onFinish() {
                Toast.makeText(Lesson63.this, "FINISH", Toast.LENGTH_SHORT).show();
                textViewTimer.setText(Integer.toString(0));
            }
        };

        // запуск таймера
        timer.start();



/*        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        // Складываем данные в SharedPreferences
        preferences.edit().putInt("test", 5).apply();
        // забираем данные из SharedPreferences
        int test = preferences.getInt("test", 0);
        Toast.makeText(this, Integer.toString(test), Toast.LENGTH_SHORT).show();*/
    }
}