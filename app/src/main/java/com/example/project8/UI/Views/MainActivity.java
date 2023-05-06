package com.example.project8.UI.Views.;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import com.example.project8.R;
import com.example.project8.UI.ViewModels.ClientVM;
import com.example.project8.data.DataSources.Repository.Repository;
import com.example.project8.data.DataSources.RoomDat;
import com.example.project8.data.DataSources.appSpecificStorage;
import com.example.project8.data.DataSources.externalStorage;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Repository al = new Repository();
        al.apsl(getApplication());
        al.extl(getApplication());
        al.rool(getApplication());
        al.sharl(getApplication());

    }
}