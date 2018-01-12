package com.example.smith.mymvp.main.app_module.test_module.view.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.smith.mymvp.R;
import com.example.smith.mymvp.main.app_module.test_module.ModuleConstants;
import com.example.smith.mymvp.main.app_module.test_module.adapter.TestAdapter;
import com.example.smith.mymvp.main.app_module.test_module.contract.ITestContract;
import com.example.smith.mymvp.main.app_module.test_module.model.main_bean.TestBean;
import com.example.smith.mymvp.main.app_module.test_module.presenter.TestPresenter;
import com.example.smith.mymvp.main.app_module.test_module.view.TestView.SampleHeader;
import com.example.smith.mymvp.main.base.BaseActivity;
import com.github.jdsjlzx.ItemDecoration.LuDividerDecoration;
import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.vondear.rxtools.RxActivityTool;
import com.vondear.rxtools.RxImageTool;
import com.vondear.rxtools.view.RxToast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements ITestContract {


    @BindView(R.id.lrv_main_list)
    LuRecyclerView mLrvMainList;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    /****************************************我是一道华丽的分割线****************************************************/
    private TestAdapter mTestAdapter;
    private LuRecyclerViewAdapter mLuRecyclerViewAdapter;
    private TestPresenter mTestPresenter = new TestPresenter(this, this);

    /**
     * 封装list的数据源
     */
    List<TestBean> mTestBeanList = new ArrayList<>();

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initBundleData() {

    }

    @Override
    protected void initView() {
        //设置刷新时动画的颜色，可以设置4个
        mSwipeRefreshLayout.setProgressViewOffset(false, 0, RxImageTool.dip2px(48));
        mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
        //setLayoutManager放在setAdapter之前配置
        mLrvMainList.setLayoutManager(new LinearLayoutManager(this));

        //LRecyclerView的配置方法
        mTestAdapter = new TestAdapter(this);
        mLuRecyclerViewAdapter = new LuRecyclerViewAdapter(mTestAdapter);
        mLrvMainList.setAdapter(mLuRecyclerViewAdapter);

        //设置分割线
        LuDividerDecoration divider = new LuDividerDecoration.Builder(this, mLuRecyclerViewAdapter)
                .setHeight(R.dimen.default_divider_height)
                .setPadding(R.dimen.default_divider_padding)
                .setColorResource(R.color.split)
                .build();
        mLrvMainList.setHasFixedSize(true);
        mLrvMainList.addItemDecoration(divider);

        //添加头布局
        mLuRecyclerViewAdapter.addHeaderView(new SampleHeader(this));
    }

    @Override
    protected void initData() {
        mTestPresenter.HttpLogin("");
    }

    @Override
    protected void setListener() {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

        mLuRecyclerViewAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                TestBean item = mTestBeanList.get(position);
                RxActivityTool.skipActivity(MainActivity.this, item.view);
            }
        });
    }

    @Override
    protected boolean isEventBus() {
        return false;
    }

    /****************************************我是一道华丽的分割线****************************************************/
    @Override
    public void LoadingData() {

    }

    @Override
    public void LoadingDataFail() {

    }

    @Override
    public void LoadingDataSuccess(String result) {
        TestBean testBean = new TestBean();
        testBean.name = ModuleConstants.NetAndLogTest;
        testBean.view = NetLogTestActivity.class;
        mTestBeanList.add(testBean);

        TestBean testBean1 = new TestBean();
        testBean1.name = ModuleConstants.EventBus;
        testBean1.view = EventBusActivity.class;
        mTestBeanList.add(testBean1);

        TestBean testBean2 = new TestBean();
        testBean2.name = ModuleConstants.TabLayout;
        testBean2.view = Main2Activity.class;
        mTestBeanList.add(testBean2);

        mTestAdapter.setDataList(mTestBeanList);
    }

    @Override
    public void showToast(String result) {
        RxToast.error(result);
    }


}
