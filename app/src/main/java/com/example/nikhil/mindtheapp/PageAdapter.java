package com.example.nikhil.mindtheapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {
    public PageAdapter(android.support.v4.app.FragmentManager fragmentManager) {
        super(fragmentManager);
    }


    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        if(position==0){
            fragment=new Confession();
        }
        if(position==1){
            fragment=new News();
        }

        return fragment;
    }


    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "Confessions";
        }
        else return "News";
    }

}
