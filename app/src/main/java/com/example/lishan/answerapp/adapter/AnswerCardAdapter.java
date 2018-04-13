package com.example.lishan.answerapp.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lishan.answerapp.R;
import com.example.lishan.answerapp.bean.AnswerCardBean;
import com.lykj.aextreme.afinal.utils.Debug;

import java.util.List;

/**
 * Created by lishan on 2018/2/9.
 */

public class AnswerCardAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private Context mContext;
    private List<AnswerCardBean.DataBean> mDatas;
    private int[] img = new int[]{R.drawable.tv_bodr1, R.drawable.tv_bodr2, R.drawable.tv_bodr3, R.drawable.tv_bodr4};

    public AnswerCardAdapter(Context context, List<AnswerCardBean.DataBean> mDatas) {
        mInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.mDatas = mDatas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    Drawable drawable;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_single_str, parent,
                    false);
            viewHolder = new ViewHolder();
            viewHolder.mTextView = (TextView) convertView
                    .findViewById(R.id.id_tv_title);
            viewHolder.itemRe = convertView.findViewById(R.id.item_single);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        AnswerCardBean.DataBean bean = mDatas.get(position);
         if(bean.getUser_answer()!=null&&bean.getUser_answer().equals(bean.getAnswer())){//正确答案
             choseStatus(2,viewHolder);
         }else if(bean.getUser_answer()==null) {//未选状态
             choseStatus(3,viewHolder);
         }else if(bean.getUser_answer()!=null){
             choseStatus(1,viewHolder);
         }
        viewHolder.itemRe.setBackgroundDrawable(drawable);
        viewHolder.mTextView.setText(String.valueOf(position+1));
        return convertView;
    }

    private final class ViewHolder {
        TextView mTextView;
        RelativeLayout itemRe;
    }

    /**
     * '
     * 设置当前状态
     *
     * @param index
     * @param viewHolder
     */
    public void choseStatus(int index, ViewHolder viewHolder) {
        switch (index) {
            case 1://当前错题
                drawable = mContext.getResources().getDrawable(img[2]);
                viewHolder.mTextView.setTextColor(mContext.getResources().getColor(R.color.app_withe));
                break;
            case 2://对题状态
                drawable = mContext.getResources().getDrawable(img[3]);
                viewHolder.mTextView.setTextColor(mContext.getResources().getColor(R.color.app_withe));
                break;
            case 3://当前状态
                drawable = mContext.getResources().getDrawable(img[1]);
                viewHolder.mTextView.setTextColor(mContext.getResources().getColor(R.color.app_txtcolor));
                break;
            default:
                drawable = mContext.getResources().getDrawable(img[0]);
                viewHolder.mTextView.setTextColor(mContext.getResources().getColor(R.color.app_txtcolor));
                break;
        }
    }
}