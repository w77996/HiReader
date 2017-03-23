package com.w77996.hireader.zhihuguokr.guokr.bean;

import java.util.ArrayList;

/**
 * Created by Lizhaotailang on 2016/9/16.
 */

public class GuokrHandpickNews {

    private String now;
    private boolean ok;
    private ArrayList<result> result;

    public String getNow() {
        return now;
    }

    public void setNow(String now) {
        this.now = now;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public ArrayList<GuokrHandpickNews.result> getResult() {
        return result;
    }

    public void setResult(ArrayList<GuokrHandpickNews.result> result) {
        this.result = result;
    }

    public class result {
        private String link_v2_sync_img;
        private String source_name;
        private String video_url;
        private boolean current_user_has_collected;
        private int likings_count;
        private String[] images;
        private String video_duration;
        private int id;
        private String category;
        private String style;
        private String title;
        private source_data source_data;
        private String headline_img_tb;
        private String link_v2;
        private double date_picked;
        private boolean is_top;
        private String link;
        private String headline_img;
        private int replies_count;
        private boolean current_user_has_liked;
        private String page_source;
        private String author;
        private String summary;
        private String source;
        private int reply_root_id;
        private double date_created;

        public String getLink_v2_sync_img() {
            return link_v2_sync_img;
        }

        public void setLink_v2_sync_img(String link_v2_sync_img) {
            this.link_v2_sync_img = link_v2_sync_img;
        }

        public String getSource_name() {
            return source_name;
        }

        public void setSource_name(String source_name) {
            this.source_name = source_name;
        }

        public String getVideo_url() {
            return video_url;
        }

        public void setVideo_url(String video_url) {
            this.video_url = video_url;
        }

        public boolean isCurrent_user_has_collected() {
            return current_user_has_collected;
        }

        public void setCurrent_user_has_collected(boolean current_user_has_collected) {
            this.current_user_has_collected = current_user_has_collected;
        }

        public int getLikings_count() {
            return likings_count;
        }

        public void setLikings_count(int likings_count) {
            this.likings_count = likings_count;
        }

        public String[] getImages() {
            return images;
        }

        public void setImages(String[] images) {
            this.images = images;
        }

        public String getVideo_duration() {
            return video_duration;
        }

        public void setVideo_duration(String video_duration) {
            this.video_duration = video_duration;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getStyle() {
            return style;
        }

        public void setStyle(String style) {
            this.style = style;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public GuokrHandpickNews.source_data getSource_data() {
            return source_data;
        }

        public void setSource_data(GuokrHandpickNews.source_data source_data) {
            this.source_data = source_data;
        }

        public String getHeadline_img_tb() {
            return headline_img_tb;
        }

        public void setHeadline_img_tb(String headline_img_tb) {
            this.headline_img_tb = headline_img_tb;
        }

        public String getLink_v2() {
            return link_v2;
        }

        public void setLink_v2(String link_v2) {
            this.link_v2 = link_v2;
        }

        public double getDate_picked() {
            return date_picked;
        }

        public void setDate_picked(double date_picked) {
            this.date_picked = date_picked;
        }

        public boolean is_top() {
            return is_top;
        }

        public void setIs_top(boolean is_top) {
            this.is_top = is_top;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getHeadline_img() {
            return headline_img;
        }

        public void setHeadline_img(String headline_img) {
            this.headline_img = headline_img;
        }

        public int getReplies_count() {
            return replies_count;
        }

        public void setReplies_count(int replies_count) {
            this.replies_count = replies_count;
        }

        public boolean isCurrent_user_has_liked() {
            return current_user_has_liked;
        }

        public void setCurrent_user_has_liked(boolean current_user_has_liked) {
            this.current_user_has_liked = current_user_has_liked;
        }

        public String getPage_source() {
            return page_source;
        }

        public void setPage_source(String page_source) {
            this.page_source = page_source;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public int getReply_root_id() {
            return reply_root_id;
        }

        public void setReply_root_id(int reply_root_id) {
            this.reply_root_id = reply_root_id;
        }

        public double getDate_created() {
            return date_created;
        }

        public void setDate_created(double date_created) {
            this.date_created = date_created;
        }
    }

    public class source_data {
        private String image;
        private String summary;
        private int id;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

}
