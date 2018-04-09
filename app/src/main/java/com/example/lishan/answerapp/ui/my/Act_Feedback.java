package com.example.lishan.answerapp.ui.my;

import android.view.View;

import com.example.lishan.answerapp.R;
import com.example.lishan.answerapp.common.BaseAct;

/**
 * 我的反馈
 * Created by lishan on 2018/1/27.
 */

public class Act_Feedback extends BaseAct {
    @Override
    public int initLayoutId() {
        return R.layout.act_feedback;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.feedback_back);
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
            case R.id.feedback_back:
                finish();
                break;
        }
    }
}
