package com.w77996.hireader.joker.contract;

import com.w77996.hireader.base.BasePresenter;
import com.w77996.hireader.base.BaseView;
import com.w77996.hireader.joker.bean.JokerBean;

import java.util.List;

/**
 * Created by Administrator on 2017/3/13.
 */
public interface JokerContract {
    interface  View extends BaseView<Presenter>{
        void showLoading();
        void stopLoading();
        void showError();
        void showResult(List<JokerBean.ResultBean> list);

    }
    interface  Presenter extends BasePresenter{
        void requestData();
        void refresh();
        void loadMore();
    }
}
