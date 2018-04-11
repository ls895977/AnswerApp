package com.example.lishan.answerapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lishan.answerapp.R;

import java.util.List;

/**
 * Created by lishan on 2018/1/27.
 */

public class ErrorChlidAdapter extends RecyclerView.Adapter<ErrorChlidAdapter.MyViewHolder> {
//    private Context context;
//    private List<ErrorChlid> datas;
//
//    public Context getContext() {
//        return context;
//    }
//
//    public void setContext(Context context) {
//        this.context = context;
//    }
//
//    public List<ErrorChlid> getDatas() {
//        return datas;
//    }
//
//    public void setDatas(List<ErrorChlid> datas) {
//        this.datas = datas;
//    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder viewHolder = new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_errorchlid, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
