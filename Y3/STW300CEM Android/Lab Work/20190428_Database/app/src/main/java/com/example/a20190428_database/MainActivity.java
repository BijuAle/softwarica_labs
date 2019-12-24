package com.example.a20190428_database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.a20190428_database.Model.Notes;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);

        Notes notes = new Notes("To do list", "1. Bring milk. 2. Walk the dog. 3. Watch GOT. 4. Do Project.");
        databaseHelper.insertNote(notes);
    }
}
