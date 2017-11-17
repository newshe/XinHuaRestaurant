package com.example.zzz.xinhuarestaurant.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.zzz.xinhuarestaurant.MainActivity;
import com.example.zzz.xinhuarestaurant.R;
import com.example.zzz.xinhuarestaurant.bean.TitleName;
import com.example.zzz.xinhuarestaurant.util.Util;

/**
 * Created by zzz on 2017/10/25.
 */

public class MainFragment extends Fragment implements View.OnClickListener {

    public String TAG = "ppt";

    public FragmentManager fragmentManager;

    public String breakFastName[] = {"早餐精选","早餐饮品","清淡食品","油性食品"};
    public String lunchName[] = {"午餐精选","午餐饮品","清淡食品","油性食品"};
    public String dinnerName[] = {"晚餐精选","晚餐饮品","清淡食品","油性食品"};
    public Bundle bundle = new Bundle();

    public BreakFastFragment breakFastFragment;
    public LunchFragment lunchFragment;
    public DinnerFragment dinnerFragment;
    public static RelativeLayout relativeLayout;

    public ImageButton openLeftButton;

    public TitleName titleName;

    public static int rViewOne = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.main_xinhua,container,false);
        titleName = new TitleName();
        lunchFragment = new LunchFragment();
        breakFastFragment = new BreakFastFragment();
        relativeLayout = (RelativeLayout) view.findViewById(R.id.fragment_main);
        RelativeLayout breakFast = (RelativeLayout) view.findViewById(R.id.breakfast_main);
        LinearLayout lunch = (LinearLayout) view.findViewById(R.id.lunch_main);
        LinearLayout dinner = (LinearLayout) view.findViewById(R.id.dinner_main);
        openLeftButton = (ImageButton) view.findViewById(R.id.openLeftButton);
        openLeftButton.setOnClickListener(this);
        breakFast.setOnClickListener(this);
        lunch.setOnClickListener(this);
        dinner.setOnClickListener(this);
        fragmentManager = getActivity().getSupportFragmentManager();

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.breakfast_main:
                if (fragmentManager.findFragmentByTag("breakfast") == null) {
                    //getFragmentManager().popBackStack();

                    FragmentTransaction fragment = fragmentManager.beginTransaction();
                    fragment.addToBackStack(null).add(R.id.main_fragment,breakFastFragment,"breakfast").commit();
                    bundle.putStringArray("name",breakFastName);
                    breakFastFragment.setArguments(bundle);
                    rViewOne = 1;
                    relativeLayout.setBackgroundColor(Color.argb(255,36,179,231));
                }
                break;
            case R.id.lunch_main:
                if (fragmentManager.findFragmentByTag("breakfast") == null) {
                    getFragmentManager().popBackStack();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.addToBackStack(null).add(R.id.main_fragment, lunchFragment, "breakfast").commit();
                    MainActivity.breakFastIsOpen = true;
                    bundle.putStringArray("name", lunchName);
                    lunchFragment.setArguments(bundle);
                    rViewOne = 2;
                }
                break;
            case R.id.dinner_main:
                break;
            case R.id.openLeftButton:
                MainActivity.drawerLayout.openDrawer(Gravity.LEFT);
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: MainFragment");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: MainFragment");
    }
}
