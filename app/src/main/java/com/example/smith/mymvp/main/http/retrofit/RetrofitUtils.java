package com.example.smith.mymvp.main.http.retrofit;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * RetrofitUtils工具类
 *
 * @author 姚中平
 */
public class RetrofitUtils {
    /**
     * 接口地址
     */
    public static final String BASE_API = "http://118.89.246.194:8080/api/";
    public static final int CONNECT_TIME_OUT = 30;//连接超时时长x秒
    public static final int READ_TIME_OUT = 30;//读数据超时时长x秒
    public static final int WRITE_TIME_OUT = 30;//写数据接超时时长x秒
    private static RetrofitUtils mInstance = null;

    private RetrofitUtils() {
    }

    public static RetrofitUtils get() {
        if (mInstance == null) {
            synchronized (RetrofitUtils.class) {
                if (mInstance == null) {
                    mInstance = new RetrofitUtils();
                }
            }
        }
        return mInstance;
    }


    /**
     * 设置okHttp
     *
     * @author 姚中平
     */
    private static OkHttpClient okHttpClient() {
        //开启Log
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
            }
        });
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);

        OkHttpClient client = new OkHttpClient.Builder()
                //TIME_OUT
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
                //设置缓存
//                .addInterceptor(cacheInterceptor)
//                .addNetworkInterceptor(cacheInterceptor)
                .addInterceptor(logging) //打印日志
                .build();
        return client;
    }

    /**
     * 获取Retrofit
     *
     * @author 姚中平
     */
    public Retrofit retrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient())  //设置OKHttpClient
                .baseUrl(BASE_API)
                .addConverterFactory(GsonConverterFactory.create())//String转化器
                .addConverterFactory(GsonConverterFactory.create())//Gson转化器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //Rxjava
                .build();
        return retrofit;
    }

}
