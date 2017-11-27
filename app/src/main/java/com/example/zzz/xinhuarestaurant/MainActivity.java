package com.example.zzz.xinhuarestaurant;

import android.graphics.Color;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.zzz.xinhuarestaurant.application.MyApplication;
import com.example.zzz.xinhuarestaurant.fragment.BreakFastFragment;
import com.example.zzz.xinhuarestaurant.fragment.MainFragment;
import com.example.zzz.xinhuarestaurant.util.HttpRequest;
import com.example.zzz.xinhuarestaurant.util.Util;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    public String TAG = "ppt";


    public static boolean breakFastIsOpen = false;

    public static DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Util.setStatusBarColor(Color.TRANSPARENT, this, Util.TEXT_WHITE);
        setContentView(R.layout.activity_main);
        initControl();

    }

    private void initControl() {
        drawerLayout = (DrawerLayout) findViewById(R.id.activity_main);
    }

    public static void setMainBackGround(int color) {
        drawerLayout.setBackgroundColor(color);
    }

}

