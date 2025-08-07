package com.example.kikishop.ui.login;

import com.example.kikishop.data.db.DataBaseResults;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class LoginCollOut {


    // function for logging to data base
    public boolean collOut(String username, String password) {

        if (password.equals("zaq1@WSX") && username.equals("kiki@gmale.com")) {
            getDataFromDB();
            return true;
        }
        return false;
    }

    private void getDataFromDB() {
        DataBaseResults results = DataBaseResults.getInstance();
        results.setItemsInNewOrders(23);
        results.setItemsInTotalOrders(412);
        results.setNewOrders(12);
        results.setTotalOrders(62);

        results.setItemsName(new String[]{"item1","item2","item3","item4","item5"});
        ArrayList<BarEntry> itemValue= new ArrayList<>();
        itemValue.add(new BarEntry(0,3));
        itemValue.add(new BarEntry(1,13));
        itemValue.add(new BarEntry(2,31));
        itemValue.add(new BarEntry(3,53));
        itemValue.add(new BarEntry(4,33));
        results.setItemsValue(itemValue);




    }
}
