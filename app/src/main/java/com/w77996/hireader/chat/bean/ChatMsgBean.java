package com.w77996.hireader.chat.bean;

/**
 * Created by Administrator on 2017/3/17.
 */
public class ChatMsgBean {
    public static final int TYPE_SEND =1;
    public static final int TYPE_RECIV=2;
    private String msg;
    private int type;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
