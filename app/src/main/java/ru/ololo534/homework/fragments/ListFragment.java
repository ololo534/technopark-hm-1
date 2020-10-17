package ru.ololo534.homework.fragments;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

import ru.ololo534.homework.R;
import ru.ololo534.homework.activities.ItemViewInterface;
import ru.ololo534.homework.adapter.ListAdapter;
import ru.ololo534.homework.dataSourse.Data;

public class ListFragment extends Fragment {

    private RecyclerView myItemRecyclerView;
    private ItemViewInterface myItemViewInterface;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        myItemRecyclerView = view.findViewById(R.id.item_list);
        int columnsCount;
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            columnsCount = getResources().getInteger(R.integer.columns_landscape);
        } else {
            columnsCount = getResources().getInteger(R.integer.columns_portrait);
        }
        myItemRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), columnsCount));
        ListAdapter Adapter = new ListAdapter(Data.getInstance().getData(), myItemViewInterface);
        myItemRecyclerView.setAdapter(Adapter);
        Button addNumberButton = view.findViewById(R.id.add_element_btn);
        addNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data data = Data.getInstance();
                data.addElement(data.getData().get(data.getData().size() - 1).GetValue() + 1);
                Objects.requireNonNull(myItemRecyclerView.getAdapter()).notifyItemInserted(data.getData().size() - 1);
            }
        });
    }

    public static ListFragment newInstance() {
        return new ListFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        myItemViewInterface = (ItemViewInterface) context;
    }

}
