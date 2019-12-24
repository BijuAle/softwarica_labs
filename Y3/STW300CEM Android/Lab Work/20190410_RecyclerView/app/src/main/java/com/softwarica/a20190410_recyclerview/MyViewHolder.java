package com.softwarica.a20190410_recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MyViewHolder extends RecyclerView.ViewHolder{
    public TextView tvId, tvName, tvDesc;
    public ImageView ivImg;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        this.tvId =  itemView.findViewById(R.id.tvID);
        this.tvName =  itemView.findViewById(R.id.tvName);
        this.tvDesc =  itemView.findViewById(R.id.tvDesc);
        this.ivImg = itemView.findViewById(R.id.ivImg);
    }
}
