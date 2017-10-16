package com.aprivate.thinklibrary.utils;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by NewNet on 2017/7/14.
 */
public class TimeUtils {

    /**
     * 将毫秒转换为时分秒
     *
     * @param millisecond 毫秒数
     * @return
     */
    public static String millisecondToHMS(long millisecond) {
        int hour = (int) (millisecond / 3600000L);
        int minutes = (int) ((millisecond - hour * 3600 * 1000) / 60000L);
        int seconds = (int) ((millisecond - hour * 3600 * 1000 - minutes * 60000) / 1000L);
        return (hour > 9 ? (hour + ":") : ("0" + hour + ":")) + (minutes > 9 ? (minutes + ":") : ("0" + minutes + ":")) + (seconds > 9 ? ("" + seconds) : ("0" + seconds));
    }


    /**
     * 将时间戳转换为普通date时间
     *
     * @param time 时间戳（10位数字）
     * @return
     */
    public static String timestampToDate(long time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return simpleDateFormat.format(new Date(time * 1000L));
    }

    /**
     * 将时分秒转换为毫秒
     *
     * @return
     */
    public static long HMS2Ms(String time) {
        long res = 0;
        int one = time.indexOf(":");
        int two = time.lastIndexOf(":");
        String h = time.substring(0, one);
        String m = time.substring(one, two).replace(":", "");
        String s = time.substring(two, time.length()).replace(":", "");
        res = Integer.valueOf(h) * 3600 + Integer.valueOf(m) * 60 + Integer.valueOf(s);
        return res * 1000;
    }

    /**
     * 将时分秒转换为分秒
     *
     * @param time
     * @return
     */
    public static String HMS2MinS(String time) {
        String res = "";
        int one = time.indexOf(":");
        int two = time.lastIndexOf(":");
        String h = time.substring(0, one);
        String m = time.substring(one, two).replace(":", "");
        String s = time.substring(two, time.length()).replace(":", "");
        int mis = Integer.valueOf(h) * 60 + Integer.valueOf(m);
        String showMis = "";
        if (mis < 10) {
            showMis = "0" + mis;
        } else {
            showMis = mis + "";
        }
        res = showMis + ":" + s;
        return res;
    }

    /**
     * 将分秒转换为毫秒
     *
     * @return
     */
    public static long MS2Ms(String time) {
        long res = 0;
        int one = time.indexOf(":");
        String m = time.substring(0, one);
        String s = time.substring(one, time.length()).replace(":", "");
        res = Integer.valueOf(m) * 60 + Integer.valueOf(s);
        return res * 1000;
    }
}
