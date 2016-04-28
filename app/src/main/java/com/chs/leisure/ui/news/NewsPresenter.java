package com.chs.leisure.ui.news;

import android.text.TextUtils;

import com.chs.leisure.model.Bean.NewsEntity;
import com.chs.leisure.model.impl.BusinessTask;
import com.chs.leisure.utils.GsonUtil;
import com.chs.leisure.utils.LogUtils;

import rx.Subscriber;

/**
 * 作者：chs on 2016/4/28 10:34
 * 邮箱：657083984@qq.com
 */
public class NewsPresenter implements NewsContract.Presenter {
    private BusinessTask mNewsTask;
    private NewsContract.View mNewsView;

    public NewsPresenter(NewsContract.View mNewsView) {
        this.mNewsView = mNewsView;
        mNewsTask = new BusinessTask();
    }

    @Override
    public void start(int page) {
    }
    @Override
    public void start(int page, int type) {
       switch (type){
           case 0:
               getSocial(page ,type);
               break;
           case 1:
               getSport(page,type);
               break;
           case 2:
               getTechnology(page,type);
               break;
           case 3:
               getWorld(page,type);
               break;
           case 4:
               getRecreation(page,type);//娱乐
               break;
           case 5:
               getRemarkable(page,type);//奇闻
               break;
           case 6:
               getHealth(page,type);
               break;
       }
    }
    public void getSocial(int page,int type) {
        mNewsTask.geNewsList(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                LogUtils.e("PicturePresenter", "onCompleted");
            }
            @Override
            public void onError(Throwable e) {
                LogUtils.e("PicturePresenter", "onError");
            }
            @Override
            public void onNext(String s) {
                if(!TextUtils.isEmpty(s)){
                    mNewsView.showInfo(GsonUtil.changeGsonToBean(s,NewsEntity.class));
                }
            }
        }, page,type);
    }
    public void getSport(int page,int type) {
        mNewsTask.geNewsList(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                LogUtils.e("PicturePresenter", "onCompleted");
            }
            @Override
            public void onError(Throwable e) {
                LogUtils.e("PicturePresenter", "onError");
            }
            @Override
            public void onNext(String s) {
                if(!TextUtils.isEmpty(s)){
                    mNewsView.showInfo(GsonUtil.changeGsonToBean(s,NewsEntity.class));
                }
            }
        }, page,type);
    }
    public void getTechnology(int page,int type) {
        mNewsTask.geNewsList(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                LogUtils.e("PicturePresenter", "onCompleted");
            }
            @Override
            public void onError(Throwable e) {
                LogUtils.e("PicturePresenter", "onError");
            }
            @Override
            public void onNext(String s) {
                if(!TextUtils.isEmpty(s)){
                    mNewsView.showInfo(GsonUtil.changeGsonToBean(s,NewsEntity.class));
                }
            }
        }, page,type);
    }
    public void getWorld(int page,int type) {
        mNewsTask.geNewsList(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                LogUtils.e("PicturePresenter", "onCompleted");
            }
            @Override
            public void onError(Throwable e) {
                LogUtils.e("PicturePresenter", "onError");
            }
            @Override
            public void onNext(String s) {
                if(!TextUtils.isEmpty(s)){
                    mNewsView.showInfo(GsonUtil.changeGsonToBean(s,NewsEntity.class));
                }
            }
        }, page,type);
    }
    public void getRecreation(int page,int type) {
        mNewsTask.geNewsList(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                LogUtils.e("PicturePresenter", "onCompleted");
            }
            @Override
            public void onError(Throwable e) {
                LogUtils.e("PicturePresenter", "onError");
            }
            @Override
            public void onNext(String s) {
                if(!TextUtils.isEmpty(s)){
                    mNewsView.showInfo(GsonUtil.changeGsonToBean(s,NewsEntity.class));
                }
            }
        }, page,type);
    }
    public void getRemarkable(int page,int type) {
        mNewsTask.geNewsList(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                LogUtils.e("PicturePresenter", "onCompleted");
            }
            @Override
            public void onError(Throwable e) {
                LogUtils.e("PicturePresenter", "onError");
            }
            @Override
            public void onNext(String s) {
                if(!TextUtils.isEmpty(s)){
                    mNewsView.showInfo(GsonUtil.changeGsonToBean(s,NewsEntity.class));
                }
            }
        }, page,type);
    }
    public void getHealth(int page,int type) {
        mNewsTask.geNewsList(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                LogUtils.e("PicturePresenter", "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e("PicturePresenter", "onError");
            }

            @Override
            public void onNext(String s) {
                if(!TextUtils.isEmpty(s)){
                    mNewsView.showInfo(GsonUtil.changeGsonToBean(s,NewsEntity.class));
                }
            }
        }, page,type);
    }
}
