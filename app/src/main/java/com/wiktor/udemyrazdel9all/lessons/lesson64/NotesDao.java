package com.wiktor.udemyrazdel9all.lessons.lesson64;

//Dao - data access object - объект доступа к данным
//здесь создаются все методы для манипулирования данными

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

// Интерфейс для работы с базой данных
@Dao
public interface NotesDao {

    @Query("SELECT * FROM notes ORDER BY dayOfWeek DESC")
    LiveData<List<Note>> getAllNotes(); //в этом случае метод getAllNotes() будет возвращать не List<Note>, а объект LiveData который содержит список записей

    @Insert
    void insertNote(Note note);

    @Delete
    void deleteNote(Note note);

    @Query("DELETE FROM notes")
    void deleteAllNotes();
}
