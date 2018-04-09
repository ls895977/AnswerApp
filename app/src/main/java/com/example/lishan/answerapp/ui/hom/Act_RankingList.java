package com.example.lishan.answerapp.ui.hom;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.lishan.answerapp.R;
import com.example.lishan.answerapp.adapter.RankingListAdapter;
import com.example.lishan.answerapp.common.BaseAct;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

/**
 * 排行榜
 * Created by lishan on 2018/2/6.
 */

public class Act_RankingList extends BaseAct {
    private XRecyclerView mRecyclerView;

    @Override
    public int initLayoutId() {
        return R.layout.act_rankinglist;
    }

    @Override
    public void initView() {
        hideHeader();
        mRecyclerView = getView(R.id.rankinglist_recyclerview);
        setOnClickListener(R.id.rankinglis_back);
    }

    private int refreshTime = 0;
    private int times = 0;
    private ArrayList<String> listData;
    RankingListAdapter mAdapter;

    @Override
    public void initData() {
        mAdapter = new RankingListAdapter(listData);
        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                refreshTime++;
                times = 0;
                new Handler().postDelayed(new Runnable() {
                    public void run() {

                        listData.clear();
                        for (int i = 0; i < 15; i++) {
                            listData.add("item" + i + "after " + refreshTime + " times of refresh");
                        }
                        mAdapter.notifyDataSetChanged();
                        mRecyclerView.refreshComplete();
                    }

                }, 1000);            //refresh data here
            }

            @Override
            public void onLoadMore() {
                if (times < 2) {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            for (int i = 0; i < 15; i++) {
                                listData.add("item" + (1 + listData.size()));
                            }
                            mRecyclerView.loadMoreComplete();
                            mAdapter.notifyDataSetChanged();
                        }
                    }, 1000);
                } else {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            for (int i = 0; i < 9; i++) {
                                listData.add("item" + (1 + listData.size()));
                            }
                            mRecyclerView.setNoMore(true);
                            mAdapter.notifyDataSetChanged();
                        }
                    }, 1000);
                }
                times++;
            }
        });

        listData = new ArrayList<String>();
        for (int i = 0; i < 15; i++) {
            listData.add("item" + i);
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new RankingListAdapter(listData);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.refresh();
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
            case R.id.rankinglis_back:
                finish();
                break;
        }
    }
}
