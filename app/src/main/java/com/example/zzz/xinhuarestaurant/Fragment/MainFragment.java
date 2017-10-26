package com.example.zzz.xinhuarestaurant.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.zzz.xinhuarestaurant.MainActivity;
import com.example.zzz.xinhuarestaurant.R;

/**
 * Created by zzz on 2017/10/25.
 */

public class MainFragment extends Fragment implements View.OnClickListener {

    public String TAG = "ppt";

    public FragmentManager fragmentManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.main_xinhua,container,false);

        RelativeLayout breakFast = (RelativeLayout) view.findViewById(R.id.breakfast_main);
        LinearLayout lunch = (LinearLayout) view.findViewById(R.id.lunch_main);
        LinearLayout dinner = (LinearLayout) view.findViewById(R.id.dinner_main);

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
                //getFragmentManager().popBackStack();
                BreakFastFragment breakFastFragment = new BreakFastFragment();
                FragmentTransaction fragment = fragmentManager.beginTransaction();
                //fragment.addToBackStack(null).add(R.id.main_fragment,breakFastFragment,"breakfast");
                fragment.addToBackStack(null).add(R.id.main_fragment,breakFastFragment);
                fragment.commit();
                Log.i(TAG, "onClick: ");
                MainActivity.breakFastIsOpen = true;
                break;
            case R.id.lunch_main:
                //getFragmentManager().popBackStack();
                Log.i(TAG, "onClick: ");
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                //fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                //为fragment加载显示动画
                //fragmentTransaction.setCustomAnimations(R.anim.enter_animal,0,0,0);
                BreakFastFragment anotherRightFragment = new BreakFastFragment();
                fragmentTransaction.addToBackStack(null).add(R.id.main_fragment,anotherRightFragment,"breakfast").commit();
                MainActivity.breakFastIsOpen = true;
                break;
            case R.id.dinner_main:
                break;
        }
    }


}
