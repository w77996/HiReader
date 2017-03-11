package com.w77996.hireader.base;

import android.view.View;

/**
 * Created by Administrator on 2017/3/11.
 */
public interface BaseView <T>{
    void setPresenter(T presenter);
    void initView(View view);
}
