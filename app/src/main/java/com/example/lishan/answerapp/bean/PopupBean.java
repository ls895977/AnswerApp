package com.example.lishan.answerapp.bean;

import java.util.List;

/**
 * Created by lishan on 2018/4/12.
 */

public class PopupBean {

    /**
     * code : 200
     * data : {"withoutArr":[61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80]}
     * error : false
     * messgae : 尚未作答题号,是否确认提交
     */

    private int code;
    private DataBean data;
    private boolean error;
    private String messgae;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
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

    public static class DataBean {
        private List<Integer> withoutArr;

        public List<Integer> getWithoutArr() {
            return withoutArr;
        }

        public void setWithoutArr(List<Integer> withoutArr) {
            this.withoutArr = withoutArr;
        }
    }
}
