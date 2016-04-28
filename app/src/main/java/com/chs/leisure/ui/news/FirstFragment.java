package com.chs.leisure.ui.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chs.leisure.R;
import com.chs.leisure.base.BaseFragment;
import com.chs.leisure.model.Bean.NewsEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者：chs on 2016/4/25 17:26
 * 邮箱：657083984@qq.com
 */
public class FirstFragment extends BaseFragment implements NewsContract.View {
    @Bind(R.id.tab_selector)
    TabLayout mTabSelector;
    @Bind(R.id.vp_news)
    ViewPager mViewPager;
    private List<NewFragment> mFragmentList;
    private String[] mTitles = new String[]{"社会","体育","科技","世界","娱乐","奇闻","健康"};
    private NewsPagerAdapter mAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, null);
        ButterKnife.bind(this,view);
        initData();
        initView();
        return view;
    }

    private void initData() {
        mFragmentList = new ArrayList<>();
        mFragmentList.clear();
        for(int i = 0;i<mTitles.length;i++){
            Bundle bundle = new Bundle();
            bundle.putInt("type",i);
            mFragmentList.add(NewFragment.NewInstance(bundle));
        }
    }

    private void initView() {
        mAdapter = new NewsPagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mTabSelector.setupWithViewPager(mViewPager);
        mTabSelector.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    public void showInfo(NewsEntity entity) {

    }

    private class NewsPagerAdapter extends FragmentStatePagerAdapter{

        public NewsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mTitles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }
    }
}
