package com.example.zzz.xinhuarestaurant.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zzz.xinhuarestaurant.R;
import com.example.zzz.xinhuarestaurant.application.MyApplication;
import com.example.zzz.xinhuarestaurant.fragment.BreakFastFragment;

import java.util.List;

import static com.example.zzz.xinhuarestaurant.application.MyApplication.numberThreeList;
import static com.example.zzz.xinhuarestaurant.application.MyApplication.numberThreeListThree;
import static com.example.zzz.xinhuarestaurant.application.MyApplication.numberTwoList;
import static com.example.zzz.xinhuarestaurant.application.MyApplication.numberTwoListThree;

/**
 * Created by zzz on 2017/10/27.
 */

public abstract class FoodRecyclerThreeAdapter<T> extends RecyclerView.Adapter<FoodRecyclerThreeAdapter.ViewHolder> {

    public String TAG = "ppt";

    public List<T> bean;

    private static double num0 = 0;
    private static double num1 = 0;
    private static double num2 = 0;
    private static double num3 = 0;
    private static double num4 = 0;
    private static double num5 = 0;
    private static double num6 = 0;
    private static double num7 = 0;
    private static double num8 = 0;
    private static double num9 = 0;
    private static double num10 = 0;
    private static double num11 = 0;
    private static double num12 = 0;
    private static double num13 = 0;
    private static double num14 = 0;

    private static double numTwo0 = 0;
    private static double numTwo1 = 0;
    private static double numTwo2 = 0;
    private static double numTwo3 = 0;
    private static double numTwo4 = 0;
    private static double numTwo5 = 0;
    private static double numTwo6 = 0;
    private static double numTwo7 = 0;
    private static double numTwo8 = 0;
    private static double numTwo9 = 0;
    private static double numTwo10 = 0;
    private static double numTwo11 = 0;
    private static double numTwo12 = 0;
    private static double numTwo13 = 0;
    private static double numTwo14 = 0;

    private static double numThree0 = 0;
    private static double numThree1 = 0;
    private static double numThree2 = 0;
    private static double numThree3 = 0;
    private static double numThree4 = 0;
    private static double numThree5 = 0;
    private static double numThree6 = 0;
    private static double numThree7 = 0;
    private static double numThree8 = 0;
    private static double numThree9 = 0;
    private static double numThree10 = 0;
    private static double numThree11 = 0;
    private static double numThree12 = 0;
    private static double numThree13 = 0;
    private static double numThree14 = 0;

    private static double allPriceAdd0 = 0;
    private static double allPriceAdd1 = 0;
    private static double allPriceAdd2 = 0;
    private static double allPriceAdd3 = 0;
    private static double allPriceAdd4 = 0;
    private static double allPriceAdd5 = 0;
    private static double allPriceAdd6 = 0;
    private static double allPriceAdd7 = 0;
    private static double allPriceAdd8 = 0;
    private static double allPriceAdd9 = 0;
    private static double allPriceAdd10 = 0;
    private static double allPriceAdd11 = 0;
    private static double allPriceAdd12 = 0;
    private static double allPriceAdd13 = 0;
    private static double allPriceAdd14 = 0;

    public static double all = 0;
    public static double allOne = 0;
    public static double allTwo = 0;
    public static double allThree = 0;
    public Context context;//上下文

    public LayoutInflater inflater;//布局器



    public FoodRecyclerThreeAdapter(Context context, List<T> foodBeen) {
        this.bean = foodBeen;
        this.context = context;
        this.inflater= LayoutInflater.from(context);
        Log.i(TAG, "FoodRecyclerAdapter: " + bean.size());

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_restaurant, parent, false);



        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final FoodRecyclerThreeAdapter.ViewHolder holder, int position) {

        holder.itemView.setTag(position);
        holder.foodImage.setImageResource(R.drawable.ic_hanbager);
        holder.foodName.setText("鸡蛋"+MyApplication.numberList.get(position));
        convert(holder, bean.get(position), position);
    }

    @Override
    public int getItemCount() {
        return bean.size();
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

            if (BreakFastFragment.recyclerView == 1) {
                switch ((int) itemView.getTag()) {
                    case 0:
                        num0 = num0 + 1;
                        numberView.setText("" + num0);
                        allPriceAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * num0);
                        break;
                    case 1:
                        num1 = num1 + 1;
                        numberView.setText("" + num1);
                        allPriceAdd1 = (Double.parseDouble(foodNumber.getText().toString()) * num1);
                        break;
                    case 2:
                        num2 = num2 + 1;
                        numberView.setText("" + num2);
                        allPriceAdd2 = (Double.parseDouble(foodNumber.getText().toString()) * num2);
                        break;
                    case 3:
                        num3 = num3 + 1;
                        numberView.setText("" + num3);
                        allPriceAdd3 = (Double.parseDouble(foodNumber.getText().toString()) * num3);
                        break;
                    case 4:
                        num4 = num4 + 1;
                        numberView.setText("" + num4);
                        allPriceAdd4 = (Double.parseDouble(foodNumber.getText().toString()) * num4);
                        break;
                    case 5:
                        num5 = num5 + 1;
                        numberView.setText("" + num5);
                        allPriceAdd5 = (Double.parseDouble(foodNumber.getText().toString()) * num5);
                        break;
                    case 6:
                        num6 = num6 + 1;
                        numberView.setText("" + num6);
                        allPriceAdd6 = (Double.parseDouble(foodNumber.getText().toString()) * num6);
                        break;
                    case 7:
                        num7 = num7 + 1;
                        numberView.setText("" + num7);
                        allPriceAdd7 = (Double.parseDouble(foodNumber.getText().toString()) * num7);
                        break;
                    case 8:
                        num8 = num8 + 1;
                        numberView.setText("" + num8);
                        allPriceAdd8 = (Double.parseDouble(foodNumber.getText().toString()) * num8);
                        break;
                    case 9:
                        num9 = num9 + 1;
                        numberView.setText("" + num9);
                        allPriceAdd9 = (Double.parseDouble(foodNumber.getText().toString()) * num9);
                        break;
                    case 10:
                        num10 = num10 + 1;
                        numberView.setText("" + num10);
                        allPriceAdd10 = (Double.parseDouble(foodNumber.getText().toString()) * num10);
                        break;
                    case 11:
                        num11 = num11 + 1;
                        numberView.setText("" + num11);
                        allPriceAdd11 = (Double.parseDouble(foodNumber.getText().toString()) * num11);
                        break;
                    case 12:
                        num12 = num12 + 1;
                        numberView.setText("" + num12);
                        allPriceAdd12 = (Double.parseDouble(foodNumber.getText().toString()) * num12);
                        break;
                    case 13:
                        num13 = num13 + 1;
                        numberView.setText("" + num13);
                        allPriceAdd13 = (Double.parseDouble(foodNumber.getText().toString()) * num13);
                        break;
                    case 14:
                        num14 = num14 + 1;
                        numberView.setText("" + num14);
                        allPriceAdd14 = (Double.parseDouble(foodNumber.getText().toString()) * num14);
                        break;
                }
                MyApplication.numberListThree.set(0,num0);
                MyApplication.numberListThree.set(1,num1);
                MyApplication.numberListThree.set(2,num2);
                MyApplication.numberListThree.set(3,num3);
                MyApplication.numberListThree.set(4,num4);
                MyApplication.numberListThree.set(5,num5);
                MyApplication.numberListThree.set(6,num6);
                MyApplication.numberListThree.set(7,num7);
                MyApplication.numberListThree.set(8,num8);
                MyApplication.numberListThree.set(9,num9);
                MyApplication.numberListThree.set(10,num10);
                MyApplication.numberListThree.set(11,num11);
                MyApplication.numberListThree.set(12,num12);
                MyApplication.numberListThree.set(13,num13);

                allOne = allPriceAdd0 + allPriceAdd1 + allPriceAdd2 + allPriceAdd3 + allPriceAdd4 + allPriceAdd5 + allPriceAdd6
                        + allPriceAdd7 + allPriceAdd8 + allPriceAdd9 + allPriceAdd10 + allPriceAdd11 + allPriceAdd12 + allPriceAdd13
                        + allPriceAdd14;
            }
            if (BreakFastFragment.recyclerView == 2) {
                switch ((int) itemView.getTag()) {
                    case 0:
                        numTwo0 = numTwo0 + 1;
                        numberView.setText("" + numTwo0);
                        allPriceAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo0);
                        break;
                    case 1:
                        numTwo1 = numTwo1 + 1;
                        numberView.setText("" + numTwo1);
                        allPriceAdd1 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo1);
                        break;
                    case 2:
                        numTwo2 = numTwo2 + 1;
                        numberView.setText("" + numTwo2);
                        allPriceAdd2 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo2);
                        break;
                    case 3:
                        numTwo3 = numTwo3 + 1;
                        numberView.setText("" + numTwo3);
                        allPriceAdd3 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo3);
                        break;
                    case 4:
                        numTwo4 = numTwo4 + 1;
                        numberView.setText("" + numTwo4);
                        allPriceAdd4 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo4);
                        break;
                    case 5:
                        numTwo5 = numTwo5 + 1;
                        numberView.setText("" + numTwo5);
                        allPriceAdd5 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo5);
                        break;
                    case 6:
                        numTwo6 = numTwo6 + 1;
                        numberView.setText("" + numTwo6);
                        allPriceAdd6 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo6);
                        break;
                    case 7:
                        numTwo7 = numTwo7 + 1;
                        numberView.setText("" + numTwo7);
                        allPriceAdd7 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo7);
                        break;
                    case 8:
                        numTwo8 = numTwo8 + 1;
                        numberView.setText("" + numTwo8);
                        allPriceAdd8 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo8);
                        break;
                    case 9:
                        numTwo9 = numTwo9 + 1;
                        numberView.setText("" + numTwo9);
                        allPriceAdd9 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo9);
                        break;
                    case 10:
                        numTwo10 = numTwo10 + 1;
                        numberView.setText("" + numTwo10);
                        allPriceAdd10 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo10);
                        break;
                    case 11:
                        numTwo11 = numTwo11 + 1;
                        numberView.setText("" + numTwo11);
                        allPriceAdd11 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo11);
                        break;
                    case 12:
                        numTwo12 = numTwo12 + 1;
                        numberView.setText("" + numTwo12);
                        allPriceAdd12 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo12);
                        break;
                    case 13:
                        numTwo13 = numTwo13 + 1;
                        numberView.setText("" + numTwo13);
                        allPriceAdd13 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo13);
                        break;
                    case 14:
                        numTwo14 = numTwo14 + 1;
                        numberView.setText("" + numTwo14);
                        allPriceAdd14 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo14);
                        break;
                }
                numberTwoListThree.set(0,numTwo0);
                numberTwoListThree.set(1,numTwo1);
                numberTwoListThree.set(2,numTwo2);
                numberTwoListThree.set(3,numTwo3);
                numberTwoListThree.set(4,numTwo4);
                numberTwoListThree.set(5,numTwo5);
                numberTwoListThree.set(6,numTwo6);
                numberTwoListThree.set(7,numTwo7);
                numberTwoListThree.set(8,numTwo8);
                numberTwoListThree.set(9,numTwo9);
                numberTwoListThree.set(10,numTwo10);
                numberTwoListThree.set(11,numTwo11);
                numberTwoListThree.set(12,numTwo12);
                numberTwoListThree.set(13,numTwo13);

                allTwo = allPriceAdd0 + allPriceAdd1 + allPriceAdd2 + allPriceAdd3 + allPriceAdd4 + allPriceAdd5 + allPriceAdd6
                        + allPriceAdd7 + allPriceAdd8 + allPriceAdd9 + allPriceAdd10 + allPriceAdd11 + allPriceAdd12 + allPriceAdd13
                        + allPriceAdd14;
            }
            if (BreakFastFragment.recyclerView == 3) {
                switch ((int) itemView.getTag()) {
                    case 0:
                        numThree0 = numThree0 + 1;
                        numberView.setText("" + numThree0);
                        allPriceAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * numThree0);
                        break;
                    case 1:
                        numThree1 = numThree1 + 1;
                        numberView.setText("" + numThree1);
                        allPriceAdd1 = (Double.parseDouble(foodNumber.getText().toString()) * numThree1);
                        break;
                    case 2:
                        numThree2 = numThree2 + 1;
                        numberView.setText("" + numThree2);
                        allPriceAdd2 = (Double.parseDouble(foodNumber.getText().toString()) * numThree2);
                        break;
                    case 3:
                        numThree3 = numThree3 + 1;
                        numberView.setText("" + numThree3);
                        allPriceAdd3 = (Double.parseDouble(foodNumber.getText().toString()) * numThree3);
                        break;
                    case 4:
                        numThree4 = numThree4 + 1;
                        numberView.setText("" + numThree4);
                        allPriceAdd4 = (Double.parseDouble(foodNumber.getText().toString()) * numThree4);
                        break;
                    case 5:
                        numThree5 = numThree5 + 1;
                        numberView.setText("" + numThree5);
                        allPriceAdd5 = (Double.parseDouble(foodNumber.getText().toString()) * numThree5);
                        break;
                    case 6:
                        numThree6 = numThree6 + 1;
                        numberView.setText("" + numThree6);
                        allPriceAdd6 = (Double.parseDouble(foodNumber.getText().toString()) * numThree6);
                        break;
                    case 7:
                        numThree7 = numThree7 + 1;
                        numberView.setText("" + numThree7);
                        allPriceAdd7 = (Double.parseDouble(foodNumber.getText().toString()) * numThree7);
                        break;
                    case 8:
                        numThree8 = numThree8 + 1;
                        numberView.setText("" + numThree8);
                        allPriceAdd8 = (Double.parseDouble(foodNumber.getText().toString()) * numThree8);
                        break;
                    case 9:
                        numThree9 = numThree9 + 1;
                        numberView.setText("" + numThree9);
                        allPriceAdd9 = (Double.parseDouble(foodNumber.getText().toString()) * numThree9);
                        break;
                    case 10:
                        numThree10 = numThree10 + 1;
                        numberView.setText("" + numThree10);
                        allPriceAdd10 = (Double.parseDouble(foodNumber.getText().toString()) * numThree10);
                        break;
                    case 11:
                        numThree11 = numThree11 + 1;
                        numberView.setText("" + numThree11);
                        allPriceAdd11 = (Double.parseDouble(foodNumber.getText().toString()) * numThree11);
                        break;
                    case 12:
                        numThree12 = numThree12 + 1;
                        numberView.setText("" + numThree12);
                        allPriceAdd12 = (Double.parseDouble(foodNumber.getText().toString()) * numThree12);
                        break;
                    case 13:
                        numThree13 = numThree13 + 1;
                        numberView.setText("" + numThree13);
                        allPriceAdd13 = (Double.parseDouble(foodNumber.getText().toString()) * numThree13);
                        break;
                    case 14:
                        numThree14 = numThree14 + 1;
                        numberView.setText("" + numThree14);
                        allPriceAdd14 = (Double.parseDouble(foodNumber.getText().toString()) * numThree14);
                        break;
                }
                numberThreeListThree.set(0,numThree0);
                numberThreeListThree.set(1,numThree1);
                numberThreeListThree.set(2,numThree2);
                numberThreeListThree.set(3,numThree3);
                numberThreeListThree.set(4,numThree4);
                numberThreeListThree.set(5,numThree5);
                numberThreeListThree.set(6,numThree6);
                numberThreeListThree.set(7,numThree7);
                numberThreeListThree.set(8,numThree8);
                numberThreeListThree.set(9,numThree9);
                numberThreeListThree.set(10,numThree10);
                numberThreeListThree.set(11,numThree11);
                numberThreeListThree.set(12,numThree12);
                numberThreeListThree.set(13,numThree13);

                allThree = allPriceAdd0 + allPriceAdd1 + allPriceAdd2 + allPriceAdd3 + allPriceAdd4 + allPriceAdd5 + allPriceAdd6
                        + allPriceAdd7 + allPriceAdd8 + allPriceAdd9 + allPriceAdd10 + allPriceAdd11 + allPriceAdd12 + allPriceAdd13
                        + allPriceAdd14;
            }

            all = allOne + allThree + allTwo;

            BreakFastFragment.price.setText(""  + all);
            Log.i("ppt", "add: " + BreakFastFragment.AllOne +"---"+ BreakFastFragment.AllTwo+"---"+BreakFastFragment.AllThree);

        }

        public void less() {
            if (BreakFastFragment.recyclerView == 1) {
                switch ((int) itemView.getTag()) {
                    case 0:
                        num0 = num0 - 1;
                        numberView.setText("" + num0);
                        allPriceAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * num0);
                        break;
                    case 1:
                        num1 = num1 - 1;
                        numberView.setText("" + num1);
                        allPriceAdd1 = (Double.parseDouble(foodNumber.getText().toString()) * num1);
                        break;
                    case 2:
                        num2 = num2 - 1;
                        numberView.setText("" + num2);
                        allPriceAdd2 = (Double.parseDouble(foodNumber.getText().toString()) * num2);
                        break;
                    case 3:
                        num3 = num3 - 1;
                        numberView.setText("" + num3);
                        allPriceAdd3 = (Double.parseDouble(foodNumber.getText().toString()) * num3);
                        break;
                    case 4:
                        num4 = num4 - 1;
                        numberView.setText("" + num4);
                        allPriceAdd4 = (Double.parseDouble(foodNumber.getText().toString()) * num4);
                        break;
                    case 5:
                        num5 = num5 - 1;
                        numberView.setText("" + num5);
                        allPriceAdd5 = (Double.parseDouble(foodNumber.getText().toString()) * num5);
                        break;
                    case 6:
                        num6 = num6 - 1;
                        numberView.setText("" + num6);
                        allPriceAdd6 = (Double.parseDouble(foodNumber.getText().toString()) * num6);
                        break;
                    case 7:
                        num7 = num7 - 1;
                        numberView.setText("" + num7);
                        allPriceAdd7 = (Double.parseDouble(foodNumber.getText().toString()) * num7);
                        break;
                    case 8:
                        num8 = num8 - 1;
                        numberView.setText("" + num8);
                        allPriceAdd8 = (Double.parseDouble(foodNumber.getText().toString()) * num8);
                        break;
                    case 9:
                        num9 = num9 - 1;
                        numberView.setText("" + num9);
                        allPriceAdd9 = (Double.parseDouble(foodNumber.getText().toString()) * num9);
                        break;
                    case 10:
                        num10 = num10 - 1;
                        numberView.setText("" + num10);
                        allPriceAdd10 = (Double.parseDouble(foodNumber.getText().toString()) * num10);
                        break;
                    case 11:
                        num11 = num11 - 1;
                        numberView.setText("" + num11);
                        allPriceAdd11 = (Double.parseDouble(foodNumber.getText().toString()) * num11);
                        break;
                    case 12:
                        num12 = num12 - 1;
                        numberView.setText("" + num12);
                        allPriceAdd12 = (Double.parseDouble(foodNumber.getText().toString()) * num12);
                        break;
                    case 13:
                        num13 = num13 - 1;
                        numberView.setText("" + num13);
                        allPriceAdd13 = (Double.parseDouble(foodNumber.getText().toString()) * num13);
                        break;
                    case 14:
                        num14 = num14 - 1;
                        numberView.setText("" + num14);
                        allPriceAdd14 = (Double.parseDouble(foodNumber.getText().toString()) * num14);
                        break;
                }
                MyApplication.numberListThree.set(0,num0);
                MyApplication.numberListThree.set(1,num1);
                MyApplication.numberListThree.set(2,num2);
                MyApplication.numberListThree.set(3,num3);
                MyApplication.numberListThree.set(4,num4);
                MyApplication.numberListThree.set(5,num5);
                MyApplication.numberListThree.set(6,num6);
                MyApplication.numberListThree.set(7,num7);
                MyApplication.numberListThree.set(8,num8);
                MyApplication.numberListThree.set(9,num9);
                MyApplication.numberListThree.set(10,num10);
                MyApplication.numberListThree.set(11,num11);
                MyApplication.numberListThree.set(12,num12);
                MyApplication.numberListThree.set(13,num13);

                allOne = allPriceAdd0 + allPriceAdd1 + allPriceAdd2 + allPriceAdd3 + allPriceAdd4 + allPriceAdd5 + allPriceAdd6
                        + allPriceAdd7 + allPriceAdd8 + allPriceAdd9 + allPriceAdd10 + allPriceAdd11 + allPriceAdd12 + allPriceAdd13
                        + allPriceAdd14;
            }
            if (BreakFastFragment.recyclerView == 2) {
                switch ((int) itemView.getTag()) {
                    case 0:
                        numTwo0 = numTwo0 - 1;
                        numberView.setText("" + numTwo0);
                        allPriceAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo0);
                        break;
                    case 1:
                        numTwo1 = numTwo1 - 1;
                        numberView.setText("" + numTwo1);
                        allPriceAdd1 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo1);
                        break;
                    case 2:
                        numTwo2 = numTwo2 - 1;
                        numberView.setText("" + numTwo2);
                        allPriceAdd2 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo2);
                        break;
                    case 3:
                        numTwo3 = numTwo3 - 1;
                        numberView.setText("" + numTwo3);
                        allPriceAdd3 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo3);
                        break;
                    case 4:
                        numTwo4 = numTwo4 - 1;
                        numberView.setText("" + numTwo4);
                        allPriceAdd4 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo4);
                        break;
                    case 5:
                        numTwo5 = numTwo5 - 1;
                        numberView.setText("" + numTwo5);
                        allPriceAdd5 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo5);
                        break;
                    case 6:
                        numTwo6 = numTwo6 - 1;
                        numberView.setText("" + numTwo6);
                        allPriceAdd6 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo6);
                        break;
                    case 7:
                        numTwo7 = numTwo7 - 1;
                        numberView.setText("" + numTwo7);
                        allPriceAdd7 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo7);
                        break;
                    case 8:
                        numTwo8 = numTwo8 - 1;
                        numberView.setText("" + numTwo8);
                        allPriceAdd8 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo8);
                        break;
                    case 9:
                        numTwo9 = numTwo9 - 1;
                        numberView.setText("" + numTwo9);
                        allPriceAdd9 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo9);
                        break;
                    case 10:
                        numTwo10 = numTwo10 - 1;
                        numberView.setText("" + numTwo10);
                        allPriceAdd10 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo10);
                        break;
                    case 11:
                        numTwo11 = numTwo11 - 1;
                        numberView.setText("" + numTwo11);
                        allPriceAdd11 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo11);
                        break;
                    case 12:
                        numTwo12 = numTwo12 - 1;
                        numberView.setText("" + numTwo12);
                        allPriceAdd12 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo12);
                        break;
                    case 13:
                        numTwo13 = numTwo13 - 1;
                        numberView.setText("" + numTwo13);
                        allPriceAdd13 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo13);
                        break;
                    case 14:
                        numTwo14 = numTwo14 - 1;
                        numberView.setText("" + numTwo14);
                        allPriceAdd14 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo14);
                        break;
                }
                numberTwoListThree.set(0,numTwo0);
                numberTwoListThree.set(1,numTwo1);
                numberTwoListThree.set(2,numTwo2);
                numberTwoListThree.set(3,numTwo3);
                numberTwoListThree.set(4,numTwo4);
                numberTwoListThree.set(5,numTwo5);
                numberTwoListThree.set(6,numTwo6);
                numberTwoListThree.set(7,numTwo7);
                numberTwoListThree.set(8,numTwo8);
                numberTwoListThree.set(9,numTwo9);
                numberTwoListThree.set(10,numTwo10);
                numberTwoListThree.set(11,numTwo11);
                numberTwoListThree.set(12,numTwo12);
                numberTwoListThree.set(13,numTwo13);

                allTwo = allPriceAdd0 + allPriceAdd1 + allPriceAdd2 + allPriceAdd3 + allPriceAdd4 + allPriceAdd5 + allPriceAdd6
                        + allPriceAdd7 + allPriceAdd8 + allPriceAdd9 + allPriceAdd10 + allPriceAdd11 + allPriceAdd12 + allPriceAdd13
                        + allPriceAdd14;
            }
            if (BreakFastFragment.recyclerView == 3) {
                switch ((int) itemView.getTag()) {
                    case 0:
                        numThree0 = numThree0 - 1;
                        numberView.setText("" + numThree0);
                        allPriceAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * numThree0);
                        break;
                    case 1:
                        numThree1 = numThree1 - 1;
                        numberView.setText("" + numThree1);
                        allPriceAdd1 = (Double.parseDouble(foodNumber.getText().toString()) * numThree1);
                        break;
                    case 2:
                        numThree2 = numThree2 - 1;
                        numberView.setText("" + numThree2);
                        allPriceAdd2 = (Double.parseDouble(foodNumber.getText().toString()) * numThree2);
                        break;
                    case 3:
                        numThree3 = numThree3 - 1;
                        numberView.setText("" + numThree3);
                        allPriceAdd3 = (Double.parseDouble(foodNumber.getText().toString()) * numThree3);
                        break;
                    case 4:
                        numThree4 = numThree4 - 1;
                        numberView.setText("" + numThree4);
                        allPriceAdd4 = (Double.parseDouble(foodNumber.getText().toString()) * numThree4);
                        break;
                    case 5:
                        numThree5 = numThree5 - 1;
                        numberView.setText("" + numThree5);
                        allPriceAdd5 = (Double.parseDouble(foodNumber.getText().toString()) * numThree5);
                        break;
                    case 6:
                        numThree6 = numThree6 - 1;
                        numberView.setText("" + numThree6);
                        allPriceAdd6 = (Double.parseDouble(foodNumber.getText().toString()) * numThree6);
                        break;
                    case 7:
                        numThree7 = numThree7 - 1;
                        numberView.setText("" + numThree7);
                        allPriceAdd7 = (Double.parseDouble(foodNumber.getText().toString()) * numThree7);
                        break;
                    case 8:
                        numThree8 = numThree8 - 1;
                        numberView.setText("" + numThree8);
                        allPriceAdd8 = (Double.parseDouble(foodNumber.getText().toString()) * numThree8);
                        break;
                    case 9:
                        numThree9 = numThree9 - 1;
                        numberView.setText("" + numThree9);
                        allPriceAdd9 = (Double.parseDouble(foodNumber.getText().toString()) * numThree9);
                        break;
                    case 10:
                        numThree10 = numThree10 - 1;
                        numberView.setText("" + numThree10);
                        allPriceAdd10 = (Double.parseDouble(foodNumber.getText().toString()) * numThree10);
                        break;
                    case 11:
                        numThree11 = numThree11 - 1;
                        numberView.setText("" + numThree11);
                        allPriceAdd11 = (Double.parseDouble(foodNumber.getText().toString()) * numThree11);
                        break;
                    case 12:
                        numThree12 = numThree12 - 1;
                        numberView.setText("" + numThree12);
                        allPriceAdd12 = (Double.parseDouble(foodNumber.getText().toString()) * numThree12);
                        break;
                    case 13:
                        numThree13 = numThree13 - 1;
                        numberView.setText("" + numThree13);
                        allPriceAdd13 = (Double.parseDouble(foodNumber.getText().toString()) * numThree13);
                        break;
                    case 14:
                        numThree14 = numThree14 - 1;
                        numberView.setText("" + numThree14);
                        allPriceAdd14 = (Double.parseDouble(foodNumber.getText().toString()) * numThree14);
                        break;
                }
                numberThreeListThree.set(0,numThree0);
                numberThreeListThree.set(1,numThree1);
                numberThreeListThree.set(2,numThree2);
                numberThreeListThree.set(3,numThree3);
                numberThreeListThree.set(4,numThree4);
                numberThreeListThree.set(5,numThree5);
                numberThreeListThree.set(6,numThree6);
                numberThreeListThree.set(7,numThree7);
                numberThreeListThree.set(8,numThree8);
                numberThreeListThree.set(9,numThree9);
                numberThreeListThree.set(10,numThree10);
                numberThreeListThree.set(11,numThree11);
                numberThreeListThree.set(12,numThree12);
                numberThreeListThree.set(13,numThree13);

                allThree = allPriceAdd0 + allPriceAdd1 + allPriceAdd2 + allPriceAdd3 + allPriceAdd4 + allPriceAdd5 + allPriceAdd6
                        + allPriceAdd7 + allPriceAdd8 + allPriceAdd9 + allPriceAdd10 + allPriceAdd11 + allPriceAdd12 + allPriceAdd13
                        + allPriceAdd14;
            }

            all = allOne + allThree + allTwo;

            BreakFastFragment.price.setText(""  + all);
            Log.i("ppt", "add: " + BreakFastFragment.AllOne +"---"+ BreakFastFragment.AllTwo+"---"+BreakFastFragment.AllThree);

        }

    }
    public abstract void convert(ViewHolder holder, T item, int position);
}
