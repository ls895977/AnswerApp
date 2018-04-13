package com.example.lishan.answerapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lishan.answerapp.R;
import com.example.lishan.answerapp.bean.HomeBean;
import com.example.lishan.answerapp.bean.RecordBean;
import com.lykj.aextreme.afinal.utils.Debug;

import java.util.List;

/**
 * Created by lishan on 2018/1/27.
 */
public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.MyViewHolder> {
    private Context context;
    public OnBackItem onBackItem;
    private List<RecordBean.DataBean> datas;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context, OnBackItem onBackItem1) {
        this.context = context;
        this.onBackItem = onBackItem1;
    }

    public List<RecordBean.DataBean> getDatas() {
        return datas;
    }

    public void setDatas(List<RecordBean.DataBean> datas) {
        this.datas = datas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder viewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_record, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        RecordBean.DataBean item = datas.get(position);
        holder.fenshu.setText(item.getUser_score());
        holder.myTextView.setText(item.getUnit());
        holder.max.setText("/" + item.getUnit_full());
        holder.itemLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackItem.OnItemBack(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView myTextView, fenshu, max;
        private LinearLayout myLinear, itemLinear;

        public MyViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.record_title);
            myLinear = itemView.findViewById(R.id.item_ll_record);
            fenshu = itemView.findViewById(R.id.record_fsu);
            max = itemView.findViewById(R.id.record_max);
            itemLinear = itemView.findViewById(R.id.item_record);
        }
    }

  public   interface OnBackItem {
        void OnItemBack(int position);
    }

}
