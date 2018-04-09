package com.example.lishan.answerapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lishan.answerapp.R;
import com.example.lishan.answerapp.bean.ErrorBean;
import com.example.lishan.answerapp.bean.HomeBean;
import com.example.lishan.answerapp.bean.InformationBean;
import com.example.lishan.answerapp.view.FullyLinearLayoutManager;
import com.lykj.aextreme.afinal.utils.Debug;

import java.util.List;

/**
 * Created by lishan on 2018/1/27.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
    private Context context;
    private List<HomeBean.DataBean.UnitBean> datas;
    private onItemBack onBack;

    public Context getContext() {
        return context;
    }

    public HomeAdapter(onItemBack onBack1) {
        onBack = onBack1;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<HomeBean.DataBean.UnitBean> getDatas() {
        return datas;
    }

    public void setDatas(List<HomeBean.DataBean.UnitBean> datas) {
        this.datas = datas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder viewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_home, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final HomeBean.DataBean.UnitBean bean = datas.get(position);
        holder.title.setText(bean.getUnit());
        holder.renshu.setText(bean.getUnit_man() + "人回答过");
        if (bean.isDerail()) {//开
            holder.myRecyclerView.setVisibility(View.VISIBLE);
            holder.myImage.setImageResource(R.mipmap.icon_jian);
            if (bean.getSection().size() > 0) {
                ChapterChlidAdapter adapter = new ChapterChlidAdapter();
                adapter.setContext(getContext());
                adapter.setDatas(bean.getSection());
                holder.myRecyclerView.setAdapter(adapter);
                FullyLinearLayoutManager manager = new FullyLinearLayoutManager(context);
                holder.myRecyclerView.setLayoutManager(manager);
            }
        } else {//关
            holder.myRecyclerView.setVisibility(View.GONE);
            holder.myImage.setImageResource(R.mipmap.icon_add);
        }

        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBack.OnBack(bean.isDerail(), position);
            }
        });


    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView myRecyclerView;
        private ImageView myImage;
        private TextView renshu, title;
        private RelativeLayout item;

        public MyViewHolder(View itemView) {
            super(itemView);
            myRecyclerView = itemView.findViewById(R.id.item_homechapterRclv);
            myImage = itemView.findViewById(R.id.item_homechapter);
            renshu = itemView.findViewById(R.id.home_dati);
            title = itemView.findViewById(R.id.home_title);
            item = itemView.findViewById(R.id.homeHaderitem);
        }
    }

    public interface onItemBack {
        void OnBack(boolean item, int position);
    }
}
