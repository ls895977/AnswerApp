package com.example.lishan.answerapp.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.example.lishan.answerapp.R;
import com.example.lishan.answerapp.bean.RegisterBean;
import com.example.lishan.answerapp.common.BaseAct;
import com.example.lishan.answerapp.httppost.BackString;
import com.example.lishan.answerapp.httppost.HttpReqest;
import com.google.gson.Gson;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.lzy.okgo.model.Response;

import java.util.HashMap;

/**
 * 忘记密码
 * Created by lishan on 2018/1/27.
 */

public class Act_ForgotPassword extends BaseAct {
    private EditText phone, pwd1, pwd2;
    private HttpReqest httpReqest;

    @Override
    public int initLayoutId() {
        return R.layout.act_forgotpassword;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.forgotpassword_back);
        setOnClickListener(R.id.forgotpassword_enter);
        httpReqest = new HttpReqest();
        phone = getView(R.id.forgotpassword_phone);
        pwd1 = getView(R.id.forgotpassword_pwd1);
        pwd2 = getView(R.id.forgotpassword_pwd2);
    }

    @Override
    public void initData() {

    }

    @Override
    public void requestData() {

    }

    @Override
    public void updateUI() {

    }

    @Override
    public void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.forgotpassword_enter:
                forgot();
                break;
            case R.id.forgotpassword_back:
                finish();
                break;
        }
    }

    public void forgot() {
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
        httpReqest.HttpPost("/user/replacement/", hashMap, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                String str = response.body();
                Gson gson = new Gson();
                RegisterBean bean = gson.fromJson(str, RegisterBean.class);
                MyToast.show(Act_ForgotPassword.this, bean.getMessgae());
                if (bean.isError()) {
                    finish();
                }
                showCView();
            }

            @Override
            public void onError(Response<String> response) {
                MyToast.show(Act_ForgotPassword.this, "服务器返回错误!");
                showCView();
            }
        });
    }

}
