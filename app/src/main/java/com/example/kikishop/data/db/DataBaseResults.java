package com.example.kikishop.data.db;

import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;

public class DataBaseResults {

    private static DataBaseResults instance;

    private int newOrders;
    private int totalOrders;
    private int itemsInNewOrders;
    private int itemsInTotalOrders;
    private String[] itemsName;
    private List<Integer> itemsColor;
    private ArrayList<BarEntry> itemsValue;

    private DataBaseResults() {
        // inicjalizacja
    }

    public static DataBaseResults getInstance() {
        if (instance == null) {
            instance = new DataBaseResults();
        }
        return instance;
    }

    public void setItemsInTotalOrders(int itemsInTotalOrders) {
        this.itemsInTotalOrders = itemsInTotalOrders;
    }

    public void setItemsInNewOrders(int itemsInNewOrders) {
        this.itemsInNewOrders = itemsInNewOrders;
    }

    public void setTotalOrders(int totalOrders) {
        this.totalOrders = totalOrders;
    }

    public void setNewOrders(int newOrders) {
        this.newOrders = newOrders;
    }

    public int getNewOrders() {
        return newOrders;
    }

    public int getTotalOrders() {
        return totalOrders;
    }

    public int getItemsInNewOrders() {
        return itemsInNewOrders;
    }

    public int getItemsInTotalOrders() {
        return itemsInTotalOrders;
    }

    public ArrayList<BarEntry> getItemsValue() {
        return itemsValue;
    }

    public void setItemsValue(ArrayList<BarEntry> itemsValue) {
        this.itemsValue = itemsValue;
    }

    public List<Integer> getItemsColor() {
        return itemsColor;
    }

    public void setItemsColor(List<Integer> itemsColor) {
        this.itemsColor = itemsColor;
    }

    public String[] getItemsName() {
        return itemsName;
    }

    public void setItemsName(String[] itemsName) {
        this.itemsName = itemsName;
    }
}
