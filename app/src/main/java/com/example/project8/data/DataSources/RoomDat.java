package com.example.project8.data.DataSources;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.ViewModelProvider;

import com.example.project8.UI.ViewModels.ClientVM;
import com.example.project8.data.DataSources.Room.Entity.Client;

public class RoomDat {

    public  void roomDatt(Application application) {
        // room
        ClientVM clientVM = new ViewModelProvider(application).get(ClientVM.class);
        clientVM.getAllClient().observe(application, clients -> {
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

                    } catch (Exception e) {
                        Log.e("Error", e.toString());
                    }
                }
        );
    }
}
