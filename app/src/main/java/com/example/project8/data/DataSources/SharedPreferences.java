package com.example.project8.data.DataSources;

import android.content.Context;
import android.util.Log;

public class SharedPreferences {

    public void externalStor() {
        //SharedPreferences
        android.content.SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        android.content.SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("string_key", "Hello world!");
        editor.putInt("value_key", 1223);
        editor.apply();
        Log.d("SharedPreferences", sharedPref.getString("string_key", ""));
        Log.d("SharedPreferences", String.valueOf(sharedPref.getInt("value_key", 0)));
    }
}