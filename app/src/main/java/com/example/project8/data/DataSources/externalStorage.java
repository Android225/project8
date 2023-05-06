package com.example.project8.data.DataSources;

import android.os.Environment;
import android.util.Log;

import java.io.File;

public class externalStorage {

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }
    public  void externalStor() {
        //externalStorage
        try {
            String filename = "example";
            String fileContent = "Hello World!";
            File file = new File(Environment.getExternalStorageDirectory(), filename);
            if (isExternalStorageWritable()) {
                Log.e("ExternalStorage", "Non permission");
            } else {
                Log.e("ExternalStorage", "Good permission!");
            }

            Log.d("ExternalStorage", String.valueOf(file.getName()));
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
