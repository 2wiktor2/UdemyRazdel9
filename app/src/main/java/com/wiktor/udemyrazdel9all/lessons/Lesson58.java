package com.wiktor.udemyrazdel9all.lessons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.wiktor.udemyrazdel9all.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lesson58 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson58);

        // Метод Split. Разделяет строку на отдельные строки и складывает в массив.
        String nameString = "Андрей, Виктор, Дмитрий, Павел, Михаил, Владимир, Николай";
        String[] names = nameString.split(", ");
        for (String name : names) {
            Log.i("qwertyu", name);
        }


        // получить часть строки
        String geometry = "Геометрия";
        // необходимо получить слово метр
        String meter = geometry.substring(3, 7);
        Log.i("qwertyu", meter);


        // выделить все симфолы которы заключены между указанными
        String river = "Mississipi Mississipi Mississipi Mississipi ";
        // Возвращает строку между символами "Mi" и "pi"
        Pattern pattern = Pattern.compile("Mi(.*?)pi");
        // Обработать строку паттерном нам нужем объект Matcher. У паттерна нужно вызвать метод .matcher(river) и передать ему необходимую строку
        Matcher matcher = pattern.matcher(river);
        int i = 0;
        // Чтобы matcher искал все совпадения нужно создать цикл
        while (matcher.find()){    // Метод .find() ищет первое вхождение данного паттерна
            // Чтобы полуить доступ к первому совпадения у matcher-а вызываем метод .group и передаем туда 1
            Log.i("qwertyu", matcher.group(1));  // !!!!!!!!! находит только 2 совпадерния, а должен 6
            i++;
            Log.i("qwertyu", String.valueOf(i));
        }

    }

}