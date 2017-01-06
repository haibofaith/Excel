package com.simple.excel;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity implements OtherScroll{
    private LinearLayout title_lin;
    private ListView ver_list;
    private ArrayList<String> datas;
    private static ArrayList<MyHorizontalScrollView> mScrollLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mScrollLists = new ArrayList<>();
        title_lin = (LinearLayout) findViewById(R.id.title_lin);
        View v = (View) LayoutInflater.from(this).inflate(R.layout.hor_scroll_item, null);
        v.setBackgroundColor(Color.RED);
        MyHorizontalScrollView mHorScrollView = (MyHorizontalScrollView) v.findViewById(R.id.hor_scrollview);
        mScrollLists.add(mHorScrollView);
        title_lin.addView(v);
        ver_list = (ListView) findViewById(R.id.ver_list);
        datas = new ArrayList<>();
        //假数据
        for (int i = 0; i < 15; i++) {
            datas.add(i + "");
        }
        MyAdapter adapter = new MyAdapter(this,datas,mScrollLists);
        ver_list.setAdapter(adapter);
    }

    //监听自定义MyHorizontalScrollView的滑动，对每一个MyHorizontalScrollView滑动都使其它联动
    @Override
    public void otherItemScroll(int l, int t, int oldl, int oldt) {
        for (MyHorizontalScrollView item:mScrollLists){
            item.scrollTo(l,t);
        }
    }
}
