package com.example.nikhil.mindtheapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import retrofit2.http.POST;

public class Confession extends Fragment {

    private static final String TAG = "wow";
    RecyclerView conf_list;
    DatabaseReference ref;
    ArrayList<Post> posts= new ArrayList<>();
    Context context = getContext();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.conf_main, container, false);

        conf_list = (RecyclerView) view.findViewById(R.id.conf_list);


        ref= FirebaseDatabase.getInstance().getReference("posts");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               for (DataSnapshot postSnapshot: dataSnapshot.getChildren()){
                   for (DataSnapshot child: postSnapshot.getChildren()) {
                       Post post = child.getValue(Post.class);

                       Log.d(TAG, "onDataChange: " + post.getName());
                       posts.add(post);
                       ConfAdapter confAdapter= new ConfAdapter(getContext(),posts);
                       conf_list.setHasFixedSize(true);
                       conf_list.setLayoutManager(new LinearLayoutManager(getContext()));
                       conf_list.setAdapter(confAdapter);

                       Log.d(TAG, "onDataChange: "+posts.size());
                   }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        Log.d(TAG, "onCreateView:"+posts.size());



        return view;

    }
}
