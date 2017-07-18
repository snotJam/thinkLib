package com.aprivate.thinklibrary.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by NewNet on 2016/3/22.
 */
public class BaseWebView extends WebView {
    WebViewClient client;

    public BaseWebView(Context context) {
        super(context);
    }

    public BaseWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseWebView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public BaseWebView(Context context, AttributeSet attrs, int defStyle, boolean privateBrowsing) {
        super(context, attrs, defStyle, privateBrowsing);
    }

    /**
     * 如果需要监听加载开始和结束，可以用到这个来自定义WebViewClient
     * @param client
     */
    public void setClient(WebViewClient client){
        this.client = client;
    }

    /**
     * 设置支持Js,适配屏幕宽度，不支持缩放
     */
    public void instanceNonZoom(){
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(false);         //是否支持缩放
        settings.setLoadWithOverviewMode(true); //适配屏幕宽度加载
        settings.setUseWideViewPort(true);      //是否适配到屏幕宽度
        if(null != client){
            setWebViewClient(client);
        }else {

            setWebViewClient(new WebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }

            });
        }

    }

    /**
     * 设置基本功能，支持缩放
     */
    public void instanceSupportZoom(){
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);    //支持JS
        settings.setSupportZoom(true);          //支持缩放
        settings.setBuiltInZoomControls(true);  //使用内置缩放机制
        settings.setDisplayZoomControls(false); //是否显示缩放控件

        if(null != client){
            setWebViewClient(client);
        }else {
            setWebViewClient(new WebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }

            });
        }

    }


}
