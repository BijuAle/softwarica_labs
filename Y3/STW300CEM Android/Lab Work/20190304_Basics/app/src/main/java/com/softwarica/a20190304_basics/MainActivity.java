package com.softwarica.a20190304_basics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    User user, user2;
    Vehicle vehicle1, vehicle2, vehicle3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = new User ("John", 1);
        user2 = new User ("Douglas", 2);

        vehicle1 = new Vehicle(1,"tf6tg,","Lamborhini",4);
        vehicle1 = new Vehicle(2,"te6tg,","Porsche",4);
        vehicle1 = new Vehicle(3,"tf62g,","Rolls Royce",4);
    }
}
