package com.example.smith.mymvp.main.app_module.test_module.presenter;

import com.example.smith.mymvp.main.app_module.test_module.contract.ITestContract;
import com.example.smith.mymvp.main.app_module.test_module.view.activity.MainActivity;
import com.example.smith.mymvp.main.base.BaseActivity;
import com.example.smith.mymvp.main.base.BasePresenter;
import com.example.smith.mymvp.main.http.Api.ApiUtils;
import com.example.smith.mymvp.main.http.exception.ApiException;
import com.example.smith.mymvp.main.http.observer.HttpRxObservable;
import com.example.smith.mymvp.main.http.observer.HttpRxObserver;
import com.example.smith.mymvp.main.http.retrofit.HttpRequest;
import com.example.smith.mymvp.main.utils.LogUtils;
import com.example.smith.mymvp.main.utils.StringUtils;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;

import java.util.Map;

import io.reactivex.disposables.Disposable;

/**
 * Created by 姚中平 on 2018/1/11.
 */

public class TestPresenter extends BasePresenter<ITestContract, BaseActivity> {
    private final String TAG = TestPresenter.class.getSimpleName();

    public TestPresenter(ITestContract view, BaseActivity activity) {
        super(view, activity);
    }

    /**
     * 获取信息
     *
     * @author 姚中平
     */
    public void HttpLogin(String phone) {

        //构建请求数据
        Map<String, Object> request = HttpRequest.getRequest();
        request.put("phone", "17625017026");
        request.put("password", StringUtils.md5("qqqqqq" + "17625017026".substring(0, 5)));

        HttpRxObserver httpRxObserver = new HttpRxObserver(TAG + "getInfo") {

            @Override
            protected void onStart(Disposable d) {
                if (getView() != null)
                    getView().LoadingData();
            }

            @Override
            protected void onError(ApiException e) {
                // 给当前打印的换一个单独的tag名
                if (getView() != null) {
                    getView().LoadingDataFail();
                    getView().showToast(e.getMsg());
                }
            }

            @Override
            protected void onSuccess(Object response) {
                Logger.json(response + "");
                HttpRequest bean = new Gson().fromJson(response.toString(), HttpRequest.class);
                if (getView() != null) {
                    getView().LoadingDataSuccess(response.toString());
                }
            }
        };

        HttpRxObservable.getObservable(ApiUtils.getTestApi().login(request), getActivity()).subscribe(httpRxObserver);
    }


}
