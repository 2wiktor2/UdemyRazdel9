package com.wiktor.udemyrazdel9all.lessons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.wiktor.udemyrazdel9all.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Lesson61 extends AppCompatActivity {

    // https://openweathermap.org/api
    // api.openweathermap.org/data/2.5/weather?q=moscow&appid=f42000c97a78ddd4b5f32081010bcd22
    //  f42000c97a78ddd4b5f32081010bcd22


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson61);
        DownloadJSONTask task = new DownloadJSONTask();
        task.execute("https://api.openweathermap.org/data/2.5/weather?q=%D0%BC%D1%8B%D1%82%D0%B8%D1%89%D0%B8&appid=f42000c97a78ddd4b5f32081010bcd22");

    }

    private static class DownloadJSONTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            URL url = null;
            HttpURLConnection urlConnection = null;
            StringBuilder result = new StringBuilder();

            try {

                url = new URL(strings[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = bufferedReader.readLine();
                while (line != null) {
                    result.append(line);
                    line = bufferedReader.readLine();
                }
                return result.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.i("qwertyu", "resut JSON = " + s);

            try {
                JSONObject jsonObject = new JSONObject(s);
                String name = jsonObject.getString("name");
                Log.i("qwertyu", " JSON.name  = " + name);

                JSONObject main = jsonObject.getJSONObject("main");
                String temp = main.getString("temp");
                String pressure = main.getString("pressure");
                Log.i("qwertyu", " JSON.main.temp  = " + temp);
                Log.i("qwertyu", " JSON.main.pressure  = " + pressure);

                JSONArray jsonArray = jsonObject.getJSONArray("weather");
                JSONObject weather = jsonArray.getJSONObject(0);
                String weatherMain = weather.getString("main");
                String weatherDescription = weather.getString("description");
                Log.i("qwertyu", " JSON.weather.0.Main  = " + weatherMain);
                Log.i("qwertyu", " JSON.weather.0.Description  = " + weatherDescription);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}