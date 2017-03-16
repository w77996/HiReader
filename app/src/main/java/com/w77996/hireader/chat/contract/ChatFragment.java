package com.w77996.hireader.chat.contract;

import com.w77996.hireader.base.BasePresenter;
import com.w77996.hireader.base.BaseView;

/**
 * Created by Administrator on 2017/3/16.
 */
interface ChatFragment {
    interface View extends BaseView<Presenter>{
        void showError();

    }
    interface Presenter extends BasePresenter{
        void requestData(String data);

    }
}
