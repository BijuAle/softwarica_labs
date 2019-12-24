package com.softwarica.a20190410_recyclerview;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyClickListener{

    List<Hero> heroList = new ArrayList<>();
    RecyclerView recyclerView;
    HeroAdapter heroAdapter;

    Hero heroAslaug, heroBjorn, heroIvar;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("settings", Context.MODE_PRIVATE);
        mEditor= sharedPreferences.edit();

        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager heroLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(heroLayoutManager);

        heroAdapter = new HeroAdapter(heroList, this);
        recyclerView.setAdapter(heroAdapter);

        prepareHeroList();
    }

    private void prepareHeroList(){

        heroAslaug = new Hero("1", "Aslaug", "Warrior Queen");
        heroBjorn = new Hero("2", "Bjorn Ironside",   "King of 9th century Sweeden");
        heroIvar = new Hero("3", "Ivar the Boneless", "Commander of the Great Heather Army");

        heroList.add(heroAslaug);
        heroList.add(heroBjorn);
        heroList.add(heroIvar);

        heroAdapter.notifyDataSetChanged();

    }

    private void writePreference(){

        mEditor.putString(heroAslaug.getName(), heroAslaug.getDescription());
        mEditor.putString(heroBjorn.getName(), heroBjorn.getDescription());
    }

    @Override
    public void onClick(Hero hero) {
        Toast.makeText(this,String.valueOf(hero.getName()), Toast.LENGTH_LONG).show();
    }
}
