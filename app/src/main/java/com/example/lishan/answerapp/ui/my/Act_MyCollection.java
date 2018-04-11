package com.example.lishan.answerapp.ui.my;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.example.lishan.answerapp.R;
import com.example.lishan.answerapp.adapter.HomeAdapter;
import com.example.lishan.answerapp.adapter.MyCollectionAdapter;
import com.example.lishan.answerapp.bean.HomeBean;
import com.example.lishan.answerapp.bean.MyCollectionBean;
import com.example.lishan.answerapp.common.BaseAct;
import com.example.lishan.answerapp.httppost.BackString;
import com.example.lishan.answerapp.httppost.HttpReqest;
import com.example.lishan.answerapp.view.FullyLinearLayoutManager;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 我的收藏
 * Created by lishan on 2018/1/27.
 */

public class Act_MyCollection extends BaseAct implements BackString, HomeAdapter.onItemBack, XRecyclerView.LoadingListener {
    private XRecyclerView mRecyclerView;
    private HttpReqest httpReqest;
    private ACache aCache;
    @Override
    public int initLayoutId() {
        return R.layout.act_mycollection;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.mycollection_back);
        mRecyclerView = getView(R.id.mycollection_xRecyclerView);
        httpReqest = new HttpReqest();
        aCache=ACache.get(this);
    }

    @Override
    public void initData() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        mRecyclerView.setArrowImageView(R.drawable.iconfont_downgrey);
        mRecyclerView
                .getDefaultRefreshHeaderView()
                .setRefreshTimeVisible(true);
        mRecyclerView.setLoadingListener(this);
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
            case R.id.mycollection_back:
                finish();
                break;
        }
    }

    HomeBean bean;
    Gson gson = new Gson();

    @Override
    public void onSuccess(Response<String> response) {
        Debug.e("-------"+response.body());
//        bean = gson.fromJson(response.body(), HomeBean.class);
//        if (bean.getMessgae().equals("成功刷新数据！")) {
//            if (datas.size() == 0) {
//                setData(bean);
//                myAdapter = new HomeAdapter(Act_MyCollection.this);
//                myAdapter.setDatas(datas);
//                myAdapter.setContext(context);
//                mRecyclerView.setAdapter(myAdapter);
//                mRecyclerView.refreshComplete();
//            } else {
//                setData(bean);
//                if (bean.getData().getUnit().size() > 0) {
//                    mRecyclerView.loadMoreComplete();
//                    myAdapter.notifyDataSetChanged();
//                } else {
//                    myAdapter.notifyDataSetChanged();
//                    mRecyclerView.setNoMore(true);
//                }
//            }
//        }
//        showCView();
    }

    @Override
    public void onError(Response<String> response) {

    }

    private List<HomeBean.DataBean.UnitBean> datas = new ArrayList<>();
    HomeAdapter myAdapter;

    public void setData(HomeBean data) {
        for (int i = 0; i < data.getData().getUnit().size(); i++) {
            HomeBean.DataBean.UnitBean bean = data.getData().getUnit().get(i);
            bean.setDerail(false);
            datas.add(bean);
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

    }

    @Override
    public void onRefresh() {
        index = 1;
        datas.clear();
        postData();
    }

    @Override
    public void onLoadMore() {
        index++;
        postData();
    }

    int index = 0;

    public void postData() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("phone", aCache.getAsString("phone"));
        hashMap.put("token",aCache.getAsString("token"));
        hashMap.put("pageNumber", String.valueOf(index));
        HttpReqest myReqest = new HttpReqest();
        myReqest.HttpPost("/exam/collect_list/", hashMap, this);
    }
}
