package com.w77996.hireader.news.contract;

import com.w77996.hireader.base.BasePresenter;
import com.w77996.hireader.base.BaseView;
import com.w77996.hireader.news.bean.NewsBean;

import java.util.List;

/**
 * Created by Administrator on 2017/3/15.
 */
public interface NewsListContract {
    interface View extends BaseView<Presenter>{
        void showLoading();
        void stopLoading();
        void showError();
        void showResult(List<NewsBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean> list);
    }
    interface  Presenter extends BasePresenter{
        void request(String type,int page,String time,boolean clearing);
        void loadMore(String type,String time);
        void refresh(String type,String time);
        void showDetail(int position);
    }
}
