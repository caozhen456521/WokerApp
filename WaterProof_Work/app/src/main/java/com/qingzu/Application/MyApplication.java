package com.qingzu.Application;

import android.app.Application;
import android.content.Context;
import android.os.Environment;

import com.wzgiceman.rxretrofitlibrary.retrofit_rx.RxRetrofitApp;
import com.yjx.sharelibrary.Share;

import java.io.File;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by Administrator on 2017/3/24.
 */

public class MyApplication extends Application {
    public static Context app;
    public static int screenWidth;
    public static int screenHeight;
    public static MyApplication context;
    public static double Longitude;// 经度
    public static double Latitude;// 纬度
    public static String Address;// 地址
    public static boolean isLocation;// 地址
    public static boolean isFirst = false;
    public static final String JCHAT_CONFIGS = "JChat_configs";
    public static String PICTURE_DIR = "sdcard/JChatQinZu/pictures/";

    @Override
    public void onCreate() {
        super.onCreate();

        app = getApplicationContext();
        RxRetrofitApp.init(this);
        JPushInterface.setDebugMode(true); // 设置开启日志,发布时请关闭日志
        JPushInterface.init(this); // 初始化 JPus
        File file = new File(Environment.getExternalStorageDirectory().toString() + File.separator + "sample");
        if (!file.exists()) {
            boolean mkdirs = file.mkdirs();
        }
        Share.init("CACHE", 10 * 1024, file.toString());
    }

}

