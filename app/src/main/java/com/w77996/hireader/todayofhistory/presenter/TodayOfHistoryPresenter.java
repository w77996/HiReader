package com.w77996.hireader.todayofhistory.presenter;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.w77996.hireader.detail.BeanType;
import com.w77996.hireader.detail.DetailActivity;
import com.w77996.hireader.todayofhistory.TodayOfHistoryDetailActivity;
import com.w77996.hireader.todayofhistory.bean.TodayOfHistoryBean;
import com.w77996.hireader.todayofhistory.contract.TodayOfHistoryContract;
import com.w77996.hireader.utils.Api;
import com.w77996.hireader.utils.ApiService;
import com.w77996.hireader.utils.HttpUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/3/14.
 */
public class TodayOfHistoryPresenter implements TodayOfHistoryContract.Presenter {

    private final Context context;
    private final TodayOfHistoryContract.View view;
    private  List<TodayOfHistoryBean.ResultBean> list = new ArrayList<>();

    public TodayOfHistoryPresenter(Context context,TodayOfHistoryContract.View view){
        this.context  =context;
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public void requestData() {
        view.showLoading();
        Calendar calendar = Calendar.getInstance();
        final int month = calendar.get(Calendar.MONTH) + 1;
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        HttpUtils.getInstance()
                .create(ApiService.class,Api.TODAY_HISTORY)
                .getTodayOfHistoryData(month+"",day+"")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TodayOfHistoryBean>() {
                    @Override
                    public void accept(TodayOfHistoryBean todayOfHistoryBean) throws Exception {
                            for(TodayOfHistoryBean.ResultBean resultList :todayOfHistoryBean.getResult()){
                                list.add(resultList);
                            }
                        view.showResult(list);
                        view.stopLoading();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.showError();
                        view.stopLoading();
                    }
                });
    }

    @Override
    public void refresh() {
        requestData();
    }

    @Override
    public void loadDetail(int position) {
        context.startActivity(new Intent(context, TodayOfHistoryDetailActivity.class)
                .putExtra("type", BeanType.TYPE_HISTORY)
                .putExtra("title",list.get(position).getTitle())
                .putExtra("id", list.get(position).get_id()));

    }

    @Override
    public void start() {
        requestData();
    }
}
