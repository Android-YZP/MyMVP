package com.example.smith.mymvp.main.http.Api;

import com.example.smith.mymvp.main.http.retrofit.HttpResponse;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * @author 姚中平
 */
public interface UserApi {

    @GET("user/login")
    Observable<HttpResponse> login(@QueryMap Map<String, Object> request);

}
