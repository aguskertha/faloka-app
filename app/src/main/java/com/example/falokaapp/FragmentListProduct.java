package com.example.falokaapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class FragmentListProduct extends Fragment {

    private Toolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_product, container, false);
        AppCompatActivity activity = (AppCompatActivity) getActivity();

//        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
//        activity.setSupportActionBar(toolbar);
//        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        activity.getSupportActionBar().setTitle("BLOUSE");
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        activity.getSupportActionBar().setHomeButtonEnabled(true);


        return view;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

//        switch (item.getItemId()){
//            case android.R.id.home:
//        }
        Toast.makeText(getContext(), "HMM", Toast.LENGTH_SHORT).show();

        return super.onOptionsItemSelected(item);
    }

    //    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        switch (item.getItemId()){
//            case android.R.id.
//
//                return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
