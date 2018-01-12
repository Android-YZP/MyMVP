package com.example.smith.mymvp.main.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.smith.mymvp.main.listener.LifeCycleListener;
import com.trello.rxlifecycle2.components.support.RxFragment;
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
public abstract class BaseFragment extends RxFragment implements EasyPermissions.PermissionCallbacks {

    protected Context mContext;
    protected Unbinder unBinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getContentViewId(), container, false);
//        if (mListener != null) {
//            mListener.onCreate(savedInstanceState);
//        }
//
//        //注册EventBus
//        if (isEventBus()){
//            EventBus.getDefault().register(this);
//        }
//
//        mContext = getActivity();
//        unBinder = ButterKnife.bind(this, view);//初始化ButterKnife
//        initBundleData();
//        initView();
//        initData();
//        setListener();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mListener != null) {
            mListener.onStart();
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        if (mListener != null) {
            mListener.onResume();
        }

        //注册EventBus
        if (isEventBus()) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mListener != null) {
            mListener.onPause();
        }

        //注销EventBus
        if (isEventBus()) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mListener != null) {
            mListener.onStop();
        }
    }

    @Override
    public void onDestroy() {
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
