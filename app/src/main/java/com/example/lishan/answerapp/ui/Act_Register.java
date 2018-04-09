package com.example.lishan.answerapp.ui;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lishan.answerapp.R;
import com.example.lishan.answerapp.bean.RegisterBean;
import com.example.lishan.answerapp.bean.VerifyBean;
import com.example.lishan.answerapp.common.BaseAct;
import com.example.lishan.answerapp.common.MyUrl;
import com.example.lishan.answerapp.httppost.BackString;
import com.example.lishan.answerapp.httppost.HttpReqest;
import com.google.gson.Gson;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.lykj.aextreme.afinal.utils.TimeUtils;
import com.lzy.okgo.model.Response;

import java.util.HashMap;

/**
 * 注册
 * Created by lishan on 2018/1/27.
 */
public class Act_Register extends BaseAct implements TextWatcher {
    private EditText phone, pwd1, pwd2;
    private HttpReqest httpReqest;

    @Override
    public int initLayoutId() {
        return R.layout.act_register;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.login_bt);
        phone = getView(R.id.register_phone);
        pwd1 = getView(R.id.register_pwd1);
        pwd2 = getView(R.id.register_pwd2);
    }

    @Override
    public void initData() {
        phone.addTextChangedListener(this);
        httpReqest = new HttpReqest();
        aCache = ACache.get(this);
    }

    @Override
    public void requestData() {

    }

    @Override
    public void updateUI() {

    }

    private ACache aCache;

    @Override
    public void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.login_bt://注册
                if (!bean.getMessgae().equals("账号可以注册!")) {
                    MyToast.show(this, "您的账号不可用！");
                    return;
                }
                if (TextUtils.isEmpty(pwd1.getText().toString())) {
                    MyToast.show(this, "请输入密码!");
                    return;
                }
                if (TextUtils.isEmpty(pwd2.getText().toString())) {
                    MyToast.show(this, "请输入密码!");
                    return;
                }
                if (pwd2.getText().toString().equals(pwd1.getText().toString()) != true) {
                    MyToast.show(this, "二次密码输入不一致，请重新输入!");
                    return;
                }
                showLoading();
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("phone", phone.getText().toString());
                hashMap.put("password", pwd2.getText().toString());
                httpReqest.HttpPost("/user/register/", hashMap, new BackString() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String str = response.body();
                        Gson gson = new Gson();
                        RegisterBean bean = gson.fromJson(str, RegisterBean.class);
                        MyToast.show(Act_Register.this, bean.getMessgae());
                        if (bean.isError()) {
//                            aCache.put("token", bean.getData().getToken());
                            finish();
                        }
                        showCView();
                    }

                    @Override
                    public void onError(Response<String> response) {
                        MyToast.show(Act_Register.this, "服务器返回错误!");
                        showCView();
                    }
                });


                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    VerifyBean bean;

    @Override
    public void afterTextChanged(Editable editable) {
        String ph = phone.getText().toString();
        if (ph.length() < 11) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("phone", ph);
        httpReqest.HttpPost("/user/verify/", hashMap, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                Gson gson = new Gson();
                bean = gson.fromJson(response.body(), VerifyBean.class);
                MyToast.show(Act_Register.this, bean.getMessgae());
            }

            @Override
            public void onError(Response<String> response) {

            }
        });


    }
}
