package com.wiktor.udemyrazdel9all.lessons.lesson64;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.wiktor.udemyrazdel9all.R;

import java.util.ArrayList;

public class Lesson64 extends AppCompatActivity {

    private RecyclerView recyclerViewNotes;
    private ArrayList<Note> notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson64);

        recyclerViewNotes = findViewById(R.id.recyclerViewNotes);
        notes.add(new Note("заголовок0", "описание0", "понедельник0", 0));
        notes.add(new Note("заголовок1", "описание1", "понедельник1", 1));
        notes.add(new Note("заголовок2", "описание2", "понедельник2", 2));
        notes.add(new Note("заголовок3", "описание3", "понедельник3", 3));
        notes.add(new Note("заголовок4", "описание4", "понедельник4", 4));
        notes.add(new Note("заголовок5", "описание5", "понедельник5", 5));

        NotesAdapter notesAdapter = new NotesAdapter(notes);
        recyclerViewNotes.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewNotes.setAdapter(notesAdapter);
    }
}