package com.example.lishan.answerapp.ui.hom;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lishan.answerapp.R;
import com.example.lishan.answerapp.adapter.HomeAdapter;
import com.example.lishan.answerapp.bean.HomeBean;
import com.example.lishan.answerapp.common.BaseAct;
import com.example.lishan.answerapp.view.FullyLinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 历年真题
 * Created by lishan on 2018/2/3.
 */

public class Act_Topic extends BaseAct {
    private RecyclerView myRecyclerView;
    @Override
    public int initLayoutId() {
        return R.layout.act_topic;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.topic_back);
        myRecyclerView=getViewAndClick(R.id.topic_recyclerview);
    }

    @Override
    public void initData() {
        List<HomeBean> datas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            HomeBean bean = new HomeBean();
            datas.add(bean);
        }
//        HomeAdapter adapter = new HomeAdapter();
//        adapter.setContext(context);
//        adapter.setDatas(datas);
//        FullyLinearLayoutManager manager = new FullyLinearLayoutManager(context);
//        myRecyclerView.setLayoutManager(manager);
//        myRecyclerView.setAdapter(adapter);
    }

    @Override
    public void requestData() {

    }

    @Override
    public void updateUI() {

    }

    @Override
    public void onViewClick(View v) {
        switch (v.getId()){
            case R.id.topic_back:
                finish();
                break;
        }
    }
}
