package com.example.smith.mymvp.main.app_module.test_module.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.vondear.rxtools.RxActivityTool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 姚中平 on 2018/1/12.
 */

public class TestViewpagerAdapter extends FragmentPagerAdapter {


    private List<Fragment> mList;
    private List<String> mListTitle = new ArrayList<>();

    //重写这个方法，将设置每个Tab的标题
    @Override
    public CharSequence getPageTitle(int position) {
        return mListTitle.get(position);
    }

    public TestViewpagerAdapter(FragmentManager fm,List<Fragment> list) {
        super(fm);
        this.mList = list;
        mListTitle.add("标签一");
        mListTitle.add("标签二");
        mListTitle.add("标签三");
        mListTitle.add("标签四");
        mListTitle.add("标签五");
    }

    @Override
    public Fragment getItem(int position) {

        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }
}

