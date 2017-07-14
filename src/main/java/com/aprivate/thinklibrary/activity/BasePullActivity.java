package com.aprivate.thinklibrary.activity;

import android.support.v4.app.FragmentActivity;

import com.bumptech.glide.Glide;

import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;

/**
 * Created by NewNet on 2017/3/13.
 * 可以执行页面刷新(包含有BGARefresh控件的页面)
 */
public abstract class BasePullActivity extends FragmentActivity implements BGARefreshLayout.BGARefreshLayoutDelegate{
    protected BGARefreshLayout bga_refresh;

    /**
     * 进行初始化
     * @param refreshLayout     目标bgaRefresh控件
     */
    protected void initRefreshLayout(BGARefreshLayout refreshLayout){
        this.bga_refresh = refreshLayout;
        bga_refresh.setDelegate(this);
        bga_refresh.setRefreshViewHolder(new BGANormalRefreshViewHolder(this,true));
    }

    /**
     * 开始执行刷新
     */
    public void beginRefreshing() {
        bga_refresh.beginRefreshing();
    }

    /**
     * 开始执行加载更多
     */
    public void beginLoadingMore() {
        bga_refresh.beginLoadingMore();
    }
}
