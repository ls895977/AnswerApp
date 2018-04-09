package com.example.lishan.answerapp.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/3/15 0015.
 */

public class SexBean {


    /**
     * code : 200
     * data : ["gender"]
     * error : true
     * messgae : 修改数据成功
     */

    private int code;
    private boolean error;
    private String messgae;
    private List<String> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
