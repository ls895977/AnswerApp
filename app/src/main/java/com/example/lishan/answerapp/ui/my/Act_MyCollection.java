package com.example.lishan.answerapp.ui.my;

import android.content.Intent;
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
import com.example.lishan.answerapp.ui.hom.Act_MultiplayerExamination;
import com.example.lishan.answerapp.view.FullyLinearLayoutManager;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 我的收藏
 * Created by lishan on 2018/1/27.
 */

public class Act_MyCollection extends BaseAct implements BackString, XRecyclerView.LoadingListener, MyCollectionAdapter.onItemBack {
    private XRecyclerView mRecyclerView;
    private HttpReqest httpReqest;
    private ACache aCache;
    private MyCollectionBean collectionBean;

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
        aCache = ACache.get(this);
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

    Gson gson = new Gson();
    MyCollectionAdapter collectionAdapter;

    @Override
    public void onSuccess(Response<String> response) {
        collectionBean = gson.fromJson(response.body(), MyCollectionBean.class);
        if (response.body().contentEquals("null")) {
            Debug.e("------------------");
            return;
        }
        if (datasBean.size() == 0) {
            setData(collectionBean);
            collectionAdapter = new MyCollectionAdapter(Act_MyCollection.this);
            collectionAdapter.setDatas(datasBean);
            collectionAdapter.setContext(context);
            mRecyclerView.setAdapter(collectionAdapter);
            mRecyclerView.refreshComplete();
        } else {
            setData(collectionBean);
            if (collectionBean.getData().size() > 0) {
                mRecyclerView.loadMoreComplete();
                collectionAdapter.notifyDataSetChanged();
            } else {
                collectionAdapter.notifyDataSetChanged();
                mRecyclerView.setNoMore(true);
            }
        }
        showCView();
    }

    @Override
    public void onError(Response<String> response) {

    }

    private List<MyCollectionBean.DataBean> datasBean = new ArrayList<>();
    HomeAdapter myAdapter;

    public void setData(MyCollectionBean data) {
        for (int i = 0; i < data.getData().size(); i++) {
            MyCollectionBean.DataBean bean = data.getData().get(i);
            datasBean.add(bean);
        }
    }

    @Override
    public void onRefresh() {
        index = 1;
        datasBean = new ArrayList<>();
        postData();
    }

    @Override
    public void onLoadMore() {
        index++;
        postData();
    }

    int index = 1;

    public void postData() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("phone", aCache.getAsString("phone"));
        hashMap.put("token", aCache.getAsString("token"));
        hashMap.put("pageNumber", String.valueOf(index));
        HttpReqest myReqest = new HttpReqest();
        myReqest.HttpPost("/exam/collect_list/", hashMap, this);
    }

    @Override
    public void OnBack(boolean item, int position) {
        if (datasBean.get(position).getSection().size() < 0) {
            return;
        }
        if (datasBean.get(position).isDerail() == true) {
            datasBean.get(position).setDerail(false);
        } else {
            datasBean.get(position).setDerail(true);
        }
        collectionAdapter.notifyDataSetChanged();
    }

    @Override
    public void OnChildrenBackItem(int position, int childrenPosition) {
        Intent intent = new Intent();
        intent.putExtra("position", position);
        intent.putExtra("childrenPosition", childrenPosition);
        HomeBean bean = new HomeBean();
        HomeBean.DataBean.UnitBean unitBean = new HomeBean.DataBean.UnitBean();
        List<HomeBean.DataBean.UnitBean> datas = new ArrayList<>();
        datas.add(unitBean);
        HomeBean.DataBean dataBean = new HomeBean.DataBean();
        dataBean.setUnit(datas);
        bean.setData(dataBean);
        String[] str = datasBean.get(position).getUnit().split("-");
        dataBean.setGroup(str[0]);
        dataBean.setGroup_type(str[1]);
        intent.putExtra("data", bean);
        intent.putExtra("unit", datasBean.get(position).getUnit());
        intent.putExtra("section", datasBean.get(position).getSection().get(childrenPosition).getSection());
        startAct(intent, Act_MultiplayerExamination.class);
    }
}
