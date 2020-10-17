package ru.ololo534.homework.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import ru.ololo534.homework.R;
import ru.ololo534.homework.activities.ItemViewInterface;
import ru.ololo534.homework.dataSourse.Data;

//Adapter for RecycleView
public class ListAdapter extends RecyclerView.Adapter<MyViewHolder>{

    private final ArrayList<Data.ItemList> myData;
    private final ItemViewInterface myItemViewInterface;

    public ListAdapter(ArrayList<Data.ItemList> data, ItemViewInterface activity) {
        this.myData = data;
        this.myItemViewInterface = activity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view , parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return myData.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Data.ItemList item = myData.get(position);
        holder.myValue.setText(String.valueOf(item.GetValue()));
        holder.myValue.setTextColor(item.GetColor());
        holder.myCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myItemViewInterface.showItem(item);
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
