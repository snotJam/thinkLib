package com.aprivate.thinklibrary.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 提供一般操作
 * Created by NewNet on 2016/3/25.
 */
public class SharedPreferenceUtil {
    Context mContext;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private static final String defShareFileName = "config";

    public SharedPreferenceUtil(Context context){
        mContext = context;
        sharedPreferences = mContext.getSharedPreferences(defShareFileName ,mContext.MODE_PRIVATE);
    }

    public SharedPreferenceUtil(Context context,String sharedFileName){
        mContext = context;
        sharedPreferences = mContext.getSharedPreferences(sharedFileName,mContext.MODE_PRIVATE);
    }

    public String getString(String key){
        return sharedPreferences.getString(key,"");
    }

    public boolean getBoolean(String key){
        return sharedPreferences.getBoolean(key,false);
    }

    public boolean getBoolean(String key, boolean def){
        return sharedPreferences.getBoolean(key,def);
    }

    public int getInteger(String key){
        return sharedPreferences.getInt(key,0);
    }

    public String getStringDef(String key, String def){
        return sharedPreferences.getString(key,def);
    }

    public boolean getBooleanDef(String key, boolean def){
        return sharedPreferences.getBoolean(key,def);
    }

    public int getIntegerDef(String key, int def){
        return sharedPreferences.getInt(key,def);
    }

    public void putString(String key, String value){
        editor = sharedPreferences.edit();
        editor.putString(key,value);
        editor.commit();
    }

    public void putBoolean(String key, Boolean value){
        editor = sharedPreferences.edit();
        editor.putBoolean(key,value);
        editor.commit();
    }

    public void putInt(String key, Integer value){
        editor = sharedPreferences.edit();
        editor.putInt(key,value);
        editor.commit();
    }

}
