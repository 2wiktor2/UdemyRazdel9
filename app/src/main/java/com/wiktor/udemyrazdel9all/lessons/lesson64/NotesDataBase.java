package com.wiktor.udemyrazdel9all.lessons.lesson64;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Note.class}, version = 1, exportSchema = false)
public abstract class NotesDataBase extends RoomDatabase {

    private static NotesDataBase dataBase;
    private static final String DB_NAME = "notes2.db";
    private static final Object LOCK = new Object();

    public static NotesDataBase getInstance(Context context) {
        synchronized (LOCK) {
            if (dataBase == null) {
                dataBase = Room.databaseBuilder(context, NotesDataBase.class, DB_NAME)
                        //.allowMainThreadQueries() // Если обращаться к бд в главном потоке, то возникнет ошибка. Поэтому в databaseBuilder добавляем .allowMainThreadQueries() исключительно для тестирования!!!!!!!!!!
                        .build();
            }
        }
        return dataBase;
    }

    public abstract NotesDao notesDao();

}
