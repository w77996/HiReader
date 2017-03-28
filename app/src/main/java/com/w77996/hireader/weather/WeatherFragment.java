package com.w77996.hireader.weather;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.w77996.hireader.R;
import com.w77996.hireader.utils.SystemUtils;
import com.w77996.hireader.weather.bean.WeatherBean;
import com.w77996.hireader.weather.contract.WeatherContract;
import com.w77996.hireader.weather.presenter.WeatherPresenter;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Administrator on 2017/3/27.
 */
public class WeatherFragment extends Fragment implements WeatherContract.View{

    WeatherContract.Presenter presenter;
    SwipeRefreshLayout mSwipeRefreshLayout;
    RelativeLayout mRelativeLayout;
    TextView mTextViewRefreshTime;
    TextView mTextViewAirIndex;
    TextView mTextViewWeather;
    ImageView mImageViewWeather;
    TextView mTextViewTemp;
    TextView mTextViewMaxTemp;
    TextView mTextViewMinTemp;
    Toolbar mToolbar;
    private Context mContext;
    private int mNowWeatherHeight=-1;

    public static WeatherFragment newInstance(){
        return new WeatherFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  =inflater.inflate(R.layout.fragment_weather,container,false);

        initView(view);
        presenter.loadLocation();
        return view;
    }

    @Override
    public void showLoading() {
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
            }
        });
    }

    @Override
    public void showError() {

    }

    @Override
    public void stopLoading() {
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public void showWeather(WeatherBean weather) {
        mToolbar.setTitle(weather.getShowapi_res_body().getCityInfo().getC5());
    }

    @Override
    public void setPresenter(WeatherContract.Presenter presenter) {
        if(presenter!=null){
            this.presenter = presenter;
        }
    }

    @Override
    public void initView(View view) {
        mSwipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.weather_swiperefresh);
        mRelativeLayout = (RelativeLayout) view.findViewById(R.id.main_now_weather);
        mNowWeatherHeight = SystemUtils.getDisplayHeight(mContext) - SystemUtils.getActionBarSize(mContext) - SystemUtils.getStatusBarHeight(mContext);
        mRelativeLayout.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, mNowWeatherHeight));
        mToolbar = (Toolbar) getActivity().findViewById(R.id.main_toolbar);
        mTextViewRefreshTime = (TextView)view.findViewById(R.id.weather_time);
    }
}
