package com.w77996.hireader.utils;

import com.orhanobut.logger.Logger;

import java.text.SimpleDateFormat;
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

    public String DoubanDateFormat(long date){
        String sDate;
        Date d = new Date(date);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        sDate = format.format(d);

        return sDate;
    }

}
