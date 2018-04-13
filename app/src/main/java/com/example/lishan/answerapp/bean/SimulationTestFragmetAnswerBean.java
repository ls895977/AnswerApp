package com.example.lishan.answerapp.bean;

/**
 * Created by lishan on 2018/4/12.
 */

public class SimulationTestFragmetAnswerBean {

    /**
     * code : 200
     * data : {"user_answer":"B"}
     * error : true
     * messgae : 作答记录信息
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
         * user_answer : B
         */

        private String user_answer;

        public String getUser_answer() {
            return user_answer;
        }

        public void setUser_answer(String user_answer) {
            this.user_answer = user_answer;
        }
    }
}
