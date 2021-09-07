package com.example.falokaapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentSearch extends Fragment {

    public static final String EXTRA_NAME = "extra_name";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search, container, false);
        Bundle bundle = this.getArguments();

        if(bundle != null){
            // handle your code here.
            Toast.makeText(getContext(), bundle.getString("name") , Toast.LENGTH_SHORT).show();
        }



        return view;
    }
}
