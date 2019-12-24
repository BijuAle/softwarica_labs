package com.softwarica.a20190410_recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class HeroAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<Hero> heroList;

    public HeroAdapter(List<Hero> heroList) {
        this.heroList = heroList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_heroes, viewGroup, false);
       return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Hero hero = heroList.get(i);
        myViewHolder.tvId.setText(hero.getId());
        myViewHolder.tvName.setText(hero.getName());
        myViewHolder.tvDesc.setText(hero.getDescription());
    }

    @Override
    public int getItemCount() {
        return heroList.size();
    }
}
