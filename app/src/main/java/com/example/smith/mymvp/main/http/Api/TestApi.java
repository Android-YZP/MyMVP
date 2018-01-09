package com.example.smith.mymvp.main.http.Api;


import com.example.smith.mymvp.main.http.retrofit.HttpResponse;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.HEAD;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * @author 姚中平
 */
public interface TestApi {


    //静态设置Header值
    @Headers("token: C47B1071")//传入固定的Token
    @POST("login")
    Observable<HttpResponse> login(@QueryMap Map<String, Object> request);

}
