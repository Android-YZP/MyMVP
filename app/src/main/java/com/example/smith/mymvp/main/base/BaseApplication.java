package com.example.smith.mymvp.main.base;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.vondear.rxtools.RxTool;

/**
 * Created by 姚中平 on 2018/1/11.
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //RxTools的初始化
        RxTool.init(this);
        //Logger的初始化
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(true)  // 显示线程信息
                .methodCount(1)         // 显示这一行的Log又几个方法的嵌套
                .methodOffset(0)        // 隐藏内部方法调用，以抵消。默认的5
                .tag("项目名=======》")   // 每个日志的全局标记。默认PRETTY_LOGGER
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));

    }
}
