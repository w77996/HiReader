package com.w77996.hireader.weather;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.w77996.hireader.R;
import com.w77996.hireader.weather.bean.WeatherBean;
import com.w77996.hireader.weather.contract.WeatherContract;
import com.w77996.hireader.weather.presenter.WeatherPresenter;

import java.util.List;

/**
 * Created by Administrator on 2017/3/27.
 */
public class WeatherFragment extends Fragment implements WeatherContract.View{

    WeatherContract.Presenter presenter;
    public static WeatherFragment newInstance(){
        return new WeatherFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view  =inflater.inflate(R.layout.fragment_weather,container,false);
        presenter.loadLocation();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showWeather(WeatherBean weather) {

    }

    @Override
    public void setPresenter(WeatherContract.Presenter presenter) {
        if(presenter!=null){
            this.presenter = presenter;
        }
    }

    @Override
    public void initView(View view) {

    }
}
