package ru.ololo534.homework.dataSourse;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Data {

    private static Data ourInstance;
    private ArrayList<ItemList> myList;

    private Data() {
        myList = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            myList.add(new ItemList(i));
        }
    }

    public static Data getInstance() {
        if (ourInstance == null) {
            ourInstance = new Data();
        }
        return ourInstance;
    }

    public  ArrayList<ItemList> getData() {
        return myList;
    }

    public void setData(ArrayList<ItemList> dataList) {
        this.myList = new ArrayList<>(dataList);
    }

    public void addElement(int value) {
        myList.add(new ItemList(value));
    }

    public static class ItemList implements Parcelable {

        private int myValue;
        private int myItemColor;

        ItemList(int value) {
            SetValue(value);
        }

        ItemList(Parcel in) {
            myValue = in.readInt();
            myItemColor = in.readInt();
        }

        public static final Creator<ItemList> CREATOR = new Creator<ItemList>() {
            @Override
            public ItemList createFromParcel(Parcel in) {

                return new ItemList(in);
            }

            @Override
            public ItemList[] newArray(int size) {

                return new ItemList[size];
            }
        };

        public int GetValue() {
            return myValue;
        }

        public int GetColor() {
            return myItemColor;
        }

        private void SetValue(int value) {
            this.myValue = value;
            SetColor();
        }

        private void SetColor() {
            if (myValue % 2 == 0) {
                myItemColor = Color.RED;
            } else {
                myItemColor = Color.BLUE;
            }
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(myValue);
            dest.writeInt(myItemColor);
        }
    }
}
