package com.example.zzz.xinhuarestaurant.util;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import android.view.View;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zzz on 2017/11/13.
 */

public class Util {

    public static final int TEXT_BLACK = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;

    public static final int TEXT_WHITE = View.SYSTEM_UI_FLAG_LAYOUT_STABLE|View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;

    public static void setStatusBarColor(int color,Activity activity,int system){
        if(Build.VERSION.SDK_INT>=21){

                activity.getWindow().getDecorView().setSystemUiVisibility(system);

            //activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE|View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            activity.getWindow().setStatusBarColor(color);
        }
    }
    //将字符串转换为纯数字手机号
    public static String getPhoneNumber(String userPhone) {
        String userPhoneNumber;
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(userPhone);
        userPhoneNumber = m.replaceAll("").trim();
        return userPhoneNumber;
    }
    //将传来的字符串转换成Bitmap类型
    public static Bitmap getStringToBitmap(String verifyImg) {
        Bitmap bitmap = null;
        try {
            byte[]bitmapArray = Base64.decode(verifyImg, Base64.DEFAULT);
            bitmap= BitmapFactory.decodeByteArray(bitmapArray, 0, bitmapArray.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
