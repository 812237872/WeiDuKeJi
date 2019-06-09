package com.wd.tech.model;

import android.annotation.SuppressLint;
import android.util.Log;

import com.google.gson.Gson;
import com.wd.tech.mvp.MyInterface;
import com.wd.tech.util.Api;
import com.wd.tech.util.RetrofitUtil;

import java.util.Map;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * @Author: zhang
 * @Date: 2019/5/9 16:01
 * @Description:
 */
public class MyModel implements MyInterface.ModelInter {
    MyCallBack myCallBack;

    @Override
    public void doGet(String url, final Class cls, Map<String, String> map, final MyCallBack myCallBack) {
        this.myCallBack = myCallBack;
        RetrofitUtil.getRetrofitUtil().getApi(Api.class)
                .requestGet(url,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        //Log.i("tag",responseBody.string());
                        Gson gson = new Gson();
                        Object o = gson.fromJson(responseBody.string(), cls);
                        myCallBack.success(o);
                    }
                });
    }

    @Override
    public void doPost(String url, final Class aClass, Map<String, String> map, final MyCallBack myCallBack) {
        this.myCallBack = myCallBack;
        RetrofitUtil.getRetrofitUtil().getApi(Api.class)
                .requestPost(url,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        Gson gson = new Gson();
                        Object o = gson.fromJson(responseBody.string(), aClass);
                        myCallBack.success(o);
                    }
                });
    }

    public interface MyCallBack{
        void success(Object object);
    }
}
