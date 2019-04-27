package com.android.stockmanager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int numOfTabs;
    public PagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int i) {
        switch(i){
            case 0: return new ProductListFragment();
            case 1: return new ProductListFragment();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return this.numOfTabs;
    }
}
