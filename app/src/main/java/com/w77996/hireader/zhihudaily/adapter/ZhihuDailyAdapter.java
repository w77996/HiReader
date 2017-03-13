package com.w77996.hireader.zhihudaily.adapter;

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
import com.w77996.hireader.interfaze.OnRecyclerViewOnClickListener;
import com.w77996.hireader.zhihudaily.bean.ZhihuDailyBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/13.
 */
public class ZhihuDailyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<ZhihuDailyBean.StoriesBean> list = new ArrayList<>();

    private OnRecyclerViewOnClickListener mListener;

    private static final int TYPE_NORMAL = 0;
    private static final int TYPE_FOOTER = 1;

    public ZhihuDailyAdapter(Context context, List<ZhihuDailyBean.StoriesBean> list) {
        this.mContext = context;
        this.list = list;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_NORMAL:
                return new NormalViewHolder(mLayoutInflater.inflate(R.layout.recyclerview_normal_item, parent, false), mListener);
            case TYPE_FOOTER:
                return new FooterViewHolder(mLayoutInflater.inflate(R.layout.recyclerview_footer_item, parent, false));
        }
        return null;
    }

    public  void setItemOnClick(OnRecyclerViewOnClickListener onRecyclerViewOnClickListener) {
        this.mListener = onRecyclerViewOnClickListener;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof NormalViewHolder) {
            ZhihuDailyBean.StoriesBean storiesBean = list.get(position);
            if (storiesBean.getImages().get(0) == null) {
                ((NormalViewHolder) holder).imageView.setImageResource(R.mipmap.ic_launcher);
            } else {
                Glide.with(mContext)
                        .load(storiesBean.getImages().get(0))
                        .asBitmap()
                        .placeholder(R.mipmap.ic_launcher)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .error(R.mipmap.ic_launcher)
                        .centerCrop()
                        .into(((NormalViewHolder) holder).imageView);
            }
            ((NormalViewHolder) holder).textView.setText(storiesBean.getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return list.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == list.size()) {
            return ZhihuDailyAdapter.TYPE_FOOTER;
        }
        return ZhihuDailyAdapter.TYPE_NORMAL;
    }

    public class NormalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imageView;
        private TextView textView;
        private OnRecyclerViewOnClickListener listener;

        public NormalViewHolder(View itemView, OnRecyclerViewOnClickListener onRecyclerViewOnClickListener) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.recycleview_normal_imageview);
            textView = (TextView) itemView.findViewById(R.id.recycleview_normal_textview);
            this.listener = onRecyclerViewOnClickListener;
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onItemClick(itemView, getLayoutPosition());
            }
        }
    }

    public class FooterViewHolder extends RecyclerView.ViewHolder {

        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }
}
