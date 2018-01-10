package com.example.smith.mymvp.main.base;

/**
 * IBaseView
 *
 * @author 姚中平
 */

public interface IBaseView {

    //显示loading，加载中
    void showLoading();

    //关闭loading，加载完成
    void closeLoading();

    //显示吐司，显示信息
    void showToast(String msg);

}
