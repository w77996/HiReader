package com.w77996.hireader.chat.contract;

import com.w77996.hireader.base.BasePresenter;
import com.w77996.hireader.base.BaseView;
import com.w77996.hireader.chat.bean.ChatMsgBean;

import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */
public interface ChatContract {
    interface View extends BaseView<Presenter>{
        void showError();
        void showReslut(ChatMsgBean list);
    }
    interface Presenter extends BasePresenter{
        void requestData(String data);

        void sendMsg(String data);
    }
}
