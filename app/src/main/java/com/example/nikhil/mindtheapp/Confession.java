package com.example.nikhil.mindtheapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Confession extends Fragment {

    RecyclerView conf_list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.conf_main, container, false);

        conf_list = (RecyclerView) view.findViewById(R.id.conf_list);
        conf_list.setHasFixedSize(true);
        conf_list.setLayoutManager(new LinearLayoutManager(getContext()));


        return view;

    }
}
