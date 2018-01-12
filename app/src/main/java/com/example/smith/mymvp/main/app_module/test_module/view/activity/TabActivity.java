package com.example.smith.mymvp.main.app_module.test_module.view.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.smith.mymvp.R;
import com.example.smith.mymvp.main.app_module.test_module.adapter.TestViewpagerAdapter;
import com.example.smith.mymvp.main.app_module.test_module.view.fragment.BlankFragment;
import com.example.smith.mymvp.main.app_module.test_module.view.fragment.TestBlankFragment;
import com.example.smith.mymvp.main.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
public class TabActivity extends BaseActivity {


    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected int getContentViewId() {
        return R.layout.activity_tab;
    }

    @Override
    protected void initBundleData() {

    }

    @Override
    protected void initView() {
        tabLayout.addTab(tabLayout.newTab().setText("标签一"));
        tabLayout.addTab(tabLayout.newTab().setText("标签一"));
        tabLayout.addTab(tabLayout.newTab().setText("标签一"));
        tabLayout.addTab(tabLayout.newTab().setText("标签一"));

        fragmentList.add(new TestBlankFragment());
        fragmentList.add(new TestBlankFragment());
        fragmentList.add(new TestBlankFragment());
        fragmentList.add(new TestBlankFragment());
        viewpager.setAdapter(new TestViewpagerAdapter(getSupportFragmentManager(),fragmentList));

//        tabLayout.setupWithViewPager(viewpager);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setListener() {


    }

    @Override
    protected boolean isEventBus() {
        return false;
    }


}
