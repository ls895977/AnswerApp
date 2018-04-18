package com.example.lishan.answerapp.ui.examination;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.example.lishan.answerapp.R;
import com.example.lishan.answerapp.adapter.AnswerCardAdapter;
import com.example.lishan.answerapp.bean.AnswerCardBean;
import com.example.lishan.answerapp.bean.StartTheExamBean;
import com.example.lishan.answerapp.common.BaseAct;
import com.example.lishan.answerapp.httppost.BackString;
import com.example.lishan.answerapp.httppost.HttpReqest;
import com.example.lishan.answerapp.ui.hom.Act_MultiplayerExamination;
import com.example.lishan.answerapp.ui.hom.Act_StartTheExam;
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
                StartTheExamBean startTheExamBean = new StartTheExamBean();
                StartTheExamBean.DataBean dataBean = new StartTheExamBean.DataBean();
                startTheExamBean.setData(dataBean);
                List<StartTheExamBean.DataBean.QuestionsBean> questionsBeansList = new ArrayList<>();
                for (int i = 0; i < datas.getData().size(); i++) {
                    StartTheExamBean.DataBean.QuestionsBean questionsBean = new StartTheExamBean.DataBean.QuestionsBean();
                    questionsBean.setAnswer(datas.getData().get(i).getAnswer());
                    questionsBean.setAnswer_A(datas.getData().get(i).getAnswer_A());
                    questionsBean.setAnswer_B(datas.getData().get(i).getAnswer_B());
                    questionsBean.setAnswer_C(datas.getData().get(i).getAnswer_C());
                    questionsBean.setAnswer_D(datas.getData().get(i).getAnswer_D());
                    questionsBean.setQuestions_id(datas.getData().get(i).getId());
                    questionsBean.setQuestions(datas.getData().get(i).getQuestions());
                    questionsBean.setAnswer_info(datas.getData().get(i).getAnswer_info());
                    questionsBean.setQuestions_img(datas.getData().get(i).getQuestions_img());
                    questionsBean.setQuestions_type(datas.getData().get(i).getQuestions_type());
                    questionsBean.setAnswer_F(datas.getData().get(i).getAnswer_F());
                    questionsBean.setAnswer_E(datas.getData().get(i).getAnswer_E());
                    questionsBeansList.add(questionsBean);
                }
                dataBean.setQuestions(questionsBeansList);
                Intent intent = new Intent();
                intent.putExtra("status_A","1");
                intent.putExtra("indext", position);
                intent.putExtra("data", startTheExamBean);
                startAct(intent, Act_StartTheExam.class);
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
