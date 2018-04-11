package com.example.lishan.answerapp.ui.minfgt;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.lishan.answerapp.R;
import com.example.lishan.answerapp.adapter.HomeAdapter;
import com.example.lishan.answerapp.bean.HomeBean;
import com.example.lishan.answerapp.bean.HomePageBean;
import com.example.lishan.answerapp.common.BaseFgt;
import com.example.lishan.answerapp.common.GlideImageLoader;
import com.example.lishan.answerapp.httppost.BackString;
import com.example.lishan.answerapp.httppost.HttpReqest;
import com.example.lishan.answerapp.ui.examination.Act_MultiplayerExamination;
import com.example.lishan.answerapp.ui.hom.Act_Chapter;
import com.example.lishan.answerapp.ui.hom.Act_Error;
import com.example.lishan.answerapp.ui.hom.Act_RankingList;
import com.example.lishan.answerapp.ui.hom.Act_Search;
import com.example.lishan.answerapp.ui.hom.Act_SimulationTest;
import com.example.lishan.answerapp.ui.hom.Act_Topic;
import com.example.lishan.answerapp.view.PopupWindowUtil;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lzy.okgo.model.Response;
import com.sunfusheng.marqueeview.MarqueeView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 首面
 * Created by lishan on 2018/1/27.
 */

public class Fgt_Home extends BaseFgt implements XRecyclerView.LoadingListener, BackString, HomeAdapter.onItemBack, PopupWindowUtil.PopupItem {
    private XRecyclerView mRecyclerView;
    private PopupWindowUtil utils;
    private HttpReqest httpReqest;
    private Gson gson;
    private List<HomeBean.DataBean.UnitBean> datas;
    private Banner myHomeBanner;
    private HomePageBean pageBean;
    private MarqueeView homHaderTitle;
    private TextView home_title;
    private ACache aCache;

    @Override
    public void sendMsg(int flag, Object obj) {

    }

    @Override
    public int initLayoutId() {
        return R.layout.fgt_home;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void initView() {
        hideHeader();
        mRecyclerView = getView(R.id.home_recyclerview);
        myHomeBanner = getView(R.id.home_banner);
        setOnClickListener(R.id.home_down);
        home_title = getView(R.id.home_down);
        setOnClickListener(R.id.home_search);
        httpReqest = new HttpReqest();
        aCache = ACache.get(context);
        httpReqest.HttpGet("/exam/index/", new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                pageBean = gson.fromJson(response.body(), HomePageBean.class);
                if (pageBean.getCode() == 200) {
                    utils = new PopupWindowUtil(context, pageBean.getData().getGroup(), Fgt_Home.this);
                    List<String> usrDatas = new ArrayList<String>();
                    for (int i = 0; i < pageBean.getData().getSlideshow().size(); i++) {
                        usrDatas.add(pageBean.getData().getSlideshow().get(i).getImg());
                    }
                    myHomeBanner.setImages(usrDatas)
                            .setImageLoader(new GlideImageLoader())
                            .start();
                    myHomeBanner.updateBannerStyle(BannerConfig.NOT_INDICATOR);
                    homHaderTitle.startWithList(pageBean.getData().getInfoArr());
                    // 在代码里设置自己的动画
                    homHaderTitle.startWithList(pageBean.getData().getInfoArr(), R.anim.anim_bottom_in, R.anim.anim_top_out);
                }
            }

            @Override
            public void onError(Response<String> response) {
            }
        });
        aCache.put("group", tiaojian);
    }

    HomeAdapter myAdapter;

    @Override
    public void initData() {
        datas = new ArrayList<>();
        gson = new Gson();
        showLoading();
        postData();
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        mRecyclerView.setArrowImageView(R.drawable.iconfont_downgrey);
        mRecyclerView
                .getDefaultRefreshHeaderView()
                .setRefreshTimeVisible(true);
        View header = LayoutInflater.from(context).inflate(R.layout.view_homehader, null);
        myHomeBanner = getView(header, R.id.home_banner);
        setOnClickListener(header, R.id.home_lainxi);
        setOnClickListener(header, R.id.home_kaoshi);
        setOnClickListener(header, R.id.home_zhenti);
        setOnClickListener(header, R.id.home_cuoti);
        homHaderTitle = getView(header, R.id.homeHader_title);
        mRecyclerView.addHeaderView(header);
        mRecyclerView.setLoadingListener(this);
    }

    @Override
    public void requestData() {

    }

    @Override
    public void updateUI() {

    }

    Intent intent = new Intent();

    @Override
    public void onViewClick(View v) {
        intent.putExtra("tiaojian", tiaojian);
        switch (v.getId()) {
            case R.id.home_lainxi://练节练习
                startAct(intent, Act_Chapter.class);
                break;
            case R.id.home_kaoshi://模拟考试
                startAct(intent, Act_SimulationTest.class);
                break;
            case R.id.home_zhenti://历年真题
                startAct(intent, Act_Topic.class);
                break;
            case R.id.home_cuoti://错题练习
                startAct(Act_Error.class);
                break;
            case R.id.home_search://搜索
                Intent intent = new Intent();
                intent.putExtra("person", pageBean);
                startAct(intent, Act_Search.class);
                break;
            case R.id.home_down://下啦
                utils.show(v);
                break;
            case R.id.home_more://更多
                startAct(Act_RankingList.class);
                break;
        }
    }

    private int index = 1;

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

    private String tiaojian = "注册安全工程师";

    public void postData() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("group", tiaojian);
        hashMap.put("group_type", "精选考题");
        hashMap.put("pageNumber", String.valueOf(index));
        HttpReqest myReqest = new HttpReqest();
        myReqest.HttpPost("/exam/paging/", hashMap, this);
    }

    HomeBean bean;

    @Override
    public void onSuccess(Response<String> response) {
        bean = gson.fromJson(response.body(), HomeBean.class);
        if (bean.getMessgae().equals("成功刷新数据！")) {
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
        }
        showCView();
    }

    public void setData(HomeBean data) {
        for (int i = 0; i < data.getData().getUnit().size(); i++) {
            HomeBean.DataBean.UnitBean bean = data.getData().getUnit().get(i);
            bean.setDerail(false);
            datas.add(bean);
        }
    }

    @Override
    public void onError(Response<String> response) {
        showCView();
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
//        Intent intent = new Intent();
//        intent.putExtra("position", position);
//        intent.putExtra("childrenPosition", childrenPosition);
//        intent.putExtra("data", bean);
//        startAct(intent, Act_MultiplayerExamination.class);

    }

    @Override
    public void OnBackpopupItem(int position) {
        utils.dismiss();
        tiaojian = pageBean.getData().getGroup().get(position);
        index = 1;
        datas.clear();
        postData();
        home_title.setText(tiaojian);
        aCache.put("group", tiaojian);
    }
}
