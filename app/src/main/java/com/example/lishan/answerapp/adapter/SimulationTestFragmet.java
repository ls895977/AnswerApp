package com.example.lishan.answerapp.adapter;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lishan.answerapp.R;
import com.example.lishan.answerapp.bean.SimulationTestBean;
import com.example.lishan.answerapp.bean.SimulationTestFragmetAnswerBean;
import com.example.lishan.answerapp.bean.SimulationTestFragmetBean;
import com.example.lishan.answerapp.common.BaseFgt;
import com.example.lishan.answerapp.httppost.BackString;
import com.example.lishan.answerapp.httppost.HttpReqest;
import com.google.gson.Gson;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 答题卡子布局
 * Created by Administrator on 2018/4/11 0011.
 */

@SuppressLint("ValidFragment")
public class SimulationTestFragmet extends BaseFgt {
    private int indxt;
    private TextView item_subject, t1, t2, t3, t4, t5, t6;
    private SimulationTestBean dataBean;
    private SimulationTestBean.DataBean.QuestionsBean item;
    private ImageView img;
    private LinearLayout li1, li2, li3, li4, li5, li6;
    private TextView[] rd = new TextView[6];
    private ACache aCache;
    SimulationTestFragmetAnswerBean answer;

    @SuppressLint("ValidFragment")
    public SimulationTestFragmet(int indxt1, SimulationTestBean dataBean1) {
        this.indxt = indxt1;
        this.dataBean = dataBean1;
        item = dataBean1.getData().getQuestions().get(indxt1);

    }

    @Override
    public void sendMsg(int flag, Object obj) {

    }

    @Override
    public int initLayoutId() {
        return R.layout.fgt_simulationtest;
    }

    @Override
    public void initView() {
        hideHeader();
        item_subject = getView(R.id.item_subject);//题目
        li1 = getViewAndClick(R.id.silin1);
        li2 = getViewAndClick(R.id.silin2);
        li3 = getViewAndClick(R.id.silin3);
        li4 = getViewAndClick(R.id.silin4);
        li5 = getViewAndClick(R.id.silin5);
        li6 = getViewAndClick(R.id.silin6);
        img = getView(R.id.item_Answerimg);
        t1 = getView(R.id.item_Answer1);
        t2 = getView(R.id.item_Answer2);
        t3 = getView(R.id.item_Answer3);
        t4 = getView(R.id.item_Answer4);
        t5 = getView(R.id.item_Answer5);
        t6 = getView(R.id.item_Answer6);
        rd[0] = getViewAndClick(R.id.rb_1);
        rd[1] = getViewAndClick(R.id.rb_2);
        rd[2] = getViewAndClick(R.id.rb_3);
        rd[3] = getViewAndClick(R.id.rb_4);
        rd[4] = getViewAndClick(R.id.rb_5);
        rd[5] = getViewAndClick(R.id.rb_6);
    }

    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    public void initData() {
        aCache = ACache.get(context);
        if (item.getQuestions_type().equals("单选题")) {
            li5.setVisibility(View.GONE);
            li6.setVisibility(View.GONE);
        } else {
            li5.setVisibility(View.VISIBLE);
            li6.setVisibility(View.VISIBLE);
        }
        Glide.with(context).load(item.getQuestions_img()).into(img);
        item_subject.setText(item.getQuestions());
        t1.setText(item.getAnswer_A());
        t2.setText(item.getAnswer_B());
        t3.setText(item.getAnswer_C());
        t4.setText(item.getAnswer_D());
        t5.setText(item.getAnswer_E());
        t6.setText(item.getAnswer_F());
        backData();
    }
    @Override
    public void requestData() {

    }
    @Override
    public void updateUI() {

    }

    List<String> daan = new ArrayList<>();

    @Override
    public void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.silin1://选中第一个
            case R.id.rb_1:
                if (item.getQuestions_type().equals("单选题")) {
                    RadioChebox(0);
                } else {
                    if (rd[0].isSelected()) {
                        rd[0].setSelected(false);
                        daan.remove("A");
                    } else {
                        daan.add("A");
                        rd[0].setSelected(true);
                    }
                }
                saveAnswer();
                break;
            case R.id.silin2://选中第二个
            case R.id.rb_2:
                if (item.getQuestions_type().equals("单选题")) {
                    RadioChebox(1);
                } else {
                    if (rd[1].isSelected()) {
                        rd[1].setSelected(false);
                        daan.remove("B");
                    } else {
                        daan.add("B");
                        rd[1].setSelected(true);
                    }
                }
                saveAnswer();
                break;
            case R.id.silin3://选中第三个
            case R.id.rb_3:
                if (item.getQuestions_type().equals("单选题")) {
                    RadioChebox(2);
                } else {
                    if (rd[2].isSelected()) {
                        rd[2].setSelected(false);
                        daan.remove("C");
                    } else {
                        daan.add("C");
                        rd[2].setSelected(true);
                    }
                }
                saveAnswer();
                break;
            case R.id.silin4://选中第四个
            case R.id.rb_4:
                if (item.getQuestions_type().equals("单选题")) {
                    RadioChebox(3);
                } else {
                    if (rd[3].isSelected()) {
                        rd[3].setSelected(false);
                        daan.remove("D");
                    } else {
                        daan.add("D");
                        rd[3].setSelected(true);
                    }
                }
                saveAnswer();
                break;
            case R.id.silin5://选中第五个
            case R.id.rb_5:
                if (item.getQuestions_type().equals("单选题")) {
                    RadioChebox(4);
                } else {
                    if (rd[4].isSelected()) {
                        rd[4].setSelected(false);
                        daan.remove("E");
                    } else {
                        daan.add("E");
                        rd[4].setSelected(true);
                    }
                }
                saveAnswer();
                break;
            case R.id.silin6://选中第六个
            case R.id.rb_6:
                if (item.getQuestions_type().equals("单选题")) {
                    RadioChebox(5);
                } else {
                    if (rd[5].isSelected()) {
                        rd[5].setSelected(false);
                        daan.remove("F");
                    } else {
                        daan.add("F");
                        rd[5].setSelected(true);
                    }
                }
                saveAnswer();
                break;
        }
    }

    public void RadioChebox(int indxt) {
        for (int i = 0; i < 4; i++) {
            rd[i].setSelected(false);
        }
        daan.clear();
        rd[indxt].setSelected(true);
        switch (indxt) {
            case 0:
                daan.add("A");
                break;
            case 1:
                daan.add("B");
                break;
            case 2:
                daan.add("C");
                break;
            case 3:
                daan.add("D");
                break;

        }
    }

    String jieguo = "";

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private SimulationTestFragmetBean bean;

    public void saveAnswer() {
        jieguo = "";
        for (int i = 0; i < daan.size(); i++) {
            if (daan.size() == 1) {
                jieguo += daan.get(i);
            } else {
                if (i == (daan.size() - 1)) {
                    jieguo += daan.get(i);
                } else {
                    jieguo += daan.get(i) + ",";
                }
            }
        }
        Debug.e("----结果--" + jieguo);
        if (jieguo.length() > 0) {
            HashMap<String, String> body = new HashMap<>();
            body.put("phone", aCache.getAsString("phone"));
            body.put("token", aCache.getAsString("token"));
            body.put("questions_id", String.valueOf(item.getQuestions_id()));
            body.put("user_answer", jieguo);
            HttpReqest httpReqest = new HttpReqest();
            httpReqest.HttpPost("/online/online_questions_submit/", body, new BackString() {
                @Override
                public void onSuccess(Response<String> response) {
                    Gson gson = new Gson();
                    bean = gson.fromJson(response.body(), SimulationTestFragmetBean.class);
                    if (response.body().contains("null")) {
                        return;
                    }
                    Debug.e("----/online/online_questions_submit/-------" + response.body());
                    String[] str = bean.getData().getUser_answer().split(",");
                    for (int i = 0; i < str.length; i++) {
                        switch (str[i]) {
                            case "A":
                                rd[0].setSelected(true);
                                break;
                            case "B":
                                rd[1].setSelected(true);
                                break;
                            case "C":
                                rd[2].setSelected(true);
                                break;
                            case "D":
                                rd[3].setSelected(true);
                                break;
                            case "E":
                                rd[4].setSelected(true);
                                break;
                            case "F":
                                rd[5].setSelected(true);
                                break;
                        }
                    }

                }

                @Override
                public void onError(Response<String> response) {

                }
            });
        }
    }

    /**
     * 获取当前题是否答过
     */
    public void backData() {
        showLoading();
        HashMap<String, String> body = new HashMap<>();
        body.put("phone", aCache.getAsString("phone"));
        body.put("token", aCache.getAsString("token"));
        body.put("questions_id", String.valueOf(item.getQuestions_id()));
        HttpReqest httpReqest = new HttpReqest();
        httpReqest.HttpPost("/online/online_questions_info/", body, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                showCView();
                Gson gson = new Gson();
                answer = gson.fromJson(response.body(), SimulationTestFragmetAnswerBean.class);
                if (response.body().contains("null")) {
                    return;
                }
                String[] str = answer.getData().getUser_answer().split(",");
                daan.clear();
                for (int i = 0; i < str.length; i++) {
                    switch (str[i]) {
                        case "A":
                            daan.remove("A");
                            rd[0].setSelected(true);
                            daan.add("A");
                            break;
                        case "B":
                            daan.remove("B");
                            rd[1].setSelected(true);
                            daan.add("B");
                            break;
                        case "C":
                            daan.remove("C");
                            rd[2].setSelected(true);
                            daan.add("C");
                            break;
                        case "D":
                            daan.remove("D");
                            rd[3].setSelected(true);
                            daan.add("D");
                            break;
                        case "E":
                            daan.remove("E");
                            rd[4].setSelected(true);
                            daan.add("E");
                            break;
                        case "F":
                            daan.remove("F");
                            rd[5].setSelected(true);
                            daan.add("F");
                            break;
                    }
                }
            }

            @Override
            public void onError(Response<String> response) {
                showCView();
            }
        });

    }
}
