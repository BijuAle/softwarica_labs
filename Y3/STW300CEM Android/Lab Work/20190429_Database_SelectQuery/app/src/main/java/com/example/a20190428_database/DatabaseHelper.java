package com.example.a20190428_database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.a20190428_database.Model.Notes;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "myapp";
    private static int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Notes.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Notes.TABLE_NAME);
    }

    public void insertNote(Notes notes) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Notes.COLUMN_TITLE, notes.getTitle());
        values.put(Notes.COLUMN_DESCRIPTION, notes.getDescription());

        db.insert(Notes.TABLE_NAME, null, values);
        db.close();
    }

    public List<Notes> getAllNotes() {

        List<Notes> notesList = new ArrayList<>();

        SQLiteDatabase database = getReadableDatabase();
        String selectQuery = "SELECT * FROM " + Notes.TABLE_NAME;

        Cursor cursor = database.rawQuery(selectQuery, null);
        Log.d("TAG", String.valueOf(cursor.getCount()));
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    Notes notes = new Notes();
                    notes.setId(cursor.getInt(cursor.getColumnIndex(Notes.COLUMN_ID)));
                    notes.setTitle(cursor.getString(cursor.getColumnIndex(Notes.COLUMN_TITLE)));
                    notes.setDescription(cursor.getString(cursor.getColumnIndex(Notes.COLUMN_DESCRIPTION)));
                    notesList.add(notes);
                }while(cursor.moveToNext());
            }
        }
        return notesList;
    }
}
