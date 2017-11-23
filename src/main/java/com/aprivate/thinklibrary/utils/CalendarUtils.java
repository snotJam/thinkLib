package com.aprivate.thinklibrary.utils;

import java.util.Calendar;

/**
 * Created by NewNet on 2017/11/20.
 */

public class CalendarUtils {

    /**
     * 获取传入日历的年份
     *
     * @return
     */
    public static String year(Calendar calendar) {
        return String.valueOf(calendar.get(calendar.YEAR));
    }

    /**
     * 获取传入日历的月份
     *
     * @return
     */
    public static String month(Calendar calendar) {
        int mon = calendar.get(calendar.MONTH) + 1;
        return mon + "";
    }

    /**
     * 获取传入日历的日期
     *
     * @return
     */
    public static String day(Calendar calendar) {
        return String.valueOf(calendar.get(calendar.DAY_OF_MONTH));
    }


    /**
     * 获取传入日历周几
     *
     * @return
     */
    public static String dayOfWeek(Calendar calendar) {
        int we = calendar.get(Calendar.DAY_OF_WEEK);
        String week = "";
        switch (we) {
            case 1:
                week = "星期天";
                break;
            case 2:
                week = "星期一";
                break;
            case 3:
                week = "星期二";
                break;
            case 4:
                week = "星期三";
                break;
            case 5:
                week = "星期四";
                break;
            case 6:
                week = "星期五";
                break;
            case 7:
                week = "星期六";
                break;

        }
        return week;
    }

    /**
     * 设置时间
     *
     * @param year
     * @param month
     * @param date
     * @return
     */
    public static Calendar setCalendar(int year, int month, int date) {
        Calendar cl = Calendar.getInstance();
        cl.set(year, month - 1, date);
        return cl;
    }

    /**
     * 获取当前时间的前一天时间
     *
     * @param cl
     * @return
     */
    public static Calendar getBeforeDay(Calendar cl) {
        int day = cl.get(Calendar.DATE);
        cl.set(Calendar.DATE, day - 1);
        return cl;
    }

    /**
     * 获取当前时间的后一天时间
     *
     * @param cl
     * @return
     */
    public static Calendar getAfterDay(Calendar cl) {
        int day = cl.get(Calendar.DATE);
        cl.set(Calendar.DATE, day + 1);
        return cl;
    }


}
