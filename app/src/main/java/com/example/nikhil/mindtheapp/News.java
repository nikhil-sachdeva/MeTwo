package com.example.nikhil.mindtheapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class News extends Fragment {
    ArrayList<Post> posts = new ArrayList<>();
    RecyclerView news_list;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_main, container, false);
        news_list=view.findViewById(R.id.news_list);
        Post post1 = new Post("askjfasf","asdagsd","safasf");
        posts.add(post1);
        ConfAdapter confAdapter= new ConfAdapter(getContext(),posts);
        news_list.setHasFixedSize(true);
        news_list.setLayoutManager(new LinearLayoutManager(getContext()));
        news_list.setAdapter(confAdapter);


return view;
    }
}