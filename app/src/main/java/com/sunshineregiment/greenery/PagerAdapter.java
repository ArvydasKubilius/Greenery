package com.sunshineregiment.greenery;

/**
 * Created by Zikoz on 10/03/2017.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.TextView;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                CO2_fragment tab1 = new CO2_fragment();
                //Step_counter_fragment tab1 = new Step_counter_fragment();
                return tab1;
            case 1:
                Graphs_fragment tab2 = new Graphs_fragment();
                return tab2;
            case 2:
                //Graphs_fragment tab3 = new Graphs_fragment();
                Step_counter_fragment tab3 = new Step_counter_fragment();
                return tab3;
            case 3:
                Leaderboard_fragment tab4 = new Leaderboard_fragment();
                return tab4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}