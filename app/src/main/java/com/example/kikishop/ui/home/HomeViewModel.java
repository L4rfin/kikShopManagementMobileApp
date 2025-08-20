package com.example.kikishop.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> topSId;
    private MutableLiveData<String> topSName;
    private MutableLiveData<String> topSStock;
    private MutableLiveData<String> topSSale;
    private MutableLiveData<String> visitors;

    public HomeViewModel() {
        visitors = new MutableLiveData<>();
        topSId = new MutableLiveData<>();
        topSName = new MutableLiveData<>();
        topSSale = new MutableLiveData<>();
        topSStock = new MutableLiveData<>();
    }

    public LiveData<String> getTopSId() {
        return topSId;
    }

    public MutableLiveData<String> getTopSName() {
        return topSName;
    }

    public MutableLiveData<String> getTopSStock() {
        return topSSale;
    }

    public MutableLiveData<String> getTopSSale() {
        return topSStock;
    }

    public void setTopSId(Long topSId) {
        this.topSId = new MutableLiveData<>(String.valueOf(topSId));
    }

    public void setTopSName(String topSName) {
        this.topSName = new MutableLiveData<>(topSName);
    }

    public void setTopSSale(Long topSSale) {
        this.topSSale = new MutableLiveData<>(String.valueOf(topSSale));
    }

    public void setTopSStock(int topSStock) {
        this.topSStock = new MutableLiveData<>(String.valueOf(topSStock)) ;
    }

    public void setVisitors(int visitors) {
        this.visitors = new MutableLiveData<>(String.valueOf(visitors));
    }

    public MutableLiveData<String> getVisitors() {
        return visitors;
    }
}