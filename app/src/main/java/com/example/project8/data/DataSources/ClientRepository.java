package com.example.a8.data.ClientDB;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.a8.data.ClientDB.Client;
import com.example.a8.data.ClientDB.ClientDao;
import com.example.a8.data.ClientDB.ClientDatabase;

import java.util.List;

public class ClientRepository {
    private final ClientDao mClientDao;
    private final LiveData<List<Client>> clients;

    public ClientRepository(Application application) {
        Log.d("ClientRepository", "Constructor");
        ClientDatabase db = ClientDatabase.getDatabase(application);
        mClientDao = db.clientDao();
        clients = mClientDao.getAll();
    }

    public LiveData<List<Client>> getAllApartment() {
        return clients;
    }

    public void insert(Client client) {
        ClientDatabase.databaseWriteExecutor.execute(() -> {
            mClientDao.insert(client);
            Log.d("ggg", client.name);
        });
    }
}
