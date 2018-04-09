package com.example.lishan.answerapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lishan.answerapp.R;
import com.example.lishan.answerapp.bean.ErrorBean;
import com.example.lishan.answerapp.view.FullyLinearLayoutManager;

import java.util.List;

/**
 * Created by lishan on 2018/2/5.
 */

public class ChapterAdapter   extends RecyclerView.Adapter<ChapterAdapter.MyViewHolder> {
    private Context context;
    private List<ErrorBean> datas;
    private onItemBack onBack;

    public Context getContext() {
        return context;
    }

    public ChapterAdapter(onItemBack onItem) {
        onBack = onItem;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<ErrorBean> getDatas() {
        return datas;
    }

    public void setDatas(List<ErrorBean> datas) {
        this.datas = datas;
    }

    @Override
    public ChapterAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ChapterAdapter.MyViewHolder viewHolder = new ChapterAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_chapter, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ChapterAdapter.MyViewHolder holder, final int position) {
        final ErrorBean bean = datas.get(position);
        if (bean.isDerail()) {//开
            holder.myRecyclerView.setVisibility(View.VISIBLE);
            holder.myImage.setImageResource(R.mipmap.icon_jian);
            if (bean.getDatas()!=null&&bean.getDatas().size() > 0) {
                ChapterChlidAdapter adapter = new ChapterChlidAdapter();
                adapter.setContext(getContext());
//                adapter.setDatas(bean.getDatas());
                holder.myRecyclerView.setAdapter(adapter);
                FullyLinearLayoutManager manager = new FullyLinearLayoutManager(context);
                holder.myRecyclerView.setLayoutManager(manager);
            }
        } else {//关
            holder.myRecyclerView.setVisibility(View.GONE);
            holder.myImage.setImageResource(R.mipmap.icon_add);
        }

        holder.myImage.setOnClickListener(new View.OnClickListener() {
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

        public MyViewHolder(View itemView) {
            super(itemView);
            myRecyclerView = itemView.findViewById(R.id.item_chapterRclv);
            myImage = itemView.findViewById(R.id.item_chapter);
        }
    }

    public interface onItemBack {
        void OnBack(boolean item, int position);
    }
}
