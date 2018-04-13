package com.example.lishan.answerapp.ui.examination;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.example.lishan.answerapp.R;
import com.example.lishan.answerapp.adapter.AnswerCardAdapter;
import com.example.lishan.answerapp.bean.AnswerCardBean;
import com.example.lishan.answerapp.common.BaseAct;
import com.example.lishan.answerapp.httppost.BackString;
import com.example.lishan.answerapp.httppost.HttpReqest;
import com.example.lishan.answerapp.ui.hom.Act_MultiplayerExamination;
import com.google.gson.Gson;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 答题卡
 * Created by lishan on 2018/2/7.
 */

public class Act_AnswerCard extends BaseAct {
    private GridView myGridView;
    private ACache aCache;
    private AnswerCardBean datas;
    private TextView defen, zongfen;
    @Override
    public int initLayoutId() {
        return R.layout.act_answercard;
    }
    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.answercard_back);
        myGridView = getView(R.id.answercard_Gridiview);
        aCache = ACache.get(this);
        defen = getView(R.id.answercart_defe);
        zongfen = getView(R.id.answercard_zongfen);
    }
    List<AnswerCardBean> mDatas;
    @Override
    public void initData() {
        unit = getIntent().getStringExtra("unit");
        postBackData();
        defen.setText(getIntent().getStringExtra("user_score"));
        zongfen.setText(getIntent().getStringExtra("unit_full"));
        myGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent();
//                intent.putExtra("position", position);
//                intent.putExtra("childrenPosition", childrenPosition);
//                intent.putExtra("data", bean);
//                intent.putExtra("unit",datas.getData().get(position).get(position).getUnit());
//                intent.putExtra("section",.get(position).getSection().get(childrenPosition).getSection());
//                startAct(intent, Act_MultiplayerExamination.class);
            }
        });
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

    private String unit;
    private AnswerCardAdapter answerCardAdapter;

    public void postBackData() {
        showLoading();
        HttpReqest httpReqest = new HttpReqest();
        HashMap<String, String> body = new HashMap<>();
        body.put("phone", aCache.getAsString("phone"));
        body.put("token", aCache.getAsString("token"));
        body.put("unit", unit);
        httpReqest.HttpPost("/online/record_content/", body, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                showCView();
                Gson gson = new Gson();
                datas = gson.fromJson(response.body(), AnswerCardBean.class);
                answerCardAdapter = new AnswerCardAdapter(context, datas.getData());
                myGridView.setAdapter(answerCardAdapter);
            }

            @Override
            public void onError(Response<String> response) {
                showCView();
            }
        });


    }
}
