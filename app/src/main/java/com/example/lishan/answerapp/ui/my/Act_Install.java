package com.example.lishan.answerapp.ui.my;

import android.view.View;

import com.example.lishan.answerapp.R;
import com.example.lishan.answerapp.common.BaseAct;

/**
 * 我的设置
 * Created by lishan on 2018/1/27.
 */

public class Act_Install extends BaseAct {
    @Override
    public int initLayoutId() {
        return R.layout.act_install;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.install_back);
        setOnClickListener(R.id.install_remind);
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
            case R.id.install_back:
                finish();
                break;
            case R.id.install_remind:
                startAct(Act_Remind.class);
                break;
        }
    }
}
