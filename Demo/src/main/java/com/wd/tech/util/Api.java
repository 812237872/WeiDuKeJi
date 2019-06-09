package com.wd.tech.util;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * @Author: zhang
 * @Date: 2019/5/9 19:03
 * @Description:
 */
public interface Api {
    @GET()
    Observable<ResponseBody> requestGet(@Url String url, @QueryMap Map<String,String> map);

    @FormUrlEncoded
    @POST()
    Observable<ResponseBody> requestPost(@Url String url, @FieldMap Map<String,String> map);
}
