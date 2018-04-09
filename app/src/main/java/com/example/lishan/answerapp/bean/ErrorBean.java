package com.example.lishan.answerapp.bean;

import java.util.List;

/**
 * Created by lishan on 2018/2/5.
 */

public class ErrorBean {
    private boolean derail;
    private List<ErrorChlid> datas;
    private String title;
    private String cuoti;

    public boolean isDerail() {
        return derail;
    }

    public void setDerail(boolean derail) {
        this.derail = derail;
    }

    public List<ErrorChlid> getDatas() {
        return datas;
    }

    public void setDatas(List<ErrorChlid> datas) {
        this.datas = datas;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCuoti() {
        return cuoti;
    }

    public void setCuoti(String cuoti) {
        this.cuoti = cuoti;
    }
}
