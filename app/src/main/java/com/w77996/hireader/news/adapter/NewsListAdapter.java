package com.w77996.hireader.news.adapter;

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
import com.w77996.hireader.news.bean.NewsBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/15.
 */
public class NewsListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    private final Context context;
    private LayoutInflater layoutInflater;
    private  List<NewsBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean> list  = new ArrayList<>();
    private final int TYPE_NORMAL =1;
    private final int TYPE_FOOTER =2;
    private final int TYPE_NO_IMG =3;
    private OnRecyclerViewOnClickListener mListener;
    public NewsListAdapter(Context context, List<NewsBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean> list){
        this.context =context;
        this.list = list;
        layoutInflater= LayoutInflater.from(context);
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case TYPE_NORMAL:
                return new NoramlViewHolder((layoutInflater.inflate(R.layout.news_normal_item,parent,false)),mListener);
            case TYPE_FOOTER:
                return new FooterViewHolder(layoutInflater.inflate(R.layout.recyclerview_footer_item,parent,false));
            case TYPE_NO_IMG:
                return new NoImgViewHolder(layoutInflater.inflate(R.layout.news_no_img_item,parent,false),mListener);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(!(holder instanceof FooterViewHolder)){
            if(holder instanceof NoramlViewHolder){
                Glide.with(context)
                        .load(list.get(position).getImageurls().get(0).getUrl())
                        .asBitmap()
                        .placeholder(R.drawable.icon_load)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .error(R.drawable.icon_error)
                        .centerCrop()
                        .into(((NoramlViewHolder) holder).imageView);
                ((NoramlViewHolder)holder).textViewTitle.setText(list.get(position).getTitle());
                ((NoramlViewHolder)holder).textViewDec.setText(list.get(position).getDesc());
            }else if(holder instanceof  NoImgViewHolder){
                ((NoImgViewHolder)holder).textViewTitle.setText(list.get(position).getTitle());
                ((NoImgViewHolder)holder).textViewDec.setText(list.get(position).getDesc());
            }
        }
    }
    public void setItemClickListener(OnRecyclerViewOnClickListener listener){
        this.mListener = listener;
    }

    @Override
    public int getItemCount() {
        return list.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if(list.size()==position){
            return TYPE_FOOTER;
        }
        if (list.get(position).isHavePic() == false) {
            return TYPE_NO_IMG;
        }
        return TYPE_NORMAL;

    }

    public class NoramlViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView imageView;
        private TextView textViewTitle;
        private TextView textViewDec;
        private OnRecyclerViewOnClickListener listener;
        public NoramlViewHolder(View itemView,OnRecyclerViewOnClickListener listener) {
            super(itemView);
            this.listener =listener;
            textViewTitle = (TextView)itemView.findViewById(R.id.news_normal_title);
            textViewDec = (TextView)itemView.findViewById(R.id.news_normal_dec);
            imageView = (ImageView)itemView.findViewById(R.id.news_normal_img);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(listener!=null){
                listener.onItemClick(v,getLayoutPosition());
            }
        }
    }
    public class NoImgViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewTitle;
        TextView textViewDec;

        OnRecyclerViewOnClickListener listener;

        public NoImgViewHolder(View itemView, OnRecyclerViewOnClickListener listener) {
            super(itemView);
            textViewTitle = (TextView) itemView.findViewById(R.id.news_no_img_title);
            textViewDec = (TextView) itemView.findViewById(R.id.news_no_img_dec);

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
    public class  FooterViewHolder extends RecyclerView.ViewHolder{

        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }
}
