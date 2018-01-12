package com.example.smith.mymvp.main.app_module.test_module.view.activity;

import android.os.Bundle;
import android.widget.Button;

import com.example.smith.mymvp.R;
import com.example.smith.mymvp.main.app_module.test_module.model.EventBean.TestMessage;
import com.example.smith.mymvp.main.app_module.test_module.model.EventBean.TestStickyMessage;
import com.example.smith.mymvp.main.base.BaseActivity;
import com.vondear.rxtools.view.RxToast;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventBusSkipActivity extends BaseActivity {

    @BindView(R.id.button3)
    Button button3;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_eventbus_skip;
    }

    @Override
    protected void initBundleData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected boolean isEventBus() {
        return true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void onDataSynEvent(TestStickyMessage event) {
        button3.setText(event.getMessage());
    }

}
