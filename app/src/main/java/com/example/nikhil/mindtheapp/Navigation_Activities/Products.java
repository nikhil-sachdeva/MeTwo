package com.example.nikhil.mindtheapp.Navigation_Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nikhil.mindtheapp.R;

public class Products extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        getSupportActionBar().setTitle("Producst for Women's Safety");
    }
}
