package com.w77996.hireader.weather.contract;

import com.w77996.hireader.base.BasePresenter;
import com.w77996.hireader.base.BaseView;
import com.w77996.hireader.weather.bean.WeatherBean;

import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */
public interface WeatherContract  {
    interface View extends BaseView<Presenter>{
        void showLoading();
        void showError();
        void stopLoading();
        void showWeather(WeatherBean weather);
    }
    interface Presenter extends BasePresenter{
        void loadLocation();
        void requestData(String city);
    }
}
