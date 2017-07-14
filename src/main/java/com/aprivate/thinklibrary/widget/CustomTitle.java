package com.aprivate.thinklibrary.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aprivate.thinklibrary.R;

/**
 * Created by NewNet on 2017/7/10.
 */
public class CustomTitle extends LinearLayout {
    private Context mContext;
    private LinearLayout ll_title_layout;
    private LinearLayout ll_left;
    private LinearLayout ll_mid;
    private LinearLayout ll_right;

    public CustomTitle(Context context) {
        super(context);
        init(context);
    }

    public CustomTitle(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomTitle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    /**
     * 初始化，获取部件
     *
     * @param context
     */
    private void init(Context context) {
        mContext = context;
        View view = LayoutInflater.from(context).inflate(R.layout.layout_custom_title, this, true);
        ll_title_layout = (LinearLayout) view.findViewById(R.id.ll_title_layout);
        ll_left = (LinearLayout) view.findViewById(R.id.ll_left);
        ll_mid = (LinearLayout) view.findViewById(R.id.ll_mid);
        ll_right = (LinearLayout) view.findViewById(R.id.ll_right);
    }


    /**
     * 添加纯文字中间标题
     *
     * @param title
     * @param resColor
     * @param size
     */
    public void addOnlyTextMid(String title, int resColor, int size) {
        TextView tv = new TextView(mContext);
        tv.setText(title);
        tv.setTextColor(getResources().getColor(resColor));
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
        ll_mid.removeAllViews();
        ll_mid.addView(tv);
    }

    /**
     * 添加左边view
     *
     * @param view
     */
    public void addLeftView(View view) {
        ll_left.removeAllViews();
        ll_left.addView(view);
    }

    /**
     * 添加中间view
     *
     * @param view
     */
    public void addMidView(View view) {
        ll_mid.removeAllViews();
        ll_mid.addView(view);
    }

    /**
     * 添加右边view
     *
     * @param view
     */
    public void addRightView(View view) {
        ll_right.removeAllViews();
        ll_right.addView(view);
    }
}
