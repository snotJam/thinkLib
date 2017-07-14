package com.aprivate.thinklibrary.utils;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;

import java.io.File;
import java.math.BigDecimal;

/**
 * Created by sss on 2017/3/22.
 */
public class GlideCacheUtil {
    private static GlideCacheUtil inst;

    public static GlideCacheUtil getInstance() {
        if (inst == null) {
            inst = new GlideCacheUtil();
        }

        return inst;
    }

    /**
     * 获取缓存大小
     *
     * @param context
     * @return
     */
    public String getCacheSize(Context context) {
        try {
            return getFormatSize(getFloaderSize(new File(context.getCacheDir() + "/" + InternalCacheDiskCacheFactory.DEFAULT_DISK_CACHE_DIR)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "0MB";
    }


    /**
     * 清除图片缓存
     *
     * @param context
     */
    public void clearImageAllCache(Context context) {
        clearImageMemoryCache(context);
        clearImageDiskCache(context);
        String ImageExternalCatchDir = context.getExternalCacheDir() + ExternalCacheDiskCacheFactory.DEFAULT_DISK_CACHE_DIR;
        deleteFolderFile(ImageExternalCatchDir, true);
    }

    /**
     * 删除指定目录下缓存的文件
     *
     * @param filePath       指定目录路径
     * @param deleteThisPath 是否删除
     */
    private void deleteFolderFile(String filePath, boolean deleteThisPath) {
        if (!TextUtils.isEmpty(filePath)) {
            try {
                File file = new File(filePath);
                if (file.isDirectory()) {
                    File files[] = file.listFiles();
                    for (File file1 : files) {
                        deleteFolderFile(file1.getAbsolutePath(), true);
                    }
                }
                if (deleteThisPath) {
                    if (!file.isDirectory()) {
                        file.delete();
                    } else {
                        if (file.listFiles().length == 0) {
                            file.delete();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取指定文件大小
     *
     * @param file 指定文件
     * @return
     */
    private long getFloaderSize(File file) {
        long size = 0;
        try {
            File[] fileList = file.listFiles();
            for (File afile : fileList) {
                if (afile.isDirectory()) {
                    size = size + getFloaderSize(afile);
                } else {
                    size = size + afile.length();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return size;
    }

    /**
     * 获取格式化单位后的size
     *
     * @param size 需要格式化的size，单位为byte
     * @return
     */
    private static String getFormatSize(double size) {
        double kiloByte = size / 1024;

        if (kiloByte < 1) {
            return size + "Byte";
        }

        double megaByte = kiloByte / 2014;
        if (megaByte < 1) {
            BigDecimal res = new BigDecimal(Double.toString(megaByte));
            return res.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "KB";
        }

        double gigaByte = megaByte / 1024;
        if (gigaByte < 1) {
            BigDecimal result2 = new BigDecimal(Double.toString(megaByte));
            return result2.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "MB";
        }

        double teraBytes = gigaByte / 1024;
        if (teraBytes < 1) {
            BigDecimal result3 = new BigDecimal(Double.toString(gigaByte));
            return result3.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "GB";
        }

        BigDecimal result4 = new BigDecimal(teraBytes);
        return result4.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "TB";

    }


    /**
     * 清除内存图片缓存
     *
     * @param context
     */
    private void clearImageMemoryCache(Context context) {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                Glide.get(context).clearMemory();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 清除磁盘缓存
     *
     * @param context
     */
    public void clearImageDiskCache(final Context context) {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.get(context).clearDiskCache();
                    }
                }).start();
            } else {
                Glide.get(context).clearDiskCache();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
