package com.example.lishan.answerapp.bean;

/**
 * Created by Administrator on 2018/4/10 0010.
 */

public class PersonalCenterBean {

    /**
     * code : 200
     * data : {"icon":"http://39.106.219.133/static/icon/KI157083193241523342124.jpg"}
     * error : true
     * messgae : 图片上传成功
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
         * icon : http://39.106.219.133/static/icon/KI157083193241523342124.jpg
         */

        private String icon;

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }
}
