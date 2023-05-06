package com.example.project8.data.DataSources;

import android.app.Application;
import android.content.Context;
import android.util.Log;

public class SharedPreferences {

    public void SharPref(Application application) {
        //SharedPreferences
        android.content.SharedPreferences sharedPref = application.getPreferences(Context.MODE_PRIVATE);
        android.content.SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("string_key", "Hello world!");
        editor.putInt("value_key", 1223);
        editor.apply();
        Log.d("SharedPreferences", sharedPref.getString("string_key", ""));
        Log.d("SharedPreferences", String.valueOf(sharedPref.getInt("value_key", 0)));
    }
}