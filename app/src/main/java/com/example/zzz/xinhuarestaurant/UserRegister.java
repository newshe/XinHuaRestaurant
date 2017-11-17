package com.example.zzz.xinhuarestaurant;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.zzz.xinhuarestaurant.application.MyApplication;
import com.example.zzz.xinhuarestaurant.gson.CompJson;
import com.example.zzz.xinhuarestaurant.util.HttpRequest;
import com.example.zzz.xinhuarestaurant.util.ToastUtil;
import com.example.zzz.xinhuarestaurant.util.Util;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by zzz on 2017/11/7.
 */

public class UserRegister extends AppCompatActivity implements View.OnClickListener {

    public String TAG = "ppt_UserRegister";

    public Button continueBtn;
    public EditText editPhoneRegister;
    public EditText editPhoneRegisterSure;
    public Button nextBtn;

    //判断长度
    private CharSequence textLength;
    private CharSequence textLengthSure;

    public String userPhone;
    public String userInput;
    public String userPassword;
    public String userPasswordSure;

    public ImageView showPasswordOne;
    public ImageView showPasswordTwo;

    public boolean showPassOne = false;
    public boolean showPassTwo = false;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Util.setStatusBarColor(Color.TRANSPARENT, this, Util.TEXT_BLACK);
        setContentView(R.layout.user_phone_register);

        initControl();
        userPhoneFormat();

        Intent intent = getIntent();
        userPhone = intent.getStringExtra("phone");
        userInput = intent.getStringExtra("verify");

    }

    private void initControl() {
        editPhoneRegister = (EditText) findViewById(R.id.user_edit_phone_register);
        editPhoneRegister.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    showPasswordOne.setVisibility(View.VISIBLE);
                } else {
                    showPasswordOne.setVisibility(View.INVISIBLE);
                }
            }
        });
        editPhoneRegisterSure = (EditText) findViewById(R.id.user_edit_phone_register_sure);
        editPhoneRegisterSure.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    showPasswordTwo.setVisibility(View.VISIBLE);
                } else {
                    showPasswordTwo.setVisibility(View.INVISIBLE);
                }
            }
        });
        nextBtn = (Button) findViewById(R.id.user_btn_next_register);
        nextBtn.setOnClickListener(this);

        showPasswordOne = (ImageView) findViewById(R.id.showPassword_one);
        showPasswordTwo = (ImageView) findViewById(R.id.showPassword_two);
        showPasswordOne.setOnClickListener(this);
        showPasswordTwo.setOnClickListener(this);
        continueBtn = (Button) findViewById(R.id.user_btn_continue);
        continueBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.showPassword_one:
                if (!showPassOne) {
                    editPhoneRegister.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    showPassOne = true;
                    showPasswordOne.setImageResource(R.drawable.ic_eyes);
                } else {
                    editPhoneRegister.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    showPassOne = false;
                    showPasswordOne.setImageResource(R.drawable.ic_eyeon);
                    Log.i("ppt", "showPass: ");
                }
                break;
            case R.id.showPassword_two:
                if (!showPassTwo) {
                    editPhoneRegisterSure.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    showPassTwo = true;
                    showPasswordTwo.setImageResource(R.drawable.ic_eyes);
                } else {
                    editPhoneRegisterSure.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    showPassTwo = false;
                    showPasswordTwo.setImageResource(R.drawable.ic_eyeon);
                    Log.i("ppt", "showPass: ");
                }
                break;
            case R.id.user_btn_continue:
                Intent intent = new Intent(UserRegister.this, UserPhone.class);
                startActivity(intent);
                break;
            case R.id.user_btn_next_register:
                Log.i(TAG, "onClick: " + Objects.equals(userPasswordSure, userPassword));
                if (!Objects.equals(userPasswordSure, userPassword)) {
                    ToastUtil.showToast(UserRegister.this, "两次密码不一致", 3000);
                } else {
                    HttpRequest.request(MyApplication.HttpUrl.getSet_comp(userPassword, userPasswordSure, userPhone, userInput), new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            String res = response.body().string();
                            Gson gson = new Gson();
                            CompJson com = gson.fromJson(res, CompJson.class);
                            if (com.getReturn_info().getStatus_code() == 3240) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        ToastUtil.showToast(UserRegister.this, "注册成功", 3000);
                                        Intent intent = new Intent(UserRegister.this, MainActivity.class);
                                        startActivity(intent);
                                    }
                                });
                            }
                            Log.i(TAG, "getSet_comp: " + res);
                        }
                    });
                }
                break;
        }
    }

    private int phone_length;
    private int phone_lengthSure;

    //为edit进行输入判断，是否为合法手机号
    private void userPhoneFormat() {
        editPhoneRegister.addTextChangedListener(new TextWatcher() {
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
                userPassword = editPhoneRegister.getText().toString();
                String text = textLength.toString() + ' ';
                phone_length = text.length();
                //改变按钮为高亮
                if (phone_lengthSure >= 6 && phone_length >= 6) {
                    nextBtn.setEnabled(true);
                    nextBtn.setTextColor(Color.rgb(231, 188, 17));
                }
                if (phone_length == 16) {
                    //输入完之后关闭输入
                    editPhoneRegister.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            editPhoneRegister.setFocusable(true);
                            editPhoneRegister.setFocusableInTouchMode(true);
                            return false;
                        }
                    });
                    editPhoneRegister.clearFocus();
                    editPhoneRegister.setFocusable(false);
                    //让键盘消失
                    InputMethodManager imm = (InputMethodManager) MyApplication.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editPhoneRegister.getWindowToken(), 0);

                }
                if (phone_length < 7) {
                    nextBtn.setTextColor(Color.rgb(193, 192, 190));
                    nextBtn.setEnabled(false);
                }
            }
        });
        editPhoneRegisterSure.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int i2) {
                textLengthSure = s;

            }

            /**
             *这里是进行对输入的判断
             */
            @Override
            public void afterTextChanged(Editable s) {
                userPasswordSure = editPhoneRegisterSure.getText().toString();
                String text = textLengthSure.toString() + ' ';
                phone_lengthSure = text.length();
                //改变按钮为高亮
                if (phone_lengthSure >= 6 && phone_length >= 6) {
                    nextBtn.setEnabled(true);
                    nextBtn.setTextColor(Color.rgb(231, 188, 17));
                    /**
                     * 这里是进行跳转到下一个界面，并且将手机号发送过去
                     */
//                    nextBtn.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//
//                            Log.i(TAG, "onClick: " + Objects.equals(userPasswordSure, userPassword));
//                            if (!Objects.equals(userPasswordSure, userPassword)){
//                                ToastUtil.showToast(UserRegister.this,"两次密码不一致",3000);
//                            }
//                        }
//                    });
                }
                if (phone_lengthSure == 16) {
                    //输入完之后关闭输入
                    editPhoneRegisterSure.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            editPhoneRegisterSure.setFocusable(true);
                            editPhoneRegisterSure.setFocusableInTouchMode(true);
                            return false;
                        }
                    });
                    editPhoneRegisterSure.clearFocus();
                    editPhoneRegisterSure.setFocusable(false);
                    //让键盘消失
                    InputMethodManager imm = (InputMethodManager) MyApplication.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editPhoneRegisterSure.getWindowToken(), 0);

                }
                if (phone_lengthSure < 7) {
                    nextBtn.setTextColor(Color.rgb(193, 192, 190));
                    nextBtn.setEnabled(false);
                }
                Log.i(TAG, "onClick: " + Objects.equals(userPasswordSure, userPassword));
            }
        });

    }

    private static long time = 0;

    @Override
    public void onBackPressed() {
        ToastUtil.showToast(this, "再次点击放弃注册", 3000);
        if (System.currentTimeMillis() - time < 3000) {
            finish();
        }
        time = System.currentTimeMillis();
    }
}
