package com.example.project8.data.DataSources.Room.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.project8.data.DataSources.Room.Entity.Client;

import java.util.List;

@Dao
public interface ClientDao {
    @Query("SELECT * FROM Client")
    LiveData<List<Client>> getAll();

    @Query("SELECT * FROM Client WHERE clientId IN (:clientIds)")
    List<Client> loadAllByIds(int[] clientIds);

    @Query("SELECT * FROM Client WHERE name LIKE :name LIMIT 1")
    Client findByName(String name);

    @Query("SELECT * FROM Client WHERE clientId LIKE :id")
    Client findById(int id);

    @Insert
    void insertAll(Client... clients);

    @Query("INSERT INTO Client(clientId,name) VALUES (:id,:name)")
    void insert(int id, String name);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Client client);

    @Query("DELETE FROM Client")
    void deleteAll();

    @Query("DELETE FROM Client WHERE clientId LIKE :id")
    void delete(int id);

    @Query("UPDATE Client SET name =:name WHERE clientId LIKE :id")
    void update(int id, String name);

}