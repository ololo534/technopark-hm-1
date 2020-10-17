package ru.ololo534.homework.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.jetbrains.annotations.NotNull;

import ru.ololo534.homework.R;
import ru.ololo534.homework.dataSourse.Data;
import ru.ololo534.homework.fragments.ItemFragment;
import ru.ololo534.homework.fragments.ListFragment;

public class MainActivity extends AppCompatActivity implements ItemViewInterface{

    private static final String DATA_LIST_ARG_NAME = "data_list";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            setupBasicFragment();
        } else {
            Data.getInstance().setData(savedInstanceState.<Data.ItemList>getParcelableArrayList(DATA_LIST_ARG_NAME));
        }
    }

    private void setupBasicFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.recycle_fragment, ListFragment.newInstance())
                .commit();
    }

    @Override
    public void showItem(@NotNull Data.ItemList item) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.recycle_fragment, ItemFragment.newInstance(item.GetValue(), item.GetColor()))
                .addToBackStack(null)
                .commit();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(DATA_LIST_ARG_NAME, Data.getInstance().getData());
    }
}
