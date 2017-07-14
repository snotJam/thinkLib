package com.aprivate.thinklibrary.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;

/**
 * Created by NewNet on 2017/4/24.
 * 包含下拉上滑的fragment
 */
public abstract class BasePullFragment extends Fragment implements BGARefreshLayout.BGARefreshLayoutDelegate{
    protected BGARefreshLayout bga_refresh;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 进行初始化
     * @param refreshLayout     目标bgaRefresh控件
     */
    protected void initRefreshLayout(BGARefreshLayout refreshLayout){
        this.bga_refresh = refreshLayout;
        bga_refresh.setDelegate(this);
        bga_refresh.setRefreshViewHolder(new BGANormalRefreshViewHolder(getActivity(),true));
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
