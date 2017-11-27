package com.example.zzz.xinhuarestaurant.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zzz.xinhuarestaurant.R;
import com.example.zzz.xinhuarestaurant.adapter.RvSureAdapter;
import com.example.zzz.xinhuarestaurant.application.MyApplication;
import com.example.zzz.xinhuarestaurant.bean.FoodBean;
import com.example.zzz.xinhuarestaurant.bean.SureBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzz on 2017/11/2.
 */

public class SureFragment extends Fragment {

    public String TAG = "ppt";

    public static TextView sure_price;

    public RecyclerView recyclerView;
    public LinearLayoutManager linearManager;


    public List<SureBean> foodBeanList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.main_sureorder, container, false);
        linearManager = new LinearLayoutManager(getContext());
        initControl(view);
        sure_price.setText("" + getArguments().getDouble("price"));
        String lunch = getArguments().getString("lunch");
        String dinner = getArguments().getString("dinner");
        if (lunch != null) {
            if (foodBeanList.size() < 1) {
                for (int i = 0; i < LunchFragment.foodBeanList.size(); i++) {
                    if (MyApplication.numberListTwo.get(i) != 0) {
                        SureBean sureBean = new SureBean();
                        sureBean.setFoodName("" + LunchFragment.foodBeanList.get(i).getFoodName());
                        sureBean.setfoodNumber("" + MyApplication.numberListTwo.get(i));
                        sureBean.setnumberView("" + LunchFragment.foodBeanList.get(i).getFoodPrice());
                        foodBeanList.add(sureBean);
                    } else if (MyApplication.numberTwoListTwo.get(i) != 0) {
                        SureBean sureBean = new SureBean();
                        sureBean.setFoodName("" + LunchFragment.foodBeanTwoList.get(i).getFoodName());
                        sureBean.setfoodNumber("" + MyApplication.numberTwoListTwo.get(i));
                        sureBean.setnumberView("" + LunchFragment.foodBeanTwoList.get(i).getFoodPrice());
                        foodBeanList.add(sureBean);
                    } else if (MyApplication.numberThreeListTwo.get(i) != 0) {
                        SureBean sureBean = new SureBean();
                        sureBean.setFoodName("" + LunchFragment.foodBeanThreeList.get(i).getFoodName());
                        sureBean.setfoodNumber("" + MyApplication.numberThreeListTwo.get(i));
                        sureBean.setnumberView("" + LunchFragment.foodBeanThreeList.get(i).getFoodPrice());
                        foodBeanList.add(sureBean);
                    }
                }
            }
        } else if (dinner != null) {
            if (foodBeanList.size() < 1) {
                for (int i = 0; i < DinnerFragment.foodBeanList.size(); i++) {
                    if (MyApplication.numberListThree.get(i) != 0) {
                        SureBean sureBean = new SureBean();
                        sureBean.setFoodName("" + DinnerFragment.foodBeanList.get(i).getFoodName());
                        sureBean.setfoodNumber("" + MyApplication.numberListThree.get(i));
                        sureBean.setnumberView("" + DinnerFragment.foodBeanList.get(i).getFoodPrice());
                        foodBeanList.add(sureBean);
                    } else if (MyApplication.numberTwoListThree.get(i) != 0) {
                        SureBean sureBean = new SureBean();
                        sureBean.setFoodName("" + DinnerFragment.foodBeanTwoList.get(i).getFoodName());
                        sureBean.setfoodNumber("" + MyApplication.numberTwoListThree.get(i));
                        sureBean.setnumberView("" + DinnerFragment.foodBeanTwoList.get(i).getFoodPrice());
                        foodBeanList.add(sureBean);
                    } else if (MyApplication.numberThreeListThree.get(i) != 0) {
                        SureBean sureBean = new SureBean();
                        sureBean.setFoodName("" + DinnerFragment.foodBeanThreeList.get(i).getFoodName());
                        sureBean.setfoodNumber("" + MyApplication.numberThreeListThree.get(i));
                        sureBean.setnumberView("" + DinnerFragment.foodBeanThreeList.get(i).getFoodPrice());
                        foodBeanList.add(sureBean);
                    }
                }
            }
        } else {
            if (foodBeanList.size() < 1) {
                for (int i = 0; i < BreakFastFragment.foodBeanList.size(); i++) {
                    if (MyApplication.numberList.get(i) != 0) {
                        SureBean sureBean = new SureBean();
                        sureBean.setFoodName("" + BreakFastFragment.foodBeanList.get(i).getFoodName());
                        sureBean.setfoodNumber("" + MyApplication.numberList.get(i));
                        sureBean.setnumberView("" + BreakFastFragment.foodBeanList.get(i).getFoodPrice());
                        foodBeanList.add(sureBean);
                    } else if (MyApplication.numberTwoList.get(i) != 0) {
                        SureBean sureBean = new SureBean();
                        sureBean.setFoodName("" + BreakFastFragment.foodBeanTwoList.get(i).getFoodName());
                        sureBean.setfoodNumber("" + MyApplication.numberTwoList.get(i));
                        sureBean.setnumberView("" + BreakFastFragment.foodBeanTwoList.get(i).getFoodPrice());
                        foodBeanList.add(sureBean);
                    } else if (MyApplication.numberThreeList.get(i) != 0) {
                        SureBean sureBean = new SureBean();
                        sureBean.setFoodName("" + BreakFastFragment.foodBeanThreeList.get(i).getFoodName());
                        sureBean.setfoodNumber("" + MyApplication.numberThreeList.get(i));
                        sureBean.setnumberView("" + BreakFastFragment.foodBeanThreeList.get(i).getFoodPrice());
                        foodBeanList.add(sureBean);
                    }
                }
            }
        }

        return view;
    }

    public void initControl(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_sureOrder);
        recyclerView.setLayoutManager(linearManager);
        RvSureAdapter foodRecyclerAdapter = new RvSureAdapter<SureBean>(getContext(), foodBeanList) {
            @Override
            public void convert(ViewHolder holder, SureBean item, int position) {
                holder.numberView.setText("" + item.getFoodNumber());
                holder.foodName.setText("" + item.getFoodName());
                holder.foodNumber.setText("" + item.getNumberView());
                RvSureAdapter.arrDouble[position] = Double.parseDouble(item.getFoodNumber());
            }
        } ;
        recyclerView.setAdapter(foodRecyclerAdapter);
        sure_price = (TextView) view.findViewById(R.id.sure_price);
    }
}
