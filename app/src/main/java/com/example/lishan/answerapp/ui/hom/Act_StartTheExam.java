package com.example.lishan.answerapp.ui.hom;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.example.lishan.answerapp.R;
import com.example.lishan.answerapp.adapter.ItemAdapter;
import com.example.lishan.answerapp.adapter.StartTheExamAdapter;
import com.example.lishan.answerapp.bean.SimulationTestBean;
import com.example.lishan.answerapp.bean.StartTheExamBean;
import com.example.lishan.answerapp.bean.collectBean;
import com.example.lishan.answerapp.httppost.BackString;
import com.example.lishan.answerapp.httppost.HttpReqest;
import com.google.gson.Gson;
import com.lykj.aextreme.afinal.common.BaseActivity;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.lzy.okgo.model.Response;

import java.util.HashMap;


/**
 * 开如考试进入考试
 * Created by lishan on 2018/4/12.
 */
public class Act_StartTheExam extends BaseActivity {
    public static StartTheExamBean dataBean;
    public TextView collec;
    private ViewPager myViewPager;
    private ACache aCache;
    private int indext;
    private String status_A;

    @Override
    public int initLayoutId() {
        return R.layout.act_starttheexam;
    }

    @Override
    public void initView() {
        hideHeader();
        collec = getViewAndClick(R.id.StartTheExam_Collec);
        setOnClickListener(R.id.StartTheExam_back1);
        num = getView(R.id.StartTheExam_num);
        status = getView(R.id.StartTheExam_num);
        myViewPager = getView(R.id.StartTheExam_vp);
        tixing = getView(R.id.StartTheExam_ti);
        timu = getView(R.id.StartTheExam_timu);
        aCache = ACache.get(context);
    }

    @Override
    public void initData() {
        SimulationTest();
        collect_state(indext);
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
            case R.id.StartTheExam_Collec://收藏
                if (collec.isSelected()) {
                    CanCleCollect();
                } else {
                    collect();
                }
                break;
            case R.id.StartTheExam_back1:
                finish();
                break;
        }
    }

    /**
     * 模拟考试初始化数据
     */
    private TextView num, status, tixing, time, timu, submit;
    StartTheExamAdapter pagerAdapter;

    public void SimulationTest() {
        dataBean = (StartTheExamBean) getIntent().getSerializableExtra("data");
        timu.setText(dataBean.getData().getQuestions().get(0).getQuestions_id() + "号题目:");
        tixing.setText(dataBean.getData().getQuestions().get(0).getQuestions_type());
        pagerAdapter = new StartTheExamAdapter(getSupportFragmentManager(), dataBean);
        myViewPager.setCurrentItem(0);
        myViewPager.setAdapter(pagerAdapter);
        myViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int arg0) {
                num.setText((arg0 + 1) + "/" + dataBean.getData().getQuestions().size());
                if ((arg0 + 1) <= dataBean.getData().getQuestions().size())
                    timu.setText(dataBean.getData().getQuestions().get(arg0).getQuestions_id() + "号题目:");
                tixing.setText(dataBean.getData().getQuestions().get(arg0).getQuestions_type());
                indext = arg0;
                collect_state(arg0);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int position) {

            }
        });
        if (getIntent().getStringExtra("status_A") != null && getIntent().getStringExtra("status_A").equals("1")) {
            collec.setVisibility(View.GONE);
            int indext;
            indext = getIntent().getIntExtra("indext",100);
            num.setText((indext+1) + "/" + dataBean.getData().getQuestions().size());
            myViewPager.setCurrentItem(indext);
            pagerAdapter.setOnShow("shi");
        } else {
            collec.setVisibility(View.VISIBLE);
            num.setText(1 + "/" + dataBean.getData().getQuestions().size());
        }
    }

    /**
     * 判断是否收藏该题
     *
     * @param indext
     */
    public void collect_state(int indext) {
        HttpReqest httpReqest = new HttpReqest();
        HashMap<String, String> body = new HashMap<>();
        body.put("phone", aCache.getAsString("phone"));
        body.put("token", aCache.getAsString("token"));
        body.put("question_id", String.valueOf(dataBean.getData().getQuestions().get(indext).getQuestions_id()));
        httpReqest.HttpPost("/exam/collect_info/", body, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                Gson gson = new Gson();
                collectBean ben = gson.fromJson(response.body(), collectBean.class);
                if (ben.getMessgae().contentEquals("还未收藏")) {
                    collec.setSelected(false);
                } else {
                    collec.setSelected(true);
                }
                Debug.e("--collect_state-----" + response.body());
            }

            @Override
            public void onError(Response<String> response) {

            }
        });

    }
    /**
     * 收藏上传
     */
    public void collect() {
        HttpReqest httpReqest = new HttpReqest();
        HashMap<String, String> body = new HashMap<>();
        body.put("phone", aCache.getAsString("phone"));
        body.put("token", aCache.getAsString("token"));
        body.put("question_id", String.valueOf(dataBean.getData().getQuestions().get(indext).getQuestions_id()));
        httpReqest.HttpPost("/exam/collect_submit/", body, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                Gson gson = new Gson();
                collectBean ben = gson.fromJson(response.body(), collectBean.class);
                if (ben.getMessgae().contentEquals("收藏成功")) {
                    collec.setSelected(true);
                    MyToast.show(context, ben.getMessgae());
                }

            }

            @Override
            public void onError(Response<String> response) {

            }
        });
    }

    /**
     * 取消收藏
     */
    public void CanCleCollect() {
        HttpReqest httpReqest = new HttpReqest();
        HashMap<String, String> body = new HashMap<>();
        body.put("phone", aCache.getAsString("phone"));
        body.put("token", aCache.getAsString("token"));
        body.put("question_id", String.valueOf(dataBean.getData().getQuestions().get(indext).getQuestions_id()));
        httpReqest.HttpPost("/exam/collect_off/", body, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                Gson gson = new Gson();
                collectBean ben = gson.fromJson(response.body(), collectBean.class);
                if (ben.getMessgae().contentEquals("删除成功")) {
                    collec.setSelected(false);
                    MyToast.show(context, ben.getMessgae());
                }
            }

            @Override
            public void onError(Response<String> response) {

            }
        });
    }
}
