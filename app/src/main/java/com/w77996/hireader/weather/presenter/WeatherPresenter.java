package com.w77996.hireader.weather.presenter;

import android.content.Context;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.orhanobut.logger.Logger;
import com.w77996.hireader.utils.Api;
import com.w77996.hireader.utils.ApiService;
import com.w77996.hireader.utils.DateFomatter;
import com.w77996.hireader.utils.HttpUtils;
import com.w77996.hireader.weather.bean.WeatherBean;
import com.w77996.hireader.weather.contract.WeatherContract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/3/16.
 */
public class WeatherPresenter implements WeatherContract.Presenter {

    private  WeatherContract.View view;
    private Context context;

    public AMapLocationClient mLocationClient = null;
    public AMapLocationClientOption mLocationOption = null;
    public WeatherPresenter(Context context , WeatherContract.View view){
        this.context = context;
        this.view =view;
        this.view.setPresenter(this);
    }

    @Override
    public void loadLocation() {
       mLocationClient = new AMapLocationClient(context);
        mLocationOption = new AMapLocationClientOption();
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        mLocationOption.setOnceLocation(true);
        mLocationOption.setOnceLocationLatest(true);
        mLocationOption.setWifiActiveScan(true);
        mLocationOption.setMockEnable(true);
        mLocationOption.setHttpTimeOut(10000);
        mLocationOption.setLocationCacheEnable(true);
        mLocationClient.setLocationOption(mLocationOption);
        mLocationClient.setLocationListener(new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {
                if(aMapLocation!=null){
                    if(aMapLocation.getErrorCode()==0){
                        requestData("深圳");
                        Logger.d(aMapLocation.getCity() +" "+aMapLocation.getDistrict());
                        //requestData(aMapLocation.getCity());
                    }else{
                        requestData("深圳");
                        view.showError();
                    }
                }
            }
        });
        mLocationClient.startLocation();

    }

    @Override
    public void requestData(String city) {
        Logger.d("6666666666666");
        DateFomatter dateFomatter = new DateFomatter();
        HttpUtils.getInstance()
                .create(ApiService.class,Api.Weather)
                .getWeatherData(city,dateFomatter.WeatherDateFormat())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<WeatherBean>() {
                    @Override
                    public void accept(WeatherBean weatherBean) throws Exception {
                        view.showWeather(weatherBean);
                        Logger.d(weatherBean.getShowapi_res_code()+"");
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.showError();
                    }
                });
    }

    @Override
    public void start() {

    }
}
