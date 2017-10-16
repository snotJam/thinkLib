package com.aprivate.thinklibrary.utils;

/**
 * Created by sss on 2016/4/13.
 */
public class MathUtils {

    /**
     * 获取组合数
     * @param all  总个数
     * @param num  要求个数
     * @return
     */
    public static long getCombinationNum(int all, int num) {
        long result = 0;
        if(num == all){
            return 1;
        }else if (num * 2 > all){
            num = all - num;
        }
        result = getLastResult(all,num) / factorial(num);
        return result;
    }

    /**
     * 获取阶乘积
     * @param i
     * @return
     */
    public static int factorial(int i) {
        if (i < 0) {
            return 0;
        } else if (i == 1) {
            return 1;
        } else {
            return i * factorial(i - 1);
        }
    }

    /**
     * 被获取组合数用到
     * @param all
     * @param min
     * @return
     */
    public static long getLastResult(int all,int min){
        long result = all;
        for (int i = all; i > (all-min+1); i--) {
            result = result*(i-1);
        }
        return result;
    }

}
