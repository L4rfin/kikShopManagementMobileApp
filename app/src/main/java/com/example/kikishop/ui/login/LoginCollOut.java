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
        // coll to db for data, then set dbr to results from db

        DataBaseResults results = DataBaseResults.getInstance();


    }
}
