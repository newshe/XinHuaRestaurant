package com.example.zzz.xinhuarestaurant.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.zzz.xinhuarestaurant.R;
import com.example.zzz.xinhuarestaurant.adapter.FoodRecyclerAdapter;
import com.example.zzz.xinhuarestaurant.adapter.FoodRecyclerThreeAdapter;
import com.example.zzz.xinhuarestaurant.adapter.FoodRecyclerTwoAdapter;
import com.example.zzz.xinhuarestaurant.application.MyApplication;
import com.example.zzz.xinhuarestaurant.bean.FoodBean;
import com.example.zzz.xinhuarestaurant.bean.FoodBeanThree;
import com.example.zzz.xinhuarestaurant.bean.FoodBeanTwo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzz on 2017/11/1.
 */

public class LunchFragment extends Fragment implements View.OnClickListener {

    public String TAG = "ppt";

    public List<FoodBean> foodBeanList = new ArrayList<>();
    public List<FoodBeanTwo> foodBeanTwoList = new ArrayList<>();
    public List<FoodBeanThree> foodBeanThreeList = new ArrayList<>();

    public static int recyclerView = 1;
    public RecyclerView breakFastOne;
    public RecyclerView breakFastTwo;
    public RecyclerView breakFastThree;
    public LinearLayoutManager layoutManager;

    public Button make_sure;

    public FoodRecyclerTwoAdapter<FoodBean> foodTwoAdapter;
    public FragmentManager fragmentManager;

    public static TextView price;
    public static int AllOne;
    public static int AllTwo;
    public static int AllThree;

    public TextView first;
    public TextView second;
    public TextView third;

    public int onColor = 0;

    public static final int ONE = 1;

    public static final int TWO = 2;

    public static final int THREE = 3;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.breakfast, container, false);
        breakFastOne = (RecyclerView) view.findViewById(R.id.breakfast_rv_one);
        breakFastTwo = (RecyclerView) view.findViewById(R.id.breakfast_rv_two);
        breakFastThree = (RecyclerView) view.findViewById(R.id.breakfast_rv_three);
        layoutManager = new LinearLayoutManager(getContext());
        fragmentManager = getActivity().getSupportFragmentManager();
        loadRv(ONE);
        initBean();
        initControl(view);

        initView(view);

        return view;

    }

    private void loadRv(int number) {
        switch (number) {
            case 1:
                recyclerView = 1;
                //AllOne = FoodRecyclerAdapter.all;
                Log.i("ppt", "loadRv1: " + AllOne);
                breakFastOne.setVisibility(View.VISIBLE);
                breakFastTwo.setVisibility(View.INVISIBLE);
                breakFastThree.setVisibility(View.INVISIBLE);
                break;
            case 2:
                recyclerView = 2;
                //AllTwo = FoodRecyclerAdapter.all;
                Log.i("ppt", "loadRv2: " + AllThree);
                breakFastOne.setVisibility(View.INVISIBLE);
                breakFastTwo.setVisibility(View.VISIBLE);
                breakFastThree.setVisibility(View.INVISIBLE);
                break;
            case 3:
                recyclerView = 3;
                //AllThree = FoodRecyclerAdapter.all;
                Log.i("ppt", "loadRv2: " + AllThree);
                breakFastOne.setVisibility(View.INVISIBLE);
                breakFastTwo.setVisibility(View.INVISIBLE);
                breakFastThree.setVisibility(View.VISIBLE);
                break;
            case R.id.make_sure:
                //getFragmentManager().popBackStack();
                SureFragment sureFragment = new SureFragment();
                FragmentTransaction fragment = fragmentManager.beginTransaction();
                fragment.addToBackStack(null).add(R.id.main_fragment,sureFragment,"lunch_sure").commit();
                Bundle bundle = new Bundle();
                bundle.putDouble("price",FoodRecyclerTwoAdapter.all);
                sureFragment.setArguments(bundle);
                break;
        }


    }

    public void initControl(View view) {

        breakFastOne.setLayoutManager(layoutManager);
        FoodRecyclerTwoAdapter foodAdapter = new FoodRecyclerTwoAdapter<FoodBean>(getContext(), foodBeanList) {
            @Override
            public void convert(ViewHolder holder, FoodBean item, int position) {
                holder.foodNumber.setText(item.getFoodName());
                holder.numberView.setText("" + MyApplication.numberListTwo.get(position));
            }
        };
        breakFastOne.setAdapter(foodAdapter);

        LinearLayoutManager layoutManagerTwo = new LinearLayoutManager(getContext());
        breakFastTwo.setLayoutManager(layoutManagerTwo);
        FoodRecyclerTwoAdapter foodTwo = new FoodRecyclerTwoAdapter<FoodBeanTwo>(getContext(), foodBeanTwoList) {
            @Override
            public void convert(ViewHolder holder, FoodBeanTwo item, int position) {
                holder.foodNumber.setText(item.getFoodName());
                holder.numberView.setText("" + MyApplication.numberTwoListTwo.get(position));
            }
        };
        breakFastTwo.setAdapter(foodTwo);

        LinearLayoutManager layoutManagerThree = new LinearLayoutManager(getContext());
        breakFastThree.setLayoutManager(layoutManagerThree);
        FoodRecyclerTwoAdapter foodThree = new FoodRecyclerTwoAdapter<FoodBeanThree>(getContext(), foodBeanThreeList) {
            @Override
            public void convert(ViewHolder holder, FoodBeanThree item, int position) {
                holder.foodNumber.setText(item.getFoodName());
                holder.numberView.setText("" + MyApplication.numberThreeListTwo.get(position));
            }
        };
        breakFastThree.setAdapter(foodThree);

        make_sure = (Button)view.findViewById(R.id.make_sure);
        make_sure.setOnClickListener(this);
        ImageButton returnBtn = (ImageButton) view.findViewById(R.id.main_return_btn);
        returnBtn.setOnClickListener(this);

        price = (TextView) view.findViewById(R.id.price);
        first = (TextView) view.findViewById(R.id.first);
        second = (TextView) view.findViewById(R.id.second);
        third = (TextView) view.findViewById(R.id.third);
        first.setOnClickListener(this);
        second.setOnClickListener(this);
        third.setOnClickListener(this);
        //如果数据已经存在，就不需要在进行添加
        price.setText("" + FoodRecyclerTwoAdapter.all);
    }


    //在这里初始化fragment的主题内容
    public void initView(View view) {
        TextView mainTitle = (TextView) view.findViewById(R.id.main_title_name);
        String breakFast[] = getArguments().getStringArray("name");
        assert breakFast != null;
        mainTitle.setText(breakFast[0]);
    }

    //为recyclerView初始化数据
    public void initBean() {
        if (foodBeanList.size() <= 1) {
            for (int i = 0; i < 10; i++) {
                FoodBean food = new FoodBean();
                foodBeanList.add(food);
            }
        }
        if (foodBeanTwoList.size() <= 1) {
            for (int i = 0; i < 10; i++) {
                FoodBeanTwo foodTwo = new FoodBeanTwo("" + i * i);
                foodBeanTwoList.add(i, foodTwo);
            }
        }
        if (foodBeanThreeList.size() <= 1) {
            for (int i = 0; i < 10; i++) {
                FoodBeanThree foodThree = new FoodBeanThree("" + ((i + i) * i));
                foodBeanThreeList.add(i, foodThree);
            }
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_return_btn:
                getFragmentManager().popBackStack();
                break;
            case R.id.first:
                loadRv(ONE);
                first.setBackgroundColor(MyApplication.FOOD_TITLE_NAME);
                second.setBackgroundColor(Color.WHITE);
                third.setBackgroundColor(Color.WHITE);
                break;
            case R.id.second:
                loadRv(TWO);
                second.setBackgroundColor(MyApplication.FOOD_TITLE_NAME);
                first.setBackgroundColor(Color.WHITE);
                third.setBackgroundColor(Color.WHITE);
                onColor = 2;
                break;
            case R.id.third:
                loadRv(THREE);
                third.setBackgroundColor(MyApplication.FOOD_TITLE_NAME);
                first.setBackgroundColor(Color.WHITE);
                second.setBackgroundColor(Color.WHITE);
                onColor = 3;
                break;
            case R.id.make_sure:
                //getFragmentManager().popBackStack();
                SureFragment sureFragment = new SureFragment();
                FragmentTransaction fragment = fragmentManager.beginTransaction();
                fragment.addToBackStack(null).add(R.id.main_fragment,sureFragment,"dinner_sure").commit();
                Bundle bundle = new Bundle();
                bundle.putDouble("price", FoodRecyclerTwoAdapter.all);
                sureFragment.setArguments(bundle);
                break;

        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }
}