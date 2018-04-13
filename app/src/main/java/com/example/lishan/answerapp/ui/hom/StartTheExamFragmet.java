package com.example.lishan.answerapp.ui.hom;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lishan.answerapp.R;
import com.example.lishan.answerapp.bean.SimulationTestBean;
import com.example.lishan.answerapp.bean.SimulationTestFragmetAnswerBean;
import com.example.lishan.answerapp.bean.SimulationTestFragmetBean;
import com.example.lishan.answerapp.bean.StartTheExamBean;
import com.example.lishan.answerapp.common.BaseFgt;
import com.example.lishan.answerapp.httppost.BackString;
import com.example.lishan.answerapp.httppost.HttpReqest;
import com.google.gson.Gson;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 答题卡子布局
 * Created by Administrator on 2018/4/11 0011.
 */

@SuppressLint("ValidFragment")
public class StartTheExamFragmet extends BaseFgt {
    private int indxt;
    private TextView item_subject, t1, t2, t3, t4, t5, t6, cuowu, zhengque,msg;
    private StartTheExamBean.DataBean.QuestionsBean item;
    private StartTheExamBean dataBean;
    private ImageView img;
    private LinearLayout li1, li2, li3, li4, li5, li6;
    private TextView[] rd = new TextView[6];
    private ACache aCache;
    SimulationTestFragmetAnswerBean answer;
    private LinearLayout myLiner;//是否显示答案解析

    @SuppressLint("ValidFragment")
    public StartTheExamFragmet(int indxt1, StartTheExamBean dataBean1) {
        this.indxt = indxt1;
        this.dataBean = dataBean1;
        item = dataBean1.getData().getQuestions().get(indxt1);

    }

    @Override
    public void sendMsg(int flag, Object obj) {

    }

    @Override
    public int initLayoutId() {
        return R.layout.fgt_starttheexam;
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
        setOnClickListener(R.id.sumit_daan);
        cuowu = getView(R.id.Wrong_answer);//错误答案
        zhengque = getView(R.id.right_key);//正确答案
        myLiner = getView(R.id.chose_daan);//答案解析
        msg=getView(R.id.simulationtest_daan);//查看解析
        myLiner.setVisibility(View.GONE);
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
        t5.setText(String.valueOf(item.getAnswer_E()));
        t6.setText(String.valueOf(item.getAnswer_F()));
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
                show_jiexi("A");
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
                show_jiexi("B");
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
                show_jiexi("C");
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
                show_jiexi("D");
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
                show_jiexi("E");
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
                show_jiexi("F");
                break;
            case R.id.sumit_daan://提交并查看答案
                show_jiexi("");
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

    /**
     * 显示答案解析
     */
    public void show_jiexi(String cuoti) {
        myLiner.setVisibility(View.VISIBLE);
        cuowu.setText(cuoti);
        zhengque.setText(dataBean.getData().getQuestions().get(indxt).getAnswer());
        msg.setText(dataBean.getData().getQuestions().get(indxt).getAnswer_info());
    }
}
