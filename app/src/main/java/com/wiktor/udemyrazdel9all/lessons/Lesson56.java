package com.wiktor.udemyrazdel9all.lessons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.wiktor.udemyrazdel9all.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class Lesson56 extends AppCompatActivity {

    //todo переделать на rxJava

    // Урок 56. Взять всю разметку страницы https://mail.ru/ и вывести в логи

    private String mailRu = "https://mail.ru/";
//    private String triDDDRu = "https://3ddd.ru/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson56);

        Log.i("qwertyu", mailRu);

        //Запуск задачи в другом потоке
        //Создать объект класса  "private static class DownloadTask"
        DownloadTask task = new DownloadTask();
        // Чтобы запустить задачу нужно вызвать метод .execute и передать строку mailRu (task.execute(mailRu);)
        // или добавить еще нужные строки, т.к. метод принимает на вход массив(doInBackground(String... strings)) строк через запятую. например --- task.execute(mailRu, "3ddd.ru");

        // Чтобы получить данные которые вернет метод  (task.execute(mailRu, "3ddd.ru");) нужно вызвать метод .get() (task.execute(mailRu, "3ddd.ru").get();)
        // Ctrl + alt + t --- обернуть код
        try {
            String result = task.execute(mailRu).get();
            Log.i("qwertyu", result);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // доступ к нему нам нужен только из этого класса
//    private static class DownloadTask extends AsyncTask<String, Void, String>
    // Передаются 3 параметра:
//		1 - те данные которые мы будем отправлять в класс DownloadTask ( в данном случае отправляется URL который является строкой ("https://mail.ru/") )
//		2 - данные которые будут передаваться в процессе загрузки ( ???например кохда передается какой-то тяжелый фаил можно показать процесс загрузки в прогрессБаре???)
//		3 - те данные которые будут возвращаться после выполнения задачи в DownloadTask (html-код со страницы https://mail.ru/ )
    private static class DownloadTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            Log.i("qwertyu", "             " + strings[0]);
            String s = "\"готово. Вернул метод doInBackground в классе DownloadTask\"";

            StringBuilder result = new StringBuilder();
            URL url = null;
            HttpURLConnection urlConnection = null;
            try {
                //               передаем туда нашу ссылку ( url = new URL(strings[0]);). Если ошибиться в строке с адресом(строка не сможет преобразоваться в адрес), то произойдет исключение,
                //               поэтому его нужно обернуть в try/catch
                url = new URL(strings[0]);
                //               Второе что нужно сделать - открыть соединение
                urlConnection = (HttpURLConnection) url.openConnection(); // и здесь может вылезти исключение( urlConnection = url.openConnection();) поэтому оборачиваем в еще один catch. Вываливается еще одна ощибка в которой нужно преобразовать urlConnection в HttpURLConnection
                //               для того чтобы читать данные из интернета, нужно создать поток ввода для того что бы читать данные из этого соединения
                InputStream in = urlConnection.getInputStream();
                //               для того чтобы начать процесс чтения этих данных нам нужно создать , создаем его ез нашего InputStream-а in.
                InputStreamReader reader = new InputStreamReader(in); // InputStreamReader создан теперь можно читать данные.
                //              reader.read(); // Читает данные по одному символу, что занимает довольно много времени
                //               чтобы читать данные сразу строками необходимо создать
                BufferedReader bufferedReader = new BufferedReader(reader);
                //               создаем строку
                String line = bufferedReader.readLine();
                while (line != null) { // пока все данные не будут прочитаны
                    result.append(line); // собираем все строки в StringBuilder
                    line = bufferedReader.readLine(); // переменной line присваиваем значение следующей строки
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // независимо от тего успешное было соединение или нет, необходимо закрыть соединение
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                return result.toString();
            }
        }
    }
}