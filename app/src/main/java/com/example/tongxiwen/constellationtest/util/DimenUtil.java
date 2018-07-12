package com.example.tongxiwen.constellationtest.util;

import android.content.res.Resources;

public class DimenUtil {

    /**
     * 通过dp获取px
     */
    public static int dip2px(int dpValue) {
        int density = (int) Resources.getSystem().getDisplayMetrics().density;
        return dpValue * density;
    }

    /**
     * 通过px获取dp
     */
    public static int px2dip(int pxValue) {
        int density = (int) Resources.getSystem().getDisplayMetrics().density;
        return pxValue / density;
    }
}
