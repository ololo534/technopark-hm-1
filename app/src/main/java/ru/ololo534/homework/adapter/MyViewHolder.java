package ru.ololo534.homework.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import ru.ololo534.homework.R;

//ViewHolder for RecycleView
class MyViewHolder extends RecyclerView.ViewHolder {
    public final TextView myValue;
    public final CardView myCardView;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        this.myValue = itemView.findViewById(R.id.item_content);
        this.myCardView = itemView.findViewById(R.id.card);
    }
}
