package com.wiktor.udemyrazdel9all.lessons.lesson64;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class NotesDBHelper extends SQLiteOpenHelper {

    //Вынести название базы данных в переменную
    private static final String DB_NAME = "notes.db";
    // Вынести версию БД в переменную, при создании бд ей всегда рисваивается номер версии 1, при обновлении базы данных меняется номр версии 2,3,4 и т.д.
    private static final int DB_VERSION = 1;

    public NotesDBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(NotesContract.NotesEntry.CREATE_COMMAND);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(NotesContract.NotesEntry.DROP_COMMAND);
        onCreate(db);
    }
}
