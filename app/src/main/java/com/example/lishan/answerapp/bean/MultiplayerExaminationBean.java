package com.example.lishan.answerapp.bean;

/**
 * Created by Administrator on 2018/4/10 0010.
 */

public class MultiplayerExaminationBean {

    /**
     * code : 200
     * data : {"unit_info":"单项选择题(共10题，每题4分),多项选择题(共10题，每题6分)","unit_full":"100","unit_time":"1521089200","unit":"2018年-注册安全工程师考试","unit_duration":"120","unit_pass":"60"}
     * error : true
     * messgae : 计时考试
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
        /**
         * unit_info : 单项选择题(共10题，每题4分),多项选择题(共10题，每题6分)
         * unit_full : 100
         * unit_time : 1521089200
         * unit : 2018年-注册安全工程师考试
         * unit_duration : 120
         * unit_pass : 60
         */

        private String unit_info;
        private String unit_full;
        private String unit_time;
        private String unit;
        private String unit_duration;
        private String unit_pass;

        public String getUnit_info() {
            return unit_info;
        }

        public void setUnit_info(String unit_info) {
            this.unit_info = unit_info;
        }

        public String getUnit_full() {
            return unit_full;
        }

        public void setUnit_full(String unit_full) {
            this.unit_full = unit_full;
        }

        public String getUnit_time() {
            return unit_time;
        }

        public void setUnit_time(String unit_time) {
            this.unit_time = unit_time;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public String getUnit_duration() {
            return unit_duration;
        }

        public void setUnit_duration(String unit_duration) {
            this.unit_duration = unit_duration;
        }

        public String getUnit_pass() {
            return unit_pass;
        }

        public void setUnit_pass(String unit_pass) {
            this.unit_pass = unit_pass;
        }
    }
}
