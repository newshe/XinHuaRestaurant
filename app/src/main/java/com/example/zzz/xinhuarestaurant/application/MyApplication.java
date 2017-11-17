package com.example.zzz.xinhuarestaurant.application;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzz on 2017/10/25.
 */

public class MyApplication extends Application {

    public static List<Integer> numberList = new ArrayList<>();
    public static List<Integer> numberTwoList = new ArrayList<>();
    public static List<Integer> numberThreeList = new ArrayList<>();

    public static List<Integer> numberListTwo = new ArrayList<>();
    public static List<Integer> numberTwoListTwo = new ArrayList<>();
    public static List<Integer> numberThreeListTwo = new ArrayList<>();

    public static List<Integer> numberListThree = new ArrayList<>();
    public static List<Integer> numberTwoListThree = new ArrayList<>();
    public static List<Integer> numberThreeListThree = new ArrayList<>();

    //三种食品标题的背景颜色
    public static final int FOOD_TITLE_NAME = 0x66e4dfd6;

    public static final int NUMBER_ONE_LIST = 0;

    public static final int NUMBER_TWO_LIST = 1;

    public static final int NUMBER_THREE_LIST = 2;

    public static Context mcontext ;

    @Override
    public void onCreate() {
        super.onCreate();
        mcontext = getApplicationContext();

        initList();
    }

    public void initList() {
        for (int i = 0; i < 20; i++) {
            numberList.add(i,0);
            numberTwoList.add(i,0);
            numberThreeList.add(i,0);
            numberListTwo.add(i,0);
            numberTwoListTwo.add(i,0);
            numberThreeListTwo.add(i,0);
        }
    }

    public static Context getContext(){
        return mcontext;
    }

    //这是向聚合数据申请的天气预报key
    public static final String weatherKey = "10ae38a3f9c1cb3677cd6d9e7cf1f8ce";


    public static String getWeatherUrl(String city){

        return "http://v.juhe.cn/weather/index?cityname="+city+"&dtype=json&format=2&key=" + weatherKey;
    }

    private static final String appUrl = "http://192.168.43.67/v1/";

    public static class HttpUrl {
        //客户端版本
        public static final String get_client_version = appUrl + "get_client_version ";

        //检查当前号码是否存在
        public static String getUser_exist(String phone) {
            return appUrl + "user_exist/" + phone;
        }

        //账号密码登陆验证
        public static String getLogin_status(String phone, String password) {
            return appUrl + "login_status/" + phone + "/" + password;
        }

        //申请临时令牌
        public static final String assign_cookie =  "http://192.168.43.67/v1/assign_cookie";

        //将令牌转换成base64验证码图片
        public static String getMake_verifyimg(String verifyimg) {
            return appUrl + "make_verifyimg/" + verifyimg;
        }

        //验证临时令牌转换成正式令牌
        public static String getVerify_cookie(String verify,String cookie) {
            return appUrl + "verify_cookie/" + verify + "/" + cookie;
        }

        //发送手机验证码
        public static String getSend_verify(String phone,String verify) {
            return appUrl + "send_verify/" + phone + "/" + verify;
        }

        //验证手机验证码
        public static String getVerify_number(String phone,String verify){
            return appUrl + "verify_number/" + phone + "/" + verify;
        }

        //验证并完成设置
        public static String getSet_comp(String password,String passwordTwo,String phone,String verify) {
           return appUrl + "set_comp/" + password+"/"+ passwordTwo+ "/" + phone + "/" + verify;
        }

        //获取目录下的商品分类 - 以及附上当前菜单默认商品
        public static String get_Commodity(int id) {
            return appUrl + "get_commodity_list/" + id;
        }
    }
}
