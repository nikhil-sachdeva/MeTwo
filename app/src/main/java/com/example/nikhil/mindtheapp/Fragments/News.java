package com.example.nikhil.mindtheapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nikhil.mindtheapp.Adapters.ConfAdapter;
import com.example.nikhil.mindtheapp.Models.Post;
import com.example.nikhil.mindtheapp.R;

import java.util.ArrayList;

public class News extends Fragment {
    ArrayList<Post> posts = new ArrayList<>();
    RecyclerView news_list;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_main, container, false);
        news_list=view.findViewById(R.id.news_list);
        Post post1 = new Post("Home Minister Present, Maneka Gandhi Asks Tough Questions On Women Safety","Women and Child Welfare Minister Maneka Gandhi today questioned the safety of shelter homes in the country in the presence of Home Minister Rajnath Singh, who was inaugurating the sexual offender registry portal in the national capital.","17th Jan");
        Post post2 = new Post("Mohan Bhagwat's Top Quotes As RSS Outreach Programme Concludes","On the last day of RSS conclave 'Bhavishya Ka Bharat', chief Mohan Bhagwat answered questions answered questions on education, language, women safety and cow vigilantism, asked by special invites.","20th July");
        Post post3 = new Post("Congress Launches Mobile App And Pepper Sprays For Women Safety In Bihar","The Congress party yesterday launched a Bihar-specific mobile app, named after late prime minister Indira Gandhi, which can be used by women in times of distress, and a pepper spray on which the image of its president Rahul Gandhi is inscribed.","9th August");
        posts.add(post2);
        posts.add(post3);
        posts.add(post1);
        ConfAdapter confAdapter= new ConfAdapter(getContext(),posts);
        news_list.setHasFixedSize(true);
        news_list.setLayoutManager(new LinearLayoutManager(getContext()));
        news_list.setAdapter(confAdapter);


return view;
    }
}