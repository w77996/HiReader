package com.w77996.hireader.utils;

import com.w77996.hireader.guokr.bean.GuokrHandpickNews;
import com.w77996.hireader.zhihudaily.bean.ZhihuDailyBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by Administrator on 2017/3/13.
 */
public interface ApiService {
    @GET("api/4/news/before/{date}")
    Observable<ZhihuDailyBean> getZhihuDaily(@Path("date") String date);

    @GET("article.json?retrieve_type=by_since&category=all&limit=25&ad=1")
    Observable<GuokrHandpickNews> getGuokrHandpick();
}
