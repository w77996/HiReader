package com.w77996.hireader.utils;

import com.orhanobut.logger.Logger;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2017/3/13.
 */
public class DateFomatter {
    /**
     * 将long类date转换为String类型
     * @param date date
     * @return String date
     */
    public String ZhihuDailyDateFormat(long date) {
        String sDate;
        Date d = new Date(date + 24*60*60*1000);
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        sDate = format.format(d);
        Logger.d(sDate);
        return sDate;
    }
    public String TodayOfHistoryDateFormat(){
        Calendar calendar = Calendar.getInstance();
        final int month = calendar.get(Calendar.MONTH) + 1;
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        return month+""+day;
    }
    public String DoubanDateFormat(long date){
        String sDate;
        Date d = new Date(date);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        sDate = format.format(d);

        return sDate;
    }
    public String NewsDateFormat(){
        String date;
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        date = format.format(d);
       // Logger.d(date);
        return date;
    }
    public String WeatherDateFormat(){
        String date;
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        date = format.format(d);
        // Logger.d(date);
        return date;
    }
}
