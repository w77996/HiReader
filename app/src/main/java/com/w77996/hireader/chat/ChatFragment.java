package com.w77996.hireader.chat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.w77996.hireader.R;
import com.w77996.hireader.chat.bean.ChatMsgBean;
import com.w77996.hireader.chat.contract.ChatContract;
import com.w77996.hireader.chat.presenter.ChatPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */
public class ChatFragment extends Fragment implements ChatContract.View {
    private RecyclerView recyclerView;
    private EditText editText;
    private Button button;
    private ChatContract.Presenter presenter;
    private ChatAdapter chatAdapter;
    private List<ChatMsgBean> list = new ArrayList<>();
    public static  ChatFragment newIntance(){
        return new ChatFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ChatPresenter(getContext(),this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chat_fragment,container,false);
        initView(view);

        ChatMsgBean chatMsgBean = new ChatMsgBean();
        chatMsgBean.setType(ChatMsgBean.TYPE_RECIV);
        chatMsgBean.setMsg("你好,我是智能机器人");
        list.add(chatMsgBean);
        chatAdapter = new ChatAdapter(getContext(),list);
        recyclerView.setAdapter(chatAdapter);
        return view;
    }

    @Override
    public void showError() {

    }

    @Override
    public void showReslut(ChatMsgBean data) {

        list.add(data);

        chatAdapter.notifyDataSetChanged();
        recyclerView.scrollToPosition(list.size()-1);
    }

    @Override
    public void setPresenter(ChatContract.Presenter presenter) {
        if(presenter!=null){
            this.presenter = presenter;
        }
    }

    @Override
    public void initView(View view) {
        recyclerView = (RecyclerView)view.findViewById(R.id.robot_rl);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setStackFromEnd(true);
        //recyclerView.smoothScrollOffset(offset);
      //  linearLayoutManager.setStackFromEnd(true);
       // linearLayoutManager.scrollToPositionWithOffset(2, 20);
        recyclerView.setLayoutManager(linearLayoutManager);
        editText = (EditText)view.findViewById(R.id.robot_edit);
        button = (Button)view.findViewById(R.id.robot_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.sendMsg(editText.getText().toString().trim());
                ChatMsgBean chatMsgBean = new ChatMsgBean();
                chatMsgBean.setType(ChatMsgBean.TYPE_SEND);
                chatMsgBean.setMsg(editText.getText().toString());
                list.add(chatMsgBean);
                chatAdapter.notifyDataSetChanged();
                recyclerView.scrollToPosition(list.size()-1);

                editText.setText("");

            }
        });
    }
}
