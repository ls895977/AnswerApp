package com.example.lishan.answerapp.ui;

import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.example.lishan.answerapp.R;
import com.example.lishan.answerapp.common.BaseAct;
import com.example.lishan.answerapp.common.BaseFgt;
import com.example.lishan.answerapp.ui.minfgt.Fgt_Examination;
import com.example.lishan.answerapp.ui.minfgt.Fgt_Home;
import com.example.lishan.answerapp.ui.minfgt.Fgt_My;
import com.example.lishan.answerapp.ui.minfgt.Fgt_Record;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseAct {
    TextView[] title = new TextView[4];
    List<BaseFgt> fgtData = new ArrayList<>();

    @Override
    public int initLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        hideHeader();
        title[0] = getViewAndClick(R.id.tab_home);
        title[1] = getViewAndClick(R.id.tab_Examination);
        title[2] = getViewAndClick(R.id.tab_Record);
        title[3] = getViewAndClick(R.id.tab_My);
        fgtData.add(new Fgt_Home());
        fgtData.add(new Fgt_Examination());
        fgtData.add(new Fgt_Record());
        fgtData.add(new Fgt_My());
        getSupportFragmentManager().beginTransaction().add(R.id.myFrame, fgtData.get(0)).add(R.id.myFrame, fgtData.get(1)).hide(fgtData.get(1)).show(fgtData.get(0)).commit();
        setCurrent(0);
    }

    @Override
    public void initData() {


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
            case R.id.tab_home:
                setCurrent(0);
                break;
            case R.id.tab_Examination:
                setCurrent(1);
                break;
            case R.id.tab_Record:
                setCurrent(2);
                break;
            case R.id.tab_My:
                setCurrent(3);
                break;
        }
    }

    public int currentTabIndex = 0;

    public void setCurrent(int indext) {
        if (currentTabIndex != indext) {
            FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
            trx.hide(fgtData.get(currentTabIndex));
            if (!fgtData.get(indext).isAdded()) {
                trx.add(R.id.myFrame, fgtData.get(indext));
            }
            trx.show(fgtData.get(indext)).commit();
        }
        title[currentTabIndex].setSelected(false);
        title[indext].setSelected(true);
        currentTabIndex = indext;
    }
}
