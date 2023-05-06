package com.example.project8.UI.ViewModels.;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;



import com.example.project8.data.DataSources.Room.Entity.Client;

import java.util.List;

public class ClientVM extends AndroidViewModel {
    private final LiveData<List<Client>> mAllClient;
    private final com.example.a8.data.ClientDB.ClientRepository mRepository;

    public ClientVM(Application application) {
        super(application);
        Log.d("ClientVM", "Constructor");
        mRepository = new com.example.a8.data.ClientDB.ClientRepository(application);
        mAllClient = mRepository.getAllApartment();
    }

    public LiveData<List<Client>> getAllClient() {
        return mAllClient;
    }

    public void insert(Client client) {
        mRepository.insert(client);
    }
}