package com.example.project8.data.Repository;

import android.app.Application;

import com.example.project8.data.DataSources.RoomDat;
import com.example.project8.data.DataSources.appSpecificStorage;
import com.example.project8.data.DataSources.externalStorage;
import com.example.project8.data.DataSources.SharedPreferences;
import com.example.project8.data.Models.Item;

public class Repository {

    private Item item;

    public Repository(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public  void apsl(Application application) {
        appSpecificStorage a = new appSpecificStorage();
        a.appSpec(application);
    }
    public  void extl(Application application) {
        externalStorage b = new externalStorage();
        b.externalStor();
    }
    public  void rool(Application application) {
        RoomDat c = new RoomDat();
        c.roomDatt(application);
    }
    public  void sharl(Application application) {
        SharedPreferences d = new SharedPreferences();
        d.SharPref(application);
    }
}
