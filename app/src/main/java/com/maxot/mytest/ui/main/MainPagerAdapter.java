package com.maxot.mytest.ui.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.maxot.mytest.ui.main.results.ResultsFragment;
import com.maxot.mytest.ui.main.tasks.TasksFragment;
import com.maxot.mytest.ui.main.tests.TestsFragment;

public class MainPagerAdapter extends FragmentStatePagerAdapter {

    private  int mTabCount;

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
        this.mTabCount = 0;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return TestsFragment.newInstance();
            case 1:
                return TasksFragment.newInstance();
            default:
                return null;
        }
    }


    @Override
    public int getCount() {
        return mTabCount;
    }

    public void setCount(int tabCount) {
        mTabCount = tabCount;
    }
}
