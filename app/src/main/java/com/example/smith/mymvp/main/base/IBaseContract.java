package com.example.smith.mymvp.main.base;

/**
 * IBaseView
 *
 * @author 姚中平
 */

public interface IBaseContract {

    //加载数据中
    void LoadingData();

    //加载失败
    void LoadingDataFail();

    //加载成功
    void LoadingDataSuccess(String result);

    //显示吐司
    void showToast(String result);

}
