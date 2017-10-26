package com.example.zzz.xinhuarestaurant;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.zzz.xinhuarestaurant.Fragment.MainFragment;

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

//    @Override
//    public void onBackPressed() {
//        fragmentManager = getSupportFragmentManager();
//        Fragment fragment = fragmentManager.findFragmentByTag("breakfast");
//        Log.i("ppt", "onBackPressed: " + breakFastIsOpen);
//        if (fragment != null && breakFastIsOpen){
//            Log.i("ppt", "onBackPressed: " + 123);
//            FragmentTransaction transaction = fragmentManager.beginTransaction();
//            //transaction.setCustomAnimations(R.anim.enter_animal,R.anim.exit_animal);
//            transaction.remove(fragment);
//            transaction.commit();
//            breakFastIsOpen = false;
//        } else {
//            Log.i(TAG, "onBackPressed: " + "finish");
//            finish();
//        }
//    }
}

