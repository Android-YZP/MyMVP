package com.example.smith.mymvp.main.listener;

import android.os.Bundle;

/**
 * 生命周期监听
 *
 * @author 姚中平
 * @date 2017/7/15
 */

public interface LifeCycleListener {

    void onCreate(Bundle savedInstanceState);

    void onStart();

    void onRestart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

}
