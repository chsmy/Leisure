package com.chs.leisure.utils;

import com.chs.leisure.Constant;
import com.chs.leisure.utils.scalars.ScalarsConverterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者：chs on 2016/4/26 10:48
 * 邮箱：657083984@qq.com
 */
public class HttpUtils {

    private static final int DEFAULT_TIMEOUT = 5;

    private static HttpUtils mHttpUtils;
    //构造方法私有
    private HttpUtils() {

    }

    //获取单例
    public static HttpUtils getInstance(){
        if(mHttpUtils==null){
           synchronized (HttpUtils.class){
               if(mHttpUtils==null){
                   mHttpUtils = new HttpUtils();
               }
           }
        }
        return mHttpUtils;
    }
    public Retrofit initRetrofit(){
        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Constant.BasePictureUrl)
                .build();

        return retrofit;
    }
}
