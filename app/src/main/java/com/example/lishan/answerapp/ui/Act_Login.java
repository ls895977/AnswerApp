package com.example.lishan.answerapp.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.example.lishan.answerapp.R;
import com.example.lishan.answerapp.bean.LoginBean;
import com.example.lishan.answerapp.bean.RegisterBean;
import com.example.lishan.answerapp.common.BaseAct;
import com.example.lishan.answerapp.common.MyTool;
import com.example.lishan.answerapp.common.MyUrl;
import com.example.lishan.answerapp.httppost.BackString;
import com.example.lishan.answerapp.httppost.HttpReqest;
import com.google.gson.Gson;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.lzy.okgo.model.Response;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录
 * Created by lishan on 2018/1/27.
 */

public class Act_Login extends BaseAct implements BackString {
    private EditText phone, pwd;
    private Gson gson;
    private ACache aCache;

    @Override
    public int initLayoutId() {
        return R.layout.act_login;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.login_register);
        setOnClickListener(R.id.login_bt);
        setOnClickListener(R.id.login_forgot_password);
        phone = getView(R.id.login_editText);
        pwd = getView(R.id.login_pwd);
        gson = new Gson();
        aCache = ACache.get(this);
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
            case R.id.login_register://注册
                startAct(Act_Register.class);
                break;
            case R.id.login_bt://登录
                login();
                break;
            case R.id.login_forgot_password://忘记密码
                startAct(Act_ForgotPassword.class);
                break;
        }
    }

    @Override
    public void onSuccess(Response<String> response) {
        Debug.e(response.body());
        String str = response.body();
        Gson gson = new Gson();
        LoginBean bean = gson.fromJson(str, LoginBean.class);
        MyToast.show(Act_Login.this, bean.getMessgae());
        if (bean.isError()) {
            Debug.e("token==" + bean.getData().getToken());
            aCache.put("token", bean.getData().getToken());
            aCache.put("timestamp", bean.getData().getMessage().get(0).getTimestamp());
            aCache.put("content", bean.getData().getMessage().get(0).getContent());
            if (bean.getData().getUser().getUser_info() != null) {
                aCache.put("user_info", bean.getData().getUser().getUser_info().toString());
            }
            aCache.put("phone", bean.getData().getUser().getPhone().toString());
            if (bean.getData().getUser().getGender() != null) {
                aCache.put("gender", bean.getData().getUser().getGender().toString());
            }
            if (bean.getData().getUser().getProvince() != null) {
                aCache.put("province", bean.getData().getUser().getProvince().toString());
            }
            if (bean.getData().getUser().getCity() != null) {
                aCache.put("city", bean.getData().getUser().getCity().toString());
            }
            if (bean.getData().getUser().getBirthday() != null) {
                aCache.put("birthday", bean.getData().getUser().getBirthday().toString());
            }
            aCache.put("icon", bean.getData().getUser().getIcon().toString());
            if (bean.getData().getUser().getNick_name() == null) {
                aCache.put("nick_name", "");
            } else {
                aCache.put("nick_name", String.valueOf(bean.getData().getUser().getNick_name()));
            }
            if (bean.getData().getUser().getGender() == null) {
                aCache.put("gender", "");
            } else {
                aCache.put("gender", String.valueOf(bean.getData().getUser().getGender()));
            }
            startAct(MainActivity.class);
            finish();
        }
        showCView();
    }

    @Override
    public void onError(Response<String> response) {

    }

    public void login() {
        if (TextUtils.isEmpty(phone.getText().toString())) {
            MyToast.show(this, "手机号码不能为空！");
            return;
        }
        if (!MyTool.isPhoneRegex(phone.getText().toString())) {
            MyToast.show(this, "手机号码难证错误！");
            return;
        }
        if (TextUtils.isEmpty(pwd.getText().toString())) {
            MyToast.show(this, "密码不能为空！");
            return;
        }
        showLoading();
        HttpReqest httpReqest = new HttpReqest();
        Map<String, String> map = new HashMap<>();
        map.put("phone", phone.getText().toString());
        map.put("password", String.valueOf(pwd.getText().toString()));
        aCache.put("password", String.valueOf(pwd.getText().toString()));
        httpReqest.HttpPost("/user/login/", map, this);
    }
}
