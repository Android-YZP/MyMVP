package com.example.smith.mymvp.main.app_module.test_module.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.smith.mymvp.R;
import com.example.smith.mymvp.main.app_module.test_module.adapter.TestViewpagerAdapter;
import com.example.smith.mymvp.main.app_module.test_module.view.fragment.TestBlankFragment;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    List<Fragment> fragmentList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ViewPager viewpager = (ViewPager) findViewById(R.id.viewpager);
        fragmentList.add(new TestBlankFragment());
        viewpager.setAdapter(new TestViewpagerAdapter(getSupportFragmentManager(),fragmentList));
    }
}
