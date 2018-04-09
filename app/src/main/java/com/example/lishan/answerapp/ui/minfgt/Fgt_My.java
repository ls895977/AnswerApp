package com.example.lishan.answerapp.ui.minfgt;

import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lishan.answerapp.R;
import com.example.lishan.answerapp.common.BaseFgt;
import com.example.lishan.answerapp.ui.my.Act_About;
import com.example.lishan.answerapp.ui.my.Act_Account;
import com.example.lishan.answerapp.ui.my.Act_Feedback;
import com.example.lishan.answerapp.ui.my.Act_Information;
import com.example.lishan.answerapp.ui.my.Act_Install;
import com.example.lishan.answerapp.ui.my.Act_MyCollection;
import com.example.lishan.answerapp.ui.my.Act_PersonalCenter;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.view.CircleImageView;

/**
 * 我的
 * Created by lishan on 2018/1/27.
 */

public class Fgt_My extends BaseFgt {
    private de.hdodenhof.circleimageview.CircleImageView myCircle;
    private ACache aCache;
    private TextView nickName, phone;

    @Override
    public void sendMsg(int flag, Object obj) {

    }

    @Override
    public int initLayoutId() {
        return R.layout.fgt_my;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.my_guanyu);
        setOnClickListener(R.id.my_feedback);
        setOnClickListener(R.id.my_install);
        setOnClickListener(R.id.my_personalcenter);
        setOnClickListener(R.id.My_collection);
        setOnClickListener(R.id.myaccount);
        setOnClickListener(R.id.my_information);
        myCircle = getView(R.id.profile_image1);
        nickName = getView(R.id.my_nickName);
        phone = getView(R.id.my_phone);
    }

    @Override
    public void initData() {
        aCache = ACache.get(context);
        Glide.with(context)
                .load(aCache.getAsString("icon"))
                .into(myCircle);
        phone.setText(aCache.getAsString("phone"));
    }

    @Override
    public void requestData() {

    }

    @Override
    public void updateUI() {

    }

    @Override
    public void onStart() {
        super.onStart();
        nickName.setText(aCache.getAsString("nick_name"));
    }

    @Override
    public void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.my_guanyu://关于
                startAct(Act_About.class);
                break;
            case R.id.my_feedback://反馈
                startAct(Act_Feedback.class);
                break;
            case R.id.my_install://设置
                startAct(Act_Install.class);
                break;
            case R.id.my_personalcenter://个人中心
                startAct(Act_PersonalCenter.class);
                break;
            case R.id.My_collection://我的收藏
                startAct(Act_MyCollection.class);
                break;
            case R.id.myaccount://账户管理
                startAct(Act_Account.class);
                break;
            case R.id.my_information://消息
                startAct(Act_Information.class);
                break;
        }
    }
}
