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
public class BaseTitleLeftView extends LinearLayout {
    private Context mContext;
    private TextView tv_left;
    private ImageView iv_left;

    public BaseTitleLeftView(Context context) {
        super(context);
        init(context);
    }

    public BaseTitleLeftView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BaseTitleLeftView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        View view = LayoutInflater.from(context).inflate(R.layout.view_title_left, this, true);
        tv_left = (TextView) view.findViewById(R.id.tv_left);
        iv_left = (ImageView) view.findViewById(R.id.iv_left);
    }

    /**
     * 设置图片
     *
     * @param width       宽
     * @param height      高
     * @param marginLeft  与左边间距
     * @param drawableRes 资源
     * @param scaleType   ScaleType
     */
    public void setImage(int width, int height, int marginLeft, int drawableRes, ImageView.ScaleType scaleType) {
        LayoutParams params = (LayoutParams) iv_left.getLayoutParams();
        params.width = DisplayUtil.dip2px(mContext, width);
        params.height = DisplayUtil.dip2px(mContext, height);
        params.setMargins(DisplayUtil.dip2px(mContext, marginLeft), 0, 0, 0);
        iv_left.setLayoutParams(params);
        iv_left.setImageResource(drawableRes);
        iv_left.setScaleType(scaleType);
    }

    /**
     * 设置文字
     *
     * @param text       内容
     * @param resColor   颜色，R.color.xxx
     * @param marginLeft 与图片间距
     * @param size
     */
    public void setText(String text, int marginLeft, int resColor, int size) {
        tv_left.setText(text);
        tv_left.setTextColor(getResources().getColor(resColor));
        tv_left.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
        LinearLayout.LayoutParams params = (LayoutParams) tv_left.getLayoutParams();
        params.setMargins(DisplayUtil.dip2px(mContext, marginLeft), 0, 0, 0);
        tv_left.setLayoutParams(params);
    }


    public TextView getTv_left() {
        return tv_left;
    }

    public ImageView getIv_left() {
        return iv_left;
    }

}
