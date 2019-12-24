package com.softwarica.a20190418_file_io;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btn_write, btn_read;
    private Writer writer;

    private InputStreamReader iReader;
    private BufferedReader bReader;
    StringBuffer buffer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_write = findViewById(R.id.btn_write);
        btn_write.setOnClickListener(this);
        btn_read = findViewById(R.id.btn_read);
        btn_read.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_write:
                break;
        }

    }

    private void writeToFile(String text) {
        try {
            writer = new FileWriter("romi.text");
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private String readFromFile() {
        try {
            iReader = new InputStreamReader(openFileInput("romi.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        bReader = new BufferedReader(iReader);

        String line;
        buffer = new StringBuffer();

        try {
            while ((line = bReader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String content = buffer.toString();
        return content;
    }
}
