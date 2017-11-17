package com.example.zzz.xinhuarestaurant.util;

import android.util.Log;

import com.example.zzz.xinhuarestaurant.application.MyApplication;

/**
 * Created by zzz on 2017/11/17.
 */



public class ErrorRequest {

    public String TAG = "ppt_error";

    public ErrorRequest (int errorCode){
        switch (errorCode) {
            case 10425:
                break;
            case 10422:
                break;
            case 10428:
                break;
            case 10415:
                break;
            case 4020:
                ToastUtil.showToast(MyApplication.getContext(),"账号密码正确",3000);
                break;
            case 4035:
                ToastUtil.showToast(MyApplication.getContext(),"账号不存在或密码错误",3000);
                break;
//            case 3240:
//                ToastUtil.showToast(MyApplication.getContext(),"成功注册",3000);
//                break;
            case 3260:
                ToastUtil.showToast(MyApplication.getContext(),"验证码错误",3000);
                break;
            case 3200:
                ToastUtil.showToast(MyApplication.getContext(),"两次密码不一致",3000);
                break;
            case 10404:
                Log.i(TAG, "ErrorRequest: " + errorCode);
                break;
            case 10410:

                break;
            case 10413:
                break;
            case 10400:
                break;
            case 3024:
                break;
            case 3025:
                break;
            case 3036:
                break;
            case 3063:
                break;


        }
    }
}
