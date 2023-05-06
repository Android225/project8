package com.example.project8.UI.Views;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.pr7.R;
import com.example.pr7.data.Models.Item;

import java.util.ArrayList;
import java.util.List;

public class sec_frag extends Fragment {
    public sec_frag() {
        super(R.layout.second_fragment);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_fragment, container, false);

        List<Item> itemList = new ArrayList<Item>();
        ListView listView = view.findViewById(R.id.list_sec);

        for(int i = 0; i < 200; i++) {
            itemList.add(new Item(R.drawable.book, "book" + (i)));
        }

        AdapterListView adapterListView = new AdapterListView(getContext(), R.layout.it_i, itemList);

        listView.setAdapter(adapterListView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                Toast.makeText(
                        getContext(),
                        ((TextView) itemClicked.findViewById(R.id.TextViewList)).getText(),
                        Toast.LENGTH_SHORT).show();
                Log.d("ListView", (String) ((TextView) itemClicked.findViewById(R.id.TextViewList)).getText());
            }
        });

        return view;
    }
}

