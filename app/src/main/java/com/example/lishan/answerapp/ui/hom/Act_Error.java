package com.example.lishan.answerapp.ui.hom;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lishan.answerapp.R;
import com.example.lishan.answerapp.adapter.ErrorAdapter;
import com.example.lishan.answerapp.bean.ErrorBean;
import com.example.lishan.answerapp.bean.ErrorChlid;
import com.example.lishan.answerapp.common.BaseAct;
import com.example.lishan.answerapp.view.FullyLinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 错题练习
 * Created by lishan on 2018/2/5.
 */

public class Act_Error extends BaseAct implements ErrorAdapter.onItemBack {
    private RecyclerView myRecylerView;

    @Override
    public int initLayoutId() {
        return R.layout.act_error;
    }
    @Override
    public void initView() {
        hideHeader();
        myRecylerView = getView(R.id.error_myRecyclerview);
        setOnClickListener(R.id.error_back);
    }

    private List<ErrorBean> datas;
    ErrorAdapter adapter;

    @Override
    public void initData() {
        datas = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ErrorBean bean = new ErrorBean();
            if (i == 0) {
                List<ErrorChlid> datas = new ArrayList<>();
                ErrorChlid bean1 = new ErrorChlid();
                datas.add(bean1);
                bean.setDatas(datas);
            } else if (i == 1) {
                List<ErrorChlid> datas = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    ErrorChlid bean1 = new ErrorChlid();
                    datas.add(bean1);
                }
                bean.setDatas(datas);
            }
            datas.add(bean);
        }
        adapter = new ErrorAdapter(this);
        adapter.setDatas(datas);
        adapter.setContext(context);
        FullyLinearLayoutManager manager = new FullyLinearLayoutManager(this);
        myRecylerView.setLayoutManager(manager);
        myRecylerView.setAdapter(adapter);
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
            case R.id.error_back:
                finish();
                break;
        }
    }

    @Override
    public void OnBack(boolean item, int position) {
        if (item) {
            datas.get(position).setDerail(false);
        } else {
            datas.get(position).setDerail(true);
        }
        adapter.notifyDataSetChanged();
    }
}
