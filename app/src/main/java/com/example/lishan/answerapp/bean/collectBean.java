package com.example.lishan.answerapp.bean;

/**
 * Created by lishan on 2018/4/12.
 */

public class collectBean {
    /**
     * code : 200
     * data : null
     * error : false
     * messgae : 还未收藏
     */

    private int code;
    private Object data;
    private boolean error;
    private String messgae;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessgae() {
        return messgae;
    }

    public void setMessgae(String messgae) {
        this.messgae = messgae;
    }
}
