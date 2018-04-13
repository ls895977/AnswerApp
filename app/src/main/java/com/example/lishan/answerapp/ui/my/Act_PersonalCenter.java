package com.example.lishan.answerapp.ui.my;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;
import com.bumptech.glide.Glide;
import com.example.lishan.answerapp.R;
import com.example.lishan.answerapp.bean.JsonBean;
import com.example.lishan.answerapp.bean.PersonalCenterBean;
import com.example.lishan.answerapp.bean.SexBean;
import com.example.lishan.answerapp.common.BaseAct;
import com.example.lishan.answerapp.common.GetJsonDataUtil;
import com.example.lishan.answerapp.dialog.Dlg_PhotoAlbum;
import com.example.lishan.answerapp.dialog.SexDialog;
import com.example.lishan.answerapp.httppost.BackString;
import com.example.lishan.answerapp.httppost.HttpReqest;
import com.example.lishan.answerapp.ui.MainActivity;
import com.google.gson.Gson;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.lykj.aextreme.afinal.view.CircleImageView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

import org.json.JSONArray;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import static android.media.MediaRecorder.VideoSource.CAMERA;
import static android.provider.MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI;

/**
 * 个人中心
 * Created by lishan on 2018/1/27.
 */

public class Act_PersonalCenter extends BaseAct implements SexDialog.OnBackSex, Dlg_PhotoAlbum.OnClick {
    private SexDialog dialog;
    private HttpReqest httpReqest;
    private ACache aCache;
    private Gson gson;
    private TextView sex, nickName, data, addr, jianjie;
    private ArrayList<JsonBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();
    private Thread thread;
    private int stats;
    Dlg_PhotoAlbum photo;
    de.hdodenhof.circleimageview.CircleImageView myHaderImage;

    @Override
    public int initLayoutId() {
        return R.layout.act_personalcenter;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.personalcenter_back);
        setOnClickListener(R.id.personalcenter_sex);
        setOnClickListener(R.id.nickname2);
        setOnClickListener(R.id.nickname1);
        setOnClickListener(R.id.personalcenter_addrss);
        sex = getView(R.id.personalcenter_sextv);
        nickName = getView(R.id.personalcenter_nickName);
        setOnClickListener(R.id.personalcenter_data);
        data = getView(R.id.personalcenter_dataTime);
        addr = getView(R.id.personalcenter_addr);
        jianjie = getView(R.id.personalcenter_jianjie);
        photo = new Dlg_PhotoAlbum(this, this);
        aCache = ACache.get(context);
        myHaderImage = getView(R.id.PersonalCenterprofile_image11111);
        Glide.with(context)
                .load(aCache.getAsString("icon"))
                .into(myHaderImage);
    }

    @Override
    public void initData() {
        dialog = new SexDialog(this, this);
        httpReqest = new HttpReqest();
        aCache = ACache.get(this);
        gson = new Gson();
        if (aCache.getAsString("gender").equals("")) {
            sex.setText("男");
        } else {
            sex.setText(aCache.getAsString("gender"));
        }
        nickName.setText(aCache.getAsString("nick_name"));

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // 写子线程中的操作,解析省市区数据
                initJsonData();
            }
        });
        thread.start();
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
            case R.id.personalcenter_back:
                finish();
                break;
            case R.id.personalcenter_sex://性别
                dialog.show();
                break;
            case R.id.nickname2://修改昵称
                stats = 1;
                startActivityForResult(Act_Nickname.class, 100);
                break;
            case R.id.nickname1://修改昵称
                photo.show();
                break;
            case R.id.personalcenter_data://日期
                stats = 2;
                TimePickerView pvTime = new TimePickerView.Builder(Act_PersonalCenter.this, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date2, View v) {//选中事件回调
                        birthday = getTime(date2);
                        data.setText(birthday);
                        postMan();
                    }
                })
                        .setType(TimePickerView.Type.YEAR_MONTH_DAY)//默认全部显示
                        .setCancelText("取消")//取消按钮文字
                        .setSubmitText("确定")//确认按钮文字
                        .setContentSize(20)//滚轮文字大小
                        .setTitleSize(20)//标题文字大小
//                        .setTitleText("请选择时间")//标题文字
                        .setOutSideCancelable(true)//点击屏幕，点在控件外部范围时，是否取消显示
                        .isCyclic(true)//是否循环滚动
                        .setTextColorCenter(Color.BLACK)//设置选中项的颜色
                        .setTitleColor(Color.BLACK)//标题文字颜色
                        .setSubmitColor(Color.BLACK)//确定按钮文字颜色
                        .setCancelColor(Color.BLACK)//取消按钮文字颜色
                        .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
//                        .isDialog(true)//是否显示为对话框样式
                        .build();
                pvTime.setDate(Calendar.getInstance());//注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
                pvTime.show();
                break;
            case R.id.personalcenter_addrss:
                stats = 3;
                ShowPickerView();
                break;
        }

    }

    String postManstr = "";

    @Override
    public void OnNan() {
        postManstr = "男";
        postMan();
    }

    @Override
    public void OnNv() {
        postManstr = "女";
        postMan();
    }

    String birthday, province, city;

    public void postMan() {
        HashMap hashMap = new HashMap();
        hashMap.put("phone", aCache.getAsString("phone"));
        hashMap.put("token", aCache.getAsString("token"));
        if (stats == 1) {
            hashMap.put("gender", postManstr);
        } else if (stats == 2) {
            hashMap.put("birthday", birthday);
        } else if (stats == 3) {
            hashMap.put("province", province);
            hashMap.put("city", city);
        }
        httpReqest.HttpPost("/user/information/", hashMap, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                SexBean bean = gson.fromJson(response.body(), SexBean.class);
                if (bean.getCode() == 200) {
                    MyToast.show(Act_PersonalCenter.this, "更新信息成功!");
                    aCache.put("gender", postManstr);
                    sex.setText(postManstr);
                } else {
                    MyToast.show(Act_PersonalCenter.this, "更新信息失败!");
                }
                dialog.dismiss();
            }

            @Override
            public void onError(Response<String> response) {
                dialog.dismiss();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 如果请求码为 sendUser 返回码 为 RESULT_OK RESULT_OK为系统自定义的int值为 -1
        if (requestCode == 100 && resultCode == RESULT_OK) {
            // 在TextView中设置返回信息
            nickName.setText(data.getStringExtra("key"));
        }
        //获取图片路径
        if (requestCode == 1 && resultCode == Activity.RESULT_OK && data != null) {//相册
            Uri selectedImage = data.getData();
            String[] filePathColumns = {MediaStore.Images.Media.DATA};
            Cursor c = getContentResolver().query(selectedImage, filePathColumns, null, null, null);
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(filePathColumns[0]);
            String imagePath = c.getString(columnIndex);
            c.close();
            url = imagePath;
            postFile();
        } else if (requestCode == 55 && resultCode == Activity.RESULT_OK) {//拍照
            url = mOutPutFileUri.getPath();
            postFile();
        }
    }

    public String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }


    private void initJsonData() {//解析数据

        /**
         * 注意：assets 目录下的Json文件仅供参考，实际使用可自行替换文件
         * 关键逻辑在于循环体
         *
         * */
        String JsonData = new GetJsonDataUtil().getJson(this, "province.json");//获取assets目录下的json文件数据

        ArrayList<JsonBean> jsonBean = parseData(JsonData);//用Gson 转成实体

        /**
         * 添加省份数据
         *
         * 注意：如果是添加的JavaBean实体，则实体类需要实现 IPickerViewData 接口，
         * PickerView会通过getPickerViewText方法获取字符串显示出来。
         */
        options1Items = jsonBean;

        for (int i = 0; i < jsonBean.size(); i++) {//遍历省份
            ArrayList<String> CityList = new ArrayList<>();//该省的城市列表（第二级）
            ArrayList<ArrayList<String>> Province_AreaList = new ArrayList<>();//该省的所有地区列表（第三极）

            for (int c = 0; c < jsonBean.get(i).getCityList().size(); c++) {//遍历该省份的所有城市
                String CityName = jsonBean.get(i).getCityList().get(c).getName();
                CityList.add(CityName);//添加城市

                ArrayList<String> City_AreaList = new ArrayList<>();//该城市的所有地区列表

                //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
                if (jsonBean.get(i).getCityList().get(c).getArea() == null
                        || jsonBean.get(i).getCityList().get(c).getArea().size() == 0) {
                    City_AreaList.add("");
                } else {

                    for (int d = 0; d < jsonBean.get(i).getCityList().get(c).getArea().size(); d++) {//该城市对应地区所有数据
                        String AreaName = jsonBean.get(i).getCityList().get(c).getArea().get(d);

                        City_AreaList.add(AreaName);//添加该城市所有地区数据
                    }
                }
                Province_AreaList.add(City_AreaList);//添加该省所有地区数据
            }

            /**
             * 添加城市数据
             */
            options2Items.add(CityList);

            /**
             * 添加地区数据
             */
            options3Items.add(Province_AreaList);
        }
    }


    public ArrayList<JsonBean> parseData(String result) {//Gson 解析
        ArrayList<JsonBean> detail = new ArrayList<>();
        try {
            JSONArray data = new JSONArray(result);
            Gson gson = new Gson();
            for (int i = 0; i < data.length(); i++) {
                JsonBean entity = gson.fromJson(data.optJSONObject(i).toString(), JsonBean.class);
                detail.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return detail;
    }


    private void ShowPickerView() {// 弹出选择器
        OptionsPickerView pvOptions = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String tx = options1Items.get(options1).getPickerViewText() + "，" +
                        options2Items.get(options1).get(options2) + "，" +
                        options3Items.get(options1).get(options2).get(options3);
                province = options1Items.get(options1).getPickerViewText();
                city = options2Items.get(options1).get(options2);
                addr.setText(tx);
                postMan();
            }
        })

                .setTitleText("城市选择")
                .setDividerColor(Color.BLACK)
                .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
                .setContentTextSize(20)
                .build();

        /*pvOptions.setPicker(options1Items);//一级选择器
        pvOptions.setPicker(options1Items, options2Items);//二级选择器*/
        pvOptions.setPicker(options1Items, options2Items, options3Items);//三级选择器
        pvOptions.show();

    }

    @Override
    public void carmer() {
        photo.dismiss();
        applyWritePermission();
    }

    @Override
    public void phonto() {
        photo.dismiss();
        Intent intent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 1);
    }

    private String url;

    public void postFile() {
        HashMap<String, String> body = new HashMap<>();
        body.put("phone", aCache.getAsString("phone"));
        body.put("token", aCache.getAsString("token"));
        httpReqest.HttpPostFils("/user/icon_upload/", body, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                Debug.e("==onSuccess===" + response.body());
                if (response.body() != null) {
                    Gson gson = new Gson();
                    PersonalCenterBean ben = gson.fromJson(response.body(), PersonalCenterBean.class);
                    aCache.put("icon", ben.getData().getIcon());
                    Glide.with(context)
                            .load(aCache.getAsString("icon"))
                            .into(myHaderImage);
                }
            }

            @Override
            public void onError(Response<String> response) {
                Debug.e("======" + response.body());
            }
        }, "img_upload", url);

    }

    /**
     * 使用相机
     */
    private Uri mOutPutFileUri;

    private void useCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/aaaa";
        File path1 = new File(path);
        if (!path1.exists()) {
            path1.mkdirs();
        }
        File file = new File(path1, System.currentTimeMillis() + ".jpg");
        mOutPutFileUri = Uri.fromFile(file);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, mOutPutFileUri);
        startActivityForResult(intent, 55);
    }

    public void applyWritePermission() {
        String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if (Build.VERSION.SDK_INT >= 23) {
            int check = ContextCompat.checkSelfPermission(this, permissions[0]);
            // 权限是否已经 授权 GRANTED---授权  DINIED---拒绝
            if (check == PackageManager.PERMISSION_GRANTED) {
                //调用相机
                useCamera();
            } else {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            }
        } else {
            useCamera();
        }
    }
}
