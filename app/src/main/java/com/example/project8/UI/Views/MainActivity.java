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
import com.example.project8.data.DataSources.Room.Entity.;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //appSpecificStorage
        try {
            String filename = "AppSpecificStorage";
            File file = new File(this.getFilesDir(), filename);
            Log.d(filename, String.valueOf(file.createNewFile()));
            file.delete();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

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


        //SharedPreferences
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("string_key", "Hello world!");
        editor.putInt("value_key", 1223);
        editor.apply();
        Log.d("SharedPreferences", sharedPref.getString("string_key", ""));
        Log.d("SharedPreferences", String.valueOf(sharedPref.getInt("value_key", 0)));


        // room
        ClientVM clientVM = new ViewModelProvider(this).get(ClientVM.class);
        clientVM.getAllClient().observe(this, clients -> {
                    try {
                        clients.add(new Client("Marta"));
                        clients.add(new Client("Potter"));
                        clients.add(new Client("Tomas"));
                        clients.add(new Client("Loli"));

                        Client client1 = clients.get(0);
                        Client client2 = clients.get(3);
                        Client client3 = clients.get(2);
                        Client client4 = clients.get(3);

                        Log.i("Client_11", client1.name);
                        Log.i("Client_22", client2.name);
                        Log.i("Client_33", client3.name);
                        Log.i("Client_44", client4.name);

                    }catch (Exception e) {
                        Log.e("Error", e.toString());
                    }
                }
        );
    }
}