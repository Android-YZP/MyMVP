package com.example.smith.mymvp.main.base;

import android.content.Context;
import android.os.Bundle;

import com.example.smith.mymvp.main.listener.LifeCycleListener;
import com.example.smith.mymvp.main.manager.ActivityStackManager;
import com.trello.rxlifecycle2.components.RxActivity;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.vondear.rxtools.RxTool;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import pub.devrel.easypermissions.EasyPermissions;


/**
 * 基类Activity
 * 备注:所有的Activity都继承自此Activity
 * 1.规范团队开发
 * 2.统一处理Activity所需配置,初始化
 *
 * @author 姚中平
 */
public abstract class BaseActivity extends RxAppCompatActivity implements EasyPermissions.PermissionCallbacks {

    protected Unbinder unBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (mListener != null) {
            mListener.onCreate(savedInstanceState);
        }

        //手动对activity栈的管理
        ActivityStackManager.getManager().push(this);
        setContentView(getContentViewId());
        unBinder = ButterKnife.bind(this);//初始化ButterKnife
        initBundleData();
        initView();
        initData();
        setListener();

        //注册EventBus
        if (isEventBus()){
            EventBus.getDefault().register(this);
        }

    }




    @Override
    protected void onStart() {
        super.onStart();
        if (mListener != null) {
            mListener.onStart();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (mListener != null) {
            mListener.onRestart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mListener != null) {
            mListener.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mListener != null) {
            mListener.onPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mListener != null) {
            mListener.onStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mListener != null) {
            mListener.onDestroy();
        }
        //移除view绑定
        if (unBinder != null) {
            unBinder.unbind();
        }

        //注销EventBus
        if (isEventBus()){
            EventBus.getDefault().unregister(this);
        }

        ActivityStackManager.getManager().remove(this);
    }


    /**
     * 获取显示view的xml文件ID
     */
    protected abstract int getContentViewId();

    /**
     * 获取上一个界面传送过来的数据
     */
    protected abstract void initBundleData();

    /**
     * 初始化应用程序，设置一些界面控件的初始化
     */
    protected abstract void initView();

    /**
     * 初始化应用程序，设置一些初始化数据,获取数据等操作
     */
    protected abstract void initData();

    /**
     * 设置一些控件的各种监听
     */
    protected abstract void setListener();
    /**
     * 是否成为EventBus消息的接收者
     */
    protected abstract boolean isEventBus();

    /*************************************权限的处理*************************************************************/

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> list) {
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> list) {
    }


    /**
     * 回调LifeCycleListener的监听
     */
    public LifeCycleListener mListener;

    public void setOnLifeCycleListener(LifeCycleListener listener) {
        mListener = listener;
    }


}
