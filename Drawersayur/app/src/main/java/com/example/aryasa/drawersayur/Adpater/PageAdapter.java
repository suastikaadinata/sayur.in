package com.example.aryasa.drawersayur.Adpater;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.aryasa.drawersayur.Fragment.TabFragmentCompleted;
import com.example.aryasa.drawersayur.Fragment.TabFragmentInprogress;

public class PageAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PageAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TabFragmentInprogress tab1 = new TabFragmentInprogress();
                return tab1;
            case 1:
                TabFragmentCompleted tab2 = new TabFragmentCompleted();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
