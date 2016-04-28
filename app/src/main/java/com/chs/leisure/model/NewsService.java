package com.chs.leisure.model;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 作者：chs on 2016/4/28 10:35
 * 邮箱：657083984@qq.com
 */
public interface NewsService {
    @GET("social/social")
    Observable<String> getSocial(@Query("page") int page, @Query("num") int rows);
    @GET("tiyu/tiyu")
    Observable<String> getSport(@Query("page") int page, @Query("num") int rows);
    @GET("keji/keji")
    Observable<String> getTechnology(@Query("page") int page, @Query("num") int rows);
    @GET("world/world")
    Observable<String> getWorld(@Query("page") int page, @Query("num") int rows);
    @GET("huabian/newtop")
    Observable<String> getRecreation(@Query("page") int page, @Query("num") int rows);
    @GET("qiwen/qiwen")
    Observable<String> getRemarkable(@Query("page") int page, @Query("num") int rows);
    @GET("health/health")
    Observable<String> getHealth(@Query("page") int page, @Query("num") int rows);
}
