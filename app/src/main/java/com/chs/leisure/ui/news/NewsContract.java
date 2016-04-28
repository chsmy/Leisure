package com.chs.leisure.ui.news;

import com.chs.leisure.base.BasePresenter;
import com.chs.leisure.base.BaseView;
import com.chs.leisure.model.Bean.NewsEntity;

/**
 * 作者：chs on 2016/4/28 10:32
 * 邮箱：657083984@qq.com
 */
public interface NewsContract {
    interface View extends BaseView<Presenter> {
        void showInfo(NewsEntity entity);
    }
    interface Presenter extends BasePresenter {
         void start(int page,int type);
    }
}
