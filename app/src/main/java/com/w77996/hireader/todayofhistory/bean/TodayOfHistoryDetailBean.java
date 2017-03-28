package com.w77996.hireader.todayofhistory.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/3/28.
 */
public class TodayOfHistoryDetailBean {

    /**
     * result : [{"_id":"11610311","title":"南宋发行纸币\u201c交子\u201d","pic":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/toh/201003/9/54235253857.jpg","year":1161,"month":3,"day":11,"des":"在856年前的今天，1161年3月11日 (农历二月十三)，南宋发行纸币\u201c交子\u201d。","content":"在856年前的今天，1161年3月11日 (农历二月十三)，南宋发行纸币\u201c交子\u201d。\n北宋以前，历代流通的贷币都是\u201c硬币\u201d，从贝壳、铁钱、铜钱到白银。到了商品经济繁荣的北宋中期，为了携带方便，在四川地区首先出现了由商人发行的纸币，称\u201c交子\u201d。这是世界上最早的纸币。交子可以在市场上流通，又可以兑换钱银，使用十分方便。\n1023年，北来政府在益州设立了\u201c交子务\u201d，开始由政府发行交子，并以铁钱为后备金。\n1161年3月11日（宋绍兴三十一年二月十三日，距今已856年）南宋政府发行了以铜钱为本位的纸币\u201c会子\u201d。纸币的面值分壹贯、贰贯、叁贯3种，后又增加贰伯文、叁伯文、伍伯文3种，通行于东南各地。不同面值的\u201c会子\u201d图案也不尽相同，并印有发行机关名称、面值、界数（三年换发一次，为一界）。票面上还印有捕捉伪造和使用假币者的赏格。政府还规定：抓到伪造\u201c会子\u201d者，若不愿领赏，可授一官职。\n【会子】huì'zi 中国南宋时的一种纸币。初为便钱会子，即汇票、支票之类的票据。\n","lunar":"辛巳年二月十三"}]
     * reason : 请求成功！
     * error_code : 0
     */

    private String reason;
    private int error_code;
    private List<ResultBean> result;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * _id : 11610311
         * title : 南宋发行纸币“交子”
         * pic : http://juheimg.oss-cn-hangzhou.aliyuncs.com/toh/201003/9/54235253857.jpg
         * year : 1161
         * month : 3
         * day : 11
         * des : 在856年前的今天，1161年3月11日 (农历二月十三)，南宋发行纸币“交子”。
         * content : 在856年前的今天，1161年3月11日 (农历二月十三)，南宋发行纸币“交子”。
         北宋以前，历代流通的贷币都是“硬币”，从贝壳、铁钱、铜钱到白银。到了商品经济繁荣的北宋中期，为了携带方便，在四川地区首先出现了由商人发行的纸币，称“交子”。这是世界上最早的纸币。交子可以在市场上流通，又可以兑换钱银，使用十分方便。
         1023年，北来政府在益州设立了“交子务”，开始由政府发行交子，并以铁钱为后备金。
         1161年3月11日（宋绍兴三十一年二月十三日，距今已856年）南宋政府发行了以铜钱为本位的纸币“会子”。纸币的面值分壹贯、贰贯、叁贯3种，后又增加贰伯文、叁伯文、伍伯文3种，通行于东南各地。不同面值的“会子”图案也不尽相同，并印有发行机关名称、面值、界数（三年换发一次，为一界）。票面上还印有捕捉伪造和使用假币者的赏格。政府还规定：抓到伪造“会子”者，若不愿领赏，可授一官职。
         【会子】huì'zi 中国南宋时的一种纸币。初为便钱会子，即汇票、支票之类的票据。

         * lunar : 辛巳年二月十三
         */

        private String _id;
        private String title;
        private String pic;
        private int year;
        private int month;
        private int day;
        private String des;
        private String content;
        private String lunar;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getLunar() {
            return lunar;
        }

        public void setLunar(String lunar) {
            this.lunar = lunar;
        }
    }
}
