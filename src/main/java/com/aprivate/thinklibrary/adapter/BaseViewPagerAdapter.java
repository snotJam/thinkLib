package com.aprivate.thinklibrary.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NewNet on 2017/6/5.
 */
public class BaseViewPagerAdapter extends PagerAdapter {
    private Context mContext;
    private List<View> list = new ArrayList<>();

    public BaseViewPagerAdapter(Context context) {
        mContext = context;
    }

    public BaseViewPagerAdapter(Context context, List<View> viewList) {
        mContext = context;
        list = viewList;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(list.get(position));
        return list.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position));
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
