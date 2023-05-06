package com.example.project8.UI.ViewModels;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.project8.data.Repository.Repository;
import com.example.project8.data.Models.Item;

public class ViewModel extends androidx.lifecycle.ViewModel {

    private final MutableLiveData<Repository> itemID =
            new MutableLiveData(new Repository(new Item(null, null)));

    public LiveData<Repository> getItemID() {
        return itemID;
    }

    public void addItem(Integer imageId, String itemText) {
        itemID.setValue(
                new Repository(new Item(imageId, itemText))
        );
    }
}