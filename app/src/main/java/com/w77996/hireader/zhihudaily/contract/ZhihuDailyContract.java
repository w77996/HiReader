package com.w77996.hireader.zhihudaily.contract;

import com.w77996.hireader.base.BasePresenter;
import com.w77996.hireader.base.BaseView;
import com.w77996.hireader.zhihudaily.bean.ZhihuDailyBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/11.
 */
public interface ZhihuDailyContract {
    interface View extends BaseView<Presenter>{
        void showLoading();
        void stopLoading();
        void showError();
        void showResult(List<ZhihuDailyBean.StoriesBean> list);
        void showPickerDialog();

    }
    interface  Presenter extends BasePresenter {
        void requestData(long date,boolean clearing);
        void refresh();
        void loadMore(long date);
        void loadDetail(int position);
    }
}
