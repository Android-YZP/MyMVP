package com.example.smith.mymvp.main.app_module.test_module.view.activity;

import android.view.View;
import android.widget.Button;
import com.example.smith.mymvp.R;
import com.example.smith.mymvp.main.app_module.test_module.model.EventBean.TestMessage;
import com.example.smith.mymvp.main.app_module.test_module.model.EventBean.TestStickyMessage;
import com.example.smith.mymvp.main.base.BaseActivity;
import com.vondear.rxtools.RxActivityTool;
import com.vondear.rxtools.view.RxToast;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import butterknife.BindView;
import butterknife.OnClick;

public class EventBusActivity extends BaseActivity {

    @BindView(R.id.button)
    Button mButton;
    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.button2)
    Button button2;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_eventbus;
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

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(TestMessage messageEvent) {
        RxToast.info(messageEvent.getMessage());
    }

    @OnClick({R.id.button, R.id.button1, R.id.button2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button:
                EventBus.getDefault().post(new TestMessage("Hello !....."));
                break;
            case R.id.button1:
                EventBus.getDefault().post(new TestMessage("Hello哈哈哈"));
                break;
            case R.id.button2:
                RxActivityTool.skipActivity(EventBusActivity.this,EventBusSkipActivity.class);
                // 发布Sticky事件
                EventBus.getDefault().postSticky(new TestStickyMessage("数据过来了吗？"));
                break;
        }
    }
}
