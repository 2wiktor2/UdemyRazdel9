package com.wiktor.udemyrazdel9all.lessons.lesson_from_64_to_71;

import android.provider.BaseColumns;

public class NotesContract {

    public static final class NotesEntry implements BaseColumns {
        public static final String TABLE_NAME = "notes";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_DAY_OF_WEEK = "day_of_week";
        public static final String COLUMN_PRIORITY = "priority";

        public static final String TYPE_TEXT = "TEXT";
        public static final String TYPE_INTEGER = "INTEGER";


        //Создать команду которая создает таблицу
/*        public static String CREATE_COMMAND = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
                "(" + _ID + " " + TYPE_INTEGER + " PRIMARY_KEY AUTOINCREMENT, "
                + COLUMN_TITLE + " " + TYPE_TEXT + ", "
                + COLUMN_DESCRIPTION + " " + TYPE_TEXT + ", "
                + COLUMN_DAY_OF_WEEK + " " + TYPE_TEXT + ", "
                + COLUMN_PRIORITY + " " + TYPE_INTEGER + ")";*/
        public static final String CREATE_COMMAND = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
                "(" + _ID + " " + TYPE_INTEGER + " PRIMARY KEY AUTOINCREMENT," +
                COLUMN_TITLE + " " + TYPE_TEXT + ", " +
                COLUMN_DESCRIPTION + " " + TYPE_TEXT + ", " +
                COLUMN_DAY_OF_WEEK + " " + TYPE_INTEGER + ", " +
                COLUMN_PRIORITY + " " + TYPE_INTEGER + ")";

        // Создать команду для удатения таблицы
        public static final String DROP_COMMAND = "DROP TABLE IF EXISTS " + TABLE_NAME;  //--- DROP TABLE IF EXISTS - удальть таблицу если она существует + имя таблицы

    }

}
