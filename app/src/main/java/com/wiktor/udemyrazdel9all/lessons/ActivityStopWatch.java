package com.wiktor.udemyrazdel9all.lessons;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wiktor.udemyrazdel9all.R;

import java.util.Locale;

public class ActivityStopWatch extends AppCompatActivity {

    //Udemy раздел 6 уроки 40-43

    TextView textViewTime;
    Button buttonStart;
    Button buttonPause;
    Button buttonReset;

    // переменные для отслеживания состояния секундомера
    private int seconds = 0; //хранит количество прошедших секунд
    private boolean isRunning = false; //работает ли секундомер в данный момент
    private boolean wasRunning = false; // переменная для хранения состояния таймера до методов жизненного цикла (onStop)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        textViewTime = findViewById(R.id.textView);
        buttonStart = findViewById(R.id.button_start);
        buttonPause = findViewById(R.id.button_pause);
        buttonReset = findViewById(R.id.button_reset);

        // 2. Получаем сохраненные значения из бандла
        // 3. для того чтобы не выпала ошибка когда бандл = null, т.е. когда активити только что создана задаем проверку
        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            isRunning = savedInstanceState.getBoolean("isRunning");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }

        ranTimer();
    }

/*    @Override
    protected void onStart() {
        super.onStart();
        // нужно запустить таймер когда активность станет видимой
    }*/

    @Override
    protected void onResume() {
        super.onResume();
        isRunning = wasRunning;
    }

    @Override
    protected void onPause() {
        super.onPause();
        wasRunning = isRunning;
        // таймер останавливается когда активность становится частично невидимой
        isRunning = false;
    }

/*    @Override
    protected void onStop() {
        super.onStop();
        // таймер останавливается когда активность становится невидимой
    }*/

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        // 1. Кладем в бандл нужные значения для созранения
        outState.putInt("seconds", seconds);
        outState.putBoolean("isRunning", isRunning);
        outState.putBoolean("wasRunning", wasRunning);
    }


    public void onClickStartTimer(View view) {
        isRunning = true;
    }

    public void onClickStopTimer(View view) {
        isRunning = false;
    }

    public void onClickResetTimer(View view) {
        isRunning = false;
        seconds = 0;
    }


    //метод для обновления показаний таймера
    private void ranTimer() {

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60; // seconds % 3600 - остаток от деления.
                int secs = seconds % 60;

                // преобоазуем данные в строковый формат
                String time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, secs);
                textViewTime.setText(time);

                if (isRunning) {
                    seconds++;
                }
                // выполнить этот же метод еще раз, но с задержкой 1сек
                //В качестве первого пеарметра передеем себя
                handler.postDelayed(this, 1000);
            }
        });

    }
}