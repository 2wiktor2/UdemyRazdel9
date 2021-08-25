package com.wiktor.udemyrazdel9all.lessons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;

import com.wiktor.udemyrazdel9all.R;


//Таймер. CountDownTimer. Из урока 63 раздел 10
public class ActivityTimer extends AppCompatActivity {

    private TextView textViewTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);


        textViewTimer = findViewById(R.id.textView_timer);

        CountDownTimer timer = new CountDownTimer(15000, 1000) { // принимает 1 - значение в миллисекундах(продолжительность) . 2 - через какой промежуток он будет тикать(интервал)
            @Override
            public void onTick(long millisUntilFinished) {  // будет вызываться каждые 1000 миллисекунды (указывается вторым параметом в new CountDownTimer(60000, 1000). millisUntilFinished - сколько осталось до конца таймера
                int seconds = (int) (millisUntilFinished / 1000); // получаем сколько осталось до конца. long нужно привести к int
                seconds++; // увеличиваем на секунду чтобы 0 не висел целую секунду
                textViewTimer.setText(Integer.toString(seconds)); // устанавливает в textView значение таймера
                if (millisUntilFinished < 10000) {
                    textViewTimer.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                }
            }

            @Override
            public void onFinish() {  // вызывается когда таймер закончит отсчет
                Toast.makeText(getApplicationContext(), "Таймер завершен", Toast.LENGTH_SHORT).show();
                textViewTimer.setText(Integer.toString(0)); // когда таймер завершит работу установим значение 0
            }
        };
        timer.start();  // запуск таймера
    }
}