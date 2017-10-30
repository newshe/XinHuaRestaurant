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
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.zzz.xinhuarestaurant.bean.FoodBean;
import com.example.zzz.xinhuarestaurant.R;
import com.example.zzz.xinhuarestaurant.adapter.FoodRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzz on 2017/10/25.
 */

public class BreakFastFragment extends Fragment implements View.OnClickListener {

    public List<FoodBean> foodBeanList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.breakfast,container,false);

        initControl(view);

        initView(view);

        return view;

    }

    public void initControl(View view) {

        ImageButton returnBtn = (ImageButton) view.findViewById(R.id.main_return_btn);
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });

        TextView price = (TextView) view.findViewById(R.id.price);
        TextView first = (TextView) view.findViewById(R.id.first);
        TextView secoend = (TextView) view.findViewById(R.id.second);
        TextView third = (TextView) view.findViewById(R.id.third);
        //如果数据已经存在，就不需要在进行添加
        if (foodBeanList.size() <= 1){
            initBean();
        }
        RecyclerView breakFast = (RecyclerView) view.findViewById(R.id.breakfast_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        breakFast.setLayoutManager(layoutManager);
        FoodRecyclerAdapter foodAdapter = new FoodRecyclerAdapter(foodBeanList);
        breakFast.setAdapter(foodAdapter);

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
        for (int i = 0; i < 10; i++) {
            FoodBean food = new FoodBean("" + i);
            foodBeanList.add(food);
        }
    }

    @Override
    public void onClick(View v) {

    }
}
