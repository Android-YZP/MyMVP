package com.example.smith.mymvp.main.http.Api;


import com.example.smith.mymvp.main.http.retrofit.RetrofitUtils;

/**
 * 接口工具类
 *
 * @author 姚中平
 */

public class ApiUtils {


    private static PhoneApi phoneApi;
    private static UserApi userApi;
    private static TestApi testApi;

    public static PhoneApi getPhoneApi() {
        if (phoneApi == null) {
            phoneApi = RetrofitUtils.get().retrofit().create(PhoneApi.class);
        }
        return phoneApi;
    }

    public static UserApi getUserApi() {
        if (userApi == null) {
            userApi = RetrofitUtils.get().retrofit().create(UserApi.class);
        }
        return userApi;
    }


    public static TestApi getTestApi() {
        if (testApi == null) {
            testApi = RetrofitUtils.get().retrofit().create(TestApi.class);
        }
        return testApi;
    }

}
