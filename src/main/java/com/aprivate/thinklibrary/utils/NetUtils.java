package com.aprivate.thinklibrary.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


/**
 * Created by NewNet on 2016/3/22.
 */
public class NetUtils {

    public static boolean checkNetworkState(Context context){
        boolean state = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if( null != connectivityManager.getActiveNetworkInfo()){
            state = connectivityManager.getActiveNetworkInfo().isAvailable();
        }
        return state;
    }

    public static String checkNetworkType(Context context){
        String type = "";
        boolean state = checkNetworkState(context);
        if(state){
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo.State wifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();
            NetworkInfo.State gprs = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState();

            //连接wifi
            if(wifi == NetworkInfo.State.CONNECTED || wifi == NetworkInfo.State.CONNECTING){
                type = "WIFI";
            }

            //连接gprs
            if(gprs == NetworkInfo.State.CONNECTED || gprs == NetworkInfo.State.CONNECTING){
                type = "GPRS";
            }
        }
        return type;
    }
}
