package com.example.lishan.answerapp.ui.minfgt;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lishan.answerapp.R;
import com.example.lishan.answerapp.bean.MultiplayerExaminationBean;
import com.example.lishan.answerapp.bean.SimulationTestBean;
import com.example.lishan.answerapp.common.BaseFgt;
import com.example.lishan.answerapp.httppost.BackString;
import com.example.lishan.answerapp.httppost.HttpReqest;
import com.example.lishan.answerapp.ui.examination.Act_SimulationTest;
import com.google.gson.Gson;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.lzy.okgo.model.Response;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * 考试
 * Created by lishan on 2018/1/27.
 */

public class Fgt_Examination extends BaseFgt {
    private TextView title, dateTime, time, fenshu, jige;
    private EditText pwd;
    private ACache aCache;

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
        title = getView(R.id.examination_title);
        dateTime = getView(R.id.examination_dateTime);
        time = getView(R.id.examination_time);
        fenshu = getView(R.id.examination_startfenshu);
        jige = getView(R.id.examination_jiege);
        pwd = getView(R.id.examination_pwd);
        aCache = ACache.get(context);
    }

    @Override
    public void initData() {
        showLoading();
    }

    @Override
    public void onStart() {
        super.onStart();
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
            case R.id.examination_bt:
                PostStartKaoShi();
//                startAct(Act_MultiplayerExamination.class);
                break;
        }
    }

    private MultiplayerExaminationBean data;

    /**
     * 获取考试界面信息
     */
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
                title.setText(data.getData().getUnit());
                dateTime.setText(timet(data.getData().getUnit_time()));
                time.setText(data.getData().getUnit_duration() + "分");
                fenshu.setText(data.getData().getUnit_full() + "分");
                jige.setText(data.getData().getUnit_pass() + "分");
                showCView();
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
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
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

    /**
     * 开始考试数据获取判读
     */
    SimulationTestBean databen;
    Gson gson = new Gson();

    public void PostStartKaoShi() {
        showLoading();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("phone", aCache.getAsString("phone"));
        Debug.e("phone====" + aCache.getAsString("phone"));
        hashMap.put("token", aCache.getAsString("token"));
        Debug.e("token====" + aCache.getAsString("token"));
        hashMap.put("password", pwd.getText().toString());
        HttpReqest myReqest = new HttpReqest();
        myReqest.HttpPost("/online/online_start/", hashMap, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                showCView();
                databen = gson.fromJson(response.body(), SimulationTestBean.class);
                if (databen.getData() == null) {
                    MyToast.show(context, databen.getMessgae());
                    return;
                }
                Debug.e(response.body());
                Intent intent = new Intent();
                intent.putExtra("indext", 0);
                intent.putExtra("databen", databen);
                startAct(intent, Act_SimulationTest.class);
            }

            @Override
            public void onError(Response<String> response) {
                showCView();
            }
        });
    }
}
