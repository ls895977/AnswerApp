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

    public StartTheExamAdapter(FragmentManager fm, StartTheExamBean datas) {
        super(fm);
        data = datas;
    }
    @Override
    public Fragment getItem(int arg0) {
        return new StartTheExamFragmet(arg0, data);
    }

    @Override
    public int getCount() {
        return Act_StartTheExam.dataBean.getData().getQuestions().size();
    }


}
