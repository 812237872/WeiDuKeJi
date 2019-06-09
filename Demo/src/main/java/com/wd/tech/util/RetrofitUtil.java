package com.wd.tech.util;

import android.util.Log;

import com.wd.tech.bean.MyId;
import com.wd.tech.view.App;
import com.wd.tech.view.LoginActivity;

import java.io.IOException;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Author: zhang
 * @Date: 2019/5/9 18:30
 * @Description:
 */
public class RetrofitUtil {
    OkHttpClient okHttpClient;
    static RetrofitUtil retrofitUtil;
    Retrofit retrofit;
    private RetrofitUtil(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request build = chain.request()
                                .newBuilder()
                                .addHeader("userId", LoginActivity.userId+"")
                                .addHeader("sessionId",LoginActivity.sessionId+"")
                                .build();
                        return chain.proceed(build);
                    }
                })
                .addNetworkInterceptor(interceptor)
                .build();
    }
    public static synchronized RetrofitUtil getRetrofitUtil(){
        if (retrofitUtil == null){
            retrofitUtil = new RetrofitUtil();
        }
        return retrofitUtil;
    }

    public Retrofit getRetrofit(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("https://mobile.bwstudent.com/")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public <T>T getApi(Class<T> service){
        return getRetrofit().create(service);
    }
}
