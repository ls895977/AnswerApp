package com.example.lishan.answerapp.ui.my;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lishan.answerapp.R;
import com.example.lishan.answerapp.adapter.InformationAdapter;
import com.example.lishan.answerapp.adapter.MyCollectionAdapter;
import com.example.lishan.answerapp.bean.InformationBean;
import com.example.lishan.answerapp.bean.MyCollectionBean;
import com.example.lishan.answerapp.common.BaseAct;
import com.example.lishan.answerapp.view.FullyLinearLayoutManager;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 消息
 * Created by lishan on 2018/1/28.
 */

public class Act_Information extends BaseAct {
    private SmartRefreshLayout refreshLayout;
    private RecyclerView myRecyclerview;

    @Override
    public int initLayoutId() {
        return R.layout.act_information;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.information_back);
        refreshLayout = getView(R.id.information_refreshLayout);
        myRecyclerview = getView(R.id.information_RecyclerView);
    }

    @Override
    public void initData() {
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }
        });
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(2000/*,false*/);//传入false表示加载失败
            }
        });
        FullyLinearLayoutManager manager = new FullyLinearLayoutManager(this);
        myRecyclerview.setLayoutManager(manager);


        InformationAdapter adapter = new InformationAdapter();
        List<InformationBean> datas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            InformationBean bean = new InformationBean();
            datas.add(bean);
        }
        adapter.setContext(this);
        adapter.setDatas(datas);
        myRecyclerview.setAdapter(adapter);
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
            case R.id.information_back:
                finish();
                break;
        }
    }
}
