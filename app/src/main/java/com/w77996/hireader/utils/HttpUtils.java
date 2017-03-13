package com.w77996.hireader.utils;

import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.w77996.hireader.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/3/13.
 */
public class HttpUtils {
    private static HttpUtils mHttpUtils;
    private Retrofit mRetrofit;
    // private String url;
    private OkHttpClient.Builder mBuilder;
    private Context mContext;
    private String url;

    private HttpUtils(Context context, String url) {
        this.mContext = context;
        this.url = url;
    }

    private HttpUtils() {
        initOkhttp();
    }

    public static HttpUtils getInstance() {
        if (mHttpUtils == null) {
            synchronized (HttpUtils.class) {
                if (mHttpUtils == null) {
                    mHttpUtils = new HttpUtils();
                }
            }
        }
        return mHttpUtils;
    }

    public <T> T create(Class<T> service,String url) {
        return  new Retrofit.Builder()
                .baseUrl(url)
                .client(mBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(service);
    }

    private void  initOkhttp() {
        mBuilder = new OkHttpClient.Builder()
                .connectTimeout(9, TimeUnit.SECONDS)    //设置连接超时 9s
                .readTimeout(10, TimeUnit.SECONDS);      //设置读取超时 10s

        if (BuildConfig.DEBUG) { // 判断是否为debug
            // 如果为 debug 模式，则添加日志拦截器
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            mBuilder.addInterceptor(interceptor);
        }
    }

}
