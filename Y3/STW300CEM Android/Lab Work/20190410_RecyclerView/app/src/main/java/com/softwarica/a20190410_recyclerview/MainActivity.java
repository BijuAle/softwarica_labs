package com.softwarica.a20190410_recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Hero> heroList = new ArrayList<>();
    RecyclerView recyclerView;
    HeroAdapter heroAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager heroLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(heroLayoutManager);

        heroAdapter = new HeroAdapter(heroList);
        recyclerView.setAdapter(heroAdapter);

        prepareHeroList();
    }

    private void prepareHeroList(){
        Hero heroAslaug, heroBjorn, heroIvar;

        heroAslaug = new Hero("1", "Aslaug", "Warrior Queen");
        heroBjorn = new Hero("2", "Bjorn Ironside", "King of 9th century Sweeden");
        heroIvar = new Hero("3", "Ivar the Boneless", "Commander of the Great Heather Army");

        heroList.add(heroAslaug);
        heroList.add(heroBjorn);
        heroList.add(heroIvar);

        heroAdapter.notifyDataSetChanged();
    }
}
