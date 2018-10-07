package com.example.nikhil.mindtheapp.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nikhil.mindtheapp.Models.Post;
import com.example.nikhil.mindtheapp.R;

import java.util.ArrayList;

public class ConfAdapter extends RecyclerView.Adapter<ConfAdapter.Holder> {

ArrayList<Post> posts = new ArrayList<>();
LayoutInflater inflater;
Context context;

    public ConfAdapter(Context context, ArrayList<Post> posts) {
        this.context=context;
        this.posts=posts;
        inflater = LayoutInflater.from(context);

    }



    @NonNull
    @Override
    public ConfAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.conf_list_layout, viewGroup, false);
        final Holder holder = new Holder(view);
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent in =new Intent(Intent.ACTION_VIEW);
//                int position = holder.getLayoutPosition();
//                in.setData(Uri.parse(results.get(position).get("link")));
//                context.startActivity(in);
//
//            }
//        });


        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        holder.name.setText(posts.get(i).getName());
        holder.location.setText(posts.get(i).getLocation());
        holder.body.setText(posts.get(i).getBody());

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
    class Holder extends RecyclerView.ViewHolder{
        TextView name,location,body;
        ImageView image;
        public Holder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            body=itemView.findViewById(R.id.body);
            location=itemView.findViewById(R.id.location);
        }
    }
}
