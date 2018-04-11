package com.example.lishan.answerapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.lishan.answerapp.bean.SimulationTestBean;
import com.example.lishan.answerapp.ui.examination.Act_SimulationTest;

/**
 * @author hzc
 * @Description: ViewPager的数据适配器
 */
public class ItemAdapter extends FragmentStatePagerAdapter {
    SimulationTestBean data;

    public ItemAdapter(FragmentManager fm, SimulationTestBean datas) {
        super(fm);
        data = datas;
    }
    @Override
    public Fragment getItem(int arg0) {
        return new SimulationTestFragmet(arg0, data);
    }

    @Override
    public int getCount() {
        return Act_SimulationTest.dataBean.getData().getQuestions().size();
    }


}
