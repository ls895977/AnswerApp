package com.example.lishan.answerapp.ui.hom;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.example.lishan.answerapp.R;
import com.example.lishan.answerapp.adapter.HomeAdapter;
import com.example.lishan.answerapp.bean.HomeBean;
import com.example.lishan.answerapp.common.BaseAct;
import com.example.lishan.answerapp.httppost.BackString;
import com.example.lishan.answerapp.httppost.HttpReqest;
import com.example.lishan.answerapp.view.PopupWindowUtil;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 章节练习
 * Created by lishan on 2018/2/5.
 */
public class Act_Chapter extends BaseAct implements BackString, HomeAdapter.onItemBack, PopupWindowUtil.PopupItem {
    private String tiaojian;
    private XRecyclerView mRecyclerView;
    private PopupWindowUtil utils;
    private HttpReqest httpReqest;
    private Gson gson;
    private List<HomeBean.DataBean.UnitBean> datas;
    private TextView home_title;
    private ACache aCache;

    @Override
    public int initLayoutId() {
        return R.layout.act_chapter;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.chapter_back);
        mRecyclerView = getView(R.id.Chapter_myRecyclerview);
        datas = new ArrayList<>();
        gson = new Gson();
    }

    @Override
    public void initData() {
        tiaojian = getIntent().getStringExtra("tiaojian");
        showLoading();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setLoadingMoreEnabled(false);
        mRecyclerView.setPullRefreshEnabled(false);
        postData();
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
            case R.id.chapter_back:
                finish();
                break;
        }
    }

    @Override
    public void OnBack(boolean item, int position) {
        if (datas.get(position).getSection().size() < 0) {
            return;
        }
        if (datas.get(position).isDerail() == true) {
            datas.get(position).setDerail(false);
        } else {
            datas.get(position).setDerail(true);
        }
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void OnChildrenBackItem(int position, int childrenPosition) {
        Intent intent = new Intent();
        intent.putExtra("position", position);
        intent.putExtra("childrenPosition", childrenPosition);
        intent.putExtra("data", bean);
        intent.putExtra("unit", datas.get(position).getUnit());
        intent.putExtra("section", datas.get(position).getSection().get(childrenPosition).getSection());
        startAct(intent, Act_MultiplayerExamination.class);
    }

    public void postData() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("group", tiaojian);
        hashMap.put("group_type", "章节练习");
        HttpReqest myReqest = new HttpReqest();
        myReqest.HttpPost("/exam/group_type/", hashMap, this);
    }

    HomeBean bean;

    HomeAdapter myAdapter;

    @Override
    public void onSuccess(Response<String> response) {
        Debug.e(response.body());
        bean = gson.fromJson(response.body(), HomeBean.class);
        if (datas.size() == 0) {
            setData(bean);
            myAdapter = new HomeAdapter(this);
            myAdapter.setDatas(datas);
            myAdapter.setContext(context);
            mRecyclerView.setAdapter(myAdapter);
            mRecyclerView.refreshComplete();
        } else {
            setData(bean);
            if (bean.getData().getUnit().size() > 0) {
                mRecyclerView.loadMoreComplete();
                myAdapter.notifyDataSetChanged();
            } else {
                myAdapter.notifyDataSetChanged();
                mRecyclerView.setNoMore(true);
            }
        }
        showCView();

    }

    @Override
    public void onError(Response<String> response) {
        showCView();
    }

    int childrenPosition1 = 0;

    @Override
    public void OnBackpopupItem(int position) {

    }

    public void setData(HomeBean data) {
        for (int i = 0; i < data.getData().getUnit().size(); i++) {
            HomeBean.DataBean.UnitBean bean = data.getData().getUnit().get(i);
            bean.setDerail(false);
            datas.add(bean);
        }
    }
}
