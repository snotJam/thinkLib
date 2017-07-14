package com.aprivate.thinklibrary.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aprivate.thinklibrary.R;
import com.aprivate.thinklibrary.utils.DisplayUtil;

/**
 * Created by NewNet on 2017/7/10.
 */
public class BaseTitleRightView extends LinearLayout {
    private Context mContext;
    private TextView tv_right;
    private ImageView iv_right;

    public BaseTitleRightView(Context context) {
        super(context);
        init(context);
    }

    public BaseTitleRightView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BaseTitleRightView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        View view = LayoutInflater.from(context).inflate(R.layout.view_title_right, this, true);
        iv_right = (ImageView) view.findViewById(R.id.iv_right);
        tv_right = (TextView) view.findViewById(R.id.tv_right);
    }

    /**
     * 设置图片
     *
     * @param width       宽
     * @param height      高
     * @param marginRight 与右边间距
     * @param drawableRes 资源
     * @param scaleType   ScaleType
     */
    public void setImage(int width, int height, int marginRight, int drawableRes, ImageView.ScaleType scaleType) {
        LayoutParams params = (LayoutParams) iv_right.getLayoutParams();
        params.width = DisplayUtil.dip2px(mContext, width);
        params.height = DisplayUtil.dip2px(mContext, height);
        params.setMargins(0, 0, DisplayUtil.dip2px(mContext, marginRight), 0);
        iv_right.setLayoutParams(params);
        iv_right.setImageResource(drawableRes);
        iv_right.setScaleType(scaleType);
    }

    /**
     * 设置文字
     *
     * @param text        内容
     * @param resColor    颜色，R.color.xxx
     * @param marginRight 与图片间距
     * @param size
     */
    public void setText(String text, int marginRight, int resColor, int size) {
        tv_right.setText(text);
        tv_right.setTextColor(getResources().getColor(resColor));
        tv_right.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
        LinearLayout.LayoutParams params = (LayoutParams) tv_right.getLayoutParams();
        params.setMargins(0, 0, DisplayUtil.dip2px(mContext, marginRight), 0);
        tv_right.setLayoutParams(params);
    }


    public TextView getTv_right() {
        return tv_right;
    }

    public ImageView getIv_right() {
        return iv_right;
    }
}
