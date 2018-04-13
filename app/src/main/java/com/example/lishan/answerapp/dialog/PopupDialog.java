package com.example.lishan.answerapp.dialog;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.lishan.answerapp.R;
import com.lykj.aextreme.afinal.common.BaseDialog;
import com.lykj.aextreme.afinal.utils.Debug;

/**
 * Created by lishan on 2018/4/12.
 */

public class PopupDialog extends BaseDialog {
    public String message;
    private TextView myMessage;
    private OnBackViewClick onBackViewClick;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message, OnBackViewClick onBackViewClick1) {
        this.message = message;
        this.onBackViewClick = onBackViewClick1;
    }

    public PopupDialog(Context context) {
        super(context);
    }

    @Override
    protected int initLayoutId() {
        return R.layout.dlg_popup;
    }

    @Override
    protected void initWindow() {
        windowDeploy(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, Gravity.CENTER);
    }

    @Override
    protected void initView() {
        setOnClickListener(R.id.popup_cancel);
        setOnClickListener(R.id.popup_center);
        myMessage = getView(R.id.popup_message);
    }

    @Override
    protected void initData() {
        Debug.e("-----....-----"+message);
        myMessage.setText(message);
    }

    @Override
    protected void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.popup_cancel://取消
                dismiss();
                break;
            case R.id.popup_center://确定
             onBackViewClick.onCenter();
                break;
        }
    }

    public interface OnBackViewClick {

        void onCenter();
    }
}
