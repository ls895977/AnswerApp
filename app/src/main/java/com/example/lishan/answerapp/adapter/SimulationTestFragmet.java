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
import com.example.lishan.answerapp.common.BaseFgt;
import com.lykj.aextreme.afinal.utils.Debug;

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
    public void initData() {
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
            case R.id.silin1://选中第一个
            case R.id.rb_1:
                if (item.getQuestions_type().equals("单选题")) {
                    RadioChebox(0);
                } else {
//                    if()
                }
                break;
            case R.id.silin2://选中第二个
            case R.id.rb_2:
                if (item.getQuestions_type().equals("单选题")) {
                    RadioChebox(1);
                } else {
                }
                break;
            case R.id.silin3://选中第三个
            case R.id.rb_3:
                if (item.getQuestions_type().equals("单选题")) {
                    RadioChebox(2);
                } else {
                }
                break;
            case R.id.silin4://选中第四个
            case R.id.rb_4:
                if (item.getQuestions_type().equals("单选题")) {
                    RadioChebox(3);
                } else {
                }
                break;
            case R.id.silin5://选中第五个
            case R.id.rb_5:
                if (item.getQuestions_type().equals("单选题")) {
                        RadioChebox(4);
                } else {
//                    if()
                }
                break;
            case R.id.silin6://选中第六个
            case R.id.rb_6:
                if (item.getQuestions_type().equals("单选题")) {
                    RadioChebox(5);
                } else {

                }
                break;
        }
    }

    public void RadioChebox(int indxt) {
        for (int i = 0; i < 4; i++) {
            rd[i].setSelected(false);
        }
        rd[indxt].setSelected(true);
    }

}
