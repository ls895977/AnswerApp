package com.example.lishan.answerapp.ui.my;

import android.view.View;

import com.example.lishan.answerapp.R;
import com.example.lishan.answerapp.common.BaseAct;

/**
 * 提醒
 * Created by lishan on 2018/1/28.
 */

public class Act_Remind extends BaseAct {
    @Override
    public int initLayoutId() {
        return R.layout.act_register;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.remind_back);
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
            case R.id.remind_back:
                finish();
                break;
        }
    }
}
