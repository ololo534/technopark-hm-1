package ru.ololo534.homework.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.ololo534.homework.R;

//Fragment for single item
public class ItemFragment extends Fragment {
    private static final String VALUE_ARG_NAME = "num", COLOR_ARG_NAME = "color";
    private int myNumber, myNumColor;

    public ItemFragment() {}

    public static ItemFragment newInstance(int value, int color) {
        ItemFragment fragment = new ItemFragment();
        Bundle args = new Bundle();
        args.putInt(VALUE_ARG_NAME, value);
        args.putInt(COLOR_ARG_NAME, color);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            myNumber = getArguments().getInt(VALUE_ARG_NAME);
            myNumColor = getArguments().getInt(COLOR_ARG_NAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textToPreview = view.findViewById(R.id.item_fragment);
        textToPreview.setText(String.valueOf(myNumber));
        textToPreview.setTextColor(myNumColor);
    }
}
