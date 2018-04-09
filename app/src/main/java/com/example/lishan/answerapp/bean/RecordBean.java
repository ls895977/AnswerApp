package com.example.lishan.answerapp.bean;

import java.util.List;

/**
 * Created by lishan on 2018/2/3.
 */

public class RecordBean {
    /**
     * messgae : 查询记录成功
     * code : 200
     * error : true
     * data : [{"unit_full":"100","unit":"2018年-会计考试","user_score":"60"}]
     */

    private String messgae;
    private int code;
    private boolean error;
    private List<DataBean> data;

    public String getMessgae() {
        return messgae;
    }

    public void setMessgae(String messgae) {
        this.messgae = messgae;
    }

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * unit_full : 100
         * unit : 2018年-会计考试
         * user_score : 60
         */

        private String unit_full;
        private String unit;
        private String user_score;

        public String getUnit_full() {
            return unit_full;
        }

        public void setUnit_full(String unit_full) {
            this.unit_full = unit_full;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public String getUser_score() {
            return user_score;
        }

        public void setUser_score(String user_score) {
            this.user_score = user_score;
        }
    }
}
