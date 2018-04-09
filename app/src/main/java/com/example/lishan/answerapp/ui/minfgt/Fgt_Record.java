package com.example.lishan.answerapp.ui.minfgt;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lishan.answerapp.R;
import com.example.lishan.answerapp.adapter.HomeAdapter;
import com.example.lishan.answerapp.adapter.RecordAdapter;
import com.example.lishan.answerapp.bean.HomeBean;
import com.example.lishan.answerapp.bean.RecordBean;
import com.example.lishan.answerapp.common.BaseFgt;
import com.example.lishan.answerapp.httppost.BackString;
import com.example.lishan.answerapp.httppost.HttpReqest;
import com.example.lishan.answerapp.view.FullyLinearLayoutManager;
import com.google.gson.Gson;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 记录
 * Created by lishan on 2018/1/27.
 */

public class Fgt_Record extends BaseFgt implements BackString {
    private RecyclerView myRecyclerView;
    private HttpReqest httpReqest;
    private ACache aCache;

    @Override
    public void sendMsg(int flag, Object obj) {

    }

    @Override
    public int initLayoutId() {
        return R.layout.fgt_record;
    }

    @Override
    public void initView() {
        hideHeader();
        myRecyclerView = getView(R.id.record_recyclerview);
    }

    List<RecordBean.DataBean> datas;
    private Gson gson;

    @Override
    public void initData() {
        aCache = ACache.get(context);
        gson = new Gson();
        datas = new ArrayList<>();
        httpReqest = new HttpReqest();
        showLoading();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("phone", aCache.getAsString("phone"));
        hashMap.put("token", aCache.getAsString("token"));
        httpReqest.HttpPost("/online/record_list/", hashMap, this);
        FullyLinearLayoutManager manager = new FullyLinearLayoutManager(context);
        myRecyclerView.setLayoutManager(manager);
    }

    @Override
    public void requestData() {

    }

    @Override
    public void updateUI() {

    }

    @Override
    public void onViewClick(View v) {

    }

    @Override
    public void onSuccess(Response<String> response) {
        RecordBean bean = gson.fromJson(response.body(), RecordBean.class);
        if (bean.getCode() == 200) {
            for (int i = 0; i < bean.getData().size(); i++) {
                RecordBean.DataBean bean1 = bean.getData().get(i);
                datas.add(bean1);
            }
            RecordAdapter adapter = new RecordAdapter();
            adapter.setContext(context);
            adapter.setDatas(datas);
            myRecyclerView.setAdapter(adapter);
        }
        showCView();
    }

    @Override
    public void onError(Response<String> response) {
        showCView();
    }
}
