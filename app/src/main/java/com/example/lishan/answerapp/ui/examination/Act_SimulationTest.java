package com.example.lishan.answerapp.ui.examination;

import android.view.View;
import android.widget.RadioButton;

import com.example.lishan.answerapp.R;
import com.example.lishan.answerapp.common.BaseAct;

/**
 * 模拟考试
 * Created by lishan on 2018/2/6.
 */

public class Act_SimulationTest extends BaseAct {
    private RadioButton[] bt = new RadioButton[4];

    @Override
    public int initLayoutId() {
        return R.layout.act_simulationtest1;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.SimulationTest_back);
        setOnClickListener(R.id.simulationtest1_datika);
        setOnClickListener(R.id.simulationtest1_tijiao);
        setOnClickListener(R.id.simulationtest1_jiucuo);
        bt[0] = getView(R.id.rb_1);
        bt[1] = getView(R.id.rb_2);
        bt[2] = getView(R.id.rb_3);
        bt[3] = getView(R.id.rb_4);
        setOnClickListener(R.id.silin1);
        setOnClickListener(R.id.silin2);
        setOnClickListener(R.id.silin3);
        setOnClickListener(R.id.silin4);


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
            case R.id.SimulationTest_back:
                finish();
                break;
            case R.id.simulationtest1_datika://答题卡
                startAct(Act_AnswerCard.class);
                break;
            case R.id.simulationtest1_tijiao://提交
                startAct(Act_TestResult.class);
                break;
            case R.id.simulationtest1_jiucuo://纠错

                break;
            case R.id.silin1:
                bt[0].setChecked(true);
                bt[1].setChecked(false);
                bt[2].setChecked(false);
                bt[3].setChecked(false);
                break;
            case R.id.silin2:
                bt[0].setChecked(false);
                bt[1].setChecked(true);
                bt[2].setChecked(false);
                bt[3].setChecked(false);
                break;
            case R.id.silin3:
                bt[0].setChecked(false);
                bt[1].setChecked(false);
                bt[2].setChecked(true);
                bt[3].setChecked(false);
                break;
            case R.id.silin4:
                bt[0].setChecked(false);
                bt[1].setChecked(false);
                bt[2].setChecked(false);
                bt[3].setChecked(true);
                break;
        }
    }

}
