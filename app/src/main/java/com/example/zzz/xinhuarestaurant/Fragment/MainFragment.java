package com.example.zzz.xinhuarestaurant.fragment;

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

import com.example.zzz.xinhuarestaurant.MainActivity;
import com.example.zzz.xinhuarestaurant.R;
import com.example.zzz.xinhuarestaurant.bean.TitleName;

/**
 * Created by zzz on 2017/10/25.
 */

public class MainFragment extends Fragment implements View.OnClickListener {

    public String TAG = "ppt";

    public FragmentManager fragmentManager;

    public String breakFastName[] = {"早餐精选","早餐饮品","清淡食品","油性食品"};
    public String lunchName[] = {"午餐精选","早餐饮品","清淡食品","油性食品"};
    public String dinnerName[] = {"晚餐精选","早餐饮品","清淡食品","油性食品"};
    public Bundle bundle = new Bundle();

    public BreakFastFragment breakFastFragment;

    public TitleName titleName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.main_xinhua,container,false);
        titleName = new TitleName();
        breakFastFragment = new BreakFastFragment();

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
                if (fragmentManager.findFragmentByTag("breakfast") == null) {
                    getFragmentManager().popBackStack();
                    FragmentTransaction fragment = fragmentManager.beginTransaction();
                    fragment.addToBackStack(null).add(R.id.main_fragment,breakFastFragment,"breakfast").commit();
                    bundle.putStringArray("name",breakFastName);
                    breakFastFragment.setArguments(bundle);
                    MainActivity.breakFastIsOpen = true;
                }
                break;
            case R.id.lunch_main:
                if (fragmentManager.findFragmentByTag("breakfast") == null) {
                    getFragmentManager().popBackStack();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.addToBackStack(null).add(R.id.main_fragment, breakFastFragment, "breakfast").commit();
                    MainActivity.breakFastIsOpen = true;
                    bundle.putStringArray("name", lunchName);
                    breakFastFragment.setArguments(bundle);
                }
                break;
            case R.id.dinner_main:
                break;
        }
    }

}
