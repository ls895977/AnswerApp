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
import com.example.lishan.answerapp.bean.SearchSuccessBean;

import java.util.List;

/**
 * Created by lishan on 2018/1/27.
 */

public class SearchsuccessChlidAdapter extends RecyclerView.Adapter<SearchsuccessChlidAdapter.MyViewHolder> {
    private Context context;
    private List<SearchSuccessBean.DataBean.SectionBean> datas;
    private OnBackChlic onBackChlic;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context, OnBackChlic onBackChlic1) {

        this.context = context;
        this.onBackChlic = onBackChlic1;
    }

    public List<SearchSuccessBean.DataBean.SectionBean> getDatas() {
        return datas;
    }

    public void setDatas(List<SearchSuccessBean.DataBean.SectionBean> datas) {
        this.datas = datas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder viewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_chapterchlid, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        SearchSuccessBean.DataBean.SectionBean bean = datas.get(position);
        holder.title.setText(bean.getSection());
        holder.num.setText(bean.getSection_man() + "人回答过");
        holder.myLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackChlic.onBackChlid(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title, num;
        private LinearLayout myLinear;
        public MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.homechlid_title);
            num = itemView.findViewById(R.id.homechlid_num);
            myLinear=itemView.findViewById(R.id.item_chapterchildItem);
        }
    }

    public interface OnBackChlic {
        void onBackChlid( int position);
    }
}
