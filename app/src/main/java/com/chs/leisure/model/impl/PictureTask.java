package com.chs.leisure.model.impl;

import com.chs.leisure.model.Bean.PictureEntity;
import com.chs.leisure.model.PictureService;
import com.chs.leisure.utils.HttpUtils;

import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 作者：chs on 2016/4/26 10:39
 * 邮箱：657083984@qq.com
 */
public class PictureTask {
    public void getPictureList(Subscriber<String> subscriber,int currentPage) {
        HttpUtils.getInstance().initRetrofit().create(PictureService.class).getPictures(currentPage, 10)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
