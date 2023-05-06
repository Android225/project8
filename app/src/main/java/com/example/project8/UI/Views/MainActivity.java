package com.example.project8.UI.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.project8.R;
import com.example.project8.data.Repository.Repository;

public class MainActivity extends AppCompatActivity {

    sec_frag second__ = new sec_frag();

    thi_frag third__ = new thi_frag();

    fir_frag first__ = new fir_frag();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Repository al = new Repository();
        al.apsl(getApplication());
        al.extl(getApplication());
        al.rool(getApplication());
        al.sharl(getApplication());

        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragment_container_view,first__)
                .commit();

        ViewModel viewModel = new ViewModelProvider(this).get(ViewModel.class);
        viewModel.addItem(1, "text");
        viewModel.getItemID().observe( this, item -> {
            Log.d("ITEM",item.getItem().getText());
        });

    }

    public void second_click(View view) {

        FragmentTransaction fTrans = getSupportFragmentManager().beginTransaction();

        Bundle bundle = new Bundle();

        second__.setArguments(bundle);

        fTrans.replace(R.id.fragment_container_view, second__).addToBackStack(null).commit();

    }

    public void third_click(View view) {
        FragmentTransaction fTrans = getSupportFragmentManager().beginTransaction();

        Bundle bundle = new Bundle();

        third__.setArguments(bundle);

        fTrans.replace(R.id.fragment_container_view, third__).addToBackStack(null).commit();

    }