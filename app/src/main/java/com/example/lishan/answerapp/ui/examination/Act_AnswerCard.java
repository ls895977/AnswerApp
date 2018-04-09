package com.example.lishan.answerapp.ui.examination;

import android.view.View;
import android.widget.GridView;

import com.example.lishan.answerapp.R;
import com.example.lishan.answerapp.adapter.AnswerCardAdapter;
import com.example.lishan.answerapp.bean.AnswerCardBean;
import com.example.lishan.answerapp.common.BaseAct;

import java.util.ArrayList;
import java.util.List;

/**
 * 答题卡
 * Created by lishan on 2018/2/7.
 */

public class Act_AnswerCard extends BaseAct {
    private GridView myGridView;

    @Override
    public int initLayoutId() {
        return R.layout.act_answercard;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.answercard_back);
        myGridView = getView(R.id.answercard_Gridiview);
    }

    List<AnswerCardBean> mDatas;

    @Override
    public void initData() {
        mDatas = new ArrayList<>();
        for (int i = 1; i < 19; i++) {
            AnswerCardBean b1 = new AnswerCardBean();
            b1.setIndext(i);
            if (i == 1 || i == 7 || i == 21) {
                b1.setZhuangtai(1);
            } else if (i == 2 || i == 6 || i == 8 || i == 12 || i == 14 || i == 18) {
                b1.setZhuangtai(2);
            } else if (i == 5) {
                b1.setZhuangtai(3);
            } else {
                b1.setZhuangtai(4);
            }
            mDatas.add(b1);
        }


        AnswerCardAdapter answerCardAdapter = new AnswerCardAdapter(this, mDatas);
        myGridView.setAdapter(answerCardAdapter);
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
            case R.id.answercard_back:
                finish();
                break;
        }
    }
}
