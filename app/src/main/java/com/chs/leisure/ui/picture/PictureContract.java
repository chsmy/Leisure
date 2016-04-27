package com.chs.leisure.ui.picture;

import com.chs.leisure.base.BasePresenter;
import com.chs.leisure.base.BaseView;
import com.chs.leisure.model.Bean.PictureEntity;

/**
 * 作者：chs on 2016/4/26 09:57
 * 邮箱：657083984@qq.com
 */
public interface PictureContract {
    interface View extends BaseView<Presenter>{
      void showInfo(PictureEntity entity);
    }
    interface Presenter extends BasePresenter{

    }
}
