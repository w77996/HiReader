package com.w77996.hireader.detail;

import com.w77996.hireader.base.BasePresenter;
import com.w77996.hireader.base.BaseView;

/**
 * Created by Administrator on 2017/3/15.
 */
interface  DetailContract {
    interface View extends BaseView<Presenter>{
        void showLoading();
        void stopLoading();
        void showResult(String url);
        void setTitle(String title);

    }
    interface Presenter extends BasePresenter{

    }

}
