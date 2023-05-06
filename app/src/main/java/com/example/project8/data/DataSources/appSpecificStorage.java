package com.example.project8.data.DataSources;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.IOException;

public class appSpecificStorage {
    public  void appSpec(Application application) {
        //appSpecificStorage
        try {
            String filename = "AppSpecificStorage";
            File file = new File(application.getFilesDir(), filename);
            Log.d(filename, String.valueOf(file.createNewFile()));
            file.delete();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}