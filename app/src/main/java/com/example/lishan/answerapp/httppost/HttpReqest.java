package com.example.lishan.answerapp.httppost;

import com.example.lishan.answerapp.common.MyUrl;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.lykj.aextreme.afinal.utils.MyUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.PostRequest;

import org.json.JSONObject;

import java.io.File;
import java.util.Map;

/**
 * Created by lishan on 2018/2/24.
 */

public class HttpReqest {
    private BackString onBack;

    public void HttpPost(String url, Map<String, String> params, BackString onBack1) {
        this.onBack = onBack1;
        JSONObject jsonObject = new JSONObject(params);
        OkGo.<String>post(MyUrl.StBodyUrl + url).params(params, true).tag(this).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                onBack.onSuccess(response);
            }

            @Override
            public void onError(Response<String> response) {
                onBack.onError(response);
            }
        });
    }

    public void HttpGet(String url, BackString onBack1) {
        this.onBack = onBack1;
        OkGo.<String>get(MyUrl.StBodyUrl + url).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                onBack.onSuccess(response);
            }

            @Override
            public void onError(Response<String> response) {

                onBack.onSuccess(response);
            }
        });

    }

    public void HttpPostFils(String url, Map<String, String> params, final BackString onBack1, String key, String pathh) {
        this.onBack = onBack1;
        Debug.e("-----"+pathh);
        OkGo.<String>post(MyUrl.StBodyUrl +url)
                .tag(this)
                .params(params, true)
                .params(key, new File(pathh)).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                onBack.onSuccess(response);
            }
            @Override
            public void onError(Response<String> response) {

                onBack.onSuccess(response);
            }
        });

    }
}
