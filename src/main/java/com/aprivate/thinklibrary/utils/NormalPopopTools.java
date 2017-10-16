package com.aprivate.thinklibrary.utils;

import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.PopupWindow;

/**
 * Created by sss on 2017/7/18.
 */
public class NormalPopopTools {

    /**
     * 创建一个基本的popupWindow(点击空白关闭，可获取焦点)
     *
     * @param view
     * @param width
     * @param height
     * @return
     */
    public static PopupWindow createNormalPopup(View view, int width, int height) {
        view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        PopupWindow pw = new PopupWindow(view, width, height);
        pw.setBackgroundDrawable(new BitmapDrawable());
        pw.setOutsideTouchable(true);
        pw.setFocusable(true);
        pw.setClippingEnabled(false);
        return pw;
    }
}
