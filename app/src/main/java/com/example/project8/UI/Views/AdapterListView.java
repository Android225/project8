package com.example.project8.UI.Views;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pr7.R;
import com.example.pr7.data.Models.Item;

import java.util.List;

public class AdapterListView extends ArrayAdapter<Item> {
    private LayoutInflater inflater;
    private int layout;
    private List<Item> items;

    public AdapterListView(Context context, int resource, List<Item> items) {
        super(context, resource, items);
        this.items = items;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(this.layout, parent, false);

        Item item = items.get(position);
        Log.d("getView", item.getText());

        TextView textView = view.findViewById(R.id.TextViewList);
        textView.setText(item.getText());

        ImageView imageView = view.findViewById(R.id.ImageViewList);
        imageView.setImageResource(item.getImageId());

        return view;
    }
}