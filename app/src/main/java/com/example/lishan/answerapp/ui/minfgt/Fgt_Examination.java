package com.example.lishan.answerapp.ui.minfgt;

import android.view.View;

import com.example.lishan.answerapp.R;
import com.example.lishan.answerapp.common.BaseFgt;
import com.example.lishan.answerapp.ui.examination.Act_MultiplayerExamination;

/**
 * 考试
 * Created by lishan on 2018/1/27.
 */

public class Fgt_Examination extends BaseFgt {
    @Override
    public void sendMsg(int flag, Object obj) {

    }

    @Override
    public int initLayoutId() {
        return R.layout.fgt_examination;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.examination_bt);
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
            case R.id.examination_bt:
                startAct(Act_MultiplayerExamination.class);
                break;
        }
    }
}
