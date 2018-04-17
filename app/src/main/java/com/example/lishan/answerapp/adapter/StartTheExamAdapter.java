package com.example.lishan.answerapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.lishan.answerapp.bean.SimulationTestBean;
import com.example.lishan.answerapp.bean.StartTheExamBean;
import com.example.lishan.answerapp.ui.examination.Act_SimulationTest;
import com.example.lishan.answerapp.ui.hom.Act_StartTheExam;
import com.example.lishan.answerapp.ui.hom.StartTheExamFragmet;

/**
 * @author hzc
 * @Description: ViewPager的数据适配器
 */
public class StartTheExamAdapter extends FragmentStatePagerAdapter {
    StartTheExamBean data;
    String mmc = null;

    public void setOnShow(String mmc1) {
        mmc = mmc1;
    }

    public StartTheExamAdapter(FragmentManager fm, StartTheExamBean datas) {
        super(fm);
        data = datas;
    }

    @Override
    public Fragment getItem(int arg0) {
        StartTheExamFragmet startTheExamFragmet = new StartTheExamFragmet(arg0, data);
        startTheExamFragmet.setOnShow(mmc);
        return startTheExamFragmet;
    }

    @Override
    public int getCount() {
        return Act_StartTheExam.dataBean.getData().getQuestions().size();
    }


}
