package com.example.lishan.answerapp.ui.my;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import com.example.lishan.answerapp.R;
import com.example.lishan.answerapp.bean.NickNameBean;
import com.example.lishan.answerapp.common.BaseAct;
import com.example.lishan.answerapp.httppost.BackString;
import com.example.lishan.answerapp.httppost.HttpReqest;
import com.google.gson.Gson;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.lzy.okgo.model.Response;

import java.util.HashMap;

/**
 * 修改昵称
 * Created by lishan on 2018/1/28.
 */

public class Act_Nickname extends BaseAct {
    private EditText edNickname;
    private HttpReqest httpReqest;
    private ACache aCache;
    private Gson gson;

    @Override
    public int initLayoutId() {
        return R.layout.act_nickname;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.nickname_back);
        setOnClickListener(R.id.nickname_commit);
        edNickname = getView(R.id.ed_nickName);
    }

    @Override
    public void initData() {
        httpReqest = new HttpReqest();
        aCache = ACache.get(this);
        gson = new Gson();
        edNickname.setText(aCache.getAsString("nick_name"));
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
            case R.id.nickname_back:
                finish();
                break;
            case R.id.nickname_commit:
                PostNickName();
                break;
        }
    }

    public void PostNickName() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("phone", aCache.getAsString("phone"));
        hashMap.put("token", aCache.getAsString("token"));
        hashMap.put("nick_name", edNickname.getText().toString());
        httpReqest.HttpPost("/user/information/", hashMap, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                Debug.e("---------" + response.body());
                NickNameBean bean = gson.fromJson(response.body(), NickNameBean.class);
                if (bean.getCode() == 200) {
                    aCache.put("nick_name", edNickname.getText().toString());
                    MyToast.show(Act_Nickname.this, bean.getMessgae());
                    // 发送返回数据  key可自己定义，但前后必须一样
                    Intent intent = new Intent();
                    intent.putExtra("key", edNickname.getText().toString());
                    // RESULT_OK 系统定义的int 值 为-1
                    setResult(RESULT_OK, intent);
                    // 关闭当前 Activity
                    finish();
                } else {
                    MyToast.show(Act_Nickname.this, bean.getMessgae());
                }
            }

            @Override
            public void onError(Response<String> response) {

            }
        });

    }
}
