package com.example.lishan.answerapp.view;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

import com.example.lishan.answerapp.R;
import com.lykj.aextreme.afinal.common.BaseDialog;

/**
 * Created by lishan on 2018/2/27.
 */

public class LodingDialog extends BaseDialog {
    public LodingDialog(Context context) {
        super(context);
    }

    @Override
    protected int initLayoutId() {
        return R.layout.dlg_loding;
    }

    @Override
    protected void initWindow() {
        windowDeploy(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, Gravity.CENTER);

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onViewClick(View v) {

    }
}
