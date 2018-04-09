package com.example.lishan.answerapp.bean;

/**
 * Created by Administrator on 2018/2/28 0028.
 */

public class VerifyBean {

    /**
     * code : 200
     * data : null
     * messgae : 手机格式错误!
     * error : false
     */

    private int code;
    private Object data;
    private String messgae;
    private boolean error;

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

    public String getMessgae() {
        return messgae;
    }

    public void setMessgae(String messgae) {
        this.messgae = messgae;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
