package com.example.project8.data.Models;

public class Item {
    Integer imageId;
    String itemText;

    public Item(Integer imageId, String itemText) {
        super();
        this.imageId = imageId;
        this.itemText = itemText;
    }

    public void setText(String itemText) {
        this.itemText = itemText;
    }

    public String getText() {
        return itemText;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public Integer getImageId() {
        return imageId;
    }
}