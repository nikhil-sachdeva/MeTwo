package com.example.nikhil.mindtheapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ToggleButton;

<<<<<<< HEAD
import com.example.nikhil.mindtheapp.Models.Post;
=======
>>>>>>> origin/master
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreatePost extends AppCompatActivity {
    FloatingActionButton postfab;
    EditText body,location;
    ToggleButton anon;
    String post_body,loc;
    FirebaseUser user;
    DatabaseReference myRef;
    boolean anonymous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);
        postfab=findViewById(R.id.postbt);
        body=findViewById(R.id.body);
        anon=findViewById(R.id.anon);
        user= FirebaseAuth.getInstance().getCurrentUser();
        myRef= FirebaseDatabase.getInstance().getReference("posts");
        anon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    anonymous=true;
                } else {
                    anonymous=false;
                }
            }
        });
        location=findViewById(R.id.location);
        postfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Post post;
                post_body=body.getText().toString();
                loc=location.getText().toString();
                if(anonymous) {
                    post = new Post("Anonymous",post_body,loc);
                }
                else{
                    post = new Post(user.getDisplayName(),post_body,loc);
                }


                myRef.child(user.getDisplayName()).child("post").setValue(post);
                startActivity(new Intent(CreatePost.this,MainActivity.class));

            }
        });
    }
}
