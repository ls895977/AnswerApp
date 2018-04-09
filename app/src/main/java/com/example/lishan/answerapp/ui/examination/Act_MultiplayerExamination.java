package com.example.lishan.answerapp.ui.examination;

import android.view.View;

import com.example.lishan.answerapp.R;
import com.example.lishan.answerapp.common.BaseAct;

/**
 * 多人考试第二页
 * Created by lishan on 2018/2/6.
 */

public class Act_MultiplayerExamination extends BaseAct {
    @Override
    public int initLayoutId() {
        return R.layout.act_multiplayerexamination;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.multiplayer_back);
        setOnClickListener(R.id.bt_kaoshi);

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
            case R.id.multiplayer_back:
                finish();
                break;
            case R.id.bt_kaoshi://开始考试
                startAct(Act_SimulationTest.class);
                break;
        }
    }
}
