package com.w77996.hireader.todayofhistory.contract;

import com.w77996.hireader.base.BasePresenter;
import com.w77996.hireader.base.BaseView;
import com.w77996.hireader.todayofhistory.bean.TodayOfHistoryDetailBean;

/**
 * time:2017/3/28
 * Created by w77996
 * Github:https://github.com/w77996
 * CSDN:http://blog.csdn.net/w77996?viewmode=contents
 */
public interface TodayOfHistoryDetailContract  {
    interface  View extends BaseView<Presenter>{
        void showResult(TodayOfHistoryDetailBean todayOfHistoryDetailBean);
        void showError();
        void shareData(String txt);
    }
    interface Presenter extends BasePresenter{
        void requestData(String id);

    }
}
