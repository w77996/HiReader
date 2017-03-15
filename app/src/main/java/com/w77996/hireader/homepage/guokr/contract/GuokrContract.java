package com.w77996.hireader.homepage.guokr.contract;

import com.w77996.hireader.base.BasePresenter;
import com.w77996.hireader.base.BaseView;
import com.w77996.hireader.homepage.guokr.bean.GuokrHandpickNews;

import java.util.List;

/**
 * Created by Administrator on 2017/3/13.
 */
public interface GuokrContract  {
    interface View extends BaseView<Presenter>{
        void showLoading();
        void stopLoading();
        void showError();
        void showResult(List<GuokrHandpickNews.result> list);
    }
    interface Presenter extends BasePresenter{
        void requestData();
        void refresh();
        void loadDetail(int position);

    }
}
