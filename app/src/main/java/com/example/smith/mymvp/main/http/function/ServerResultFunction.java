package com.example.smith.mymvp.main.http.function;

import com.example.smith.mymvp.main.http.exception.ServerException;
import com.example.smith.mymvp.main.http.retrofit.HttpResponse;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * 服务器结果处理函数
 * @author 姚中平
 */
public class ServerResultFunction implements Function<HttpResponse, Object> {
    @Override
    public Object apply(@NonNull HttpResponse response) throws Exception {
        //打印服务器回传结果
        if (!response.isSuccess()) {
            throw new ServerException(response.getCode(), response.getMsg());
        }
        return new Gson().toJson(response.getResult());
    }
}
