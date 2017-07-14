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
}
