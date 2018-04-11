package com.example.lishan.answerapp.ui.examination;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.example.lishan.answerapp.R;
import com.example.lishan.answerapp.bean.HomeBean;
import com.example.lishan.answerapp.bean.MultiplayerExaminationBean;
import com.example.lishan.answerapp.common.BaseAct;
import com.example.lishan.answerapp.httppost.BackString;
import com.example.lishan.answerapp.httppost.HttpReqest;
import com.google.gson.Gson;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.lzy.okgo.model.Response;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * 多人考试第二页
 * Created by lishan on 2018/2/6.
 */

public class Act_MultiplayerExamination extends BaseAct {
    private int position, childrenPosition;
    HomeBean bean;
    private TextView title, date, manfen, time, hege, renshu, starTime, xingxi;

    @Override
    public int initLayoutId() {
        return R.layout.act_multiplayerexamination;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.multiplayer_back);
        setOnClickListener(R.id.bt_kaoshi);
        title = getView(R.id.multiplayerexamination_title);//标题
        date = getView(R.id.multiplayerexamination_date);//日期
        manfen = getView(R.id.multiplayerexamination_fenshu);//试卷分数
        time = getView(R.id.multiplayerexamination_time);//考试时间
        hege = getView(R.id.multiplayerexamination_hegefenshu);//合格分数
        renshu = getView(R.id.multiplayerexamination_renshu);//人数
        starTime = getView(R.id.multiplayerexamination_starttime);//开始时间
        xingxi = getView(R.id.multiplayerexamination_unit_info);//考试信息
    }

    @Override
    public void initData() {
        position = getIntent().getIntExtra("position", 100);
        childrenPosition = getIntent().getIntExtra("childrenPosition", 100);
        bean = (HomeBean) getIntent().getSerializableExtra("data");
        showLoading();
        GetData();
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
                if (bean.getData() != null && bean.getData().getUnit().size() > 0) {
                    Intent intent = new Intent();
                    intent.putExtra("indext", 1);
                    startAct(intent, Act_SimulationTest.class);
                } else {
                    MyToast.show(context, "数据获取错误！请重新退出后获取！");
                }
                break;
        }
    }

    Gson gson = new Gson();
    private MultiplayerExaminationBean data;

    public void GetData() {
        HttpReqest httpReqest = new HttpReqest();
        httpReqest.HttpGet("/online/online_Index/", new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                Debug.e(response.body());
                if (response.body().contains("null")) {
                    showCView();
                    return;
                }
                data = gson.fromJson(response.body(), MultiplayerExaminationBean.class);
                showCView();
                title.setText(data.getData().getUnit());
                date.setText(timet(data.getData().getUnit_time()));
                manfen.setText(data.getData().getUnit_full() + "分");
                time.setText(data.getData().getUnit_duration() + "分");
                hege.setText(data.getData().getUnit_pass() + "分");
                renshu.setText("50");
                starTime.setText(getTime(data.getData().getUnit_time()));
                xingxi.setText(data.getData().getUnit_info());
            }

            @Override
            public void onError(Response<String> response) {
                showCView();
            }
        });
    }

    /**
     * 调用此方法输入所要转换的时间戳输入例如（1402733340）输出（"2014年06月14日16:09"）
     *
     * @param time
     * @return
     */
    public static String timet(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy年MM月dd日");
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        int i = Integer.parseInt(time);
        String times = sdr.format(new Date(i * 1000L));
        return times;
    }
    public static String getTime(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("HH:mm");
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        int i = Integer.parseInt(time);
        String times = sdr.format(new Date(i * 1000L));
        return times;
    }
}
