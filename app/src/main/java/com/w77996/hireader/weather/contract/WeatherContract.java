package com.w77996.hireader.weather.contract;

import com.w77996.hireader.base.BasePresenter;
import com.w77996.hireader.base.BaseView;

/**
 * Created by Administrator on 2017/3/16.
 */
interface WeatherContract  {
    interface View extends BaseView<Presenter>{
        void showLoading();
        void showError();
        void stopLoading();
        void showWeather();
    }
    interface Presenter extends BasePresenter{
        void loadLocation();
        void requestData();
    }
}
