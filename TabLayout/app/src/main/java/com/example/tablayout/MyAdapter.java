package com.example.tablayout;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyAdapter extends FragmentPagerAdapter {

    private Context context;
    int totleTab;

    public MyAdapter(FragmentManager fm, Context context, int totleTab) {
        super(fm);
        this.context = context;
        this.totleTab = totleTab;
    }



    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;
            case 1:
                SportFragment sportFragment = new SportFragment();
                return sportFragment;
            case 2:
                MovieFragment movieFragment = new MovieFragment();
                return movieFragment;
            default:
                return null;

        }



    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return totleTab;
    }
}
