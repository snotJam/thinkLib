package com.aprivate.thinklibrary.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by NewNet on 2017/7/11.
 */
public abstract class BaseSimpleAdapter<T> extends BaseAdapter {
    protected Context mContext;
    protected ArrayList<T> data = new ArrayList<>();

    @Override
    public int getCount() {
        return data.size();
    }

    public void addAll(ArrayList<T> list) {
        data.addAll(list);
        notifyDataSetChanged();
    }

    public void removeAll() {
        data.clear();
        notifyDataSetChanged();
    }

    public void addItem(T obj) {
        data.add(obj);
        notifyDataSetChanged();
    }

    public void updateItem(int pos, T object) {
        data.set(pos, object);
        notifyDataSetChanged();
    }

    @Override
    public T getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public abstract View getView(int position, View convertView, ViewGroup parent);
}
