package com.example.lishan.answerapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lishan.answerapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lishan on 2018/2/6.
 */

public class RankingListAdapter extends RecyclerView.Adapter<RankingListAdapter.ViewHolder> {

    public void setClickCallBack(ItemClickCallBack clickCallBack) {
        this.clickCallBack = clickCallBack;
    }

    public interface ItemClickCallBack {
        void onItemClick(int pos);
    }

    public ArrayList<String> datas = null;
    private ItemClickCallBack clickCallBack;

    public RankingListAdapter(ArrayList<String> datas) {
        this.datas = datas;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rankinglist, viewGroup, false);
        return new ViewHolder(view);
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
        holder.mTextView.setText(String.valueOf(position + 1));
    }

    //获取数据的数量
    @Override
    public int getItemCount() {
        return datas.size();
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;

        public ViewHolder(View view) {
            super(view);
            mTextView = view.findViewById(R.id.tv_itemRankingList);

        }
    }
}