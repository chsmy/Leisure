package com.chs.leisure.model.impl;

import com.chs.leisure.model.Bean.PictureEntity;
import com.chs.leisure.model.NewsService;
import com.chs.leisure.model.PictureService;
import com.chs.leisure.utils.HttpUtils;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 作者：chs on 2016/4/26 10:39
 * 邮箱：657083984@qq.com
 */
public class BusinessTask {

    public void getPictureList(Subscriber<String> subscriber, int currentPage) {
        HttpUtils.getInstance().initRetrofit().create(PictureService.class).getPictures(currentPage, 10)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void geNewsList(Subscriber<String> subscriber, int currentPage, int type) {
        NewsService newsService = HttpUtils.getInstance().initRetrofitWithHeader().create(NewsService.class);
        Observable<String> observable = null;
        switch (type) {
            case 0:
                observable = newsService.getSocial(currentPage, 10);
                break;
            case 1:
                observable = newsService.getSport(currentPage, 10);
                break;
            case 2:
                observable = newsService.getTechnology(currentPage, 10);
                break;
            case 3:
                observable = newsService.getWorld(currentPage, 10);
                break;
            case 4:
                observable = newsService.getRecreation(currentPage, 10);
                break;
            case 5:
                observable = newsService.getRemarkable(currentPage, 10);
                break;
            case 6:
                observable = newsService.getHealth(currentPage, 10);
                break;
        }
        if (observable != null) {
            observable
                    .subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(subscriber);
        }
    }
}
