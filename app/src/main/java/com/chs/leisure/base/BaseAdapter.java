package com.chs.leisure.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chs.leisure.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：chs on 2016/4/26 16:27
 * 邮箱：657083984@qq.com
 */
public abstract class BaseAdapter<T> extends RecyclerView.Adapter<ViewHolder> {
    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;

    private OnItemClickListener mOnItemClickListener;
    private List<Integer> heights;
    private RecyclerView mRecyclerView;
    private static final int TYPE_NORMAL =  0;
    private static final int TYPE_FOOTER =  -3;
    public void setOnItemClickListener(OnItemClickListener onItemClickListener)
    {
        this.mOnItemClickListener = onItemClickListener;
    }

    public BaseAdapter(Context context, int layoutId, List<T> datas,RecyclerView recyclerView)
    {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        mDatas = datas;
        mRecyclerView = recyclerView;
        getRandomHeight(3);
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType)
    {
        if(viewType==TYPE_NORMAL){
            ViewHolder viewHolder = ViewHolder.get(mContext, null, parent, mLayoutId, -1);
            setListener(parent, viewHolder, viewType);
            return viewHolder;
        }else {
            View itemView = LayoutInflater.from(mContext).inflate(R.layout.listview_footer, parent,
                    false);
            ViewHolder holder = new ViewHolder(mContext, itemView, parent, -1);
            return holder;
        }
    }

    protected int getPosition(RecyclerView.ViewHolder viewHolder)
    {
        return viewHolder.getAdapterPosition();
    }

    protected boolean isEnabled(int viewType)
    {
        return true;
    }


    protected void setListener(final ViewGroup parent, final ViewHolder viewHolder, int viewType)
    {
        if (!isEnabled(viewType)) return;
        viewHolder.getConvertView().setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (mOnItemClickListener != null)
                {
                    int position = getPosition(viewHolder);
                    mOnItemClickListener.onItemClick(parent, v, mDatas.get(position), position);
                }
            }
        });


        viewHolder.getConvertView().setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View v)
            {
                if (mOnItemClickListener != null)
                {
                    int position = getPosition(viewHolder);
                    return mOnItemClickListener.onItemLongClick(parent, v, mDatas.get(position), position);
                }
                return false;
            }
        });
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        RecyclerView.LayoutManager manager = mRecyclerView.getLayoutManager();
        if(manager instanceof StaggeredGridLayoutManager){
            ViewGroup.LayoutParams params =  holder.itemView.getLayoutParams();//得到item的LayoutParams布局参数
            params.height = heights.get((int) (Math.random()*3));//把随机的高度赋予item布局
            holder.itemView.setLayoutParams(params);//把params设置给item布局
            holder.updatePosition(position);
        }
        if(mDatas.size()>0&&position<mDatas.size()){
            convert(holder, mDatas.get(position));
        }
    }

    public abstract void convert(ViewHolder holder, T t);

    @Override
    public int getItemCount()
    {
        return mDatas.size()+1;
    }
    private void getRandomHeight(int count){//得到随机item的高度
        heights = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            heights.add((int)(200+Math.random()*400));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position>=mDatas.size()){
            return TYPE_FOOTER;
        }else {
            return TYPE_NORMAL;
        }
    }
}
