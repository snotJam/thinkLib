package com.aprivate.thinklibrary.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

/**
 * Created by NewNet on 2017/5/16.
 */
public class NormalDialog extends Dialog {
    private Context mContext;
    private View view;


    public NormalDialog(Context context) {
        super(context);
        mContext = context;
    }

    public NormalDialog(Context context, int themeResId, View resView) {
        super(context, themeResId);
        mContext = context;
        view = resView;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(view);
    }

}
