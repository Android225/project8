package com.example.project8.data.DataSources;

import android.util.Log;

import androidx.lifecycle.ViewModelProvider;

import com.example.project8.UI.ViewModels.ClientVM;

public class RoomDat {

    public  void roomDatt() {
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

                    } catch (Exception e) {
                        Log.e("Error", e.toString());
                    }
                }
        );
    }
}
