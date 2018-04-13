package com.example.lishan.answerapp.ui.examination;

import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.lishan.answerapp.R;
import com.example.lishan.answerapp.adapter.ItemAdapter;
import com.example.lishan.answerapp.bean.PopupBean;
import com.example.lishan.answerapp.bean.SimulationTestBean;
import com.example.lishan.answerapp.bean.popupShowBean;
import com.example.lishan.answerapp.common.BaseAct;
import com.example.lishan.answerapp.dialog.PopupDialog;
import com.example.lishan.answerapp.httppost.BackString;
import com.example.lishan.answerapp.httppost.HttpReqest;
import com.google.gson.Gson;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.lzy.okgo.model.Response;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 模拟考试
 * Created by lishan on 2018/2/6.
 */
public class Act_SimulationTest extends BaseAct implements PopupDialog.OnBackViewClick {
    private TextView num, status, tixing, time, timu, submit;
    private RadioButton[] bt = new RadioButton[4];
    private ACache aCache;
    private LinearLayout myTime;
    private int indext;
    public static SimulationTestBean dataBean;
    private ViewPager myViewPager;
    private PopupDialog dialog;

    @Override
    public int initLayoutId() {
        return R.layout.act_simulationtest1;
    }

    @Override
    public void initView() {
        hideHeader();
        aCache = ACache.get(this);
        setOnClickListener(R.id.SimulationTest_back);
        submit = getViewAndClick(R.id.simulationtest1_sumit);
        num = getView(R.id.simulationtest1_num);
        myTime = getView(R.id.li_time);
        status = getView(R.id.simulationtest1_status);
        myViewPager = getView(R.id.simulationtest1_vp);
        tixing = getView(R.id.simulationtest1_ti);
        time = getView(R.id.simulationtest1_time);
        timu = getView(R.id.simulationtest1_timu);
    }

    private ItemAdapter pagerAdapter;

    @Override
    public void initData() {
        indext = getIntent().getIntExtra("indext", 9);
        SimulationTest();
        submit.setVisibility(View.VISIBLE);//提交按钮
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
            case R.id.simulationtest1_sumit://提交
                Popup();
                break;
        }
    }

    Timer timer;
    int second = 100000;

    private void countDown() {
        time.setText(formatTimeBySecond(second));
        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        time.setText(formatTimeBySecond(second));
                        if (second <= 0) {
                            timer.cancel();
                        }
                        second--;
                    }
                });
            }
        };
        timer.schedule(task, 1000, 1000);
    }

    /**
     * me.tongleer.com
     * 通过秒格式化时间
     *
     * @param s
     * @return
     */
    public static String formatTimeBySecond(Integer s) {
        int hour = 0;
        int minute = 0;
        int second = 0;
        second = s;
        if (second > 60) {
            minute = second / 60;
            second = second % 60;
        }
        if (minute > 60) {
            hour = minute / 60;
            minute = minute % 60;
        }
        String strtime = hour + "：" + minute + "：" + second;
        return strtime;
    }

    /**
     * 弹窗访问接口
     */
    String str = "";

    public void Popup() {
        str = "";
        HttpReqest httpReqest = new HttpReqest();
        HashMap<String, String> body = new HashMap<>();
        body.put("phone", aCache.getAsString("phone"));
        body.put("token", aCache.getAsString("token"));
        httpReqest.HttpPost("/online/online_unit_submit_one/", body, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                Debug.e("-----" + response.body());
                Gson gson = new Gson();
                PopupBean bean = gson.fromJson(response.body(), PopupBean.class);
                if (bean.getData() != null) {
                    for (int i = 0; i < bean.getData().getWithoutArr().size(); i++) {
                        str += bean.getData().getWithoutArr().get(i) + ",";
                    }
                }
                dialog = new PopupDialog(context);
                dialog.setMessage(bean.getMessgae() + "\n" + bean.getData().getWithoutArr(), Act_SimulationTest.this);
                dialog.show();
            }

            @Override
            public void onError(Response<String> response) {

            }
        });
    }

    /**
     * dialog弹窗问题
     */
    @Override
    public void onCenter() {
        showCenter();
    }

    public void showCenter() {
        HttpReqest httpReqest = new HttpReqest();
        HashMap<String, String> body = new HashMap<>();
        body.put("phone", aCache.getAsString("phone"));
        body.put("token", aCache.getAsString("token"));
        httpReqest.HttpPost("/online/online_unit_submit_two/", body, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                Debug.e("--//////---" + response.body());
                Gson gson = new Gson();
                popupShowBean bean = gson.fromJson(response.body(), popupShowBean.class);
                MyToast.show(context, bean.getMessgae());
                dialog.dismiss();
                finish();
            }

            @Override
            public void onError(Response<String> response) {

            }
        });
    }

    /**
     * 模拟考试初始化数据
     */
    public void SimulationTest() {
        dataBean = (SimulationTestBean) getIntent().getSerializableExtra("databen");
        status.setText("模拟考试");
        myTime.setVisibility(View.VISIBLE);
        num.setText(1 + "/" + dataBean.getData().getQuestions().size());
        timu.setText(dataBean.getData().getQuestions().get(0).getQuestions_id() + "号题目:");
        tixing.setText(dataBean.getData().getQuestions().get(0).getQuestions_type());
        pagerAdapter = new ItemAdapter(getSupportFragmentManager(), dataBean);
        myViewPager.setCurrentItem(0);
        myViewPager.setAdapter(pagerAdapter);
        myViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                num.setText((arg0 + 1) + "/" + dataBean.getData().getQuestions().size());
                if ((arg0 + 1) <= dataBean.getData().getQuestions().size())
                    timu.setText(dataBean.getData().getQuestions().get(arg0).getQuestions_id() + "号题目:");
                tixing.setText(dataBean.getData().getQuestions().get(arg0).getQuestions_type());
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int position) {

            }
        });
        countDown();
    }
}
