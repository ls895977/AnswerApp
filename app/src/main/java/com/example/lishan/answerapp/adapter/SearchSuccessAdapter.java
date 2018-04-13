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
import com.example.lishan.answerapp.bean.HomeBean;
import com.example.lishan.answerapp.bean.SearchSuccessBean;
import com.example.lishan.answerapp.view.FullyLinearLayoutManager;

import java.util.List;

/**
 * Created by Administrator on 2018/3/14 0014.
 */

public class SearchSuccessAdapter extends RecyclerView.Adapter<SearchSuccessAdapter.MyViewHolder> {
    private Context context;
    private List<SearchSuccessBean.DataBean> datas;
    private HomeAdapter.onItemBack onBack;

    public Context getContext() {
        return context;
    }

    public SearchSuccessAdapter(HomeAdapter.onItemBack onBack1) {
        onBack = onBack1;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<SearchSuccessBean.DataBean> getDatas() {
        return datas;
    }

    public void setDatas(List<SearchSuccessBean.DataBean> datas) {
        this.datas = datas;
    }

    @Override
    public SearchSuccessAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        SearchSuccessAdapter.MyViewHolder viewHolder = new SearchSuccessAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_home, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SearchSuccessAdapter.MyViewHolder holder, final int position1) {
        final SearchSuccessBean.DataBean bean = datas.get(position1);
        holder.title.setText(bean.getUnit());
        holder.renshu.setText(bean.getUnit_man() + "人回答过");
        if (bean.isIskaiguan()) {//开
            holder.myRecyclerView.setVisibility(View.VISIBLE);
            holder.myImage.setImageResource(R.mipmap.icon_jian);
            if (bean.getSection().size() > 0) {
                SearchsuccessChlidAdapter adapter = new SearchsuccessChlidAdapter();
                adapter.setContext(getContext(),new SearchsuccessChlidAdapter.OnBackChlic(){
                    @Override
                    public void onBackChlid(int position) {
                        onBack.OnChildrenBackItem(position1,position);
                    }
                });
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
                onBack.OnBack(bean.isIskaiguan(), position1);
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

        void OnChildrenBackItem(int position, int childrenPosition);
    }
}
