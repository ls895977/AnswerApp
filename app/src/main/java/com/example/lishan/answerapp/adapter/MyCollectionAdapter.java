package com.example.lishan.answerapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lishan.answerapp.R;
import com.example.lishan.answerapp.bean.MyCollectionBean;

import java.util.List;

/**
 * Created by lishan on 2018/1/27.
 */

public class MyCollectionAdapter extends RecyclerView.Adapter<MyCollectionAdapter.MyViewHolder> {
    private Context context;
    private List<MyCollectionBean> datas;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<MyCollectionBean> getDatas() {
        return datas;
    }

    public void setDatas(List<MyCollectionBean> datas) {
        this.datas = datas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder viewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_mycollection, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.item_colletiontv);
        }
    }
}
