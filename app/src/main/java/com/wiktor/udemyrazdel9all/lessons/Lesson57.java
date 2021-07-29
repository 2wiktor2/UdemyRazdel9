package com.wiktor.udemyrazdel9all.lessons;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.wiktor.udemyrazdel9all.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.AsynchronousChannelGroup;
import java.util.concurrent.ExecutionException;

public class Lesson57 extends AppCompatActivity {

    // Урок 57 загрузка картинки из интернета

    private ImageView imageView;

    private String url = "https://i.pinimg.com/originals/c1/b7/15/c1b7158269b5ceda65e795b1543d805c.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson57);

        imageView = findViewById(R.id.imageViewLesson57);
    }

    public void onClickDownloadImage(View view) {
        DownloadImageTask task = new DownloadImageTask();
        Bitmap bitmap = null;
        try {
            bitmap = task.execute(url).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        imageView.setImageBitmap(bitmap);
    }

    // Первый пораметр принимает строку, наш url. Второй параметр возвращает информацию в процессе загрузки. Третий параметр возвращает Картинку
    private static class DownloadImageTask extends AsyncTask <String, Void, Bitmap>{
        @Override
        protected Bitmap doInBackground(String... strings) {
            URL url = null;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(strings[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                // получаем картинку из BitmapFactory с помощью метода decodeStream()
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                return bitmap;
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null){
                    urlConnection.disconnect();
                }
            }
            return null;
        }
    }
}