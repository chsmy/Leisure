package com.chs.leisure.ui.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chs.leisure.R;
import com.chs.leisure.base.BaseFragment;
import com.chs.leisure.model.Bean.PictureEntity;
import com.chs.leisure.ui.picture.PictureContract;

/**
 * 作者：chs on 2016/4/25 17:26
 * 邮箱：657083984@qq.com
 */
public class FirstFragment extends BaseFragment implements PictureContract.View {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_first,null);
        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void showInfo(PictureEntity entity) {

    }

    @Override
    protected void lazyLoad() {

    }
}
