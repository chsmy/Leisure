package com.chs.leisure.ui.picture;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chs.leisure.Constant;
import com.chs.leisure.R;
import com.chs.leisure.base.BaseAdapter;
import com.chs.leisure.base.BaseFragment;
import com.chs.leisure.base.ViewHolder;
import com.chs.leisure.model.Bean.PictureEntity;
import com.chs.leisure.utils.DensityUtil;
import com.chs.leisure.widget.LoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.header.MaterialHeader;

/**
 * 作者：chs on 2016/4/25 17:26
 * 邮箱：657083984@qq.com
 * 美图的fragment
 */
public class SecondFragment extends BaseFragment implements PictureContract.View {
    private PicturePresenter presenter;
    @Bind(R.id.rv_picture)
    LoadMoreRecyclerView rvPicture;
    private BaseAdapter mAdapter;
    @Bind(R.id.material_style_ptr_frame)
    PtrClassicFrameLayout mPtrFrame;
    private int currentPage = 1;
    private List<PictureEntity.TngouEntity> mDataList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second,null);
        ButterKnife.bind(this,view);
        presenter = new PicturePresenter(this);
        initView();
        initEvent();
        presenter.start(currentPage);
        return view;
    }

    private void initEvent() {
        rvPicture.setLoadMoreListener(new LoadMoreRecyclerView.LoadMoreListener() {
            @Override
            public void loadMore() {
                currentPage++;
                presenter.start(currentPage);
            }
        });
    }

    private void initView() {
        mDataList = new ArrayList<>();
        mAdapter = new BaseAdapter<PictureEntity.TngouEntity>(getActivity(),R.layout.item_pictures,mDataList) {
            @Override
            public void convert(ViewHolder holder, final PictureEntity.TngouEntity tngouEntity) {
                holder.setText(R.id.tv_title, tngouEntity.getTitle());
                holder.setImageWithUrl(R.id.iv_pic, Constant.PIC_HEAD+tngouEntity.getImg());
                holder.setOnClickListener(R.id.iv_pic, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(),PictureDetailActivity.class);
                        intent.putExtra("id",tngouEntity.getId());
                        getActivity().startActivity(intent);
                    }
                });
            }
        };
        rvPicture.setLayoutManager(new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL));
        rvPicture.setAdapter(mAdapter);
        mPtrFrame.setPtrHandler(new PtrHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                currentPage = 1;
                presenter.start(currentPage);
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
    public void onResume() {
        super.onResume();
    }

    @Override
    public void showInfo(PictureEntity entity) {
        mPtrFrame.refreshComplete();
        if(currentPage==1){
            mDataList.clear();
        }
        mDataList.addAll(entity.getTngou());
        mAdapter.notifyDataSetChanged();
    }
    @Override
    protected void lazyLoad() {

    }
}
