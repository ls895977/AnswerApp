package com.example.lishan.answerapp.ui.my;

import android.view.View;

import com.example.lishan.answerapp.R;
import com.example.lishan.answerapp.common.BaseAct;

/**
 * 账户管理
 * Created by lishan on 2018/1/27.
 */

public class Act_Account extends BaseAct {
    @Override
    public int initLayoutId() {
        return R.layout.act_myaccount;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.account_back);
        setOnClickListener(R.id.account_cryptogram);
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
            case R.id.account_back:
                finish();
                break;
            case R.id.account_cryptogram://修改密码
                startAct(Act_Cryptogram.class);
                break;
        }
    }
}
