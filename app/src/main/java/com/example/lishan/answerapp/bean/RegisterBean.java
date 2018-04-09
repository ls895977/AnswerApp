package com.example.lishan.answerapp.bean;

/**
 * Created by Administrator on 2018/2/28 0028.
 */

public class RegisterBean {

    /**
     * error : true
     * data : {"new_password":"456789"}
     * code : 200
     * messgae : 密码修改成功!
     */

    private boolean error;
    private DataBean data;
    private int code;
    private String messgae;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessgae() {
        return messgae;
    }

    public void setMessgae(String messgae) {
        this.messgae = messgae;
    }

    public static class DataBean {
        /**
         * new_password : 456789
         */

        private String new_password;

        public String getNew_password() {
            return new_password;
        }

        public void setNew_password(String new_password) {
            this.new_password = new_password;
        }
    }
}
