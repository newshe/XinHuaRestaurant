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

    public TextView sure_price;

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

        if (foodBeanList.size() < 1) {
            for (int i = 0; i < BreakFastFragment.foodBeanList.size(); i++) {
                if (MyApplication.numberList.get(i) != 0) {
                    SureBean sureBean = new SureBean();
                    sureBean.setFoodName("" + BreakFastFragment.foodBeanList.get(i).getFoodName());
                    sureBean.setfoodNumber("" + MyApplication.numberList.get(i));
                    foodBeanList.add(sureBean);
                    Log.i(TAG, "onCreateView: " + i);
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
            }
        } ;
        recyclerView.setAdapter(foodRecyclerAdapter);
        sure_price = (TextView) view.findViewById(R.id.sure_price);

    }
}
