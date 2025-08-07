package com.example.kikishop.ui.dashboard;

import android.graphics.Color;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;

public class DashboardViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private MutableLiveData<String> order;
    private MutableLiveData<Integer[]> items;

    private MutableLiveData<String[]> itemsName;

    private MutableLiveData<ArrayList<BarEntry>> itemsValue;
    private List<Integer> itemsColor;


    public DashboardViewModel() {
        mText = new MutableLiveData<>();
        order = new MutableLiveData<>();
        items = new MutableLiveData<>();
        itemsName = new MutableLiveData<>();
        itemsValue = new MutableLiveData<>();
        itemsColor = new ArrayList<>();
    }

    public LiveData<String> getText() {
        return mText;
    }

    public MutableLiveData<String> getOrder() {
        return order;
    }

    public void setOrder(MutableLiveData<String> order) {
        this.order = order;
    }

    public MutableLiveData<Integer[]> getItems() {
        return items;
    }

    public void setItems(MutableLiveData<Integer[]> items) {
        this.items = items;
    }

    public MutableLiveData<String[]> getItemsName() {
        return itemsName;
    }

    public void setItemsName(MutableLiveData<String[]> itemsName) {
        this.itemsName = itemsName;
    }

    public MutableLiveData<ArrayList<BarEntry>> getItemsValue() {
        return itemsValue;
    }

    public void setItemsValue(MutableLiveData<ArrayList<BarEntry>> itemsValue) {
        this.itemsValue = itemsValue;
        ArrayList<BarEntry> items = itemsValue.getValue();
        assert items != null;
        setItemsColor(items);
    }

    public void setItemsColor(ArrayList<BarEntry> entries) {
        List<Integer> colors = new ArrayList<>();
        for (BarEntry entry : entries) {
            float y = entry.getY();

            if (y < 20) {
                colors.add(Color.RED);
            } else if (y < 40) {
                colors.add(Color.YELLOW);
            } else {
                colors.add(Color.GREEN);
            }
        }
        this.itemsColor = colors;
    }

    public List<Integer> getItemsColor() {
        return itemsColor;
    }
}