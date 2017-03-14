package com.w77996.hireader.todayofhistory.contract;

import com.w77996.hireader.base.BasePresenter;
import com.w77996.hireader.base.BaseView;
import com.w77996.hireader.todayofhistory.bean.TodayOfHistoryBean;

import java.util.List;

/**
 * Created by Administrator on 2017/3/14.
 */
public interface TodayOfHistoryContract {
    interface  View extends BaseView<Presenter>{
        void showLoading();
        void stopLoading();
        void showError();
        void showResult(List<TodayOfHistoryBean.ResultBean> list);
    }
    interface Presenter extends BasePresenter{
        void requestData();
        void refresh();
        void loadDetail(int position);

    }
}
