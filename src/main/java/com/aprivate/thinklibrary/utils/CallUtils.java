package com.aprivate.thinklibrary.utils;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

/**
 * 拨打电话
 * 只能在activity中调用，参数为activity
 * Created by NewNet on 2016/7/29.
 */
public class CallUtils {
    private Activity mContext;
    public CallUtils(Context context){
        mContext = (Activity) context;
    }

    public void call(String phoneNum){
        String permission = "android.permission.CALL_PHONE";
        String[] permissionArray = {permission};
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mContext.requestPermissions(permissionArray, 0);
        }


        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(mContext, "权限不足", Toast.LENGTH_SHORT).show();
            return;
        }else {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + phoneNum));
            mContext.startActivity(intent);
        }
    }
}
