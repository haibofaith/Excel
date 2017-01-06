package com.simple.excel;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

/**
 * Created by user on 2017/1/6.
 */

public class MyHorizontalScrollView extends HorizontalScrollView {
    MainActivity activity;

    public MyHorizontalScrollView(Context context) {
        super(context);
        init(context);
    }

    public MyHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        activity = (MainActivity)context;
    }

    //对外公开监听
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        activity.otherItemScroll(l,t,oldl,oldt);
    }

}
