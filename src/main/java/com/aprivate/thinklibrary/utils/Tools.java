package com.aprivate.thinklibrary.utils;

import android.content.Context;
import android.os.Environment;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import me.shenfan.updateapp.UpdateService;

/**
 * Created by NewNet on 2016/4/17.
 */
public class Tools {
    /**
     * 检测SD卡
     * @return
     */
    public static boolean hasSDcard(){
        String state = Environment.getExternalStorageState();
        if(state.equals(Environment.MEDIA_MOUNTED)){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 验证手机号
     * @param phone
     * @return
     */
    public static boolean isMobilePhone(String phone) {//
        Pattern pattern = Pattern
                .compile("^((13[0-9])|(14[5,7])|(15[^4,\\D])|(17[6-8])|(18[0-9]))\\d{8}$");
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    /**
     * 验证密码是否符合6-20位字母和数字的要求
     * @param phone
     * @return
     */
    public static boolean isRightPw(String phone) {
        Pattern pat = Pattern.compile("[\\da-zA-Z]{6,20}");
        Matcher mat = pat.matcher(phone);
        return mat.matches();
    }


    /**
     * "md5"加密
     * @param str
     * @return
     */
    public static String parseStrToMd5L32(String str){
        String reStr = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(str.getBytes());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bytes){
                int bt = b&0xff;
                if (bt < 16){
                    stringBuffer.append(0);
                }
                stringBuffer.append(Integer.toHexString(bt));
            }
            reStr = stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return reStr;
    }

    /**
     * 下载安装apk
     * @param url      下载地址
     * @param context   context
     */
    public static void startDownLoad(String url, Context context){
        UpdateService.Builder.create(url).build(context);
    }
}
