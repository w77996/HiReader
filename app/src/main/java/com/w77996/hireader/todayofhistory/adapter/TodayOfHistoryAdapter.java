package com.w77996.hireader.todayofhistory.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.w77996.hireader.R;
import com.w77996.hireader.utils.interfaze.OnRecyclerViewOnClickListener;
import com.w77996.hireader.todayofhistory.bean.TodayOfHistoryBean;

import java.util.List;

/**
 * Created by Administrator on 2017/3/14.
 */
public class TodayOfHistoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private final Context context;
    private final LayoutInflater inflater;
    private List<TodayOfHistoryBean.ResultBean> list;
    private static final int TYPE_NORMAL = 0x00;
    private static final int TYPE_NO_IMG = 0x01;

    private OnRecyclerViewOnClickListener listener;

    public TodayOfHistoryAdapter(Context context, List<TodayOfHistoryBean.ResultBean> list) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_NORMAL:
                return new NormalViewHolder(inflater.inflate(R.layout.recyclerview_normal_item, parent, false), listener);
            case TYPE_NO_IMG:
                return new NoImgViewHolder(inflater.inflate(R.layout.recyclerview_no_img_item, parent, false), listener);

        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof  NormalViewHolder){
            Glide.with(context)
                    .load(list.get(position).getPic())
                    .asBitmap()
                    .placeholder(R.mipmap.ic_launcher)
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .error(R.mipmap.ic_launcher)
                    .centerCrop()
                    .into(((NormalViewHolder)holder).ivHeadlineImg);

            ((NormalViewHolder)holder).tvTitle.setText(list.get(position).getTitle());
        }else if(holder instanceof NoImgViewHolder){
            ((NoImgViewHolder)holder).tvTitle.setText(list.get(position).getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void setItemClickListener(OnRecyclerViewOnClickListener listener){
        this.listener = listener;
    }
    @Override
    public int getItemViewType(int position) {
        if(list.get(position).getPic()==""||list.get(position).getPic()==null){
            return TYPE_NO_IMG;
        }else{
            return TYPE_NORMAL;
        }
    }

    public class NormalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView ivHeadlineImg;
        TextView tvTitle;

        OnRecyclerViewOnClickListener listener;

        public NormalViewHolder(View itemView, OnRecyclerViewOnClickListener listener) {
            super(itemView);
            ivHeadlineImg = (ImageView) itemView.findViewById(R.id.recycleview_normal_imageview);
            tvTitle = (TextView) itemView.findViewById(R.id.recycleview_normal_textview);

            this.listener = listener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (listener != null){
                listener.onItemClick(view, getLayoutPosition());
            }
        }
    }

    public class NoImgViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvTitle;

        OnRecyclerViewOnClickListener listener;

        public NoImgViewHolder(View itemView, OnRecyclerViewOnClickListener listener) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.recycleview_no_img_textview);

            this.listener = listener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (listener != null){
                listener.onItemClick(view, getLayoutPosition());
            }
        }
    }
}
