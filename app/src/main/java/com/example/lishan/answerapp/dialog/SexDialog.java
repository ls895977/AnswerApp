package com.example.lishan.answerapp.dialog;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

import com.example.lishan.answerapp.R;
import com.lykj.aextreme.afinal.common.BaseDialog;

/**
 * 性别选择
 * Created by lishan on 2018/1/27.
 */

public class SexDialog extends BaseDialog {
    private OnBackSex onBackSex;

    public SexDialog(Context context, OnBackSex onBackSex1) {
        super(context);
        this.onBackSex = onBackSex1;
    }

    @Override
    protected int initLayoutId() {
        return R.layout.dlg_sex;
    }

    @Override
    protected void initWindow() {
        windowDeploy(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, Gravity.CENTER);
    }

    @Override
    protected void initView() {
        setOnClickListener(R.id.sex_female);
        setOnClickListener(R.id.sex_male);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.sex_female://选择女
                onBackSex.OnNv();
                break;
            case R.id.sex_male://选择男
                onBackSex.OnNan();
                break;
        }
    }

  public   interface OnBackSex {
        void OnNan();

        void OnNv();
    }

}
