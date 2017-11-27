package com.example.zzz.xinhuarestaurant;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.zzz.xinhuarestaurant.application.MyApplication;
import com.example.zzz.xinhuarestaurant.db.UserInfo;
import com.example.zzz.xinhuarestaurant.gson.LoginJson;
import com.example.zzz.xinhuarestaurant.util.HttpRequest;
import com.example.zzz.xinhuarestaurant.util.PopupWindowUtil;
import com.example.zzz.xinhuarestaurant.util.ToastUtil;
import com.example.zzz.xinhuarestaurant.util.Util;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by zzz on 2017/11/7.
 */

public class UserPassword extends AppCompatActivity implements View.OnClickListener {

    public final String TAG = "ppt_UserPassword";

    public EditText userEditPhonePassword;
    public ImageView showPassword;
    public boolean showPass = false;
    public Button userBtnNextPassword;

    //判断长度
    private CharSequence textLength;
    //字符长度
    public boolean Fourteen = false;
    //输入完毕后，记录用户输入的手机号
    public String userPhoneNumber;
    public String userPassword;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Util.setStatusBarColor(Color.TRANSPARENT,this,Util.TEXT_BLACK);
        setContentView(R.layout.user_phone_password);
        initControl();
        Intent intent = getIntent();
        userPhoneNumber = intent.getStringExtra("phone");
    }

    private void initControl() {
        userEditPhonePassword = (EditText) findViewById(R.id.user_edit_phone_password);
        userBtnNextPassword = (Button) findViewById(R.id.user_btn_next_password);
        showPassword = (ImageView) findViewById(R.id.showPassword);
        showPassword.setOnClickListener(this);
        userPhoneFormat();
    }

    //为edit进行输入判断，是否为合法手机号
    private void userPhoneFormat() {
        userEditPhonePassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int i2) {
                textLength = s;

            }

            /**
             *这里是进行对输入的判断
             */
            @Override
            public void afterTextChanged(Editable s) {
                String text = textLength.toString() + ' ';
                int phone_length = text.length();
                //改变按钮为高亮
                if (phone_length >= 6) {
                    userBtnNextPassword.setTextColor(Color.rgb(231, 188, 17));
                    userBtnNextPassword.setEnabled(true);
                    /**
                     * 这里是进行跳转到下一个界面，并且将手机号发送过去
                     */
                    userBtnNextPassword.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            userPassword = userEditPhonePassword.getText().toString();
                            setBackGroundLoading();
                            //setBackGroundLoading();
                            requestPassword();
                        }
                    });
                }
                if (phone_length == 16) {
                    Fourteen = false;
                    //输入完之后关闭输入
                    userEditPhonePassword.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            userEditPhonePassword.setFocusable(true);
                            userEditPhonePassword.setFocusableInTouchMode(true);
                            return false;
                        }
                    });
                    userEditPhonePassword.clearFocus();
                    userEditPhonePassword.setFocusable(false);
                    //让键盘消失
                    InputMethodManager imm = (InputMethodManager) MyApplication.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(userEditPhonePassword.getWindowToken(), 0);

                }
                if (phone_length < 7) {
                    userBtnNextPassword.setTextColor(Color.rgb(193, 192, 190));
                    userBtnNextPassword.setEnabled(false);
                }
            }
        });

    }

    private void requestPassword() {
        HttpRequest.request(MyApplication.HttpUrl.getLogin_status(userPhoneNumber, userPassword), new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res = response.body().string();
                Log.i(TAG, "getLogin_status: " + res);
                Gson gson = new Gson();
                final LoginJson login = gson.fromJson(res,LoginJson.class);
                if (login.getReturn_info().getStatus_code() == 4020) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            UserInfo userInfo = new UserInfo();
                            userInfo.setToken(login.getReturn_info().getToken());
                            userInfo.save();
                            ToastUtil.showToast(UserPassword.this,"登陆成功",3000);
                            closeBackGroundLoading();
                            Intent intent = new Intent(UserPassword.this,MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    });
                } else if (login.getReturn_info().getStatus_code() == 4035) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ToastUtil.showToast(UserPassword.this,"密码错误",3000);
                            closeBackGroundLoading();
                        }
                    });
                }
            }
        });
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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.showPassword:
                if (!showPass) {
                    userEditPhonePassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    showPass = true;
                    showPassword.setImageResource(R.drawable.ic_eyes);
                }else {
                    userEditPhonePassword.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    showPass = false;
                    showPassword.setImageResource(R.drawable.ic_eyeon);
                    Log.i("ppt", "showPass: ");
                }
                break;
        }
    }

//    @Override
//    public void onBackPressed() {
////        String toast = "再次点击";
////        ToastUtil.showToast(this, toast, 3000);
////        if (System.currentTimeMillis() - time < 3000) {
////            finish();
////        }
////        time = System.currentTimeMillis();
//        super
//    }
//    onB
}