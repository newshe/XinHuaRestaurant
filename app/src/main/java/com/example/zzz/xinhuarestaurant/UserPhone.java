package com.example.zzz.xinhuarestaurant;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.nfc.Tag;
import android.os.Bundle;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.zzz.xinhuarestaurant.application.MyApplication;
import com.example.zzz.xinhuarestaurant.db.UserInfo;
import com.example.zzz.xinhuarestaurant.gson.AssignJson;
import com.example.zzz.xinhuarestaurant.gson.PhoneJson;
import com.example.zzz.xinhuarestaurant.util.HttpRequest;
import com.example.zzz.xinhuarestaurant.util.PopupWindowUtil;
import com.example.zzz.xinhuarestaurant.util.ToastUtil;
import com.example.zzz.xinhuarestaurant.util.Util;
import com.google.gson.Gson;

import org.litepal.crud.DataSupport;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


/**
 * 这里是用户输入手机号的界面
 */
public class UserPhone extends AppCompatActivity {

    public static final String TAG = "userPhone_ppt";

    public static final int SHOW_TOAST = 0;
    public static final int SHOW_WINDOW_LOADING = 1;
    public static final int CLOSE_WINDOW_LOADING = 2;
    public static final int PHONE_ISNULL = 3;
    public static final int PHONE_ISHAVE = 4;

    public EditText userEditPhone;
    //public Button registerBtn; //注册按钮
    public Button userBtnNext;

    //手机号码格式
    public String telRegex = "[1][34578][0-9][ ]\\d{4}[ ]\\d{4}";
    //判断长度
    private CharSequence textLength;
    //字符长度
    public boolean Fourteen = false;
    //输入完毕后，记录用户输入的手机号
    public String userPhoneNumber;
    public HandlerInfo han = new HandlerInfo();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Util.setStatusBarColor(Color.TRANSPARENT,this,Util.TEXT_BLACK);
        List<UserInfo> userInfo = DataSupport.findAll(UserInfo.class);
        for (UserInfo user : userInfo) {
            if (user.getToken() != null) {
                Log.i(TAG, "getToken: " + user.getToken());
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                finish();
            }

        }

        setContentView(R.layout.user_phone_first);
        initControl();
        //获取临时令牌
        //getAssignCookie();
    }

    private void initControl() {
        userEditPhone = (EditText) findViewById(R.id.user_edit_phone);
        userBtnNext = (Button) findViewById(R.id.user_btn_next);
        //registerBtn = (Button) findViewById(R.id.user_btn_register); //注册按钮

//        registerBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(UserPhone.this, UserRegister.class);
//                startActivity(intent);
//            }
//        });
        userPhoneFormat();
    }

    //为edit进行输入判断，是否为合法手机号
    private void userPhoneFormat() {
        userEditPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            //          这里是手机代码格式例如 888 8888 8888
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int i2) {
                textLength = s;
                if (s == null || s.length() == 0) return;
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                    if (i != 3 && i != 8 && s.charAt(i) == ' ') {
                        continue;
                    } else {
                        sb.append(s.charAt(i));
                        if ((sb.length() == 4 || sb.length() == 9) && sb.charAt(sb.length() - 1) != ' ') {
                            sb.insert(sb.length() - 1, ' ');
                        }
                    }
                }
                if (!sb.toString().equals(s.toString())) {
                    int index = start + 1;
                    if (sb.charAt(start) == ' ') {
                        if (before == 0) {
                            index++;
                        } else {
                            index--;
                        }
                    } else {
                        if (before == 1) {
                            index--;
                        }
                    }
                    userEditPhone.setText(sb.toString());
                    userEditPhone.setSelection(index);
                }
            }

            /**
             *这里是进行对输入的判断
             */
            @Override
            public void afterTextChanged(Editable s) {

                String text = textLength.toString() + ' ';
                int phone_length = text.length();
                if (phone_length == 14) {
                    userBtnNext.setEnabled(true);
                    Fourteen = false;
                    //输入完之后关闭输入
                    userEditPhone.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            userEditPhone.setFocusable(true);
                            userEditPhone.setFocusableInTouchMode(true);
                            return false;
                        }
                    });
                    userEditPhone.clearFocus();
                    userEditPhone.setFocusable(false);
                    //让键盘消失
                    InputMethodManager imm = (InputMethodManager) MyApplication.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(userEditPhone.getWindowToken(), 0);
                    //改变按钮为高亮
                    userBtnNext.setTextColor(Color.rgb(231, 188, 17));
                    /**
                     * 这里是进行跳转到下一个界面，并且将手机号发送过去
                     */
                    userBtnNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (!userEditPhone.getText().toString().matches(telRegex)) {
                                ToastUtil.showToast(MyApplication.getContext(), "你输入的格式错误", 3000);
                            } else {
                                userPhoneNumber = userEditPhone.getText().toString();
                                //full = true;
                                setBackGroundLoading();
                                requestPhone(Util.getPhoneNumber(userPhoneNumber));
                                Log.i(TAG, "onClick: ");
                            }
                        }
                    });
                }
                if (phone_length != 14) {
                    Fourteen = true;
                    userBtnNext.setTextColor(Color.rgb(193, 192, 190));
                    userBtnNext.setEnabled(false);
                }
            }
        });
    }
    //请求服务器检查当前号码是否存在
    private void requestPhone(String userPhoneNumber) {
        Log.i(TAG, "requestPhone: " + MyApplication.HttpUrl.getUser_exist(userPhoneNumber));
        HttpRequest.request(MyApplication.HttpUrl.getUser_exist(userPhoneNumber), new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Message message = new Message();
                message.obj = "请检查网络";
                message.what = SHOW_TOAST;
                han.sendMessage(message);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res = response.body().string();
                Log.i(TAG, "onResponse: " + res);
                judgePhone(res);
            }
        });
    }
    //解析服务器json并判断
    public void judgePhone(String s){
        Gson gson = new Gson();
        PhoneJson phonejson = gson.fromJson(s,PhoneJson.class);
        if (phonejson.getReturn_info().getStatus_code() == 5408) {
            Message message = new Message();
            message.obj = "手机号不存在";
            message.what = PHONE_ISNULL;
            han.sendMessage(message);
        }else if (phonejson.getReturn_info().getStatus_code() == 5410) {
            Message message1 = new Message();
            message1.obj = "手机已注册";
            message1.what = PHONE_ISHAVE;
            han.sendMessage(message1);
        }
    }

    public PopupWindowUtil popupWindowUtil;

    public void setBackGroundLoading() {
        popupWindowUtil = new PopupWindowUtil();
        popupWindowUtil.showPopupWindowLoading(this);
        final Window window = getWindow();
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(1f, 0.4f);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                WindowManager.LayoutParams params = window.getAttributes();
                params.alpha = (float) valueAnimator.getAnimatedValue();
                window.setAttributes(params);

            }
        });
        valueAnimator.setDuration(700);
        valueAnimator.start();
    }

    public void closeBackGroundLoading(){
        popupWindowUtil.CloseLoadingPopupWindow();
        final Window window = getWindow();
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0.4f,1f);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                WindowManager.LayoutParams params = window.getAttributes();
                params.alpha = (float) valueAnimator.getAnimatedValue();
                window.setAttributes(params);

            }
        });
        valueAnimator.setDuration(700);
        valueAnimator.start();
    }

    private static long time = 0;

    @Override
    public void onBackPressed() {
        ToastUtil.showToast(this, "再次点击退出", 3000);
        if (System.currentTimeMillis() - time < 3000) {
            finish();
        }
        time = System.currentTimeMillis();
    }

    public class HandlerInfo extends Handler{
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SHOW_TOAST:
                    closeBackGroundLoading();
                    ToastUtil.showToast(UserPhone.this,(String) msg.obj,3000);
                    break;
                case SHOW_WINDOW_LOADING:
                    setBackGroundLoading();
                    break;
                case CLOSE_WINDOW_LOADING:
                    break;
                case PHONE_ISNULL:
                    Intent inten = new Intent(UserPhone.this,UserPicVerification.class);
                    inten.putExtra("phone",Util.getPhoneNumber(userPhoneNumber));
                    closeBackGroundLoading();
                    startActivity(inten);
                    finish();
                    break;
                case PHONE_ISHAVE:
                    Intent intent = new Intent(UserPhone.this,UserPassword.class);
                    intent.putExtra("phone",Util.getPhoneNumber(userPhoneNumber));
                    closeBackGroundLoading();
                    startActivity(intent);
                    finish();
                    break;
            }
        }
    }

}