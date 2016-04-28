package com.chs.leisure.ui.news;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chs.leisure.Constant;
import com.chs.leisure.R;
import com.chs.leisure.base.BaseAdapter;
import com.chs.leisure.base.BaseFragment;
import com.chs.leisure.base.ViewHolder;
import com.chs.leisure.model.Bean.NewsEntity;
import com.chs.leisure.ui.WebDetailActivity;
import com.chs.leisure.widget.LoadMoreRecyclerView;
import com.chs.leisure.widget.RecycleViewDivider;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

/**
 * 作者：chs on 2016/4/28 14:08
 * 邮箱：657083984@qq.com
 */
public class NewFragment extends BaseFragment implements NewsContract.View {
    private NewsPresenter mPresenter;
    @Bind(R.id.rv_news)
    LoadMoreRecyclerView rvNews;
    private BaseAdapter mAdapter;
    @Bind(R.id.material_style_ptr_frame)
    PtrClassicFrameLayout mPtrFrame;
    private int currentPage = 1;
    private List<NewsEntity.NewslistEntity> mDataList;
    private int type = 0;
    public static NewFragment NewInstance(Bundle bundle){
        NewFragment newFragment = new NewFragment();
        newFragment.setArguments(bundle);
        return newFragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news,null);
        ButterKnife.bind(this,view);
        type = getArguments().getInt("type");
        mPresenter = new NewsPresenter(this);
        initView();
        initEvent();
        return view;
    }
    private void initEvent() {
        rvNews.setLoadMoreListener(new LoadMoreRecyclerView.LoadMoreListener() {
            @Override
            public void loadMore() {
                currentPage++;
                mPresenter.start(currentPage,type);
            }
        });
    }

    private void initView() {
        mDataList = new ArrayList<>();
        mAdapter = new BaseAdapter<NewsEntity.NewslistEntity>(getActivity(),R.layout.item_fragment_news,mDataList) {
            @Override
            public void convert(ViewHolder holder, final NewsEntity.NewslistEntity newslistEntity) {
                holder.setText(R.id.item_title,newslistEntity.getTitle());
                holder.setText(R.id.item_time,newslistEntity.getCtime());
                holder.setImageWithUrl(R.id.left_image,newslistEntity.getPicUrl());
                holder.setOnClickListener(R.id.title_layout, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(),WebDetailActivity.class);
                        intent.putExtra("url", newslistEntity.getUrl());
                        getActivity().startActivity(intent);
                    }
                });
            }
        };
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvNews.setLayoutManager(layoutManager);
        rvNews.addItemDecoration(new RecycleViewDivider(getActivity()));
        rvNews.setAdapter(mAdapter);
        initPtr();
    }

    private void initPtr() {
        mPtrFrame.setPtrHandler(new PtrHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                currentPage = 1;
                mPresenter.start(currentPage,type);
            }

            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
            }
        });
        mPtrFrame.setResistance(1.7f);
        mPtrFrame.setRatioOfHeaderHeightToRefresh(1.2f);
        mPtrFrame.setDurationToClose(200);
        mPtrFrame.setDurationToCloseHeader(1000);
        // default is false
        mPtrFrame.setPullToRefresh(false);
        // default is true
        mPtrFrame.setKeepHeaderWhenRefresh(true);
        mPtrFrame.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPtrFrame.autoRefresh();
            }
        }, 100);
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    public void showInfo(NewsEntity entity) {
        mPtrFrame.refreshComplete();
        if(currentPage==1){
            mDataList.clear();
        }
        mDataList.addAll(entity.getNewslist());
        mAdapter.notifyDataSetChanged();
    }
}
