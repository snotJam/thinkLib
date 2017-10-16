package com.aprivate.thinklibrary.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.CompoundButton;

/**
 * Created by sss on 2017/4/20.
 */
public class DrawableUtil {

    /**
     * 设置方形圆角背景
     * @param target            目标view
     * @param radius            圆角半径(如果不需要圆角，传递0)
     * @param strokeWidth       边宽
     * @param strokeColor       边的颜色
     * @param solidColor        填充色
     */
    public static void setRoundRectBackground(View target, float radius, int strokeWidth, int strokeColor,int solidColor){
        GradientDrawable drawable = new GradientDrawable();
        drawable.setCornerRadius(radius);
        drawable.setStroke(strokeWidth, strokeColor);
        drawable.setColor(solidColor);
        target.setBackgroundDrawable(drawable);
    }

    /**
     * 设置复合控件(如checkBox，radioButton)选中和未选中状态时的背景和文字颜色
     * @param context
     * @param target                目标view
     * @param unCheckDrawableRes    未选中背景(可以使xml形式的drawable)
     * @param checkDrawableRes      选中时背景(可以使xml形式的drawable)
     * @param unCheckTextColor      未选中文字颜色(使用R.color形式)
     * @param checkTextColor        选中时颜色(使用R.color形式)
     */
    public static void setCompoundStateStyle(Context context, CompoundButton target,
                                             int unCheckDrawableRes,int checkDrawableRes,
                                             int unCheckTextColor, int checkTextColor){

        int[][] states = new int[][]{new int[]{-android.R.attr.state_checked}, // unchecked
                new int[]{android.R.attr.state_checked}  // checked
        };
        //背景
        StateListDrawable drawable = new StateListDrawable();
        drawable.addState(states[0], context.getResources().getDrawable(unCheckDrawableRes));
        drawable.addState(states[1], context.getResources().getDrawable(checkDrawableRes));
        //文字
        int[] colors = new int[]{context.getResources().getColor(unCheckTextColor), context.getResources().getColor(checkTextColor)};
        ColorStateList colorStateList = new ColorStateList(states, colors);

        target.setBackgroundDrawable(drawable);
        target.setTextColor(colorStateList);
    }


}
