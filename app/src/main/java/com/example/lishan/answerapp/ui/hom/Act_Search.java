package com.example.lishan.answerapp.ui.hom;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lishan.answerapp.R;
import com.example.lishan.answerapp.adapter.SearchAdapter;
import com.example.lishan.answerapp.bean.HomePageBean;
import com.example.lishan.answerapp.common.BaseAct;
import com.example.lishan.answerapp.httppost.BackString;
import com.example.lishan.answerapp.httppost.HttpReqest;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lzy.okgo.model.Response;

import java.util.HashMap;

/**
 * 搜索界面
 * Created by lishan on 2018/2/4.
 */
public class Act_Search extends BaseAct {
    private RecyclerView mRecyclerView;
    private ACache aCache;
    private HomePageBean pageBean;
    private LinearLayout addLinear;
    private LinearLayout mymoRen;
    private EditText ed;
    private String neirong;
    private HttpReqest httpReqest;
    private TextView onSercher;

    @Override
    public int initLayoutId() {
        return R.layout.act_search;
    }

    @Override
    public void initView() {
        hideHeader();
        addLinear = getView(R.id.hader_linearlayout);
        setOnClickListener(R.id.search_back);
        onSercher = getViewAndClick(R.id.search_sousou);
        mymoRen = getView(R.id.search_moren);
        ed = getView(R.id.search_ed);
        mRecyclerView = getView(R.id.search_recyclerview);
        aCache = ACache.get(this);
        pageBean = (HomePageBean) getIntent().getSerializableExtra("person");
    }

    @Override
    public void initData() {
        httpReqest = new HttpReqest();
        mymoRen.setVisibility(View.VISIBLE);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        for (int i = 0; i < pageBean.getData().getHotArr().size(); i++) {
            TextView mytv = new TextView(this);
            Drawable drawableLeft = getResources().getDrawable(
                    R.drawable.boder_hader);
            mytv.setBackgroundDrawable(drawableLeft);
            mytv.setTag(i);
            mytv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int indext= (int) view.getTag();
                    neirong = pageBean.getData().getGroup().get(indext);
                    Intent intent = new Intent();
                    intent.putExtra("neirong", neirong);
                    startAct(intent, Act_SearchSuccess.class);
                }
            });
            mytv.setPadding(20, 10, 20, 10);
            mytv.setText(pageBean.getData().getHotArr().get(i));
            addLinear.addView(mytv);
        }
        SearchAdapter mAdapter = new SearchAdapter(pageBean.getData().getExam().getUnit());
        mAdapter.setClickCallBack(new SearchAdapter.ItemClickCallBack() {
            @Override
            public void onItemClick(int pos) {
                neirong = pageBean.getData().getExam().getUnit().get(pos).getUnit();
                Intent intent = new Intent();
                intent.putExtra("neirong", neirong);
                startAct(intent, Act_SearchSuccess.class);
            }
        });
        mRecyclerView.setAdapter(mAdapter);
        ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                neirong = ed.getText().toString();
//                Intent intent = new Intent();
//                intent.putExtra("neirong", neirong);
//                startAct(intent, Act_SearchSuccess.class);
            }
        });
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
            case R.id.search_back:
                finish();
                break;
            case R.id.search_sousou:
                neirong = ed.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("neirong", neirong);
                startAct(intent, Act_SearchSuccess.class);
                break;
        }
    }

}
