package com.w77996.hireader.utils;

import com.w77996.hireader.guokr.bean.GuokrHandpickNews;
import com.w77996.hireader.joker.bean.JokerBean;
import com.w77996.hireader.todayofhistory.bean.TodayOfHistoryBean;
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

    @GET("text.from?key=ae240f7fba620fc370b803566654949e")
    Observable<JokerBean> getJokerData(
            @Query("page") int page,
            @Query("pagesize") int pagesize
    );
    @GET("toh?v=&key=02351f897b139cc86e39a225aaeaa42d")
    Observable<TodayOfHistoryBean> getTodayOfHistoryData(
        @Query("month") String month,
        @Query("day") String day
    );


}
