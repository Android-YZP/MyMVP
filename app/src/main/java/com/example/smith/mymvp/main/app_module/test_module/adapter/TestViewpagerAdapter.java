package com.example.smith.mymvp.main.app_module.test_module.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.orhanobut.logger.Logger;

import java.util.List;

/**
 * Created by 姚中平 on 2018/1/12.
 */

public class TestViewpagerAdapter extends FragmentPagerAdapter {


    private List<Fragment> list;

    public TestViewpagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public TestViewpagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        Logger.e(list.size()+"2");
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        Logger.e(list.size()+"1");
        return list.get(position);
    }

    @Override
    public int getCount() {
        Logger.e(list.size()+"");
        return list != null ? 0 : list.size();
    }
}

