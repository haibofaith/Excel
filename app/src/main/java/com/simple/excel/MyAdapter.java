package com.simple.excel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

/**
 * Created by user on 2017/1/6.
 */

public class MyAdapter extends BaseAdapter {

    private ArrayList<String> datas;
    private Context context;
    private ArrayList<MyHorizontalScrollView> mScrollLists;
    public MyAdapter(Context context, ArrayList<String> datas,ArrayList<MyHorizontalScrollView> mScrollLists) {
        this.context = context;
        this.datas = datas;
        this.mScrollLists = mScrollLists;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            holder = new ViewHolder();
            view = View.inflate(context, R.layout.hor_scroll_item, null);
            holder.myHorizontalScrollView = (MyHorizontalScrollView)view.findViewById(R.id.hor_scrollview);
            //将每一个MyHorizontalScrollView对象引用都添加到一个数组中
            mScrollLists.add((MyHorizontalScrollView) holder.myHorizontalScrollView);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        return view;
    }

    class ViewHolder {
        MyHorizontalScrollView myHorizontalScrollView;
    }

}
