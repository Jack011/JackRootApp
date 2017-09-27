package com.jack.rootapp.common.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;

import com.jack.rootapp.base.ThisApplication;

import java.util.Random;

/**
 * 资源工具类
 * Created by Administrator on 2017-09-25.
 */

public class ResUtils {

    private ResUtils()
    {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");

    }


    /**
     * 随机颜色
     */
    public static int randomColor() {
        Random random = new Random();
        int red = random.nextInt(150) + 50;//50-199
        int green = random.nextInt(150) + 50;//50-199
        int blue = random.nextInt(150) + 50;//50-199
        return Color.rgb(red, green, blue);
    }

    /**
     * 获取颜色
     * @param resid
     * @return
     */
    public static int getColor(int resid) {
        return getResoure().getColor(resid);
    }

    /**
     * 获取图片
     * @param resid
     * @return
     */
    public static Drawable getDrawable(int resid) {
        return getResoure().getDrawable(resid);
    }
    public static Resources getResoure() {
        return ThisApplication.getApplication().getResources();
    }
    /**
     *
     * 获取数组资源
     * @param resid
     * @return
     */
    public static String[] getStringArray(int resid) {
        return getResoure().getStringArray(resid);
    }

    /**
     *
     * 获取字符串资源
     * @param resid
     * @return
     */
    public static String getString(int resid) {
        return getResoure().getString(resid);
    }

    /**
     *
     * 获取尺寸资源
     * @param resid
     * @return
     */
    public static float getDimens(int resid) {
        return getResoure().getDimension(resid);
    }


    //private static final String TAG = "ResUtil";

    public static int getLayoutId(Context paramContext, String paramString) {
        return paramContext.getResources().getIdentifier(paramString, "layout", paramContext.getPackageName());
    }
}
