package com.example.kikishop.data.db;

import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;

public class DataBaseResults {

    private static DataBaseResults instance;
    private int visitors;
    private int newOrders;
    private int totalOrders;
    private int itemsInNewOrders;
    private int itemsInTotalOrders;
    private String[] itemsName;
    private List<Integer> itemsColor;
    private ArrayList<BarEntry> itemsValue;

    private DataBaseResults() {
        //
        visitors = 53;
        newOrders = 23;
        totalOrders = 62;
        itemsInTotalOrders = 412;
        itemsInNewOrders = 12;

        itemsName = new String[]{"item1", "item2", "item3", "item4", "item5"};
        ArrayList<BarEntry> itemValue = new ArrayList<>();
        itemValue.add(new BarEntry(0, 3));
        itemValue.add(new BarEntry(1, 13));
        itemValue.add(new BarEntry(2, 31));
        itemValue.add(new BarEntry(3, 53));
        itemValue.add(new BarEntry(4, 33));
        itemsValue = itemValue;
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

    public int getVisitors() {
        return visitors;
    }

    public void setVisitors(int visitors) {
        this.visitors = visitors;
    }
}
