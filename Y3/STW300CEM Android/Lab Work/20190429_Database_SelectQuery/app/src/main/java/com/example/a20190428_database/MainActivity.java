package com.example.a20190428_database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a20190428_database.Model.Notes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_list;
    TextView tv_notes;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_list = findViewById(R.id.btn_list);
        btn_list.setOnClickListener(this);

        tv_notes = findViewById(R.id.tv_notes);

        databaseHelper = new DatabaseHelper(this);

        Notes notes1 = new Notes("To do list", "1. Bring milk. 2. Walk the dog. 3. Watch GOT. 4. Do Project.");
        Notes notes2 = new Notes("Laundry list", "1. Shoes. 2. Shirt. 3. Jeans.");
        Notes notes3 = new Notes("Pizza ingredients", "1. Oregano 2. Thyme 3. Tomato puree. 4. Dough 5. Cheese");

        databaseHelper.insertNote(notes1);
        databaseHelper.insertNote(notes2);
        databaseHelper.insertNote(notes3);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_list:
                List<Notes> notes = databaseHelper.getAllNotes();
                Iterator iterator = notes.iterator();

                while (iterator.hasNext()) {
                    Notes n = (Notes) iterator.next();
                    tv_notes.append(n.getId() + ", " + n.getTitle() + " ," + n.getDescription() + "\n");
                }
                break;
        }
    }
}
