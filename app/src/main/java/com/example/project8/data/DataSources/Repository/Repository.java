package com.example.project8.data.DataSources.Repository;

import android.app.Application;
import android.content.SharedPreferences;

import com.example.project8.data.DataSources.RoomDat;
import com.example.project8.data.DataSources.appSpecificStorage;
import com.example.project8.data.DataSources.externalStorage;

public class Repository {

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
