package com.example.smith.mymvp.main.app_module.test_module.view.activity;


import com.example.smith.mymvp.R;
import com.example.smith.mymvp.main.app_module.test_module.contract.ITestContract;
import com.example.smith.mymvp.main.app_module.test_module.model.main_bean.TestBean;
import com.example.smith.mymvp.main.app_module.test_module.presenter.TestPresenter;
import com.example.smith.mymvp.main.base.BaseActivity;
import com.vondear.rxtools.view.RxToast;

import java.util.ArrayList;
import java.util.List;

public class NetLogTestActivity extends BaseActivity implements ITestContract {
    private TestPresenter mTestPresenter = new TestPresenter(this, this);

    @Override
    protected int getContentViewId() {
        return R.layout.activity_net_log_test;
    }

    @Override
    protected void initBundleData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        mTestPresenter.HttpLogin("");
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected boolean isEventBus() {
        return false;
    }

    @Override
    public void LoadingData() {

    }

    @Override
    public void LoadingDataFail() {

    }

    @Override
    public void LoadingDataSuccess(String result) {

    }

    @Override
    public void showToast(String result) {
        RxToast.error(result);
    }


}
