package com.example.lishan.answerapp.common;
import com.lykj.aextreme.afinal.common.BaseApplication;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;

/**
 * Created by Administrator on 2016/11/25 0025.
 */

public class MyApplication extends BaseApplication {
    private static MyApplication app;
    public static MyApplication getApp() {
        return app;
    }
    /**
     * App根目录.
     */
    public static String APP_PATH_ROOT;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        OkGo.getInstance().init(this);
//        OkGo.getInstance().init(this)                       //必须调用初始化
//                .setOkHttpClient(builder.build())               //建议设置OkHttpClient，不设置将使用默认的
//                .setCacheMode(CacheMode.NO_CACHE)               //全局统一缓存模式，默认不使用缓存，可以不传
//                .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)   //全局统一缓存时间，默认永不过期，可以不传
//                .setRetryCount(3)                               //全局统一超时重连次数，默认为三次，那么最差的情况会请求4次(一次原始请求，三次重连请求)，不需要可以设置为0
//                .addCommonHeaders(headers)                      //全局公共头
//                .addCommonParams(params);
    }
}
