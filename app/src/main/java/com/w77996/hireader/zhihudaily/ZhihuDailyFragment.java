package com.w77996.hireader.zhihudaily;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.w77996.hireader.zhihudaily.bean.ZhihuDailyBean;
import com.w77996.hireader.zhihudaily.contract.ZhihuDailyContract;

import java.util.ArrayList;

/**
 * Created by w77996 on 2017/3/11.
 */
public class ZhihuDailyFragment extends Fragment  implements ZhihuDailyContract.View{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showResult(ArrayList<ZhihuDailyBean.StoriesBean> list) {

    }

    @Override
    public void showPickerDialog() {

    }

    @Override
    public void setPresenter(ZhihuDailyContract.Presenter presenter) {

    }

    @Override
    public void initView(View view) {

    }
}
