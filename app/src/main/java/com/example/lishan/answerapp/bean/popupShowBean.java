package com.example.lishan.answerapp.bean;

/**
 * Created by lishan on 2018/4/12.
 */

public class popupShowBean {
    /**
     * code : 200
     * data : {"user_score":"16"}
     * error : true
     * messgae : 考题提交成功
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
         * user_score : 16
         */

        private String user_score;

        public String getUser_score() {
            return user_score;
        }

        public void setUser_score(String user_score) {
            this.user_score = user_score;
        }
    }
}
