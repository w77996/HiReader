package com.w77996.hireader.chat.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.w77996.hireader.R;
import com.w77996.hireader.chat.bean.ChatMsgBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/17.
 */
public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final  Context context;
    private List<ChatMsgBean> list = new ArrayList<>();
    private LayoutInflater inflater;


    public ChatAdapter(Context context, List<ChatMsgBean> list) {

        this.context =context;
        this.list = list;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //viewType = getItemViewType()

        switch (viewType){

            case ChatMsgBean.TYPE_SEND:

                return new LeftMsgViewHolder(inflater.inflate(R.layout.chat_right,parent,false));
                case ChatMsgBean.TYPE_RECIV:

                    return new RightMsgViewHolder(inflater.inflate(R.layout.chat_left,parent,false));
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Logger.d("ddddddddddd222" + list.size()+""+list.get(position).getMsg());
        if(holder instanceof  LeftMsgViewHolder){
            ((LeftMsgViewHolder) holder).textView1.setText(list.get(position).getMsg());
        }else if(holder instanceof  RightMsgViewHolder){
            ((RightMsgViewHolder) holder).textView.setText(list.get(position).getMsg());
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(list.get(position).getType()==ChatMsgBean.TYPE_SEND){
            return ChatMsgBean.TYPE_SEND;
        }else if(list.get(position).getType()==ChatMsgBean.TYPE_RECIV){
            return ChatMsgBean.TYPE_RECIV;
        }
        return -1;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class LeftMsgViewHolder extends RecyclerView.ViewHolder{


        private TextView textView1;
        public LeftMsgViewHolder(View itemView) {
            super(itemView);
            textView1 = (TextView)itemView.findViewById(R.id.robot_right_tv);
        }
    }

    public class RightMsgViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;

        public RightMsgViewHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.robot_left_tv);

        }
    }
}
