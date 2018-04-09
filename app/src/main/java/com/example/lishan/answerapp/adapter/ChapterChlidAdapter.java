package com.example.lishan.answerapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lishan.answerapp.R;
import com.example.lishan.answerapp.bean.ErrorChlid;
import com.example.lishan.answerapp.bean.HomeBean;

import java.util.List;

/**
 * Created by lishan on 2018/1/27.
 */

public class ChapterChlidAdapter extends RecyclerView.Adapter<ChapterChlidAdapter.MyViewHolder> {
    private Context context;
    private List<HomeBean.DataBean.UnitBean.SectionBean> datas;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<HomeBean.DataBean.UnitBean.SectionBean> getDatas() {
        return datas;
    }

    public void setDatas(List<HomeBean.DataBean.UnitBean.SectionBean> datas) {
        this.datas = datas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder viewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_chapterchlid, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        HomeBean.DataBean.UnitBean.SectionBean bean = datas.get(position);
        holder.title.setText(bean.getSection());
        holder.num.setText(bean.getSection_man()+"人回答过");
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title, num;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.homechlid_title);
            num = itemView.findViewById(R.id.homechlid_num);
        }
    }
}
