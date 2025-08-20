package com.example.kikishop.data.db;

import android.util.Base64;

import java.sql.Blob;

public class TopSale {


    private static TopSale saleObject;
    byte[] img;
    long id;
    String name;
    int stock;
    long sale;

    public TopSale() {
        //call out to db for data and set up data
        String base64Str ="";
        byte[] decodedBytes = Base64.decode(base64Str, Base64.DEFAULT);;
        id = 43L;
        name = "Biedule";
        stock = 33;
        sale = 48L;
    }

    public static TopSale getInstance(){
        if (saleObject==null){
            return new TopSale();
        }
        return saleObject;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public long getSale() {
        return sale;
    }
}
