package com.chs.leisure.model;

import com.chs.leisure.model.Bean.PictureEntity;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 作者：chs on 2016/4/26 10:21
 * 邮箱：657083984@qq.com
 */
public interface PictureService {
    @GET("list")
    Observable<String> getPictures(@Query("page") int page,@Query("rows") int rows);
}
