package com.chs.leisure.ui.picture;

import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.chs.leisure.model.Bean.PictureEntity;
import com.chs.leisure.model.impl.PictureTask;
import com.chs.leisure.utils.GsonUtil;
import com.chs.leisure.utils.LogUtils;

import rx.Subscriber;

/**
 * 作者：chs on 2016/4/26 10:12
 * 邮箱：657083984@qq.com
 */
public class PicturePresenter implements PictureContract.Presenter {
    private PictureTask mPictureTask;
    private PictureContract.View mPictureView;

    public PicturePresenter( PictureContract.View pictureView) {
        this.mPictureView = pictureView;
        mPictureTask = new PictureTask();
    }

    @Override
    public void start(int page) {
        getPicList(page);
    }

    public void getPicList(int page){
        mPictureTask.getPictureList(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                LogUtils.e("PicturePresenter","onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e("PicturePresenter","onError");
            }

            @Override
            public void onNext(String result) {
                if(!TextUtils.isEmpty(result)){
                    mPictureView.showInfo(GsonUtil.changeGsonToBean(result,PictureEntity.class));
                }
            }
        },page);
    }
}
