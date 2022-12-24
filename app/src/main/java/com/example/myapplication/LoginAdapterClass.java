package com.example.myapplication;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class LoginAdapterClass extends FragmentPagerAdapter {

    private Context context;
    int totalNumberOfTabs;

    public LoginAdapterClass(FragmentManager fm, Context context, int totalNumberOfTabs){
        super(fm);
        this.context = context;
        this.totalNumberOfTabs = totalNumberOfTabs;
    }

    public Fragment getItem(int position){
        switch (position){
            case 0:
                LoginTabFragment loginTabFragment = new LoginTabFragment();
                return  loginTabFragment;
            case 1:
                AboutTabFragment aboutTabFragment = new AboutTabFragment();
                return aboutTabFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalNumberOfTabs;
    }
}
