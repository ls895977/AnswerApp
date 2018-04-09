package com.example.lishan.answerapp.ui.hom;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lishan.answerapp.R;
import com.example.lishan.answerapp.adapter.HomeAdapter;
import com.example.lishan.answerapp.adapter.SearchSuccessAdapter;
import com.example.lishan.answerapp.bean.HomeBean;
import com.example.lishan.answerapp.bean.SearchSuccessBean;
import com.example.lishan.answerapp.common.BaseAct;
import com.example.lishan.answerapp.httppost.BackString;
import com.example.lishan.answerapp.httppost.HttpReqest;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 搜索结果页
 * Created by Administrator on 2018/3/14 0014.
 */

public class Act_SearchSuccess extends BaseAct implements BackString, HomeAdapter.onItemBack {
    private HttpReqest httpReqest;
    private RecyclerView mRecyclerView;

    @Override
    public int initLayoutId() {
        return R.layout.act_searchsuccess;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.searchsuccess_back);
        mRecyclerView = getView(R.id.home_SearchSuccess);
    }

    @Override
    public void initData() {
        httpReqest = new HttpReqest();
        gson = new Gson();
        datas = new ArrayList<>();
        neirong = getIntent().getStringExtra("neirong");
        PostSearch();
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        mRecyclerView.setLayoutManager(layoutManager);
//        mRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
//        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
//        mRecyclerView.setArrowImageView(R.drawable.iconfont_downgrey);
//        mRecyclerView
//                .getDefaultRefreshHeaderView()
//                .setRefreshTimeVisible(true);
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
            case R.id.searchsuccess_back:
                finish();
                break;
        }
    }

    String neirong = "";

    public void PostSearch() {
        showLoading();
        datas.clear();
        HashMap<String, String> pear = new HashMap<>();
        pear.put("unit", neirong);
        httpReqest.HttpPost("/exam/fuzzy/", pear, this);
    }

    private SearchSuccessBean searchSuccessBean;
    private Gson gson;
    private List<SearchSuccessBean.DataBean> datas;
    private SearchSuccessAdapter myAdapter;

    @Override
    public void onSuccess(Response<String> response) {
        Debug.e("=-====" + response.body());
        searchSuccessBean = gson.fromJson(response.body(), SearchSuccessBean.class);
        if (searchSuccessBean.getMessgae().equals("查询成功")) {
            if (datas.size() == 0) {
                setData(searchSuccessBean);
                myAdapter = new SearchSuccessAdapter(this);
                myAdapter.setDatas(datas);
                myAdapter.setContext(context);
                Debug.e("-----------" + datas.size());
                mRecyclerView.setAdapter(myAdapter);
            } else {
//                setData(searchSuccessBean);
//                if (searchSuccessBean.getData().getUnit().size() > 0) {
//                    mRecyclerView.loadMoreComplete();
//                    myAdapter.notifyDataSetChanged();
//                } else {
//                    myAdapter.notifyDataSetChanged();
//                    mRecyclerView.setNoMore(true);
//                }
            }
        }
        showCView();

    }

    public void setData(SearchSuccessBean data) {
        for (int i = 0; i < data.getData().size(); i++) {
            SearchSuccessBean.DataBean bean = data.getData().get(i);
            bean.setIskaiguan(false);
            datas.add(bean);
        }
    }

    @Override
    public void onError(Response<String> response) {

    }

    @Override
    public void OnBack(boolean item, int position) {
        if (datas.get(position).getSection().size() < 0) {
            return;
        }
        if (datas.get(position).isIskaiguan() == true) {
            datas.get(position).setIskaiguan(false);
        } else {
            datas.get(position).setIskaiguan(true);
        }
        myAdapter.notifyDataSetChanged();
    }
}
