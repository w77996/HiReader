package com.w77996.hireader.weather;

/**
 * Created by Administrator on 2017/3/29.
 */
public class CityFomat {

        /**
         * 提取出城市或者县
         * @param city
         * @param district
         * @return
         */
        public static String extractLocation(final String city, final String district){
            return district.contains("县") ? district.substring(0, district.length() - 1) : city.substring(0, city.length() - 1);
        }

}
