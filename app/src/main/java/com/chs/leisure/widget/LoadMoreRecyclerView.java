package com.chs.leisure.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.chs.leisure.R;
import com.chs.leisure.base.ViewHolder;

import java.util.ArrayList;

/**
 *
 * 添加加载更多功能
 * Created by chs .
 */
public class LoadMoreRecyclerView extends RecyclerView {

    private boolean isScrollingToBottom = true;
    private FloatingActionButton floatingActionButton;
    private LoadMoreListener mLoadingListener;
    private ArrayList<View> mFootViews = new ArrayList<>();

    public LoadMoreRecyclerView(Context context) {
        super(context);
        init(context);
    }

    public LoadMoreRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.listview_footer,null);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        addFootView(view);
        mFootViews.get(0).setVisibility(GONE);
    }
    public void addFootView(final View view) {
        mFootViews.clear();
        mFootViews.add(view);
    }
    public LoadMoreRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void applyFloatingActionButton(FloatingActionButton floatingActionButton) {
        this.floatingActionButton = floatingActionButton;
    }

    public void setLoadMoreListener(LoadMoreListener loadMoreListener){
        this.mLoadingListener = loadMoreListener;
    }

    @Override
    public void onScrolled(int dx, int dy) {
        isScrollingToBottom = dy > 0;
        if (floatingActionButton != null) {
            if (isScrollingToBottom) {
                if (floatingActionButton.isShown())
                    floatingActionButton.hide();
            } else {
                if (!floatingActionButton.isShown())
                    floatingActionButton.show();
            }
        }
    }

    @Override
    public void onScrollStateChanged(int state) {
        if (state == RecyclerView.SCROLL_STATE_IDLE && mLoadingListener != null) {
            LayoutManager layoutManager = getLayoutManager();
            int lastVisibleItemPosition;
            if (layoutManager instanceof GridLayoutManager) {
                lastVisibleItemPosition = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
            } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                int[] into = new int[((StaggeredGridLayoutManager) layoutManager).getSpanCount()];
                ((StaggeredGridLayoutManager) layoutManager).findLastVisibleItemPositions(into);
                lastVisibleItemPosition = findMax(into);
            } else {
                lastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
            }
            if (layoutManager.getChildCount() > 0
                    && lastVisibleItemPosition >= layoutManager.getItemCount() - 1 &&  layoutManager.getItemCount() > layoutManager.getChildCount()) {
                    View footView = mFootViews.get(0);
                footView.setVisibility(View.VISIBLE);
                mLoadingListener.onLoadMore();
            }
        }
    }
    private int findMax(int[] lastPositions) {
        int max = lastPositions[0];
        for (int value : lastPositions) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
    public interface LoadMoreListener {
        void onLoadMore();
    }
}
