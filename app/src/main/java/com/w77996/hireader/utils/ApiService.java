package com.w77996.hireader.utils;

import com.w77996.hireader.homepage.guokr.bean.GuokrHandpickNews;
import com.w77996.hireader.joker.bean.JokerBean;
import com.w77996.hireader.news.bean.NewsBean;
import com.w77996.hireader.todayofhistory.bean.TodayOfHistoryBean;
import com.w77996.hireader.homepage.zhihudaily.bean.ZhihuDailyBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/3/13.
 */
public interface ApiService {
    @GET("api/4/news/before/{date}")
    Observable<ZhihuDailyBean> getZhihuDaily(
            @Path("date") String date);

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

    @GET("109-35?channelId=&maxResult=10&needAllList=0&needContent=0&needHtml=0&showapi_appid=33655&title=&showapi_sign=01b6b253d82c44a08ab329d453ff9d4b")
    Observable<NewsBean> getNews(
            @Query("channelName") String type,
            @Query("page") int page,
            @Query("showapi_timestamp") String time);
}
