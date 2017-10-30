package com.example.zzz.xinhuarestaurant;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public String TAG = "ppt";

    public static boolean breakFastIsOpen = false;

    public FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

    }

    public void exitFragment(){
        getSupportFragmentManager().popBackStack();
    }
}

