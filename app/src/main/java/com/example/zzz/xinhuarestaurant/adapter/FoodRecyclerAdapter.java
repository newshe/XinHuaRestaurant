package com.example.zzz.xinhuarestaurant.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zzz.xinhuarestaurant.MainActivity;
import com.example.zzz.xinhuarestaurant.bean.FoodBean;
import com.example.zzz.xinhuarestaurant.R;

import java.util.List;

/**
 * Created by zzz on 2017/10/27.
 */

public class FoodRecyclerAdapter extends RecyclerView.Adapter<FoodRecyclerAdapter.ViewHolder> {

    public List<FoodBean> foodBeen;

    public FoodBean Bean;

    int num0 = 0;
    int num1 = 0;
    int num2 = 0;
    int num3 = 0;
    int num4 = 0;
    int num5 = 0;
    int num6 = 0;
    int num7 = 0;
    int num8 = 0;
    int num9 = 0;
    int num10 = 0;
    int num11 = 0;
    int num12 = 0;
    int num13 = 0;
    int num14 = 0;

    int allPriceLess0 = 0;
    int allPriceLess1 = 0;
    int allPriceLess2 = 0;
    int allPriceLess3 = 0;
    int allPriceLess4 = 0;
    int allPriceLess5 = 0;
    int allPriceLess6 = 0;
    int allPriceLess7 = 0;
    int allPriceLess8 = 0;
    int allPriceLess9 = 0;
    int allPriceLess10 = 0;
    int allPriceLess11 = 0;
    int allPriceLess12 = 0;
    int allPriceLess13 = 0;
    int allPriceLess14 = 0;

    int allPriceAdd0 = 0;
    int allPriceAdd1 = 0;
    int allPriceAdd2 = 0;
    int allPriceAdd3 = 0;
    int allPriceAdd4 = 0;
    int allPriceAdd5 = 0;
    int allPriceAdd6 = 0;
    int allPriceAdd7 = 0;
    int allPriceAdd8 = 0;
    int allPriceAdd9 = 0;
    int allPriceAdd10 = 0;
    int allPriceAdd11 = 0;
    int allPriceAdd12 = 0;
    int allPriceAdd13 = 0;
    int allPriceAdd14 = 0;


    public FoodRecyclerAdapter(List<FoodBean> foodBeen) {
        this.foodBeen = foodBeen;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_restaurant, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Bean = foodBeen.get(position);
        holder.itemView.setTag(position);
        holder.foodImage.setImageResource(R.drawable.ic_hanbager);
        holder.foodNumber.setText(Bean.getFoodName());
        holder.foodName.setText("鸡蛋");
    }

    @Override
    public int getItemCount() {
        return foodBeen.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        public TextView foodName;
        public TextView foodNumber;
        public ImageView foodImage;

        public Button btnLess;
        public Button btnAdd;
        public TextView numberView;

        public ViewHolder(View itemView) {
            super(itemView);

            foodName = (TextView) itemView.findViewById(R.id.food_name);
            foodNumber = (TextView) itemView.findViewById(R.id.food_number);
            foodImage = (ImageView) itemView.findViewById(R.id.food_image);

            btnLess = (Button) itemView.findViewById(R.id.main_btn_less);
            btnAdd = (Button) itemView.findViewById(R.id.main_btn_add);
            numberView = (TextView) itemView.findViewById(R.id.main_number_view);

            btnAdd.setOnClickListener(this);
            btnLess.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.main_btn_less:

                    less();

                    break;
                case R.id.main_btn_add:
                    add();
                    break;
            }

        }

        public void add() {
            switch ((int) itemView.getTag()) {
                case 0:
                    num0 = num0 + 1;
                    numberView.setText("" + num0);
                    allPriceAdd0 = (Integer.parseInt(foodNumber.getText().toString()) * num0);
                    break;
                case 1:
                    num1 = num1 + 1;
                    numberView.setText("" + num1);
                    allPriceAdd1 = (Integer.parseInt(foodNumber.getText().toString()) * num1);
                    break;
                case 2:
                    num2 = num2 + 1;
                    numberView.setText("" + num2);
                    allPriceAdd2 = (Integer.parseInt(foodNumber.getText().toString()) * num2);
                    break;
                case 3:
                    num3 = num3 + 1;
                    numberView.setText("" + num3);
                    allPriceAdd3 = (Integer.parseInt(foodNumber.getText().toString()) * num3);
                    break;
                case 4:
                    num4 = num4 + 1;
                    numberView.setText("" + num4);
                    allPriceAdd4 = (Integer.parseInt(foodNumber.getText().toString()) * num4);
                    break;
                case 5:
                    num5 = num5 + 1;
                    numberView.setText("" + num5);
                    allPriceAdd5 = (Integer.parseInt(foodNumber.getText().toString()) * num5);
                    break;
                case 6:
                    num6 = num6 + 1;
                    numberView.setText("" + num6);
                    allPriceAdd6 = (Integer.parseInt(foodNumber.getText().toString()) * num6);
                    break;
                case 7:
                    num7 = num7 + 1;
                    numberView.setText("" + num7);
                    allPriceAdd7 = (Integer.parseInt(foodNumber.getText().toString()) * num7);
                    break;
                case 8:
                    num8 = num8 + 1;
                    numberView.setText("" + num8);
                    allPriceAdd8 = (Integer.parseInt(foodNumber.getText().toString()) * num8);
                    break;
                case 9:
                    num9 = num9 + 1;
                    numberView.setText("" + num9);
                    allPriceAdd9 = (Integer.parseInt(foodNumber.getText().toString()) * num9);
                    break;
                case 10:
                    num10 = num10 + 1;
                    numberView.setText("" + num10);
                    allPriceAdd10 = (Integer.parseInt(foodNumber.getText().toString()) * num10);
                    break;
                case 11:
                    num11 = num11 + 1;
                    numberView.setText("" + num11);
                    allPriceAdd11 = (Integer.parseInt(foodNumber.getText().toString()) * num11);
                    break;
                case 12:
                    num12 = num12 + 1;
                    numberView.setText("" + num12);
                    allPriceAdd12 = (Integer.parseInt(foodNumber.getText().toString()) * num12);
                    break;
                case 13:
                    num13 = num13 + 1;
                    numberView.setText("" + num13);
                    allPriceAdd13 = (Integer.parseInt(foodNumber.getText().toString()) * num13);
                    break;
                case 14:
                    num14 = num14 + 1;
                    numberView.setText("" + num14);
                    allPriceAdd14 = (Integer.parseInt(foodNumber.getText().toString()) * num14);
                    break;
            }
            int all = allPriceAdd0 + allPriceAdd1 + allPriceAdd2 + allPriceAdd3 + allPriceAdd4 + allPriceAdd5 + allPriceAdd6
                    + allPriceAdd7 + allPriceAdd8 + allPriceAdd9 + allPriceAdd10 + allPriceAdd11 + allPriceAdd12 + allPriceAdd13
                    + allPriceAdd14;
            Log.i("ppt", "add: " + all);

        }

        public void less() {
            switch ((int) itemView.getTag()) {
                case 0:
                    if (num0 > 0)
                        num0 = num0 - 1;
                    numberView.setText("" + num0);
                    allPriceLess0 = (Integer.parseInt(foodNumber.getText().toString()) * num0);
                    break;
                case 1:
                    if (num1 > 0)
                        num1 = num1 - 1;
                    numberView.setText("" + num1);
                    allPriceLess1 = (Integer.parseInt(foodNumber.getText().toString()) * num1);
                    break;
                case 2:
                    if (num2 > 0)
                        num2 = num2 - 1;
                    numberView.setText("" + num2);
                    allPriceLess2 = (Integer.parseInt(foodNumber.getText().toString()) * num2);
                    break;
                case 3:
                    if (num3 > 0)
                        num3 = num3 - 1;
                    numberView.setText("" + num3);
                    allPriceLess3 = (Integer.parseInt(foodNumber.getText().toString()) * num3);
                    break;
                case 4:
                    if (num4 > 0)
                        num4 = num4 - 1;
                    numberView.setText("" + num4);
                    allPriceLess4 = (Integer.parseInt(foodNumber.getText().toString()) * num4);
                    break;
                case 5:
                    if (num5 > 0)
                        num5 = num5 - 1;
                    numberView.setText("" + num5);
                    allPriceLess5 = (Integer.parseInt(foodNumber.getText().toString()) * num5);
                    break;
                case 6:
                    if (num6 > 0)
                        num6 = num6 - 1;
                    numberView.setText("" + num6);
                    allPriceLess6 = (Integer.parseInt(foodNumber.getText().toString()) * num6);
                    break;
                case 7:
                    if (num7 > 0)
                        num7 = num7 - 1;
                    numberView.setText("" + num7);
                    allPriceLess7 = (Integer.parseInt(foodNumber.getText().toString()) * num7);
                    break;
                case 8:
                    if (num8 > 0)
                        num8 = num8 - 1;
                    numberView.setText("" + num8);
                    allPriceLess8 = (Integer.parseInt(foodNumber.getText().toString()) * num8);
                    break;
                case 9:
                    if (num9 > 0)
                        num9 = num9 - 1;
                    numberView.setText("" + num9);
                    allPriceLess9 = (Integer.parseInt(foodNumber.getText().toString()) * num9);
                    break;
                case 10:
                    if (num10 > 0)
                        num10 = num10 - 1;
                    numberView.setText("" + num10);
                    allPriceLess10 = (Integer.parseInt(foodNumber.getText().toString()) * num10);
                    break;
                case 11:
                    if (num11 > 0)
                        num11 = num11 - 1;
                    numberView.setText("" + num11);
                    allPriceLess11 = (Integer.parseInt(foodNumber.getText().toString()) * num11);
                    break;
                case 12:
                    if (num12 > 0)
                        num12 = num12 - 1;
                    numberView.setText("" + num12);
                    allPriceLess12 = (Integer.parseInt(foodNumber.getText().toString()) * num12);
                    break;
                case 13:
                    if (num13 > 0)
                        num13 = num13 - 1;
                    numberView.setText("" + num13);
                    allPriceLess13 = (Integer.parseInt(foodNumber.getText().toString()) * num13);
                    break;
                case 14:
                    if (num14 > 0)
                        num14 = num14 - 1;
                    numberView.setText("" + num14);
                    allPriceLess14 = (Integer.parseInt(foodNumber.getText().toString()) * num14);
                    break;
            }
            int all = allPriceLess0 + allPriceLess1 + allPriceLess2 + allPriceLess3 + allPriceLess4 + allPriceLess5 + allPriceLess6
                    + allPriceLess7 + allPriceLess8 + allPriceLess9 + allPriceLess10 + allPriceLess11 + allPriceLess12 + allPriceLess13
                    + allPriceLess14;
            Log.i("ppt", "less: " + all);
        }
    }
}
