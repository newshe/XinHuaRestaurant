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

import com.example.zzz.xinhuarestaurant.MainActivity;
import com.example.zzz.xinhuarestaurant.application.MyApplication;
import com.example.zzz.xinhuarestaurant.bean.FoodBean;
import com.example.zzz.xinhuarestaurant.R;
import com.example.zzz.xinhuarestaurant.bean.FoodBeanThree;
import com.example.zzz.xinhuarestaurant.bean.FoodBeanTwo;
import com.example.zzz.xinhuarestaurant.fragment.BreakFastFragment;
import com.example.zzz.xinhuarestaurant.fragment.LunchFragment;

import java.util.ArrayList;
import java.util.List;

import static com.example.zzz.xinhuarestaurant.application.MyApplication.numberTwoList;
import static com.example.zzz.xinhuarestaurant.application.MyApplication.numberThreeList;

/**
 * Created by zzz on 2017/10/27.
 */

public abstract class FoodRecyclerAdapter<T> extends RecyclerView.Adapter<FoodRecyclerAdapter.ViewHolder> {

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

    private double numTwo0 = 0;
    private double numTwo1 = 0;
    private double numTwo2 = 0;
    private double numTwo3 = 0;
    private double numTwo4 = 0;
    private double numTwo5 = 0;
    private double numTwo6 = 0;
    private double numTwo7 = 0;
    private double numTwo8 = 0;
    private double numTwo9 = 0;
    private double numTwo10 = 0;
    private double numTwo11 = 0;
    private double numTwo12 = 0;
    private double numTwo13 = 0;
    private double numTwo14 = 0;

    private static double numThree0 = 0; //###
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

    private double allPriceAdd0 = 0;
    private double allPriceAdd1 = 0;
    private double allPriceAdd2 = 0;
    private double allPriceAdd3 = 0;
    private double allPriceAdd4 = 0;
    private double allPriceAdd5 = 0;
    private double allPriceAdd6 = 0;
    private double allPriceAdd7 = 0;
    private double allPriceAdd8 = 0;
    private double allPriceAdd9 = 0;
    private double allPriceAdd10 = 0;
    private double allPriceAdd11 = 0;
    private double allPriceAdd12 = 0;
    private double allPriceAdd13 = 0;
    private double allPriceAdd14 = 0;

    private double allPriceTwoAdd0 = 0;
    private double allPriceTwoAdd1 = 0;
    private double allPriceTwoAdd2 = 0;
    private double allPriceTwoAdd3 = 0;
    private double allPriceTwoAdd4 = 0;
    private double allPriceTwoAdd5 = 0;
    private double allPriceTwoAdd6 = 0;
    private double allPriceTwoAdd7 = 0;
    private double allPriceTwoAdd8 = 0;
    private double allPriceTwoAdd9 = 0;
    private double allPriceTwoAdd10 = 0;
    private double allPriceTwoAdd11 = 0;
    private double allPriceTwoAdd12 = 0;
    private double allPriceTwoAdd13 = 0;
    private double allPriceTwoAdd14 = 0;

    private double allPriceThreeAdd0 = 0;
    private double allPriceThreeAdd1 = 0;
    private double allPriceThreeAdd2 = 0;
    private double allPriceThreeAdd3 = 0;
    private double allPriceThreeAdd4 = 0;
    private double allPriceThreeAdd5 = 0;
    private double allPriceThreeAdd6 = 0;
    private double allPriceThreeAdd7 = 0;
    private double allPriceThreeAdd8 = 0;
    private double allPriceThreeAdd9 = 0;
    private double allPriceThreeAdd10 = 0;
    private double allPriceThreeAdd11 = 0;
    private double allPriceThreeAdd12 = 0;
    private double allPriceThreeAdd13 = 0;
    private double allPriceThreeAdd14 = 0;

    private static Integer one = 0;
    private static Integer two = 0;

    private Double oneDou = 0.0;
    private Double twoDOu = 0.0;
    private List<Integer> integerList = new ArrayList<>();
    private List<Double> doubleList = new ArrayList<>();


    public static double all = 0;
    public static double allOne = 0;
    public static double allTwo = 0;
    public static double allThree = 0;
    public Context context;//上下文

    public LayoutInflater inflater;//布局器

    public static int recycler = 1;



    public FoodRecyclerAdapter(Context context,List<T> foodBeen) {
        this.bean = foodBeen;
        this.context = context;
        this.inflater= LayoutInflater.from(context);
        Log.i(TAG, "FoodRecyclerAdapter: " + bean.size());

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_restaurant, parent, false);

        integerList.add(0,one);
        integerList.add(1,two);

        doubleList.add(0,oneDou);
        doubleList.add(1,twoDOu);
        
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final FoodRecyclerAdapter.ViewHolder holder, int position) {

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
                    //onLess((int)itemView.getTag(),numberView);
                    break;
                case R.id.main_btn_add:
                    add();
                    //onAdd((int)itemView.getTag(),numberView);
                    break;
            }

        }

        public void add() {
            Log.i(TAG, "recycler: 0" + recycler);
            if (recycler == 1) {
                switch ((int) itemView.getTag()) {
                    case 0:
                        num0 = num0 + 1;
                        numberView.setText("" + num0);
                        allPriceAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * num0);
                        break;
                    case 1:
                        num1 = num1 + 1;
                        numberView.setText("" + num1);
                        Log.i(TAG, "add: " + num1);
                        allPriceAdd1 = (Double.parseDouble(foodNumber.getText().toString()) * num1);
                        Log.i(TAG, "allPriceAdd0: " + allPriceAdd1);
                        break;
                    case 2:
                        num2 = num2 + 1;
                        numberView.setText("" + num2);
                        Log.i(TAG, "add: " + num2);
                        allPriceAdd2 = (Double.parseDouble(foodNumber.getText().toString()) * num2);
                        break;
                    case 3:
                        num3 = num3 + 1;
                        numberView.setText("" + num3);
                        Log.i(TAG, "add: " + num3);
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
                MyApplication.numberList.set(0,num0);
                MyApplication.numberList.set(1,num1);
                MyApplication.numberList.set(2,num2);
                MyApplication.numberList.set(3,num3);
                MyApplication.numberList.set(4,num4);
                MyApplication.numberList.set(5,num5);
                MyApplication.numberList.set(6,num6);
                MyApplication.numberList.set(7,num7);
                MyApplication.numberList.set(8,num8);
                MyApplication.numberList.set(9,num9);
                MyApplication.numberList.set(10,num10);
                MyApplication.numberList.set(11,num11);
                MyApplication.numberList.set(12,num12);
                MyApplication.numberList.set(13,num13);

                allOne = allPriceAdd0 + allPriceAdd1 + allPriceAdd2 + allPriceAdd3 + allPriceAdd4 + allPriceAdd5 + allPriceAdd6
                        + allPriceAdd7 + allPriceAdd8 + allPriceAdd9 + allPriceAdd10 + allPriceAdd11 + allPriceAdd12 + allPriceAdd13
                        + allPriceAdd14;
               // BreakFastFragment.price.setText(""  + allOne);
            }
            if (recycler == 2) {
                switch ((int) itemView.getTag()) {
                    case 0:
                        numTwo0 = numTwo0 + 1;
                        numberView.setText("" + numTwo0);
                        allPriceTwoAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo0);
                        break;
                    case 1:
                        numTwo1 = numTwo1 + 1;
                        numberView.setText("" + numTwo1);
                        Log.i(TAG, "add: " + numTwo1);
                        allPriceTwoAdd1 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo1);
                        break;
                    case 2:
                        numTwo2 = numTwo2 + 1;
                        numberView.setText("" + numTwo2);
                        Log.i(TAG, "add: " + numTwo2);
                        allPriceTwoAdd2 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo2);
                        break;
                    case 3:
                        numTwo3 = numTwo3 + 1;
                        numberView.setText("" + numTwo3);
                        Log.i(TAG, "add: " + numTwo3);
                        allPriceTwoAdd3 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo3);
                        break;
                    case 4:
                        numTwo4 = numTwo4 + 1;
                        numberView.setText("" + numTwo4);
                        allPriceTwoAdd4 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo4);
                        break;
                    case 5:
                        numTwo5 = numTwo5 + 1;
                        numberView.setText("" + numTwo5);
                        allPriceTwoAdd5 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo5);
                        break;
                    case 6:
                        numTwo6 = numTwo6 + 1;
                        numberView.setText("" + numTwo6);
                        allPriceTwoAdd6 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo6);
                        break;
                    case 7:
                        numTwo7 = numTwo7 + 1;
                        numberView.setText("" + numTwo7);
                        allPriceTwoAdd7 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo7);
                        break;
                    case 8:
                        numTwo8 = numTwo8 + 1;
                        numberView.setText("" + numTwo8);
                        allPriceTwoAdd8 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo8);
                        break;
                    case 9:
                        numTwo9 = numTwo9 + 1;
                        numberView.setText("" + numTwo9);
                        allPriceTwoAdd9 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo9);
                        break;
                    case 10:
                        numTwo10 = numTwo10 + 1;
                        numberView.setText("" + numTwo10);
                        allPriceTwoAdd10 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo10);
                        break;
                    case 11:
                        numTwo11 = numTwo11 + 1;
                        numberView.setText("" + numTwo11);
                        allPriceTwoAdd11 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo11);
                        break;
                    case 12:
                        numTwo12 = numTwo12 + 1;
                        numberView.setText("" + numTwo12);
                        allPriceTwoAdd12 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo12);
                        break;
                    case 13:
                        numTwo13 = numTwo13 + 1;
                        numberView.setText("" + numTwo13);
                        allPriceTwoAdd13 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo13);
                        break;
                    case 14:
                        numTwo14 = numTwo14 + 1;
                        numberView.setText("" + numTwo14);
                        allPriceTwoAdd14 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo14);
                        break;
                }
                numberTwoList.set(0,numTwo0);
                numberTwoList.set(1,numTwo1);
                numberTwoList.set(2,numTwo2);
                numberTwoList.set(3,numTwo3);
                numberTwoList.set(4,numTwo4);
                numberTwoList.set(5,numTwo5);
                numberTwoList.set(6,numTwo6);
                numberTwoList.set(7,numTwo7);
                numberTwoList.set(8,numTwo8);
                numberTwoList.set(9,numTwo9);
                numberTwoList.set(10,numTwo10);
                numberTwoList.set(11,numTwo11);
                numberTwoList.set(12,numTwo12);
                numberTwoList.set(13,numTwo13);

                allTwo = allPriceTwoAdd0 + allPriceTwoAdd1 + allPriceTwoAdd2 + allPriceTwoAdd3 + allPriceTwoAdd4 + allPriceTwoAdd5 + allPriceTwoAdd6
                        + allPriceTwoAdd7 + allPriceTwoAdd8 + allPriceTwoAdd9 + allPriceTwoAdd10 + allPriceTwoAdd11 + allPriceTwoAdd12 + allPriceTwoAdd13
                        + allPriceTwoAdd14;
                //BreakFastFragment.price.setText(""  + allTwo);
            }
            if (recycler == 3) {
                switch ((int) itemView.getTag()) {
                    case 0:
                        numThree0 = numThree0 + 1;
                        numberView.setText("" + numThree0);
                        allPriceThreeAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * numThree0);
                        break;
                    case 1:
                        Log.i(TAG, "add: " + numThree1);
                        numThree1 = numThree1 + 1;
                        numberView.setText("" + numThree1);
                        allPriceThreeAdd1 = (Double.parseDouble(foodNumber.getText().toString()) * numThree1);
                        break;
                    case 2:
                        numThree2 = numThree2 + 1;
                        numberView.setText("" + numThree2);
                        allPriceThreeAdd2 = (Double.parseDouble(foodNumber.getText().toString()) * numThree2);
                        break;
                    case 3:
                        numThree3 = numThree3 + 1;
                        numberView.setText("" + numThree3);
                        allPriceThreeAdd3 = (Double.parseDouble(foodNumber.getText().toString()) * numThree3);
                        break;
                    case 4:
                        numThree4 = numThree4 + 1;
                        numberView.setText("" + numThree4);
                        allPriceThreeAdd4 = (Double.parseDouble(foodNumber.getText().toString()) * numThree4);
                        break;
                    case 5:
                        numThree5 = numThree5 + 1;
                        numberView.setText("" + numThree5);
                        allPriceThreeAdd5 = (Double.parseDouble(foodNumber.getText().toString()) * numThree5);
                        break;
                    case 6:
                        numThree6 = numThree6 + 1;
                        numberView.setText("" + numThree6);
                        allPriceThreeAdd6 = (Double.parseDouble(foodNumber.getText().toString()) * numThree6);
                        break;
                    case 7:
                        numThree7 = numThree7 + 1;
                        numberView.setText("" + numThree7);
                        allPriceThreeAdd7 = (Double.parseDouble(foodNumber.getText().toString()) * numThree7);
                        break;
                    case 8:
                        numThree8 = numThree8 + 1;
                        numberView.setText("" + numThree8);
                        allPriceThreeAdd8 = (Double.parseDouble(foodNumber.getText().toString()) * numThree8);
                        break;
                    case 9:
                        numThree9 = numThree9 + 1;
                        numberView.setText("" + numThree9);
                        allPriceThreeAdd9 = (Double.parseDouble(foodNumber.getText().toString()) * numThree9);
                        break;
                    case 10:
                        numThree10 = numThree10 + 1;
                        numberView.setText("" + numThree10);
                        allPriceThreeAdd10 = (Double.parseDouble(foodNumber.getText().toString()) * numThree10);
                        break;
                    case 11:
                        numThree11 = numThree11 + 1;
                        numberView.setText("" + numThree11);
                        allPriceThreeAdd11 = (Double.parseDouble(foodNumber.getText().toString()) * numThree11);
                        break;
                    case 12:
                        numThree12 = numThree12 + 1;
                        numberView.setText("" + numThree12);
                        allPriceThreeAdd12 = (Double.parseDouble(foodNumber.getText().toString()) * numThree12);
                        break;
                    case 13:
                        numThree13 = numThree13 + 1;
                        numberView.setText("" + numThree13);
                        allPriceThreeAdd13 = (Double.parseDouble(foodNumber.getText().toString()) * numThree13);
                        break;
                    case 14:
                        numThree14 = numThree14 + 1;
                        numberView.setText("" + numThree14);
                        allPriceThreeAdd14 = (Double.parseDouble(foodNumber.getText().toString()) * numThree14);
                        break;
                }
                numberThreeList.set(0,numThree0);
                numberThreeList.set(1,numThree1);
                numberThreeList.set(2,numThree2);
                numberThreeList.set(3,numThree3);
                numberThreeList.set(4,numThree4);
                numberThreeList.set(5,numThree5);
                numberThreeList.set(6,numThree6);
                numberThreeList.set(7,numThree7);
                numberThreeList.set(8,numThree8);
                numberThreeList.set(9,numThree9);
                numberThreeList.set(10,numThree10);
                numberThreeList.set(11,numThree11);
                numberThreeList.set(12,numThree12);
                numberThreeList.set(13,numThree13);

                allThree = allPriceThreeAdd0 + allPriceThreeAdd1 + allPriceThreeAdd2 + allPriceThreeAdd3 + allPriceThreeAdd4 + allPriceThreeAdd5 + allPriceThreeAdd6
                        + allPriceThreeAdd7 + allPriceThreeAdd8 + allPriceThreeAdd9 + allPriceThreeAdd10 + allPriceThreeAdd11 + allPriceThreeAdd12 + allPriceThreeAdd13
                        + allPriceThreeAdd14;
            }

            all = allOne + allThree + allTwo;
            BreakFastFragment.price.setText(""  + all);
        }


        public void onLess(int tag,TextView textView){
            Integer integer = integerList.get(tag);
            integer = integer - 1;
            textView.setText("" + integer);
            Double mDouble = doubleList.get(tag);
            mDouble = (Double.parseDouble(foodNumber.getText().toString()) * integer);

            Log.i(TAG, "less--------mDouble: " + mDouble +"integer: "+ integer);

        }

        public void onAdd(int tag,TextView textView){
            integerList.get(0) ;
            Integer integer = integerList.get(tag);
            integer = integer + 1;
            textView.setText("" + integer);
            Double mDouble = doubleList.get(tag);
            mDouble = (Double.parseDouble(foodNumber.getText().toString()) * integer);

            Log.i(TAG, "less--------mDouble: " + mDouble +"integer: "+ integer);

        }

        public void less() {
            if (recycler == 1) {


                switch ((int) itemView.getTag()) {
                    case 0:
                        if (num0 > 0)
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
                MyApplication.numberList.set(0,num0);
                MyApplication.numberList.set(1,num1);
                MyApplication.numberList.set(2,num2);
                MyApplication.numberList.set(3,num3);
                MyApplication.numberList.set(4,num4);
                MyApplication.numberList.set(5,num5);
                MyApplication.numberList.set(6,num6);
                MyApplication.numberList.set(7,num7);
                MyApplication.numberList.set(8,num8);
                MyApplication.numberList.set(9,num9);
                MyApplication.numberList.set(10,num10);
                MyApplication.numberList.set(11,num11);
                MyApplication.numberList.set(12,num12);
                MyApplication.numberList.set(13,num13);

                allOne = allPriceAdd0 + allPriceAdd1 + allPriceAdd2 + allPriceAdd3 + allPriceAdd4 + allPriceAdd5 + allPriceAdd6
                        + allPriceAdd7 + allPriceAdd8 + allPriceAdd9 + allPriceAdd10 + allPriceAdd11 + allPriceAdd12 + allPriceAdd13
                        + allPriceAdd14;
            }
            if (recycler == 2) {
                switch ((int) itemView.getTag()) {
                    case 0:
                        numTwo0 = numTwo0 - 1;
                        numberView.setText("" + numTwo0);
                        allPriceTwoAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo0);
                        break;
                    case 1:
                        numTwo1 = numTwo1 - 1;
                        numberView.setText("" + numTwo1);
                        allPriceTwoAdd1 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo1);
                        break;
                    case 2:
                        numTwo2 = numTwo2 - 1;
                        numberView.setText("" + numTwo2);
                        allPriceTwoAdd2 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo2);
                        break;
                    case 3:
                        numTwo3 = numTwo3 - 1;
                        numberView.setText("" + numTwo3);
                        allPriceTwoAdd3 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo3);
                        break;
                    case 4:
                        numTwo4 = numTwo4 - 1;
                        numberView.setText("" + numTwo4);
                        allPriceTwoAdd4 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo4);
                        break;
                    case 5:
                        numTwo5 = numTwo5 - 1;
                        numberView.setText("" + numTwo5);
                        allPriceTwoAdd5 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo5);
                        break;
                    case 6:
                        numTwo6 = numTwo6 - 1;
                        numberView.setText("" + numTwo6);
                        allPriceTwoAdd6 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo6);
                        break;
                    case 7:
                        numTwo7 = numTwo7 - 1;
                        numberView.setText("" + numTwo7);
                        allPriceTwoAdd7 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo7);
                        break;
                    case 8:
                        numTwo8 = numTwo8 - 1;
                        numberView.setText("" + numTwo8);
                        allPriceTwoAdd8 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo8);
                        break;
                    case 9:
                        numTwo9 = numTwo9 - 1;
                        numberView.setText("" + numTwo9);
                        allPriceTwoAdd9 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo9);
                        break;
                    case 10:
                        numTwo10 = numTwo10 - 1;
                        numberView.setText("" + numTwo10);
                        allPriceTwoAdd10 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo10);
                        break;
                    case 11:
                        numTwo11 = numTwo11 - 1;
                        numberView.setText("" + numTwo11);
                        allPriceTwoAdd11 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo11);
                        break;
                    case 12:
                        numTwo12 = numTwo12 - 1;
                        numberView.setText("" + numTwo12);
                        allPriceTwoAdd12 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo12);
                        break;
                    case 13:
                        numTwo13 = numTwo13 - 1;
                        numberView.setText("" + numTwo13);
                        allPriceTwoAdd13 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo13);
                        break;
                    case 14:
                        numTwo14 = numTwo14 - 1;
                        numberView.setText("" + numTwo14);
                        allPriceTwoAdd14 = (Double.parseDouble(foodNumber.getText().toString()) * numTwo14);
                        break;
                }
                numberTwoList.set(0,numTwo0);
                numberTwoList.set(1,numTwo1);
                numberTwoList.set(2,numTwo2);
                numberTwoList.set(3,numTwo3);
                numberTwoList.set(4,numTwo4);
                numberTwoList.set(5,numTwo5);
                numberTwoList.set(6,numTwo6);
                numberTwoList.set(7,numTwo7);
                numberTwoList.set(8,numTwo8);
                numberTwoList.set(9,numTwo9);
                numberTwoList.set(10,numTwo10);
                numberTwoList.set(11,numTwo11);
                numberTwoList.set(12,numTwo12);
                numberTwoList.set(13,numTwo13);

                allTwo = allPriceTwoAdd0 + allPriceTwoAdd1 + allPriceTwoAdd2 + allPriceTwoAdd3 + allPriceTwoAdd4 + allPriceTwoAdd5 + allPriceTwoAdd6
                        + allPriceTwoAdd7 + allPriceTwoAdd8 + allPriceTwoAdd9 + allPriceTwoAdd10 + allPriceTwoAdd11 + allPriceTwoAdd12 + allPriceTwoAdd13
                        + allPriceTwoAdd14;
            }
            if (recycler == 3) {
                switch ((int) itemView.getTag()) {
                    case 0:
                        numThree0 = numThree0 - 1;
                        numberView.setText("" + numThree0);
                        allPriceThreeAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * numThree0);
                        break;
                    case 1:
                        Log.i(TAG, "add: " + numThree1);
                        numThree1 = numThree1 - 1;

                        numberView.setText("" + numThree1);
                        allPriceThreeAdd1 = (Double.parseDouble(foodNumber.getText().toString()) * numThree1);
                        break;
                    case 2:
                        numThree2 = numThree2 - 1;
                        numberView.setText("" + numThree2);
                        allPriceThreeAdd2 = (Double.parseDouble(foodNumber.getText().toString()) * numThree2);
                        break;
                    case 3:
                        numThree3 = numThree3 - 1;
                        numberView.setText("" + numThree3);
                        allPriceThreeAdd3 = (Double.parseDouble(foodNumber.getText().toString()) * numThree3);
                        break;
                    case 4:
                        numThree4 = numThree4 - 1;
                        numberView.setText("" + numThree4);
                        allPriceThreeAdd4 = (Double.parseDouble(foodNumber.getText().toString()) * numThree4);
                        break;
                    case 5:
                        numThree5 = numThree5 - 1;
                        numberView.setText("" + numThree5);
                        allPriceThreeAdd5 = (Double.parseDouble(foodNumber.getText().toString()) * numThree5);
                        break;
                    case 6:
                        numThree6 = numThree6 - 1;
                        numberView.setText("" + numThree6);
                        allPriceThreeAdd6 = (Double.parseDouble(foodNumber.getText().toString()) * numThree6);
                        break;
                    case 7:
                        numThree7 = numThree7 - 1;
                        numberView.setText("" + numThree7);
                        allPriceThreeAdd7 = (Double.parseDouble(foodNumber.getText().toString()) * numThree7);
                        break;
                    case 8:
                        numThree8 = numThree8 - 1;
                        numberView.setText("" + numThree8);
                        allPriceThreeAdd8 = (Double.parseDouble(foodNumber.getText().toString()) * numThree8);
                        break;
                    case 9:
                        numThree9 = numThree9 - 1;
                        numberView.setText("" + numThree9);
                        allPriceThreeAdd9 = (Double.parseDouble(foodNumber.getText().toString()) * numThree9);
                        break;
                    case 10:
                        numThree10 = numThree10 - 1;
                        numberView.setText("" + numThree10);
                        allPriceThreeAdd10 = (Double.parseDouble(foodNumber.getText().toString()) * numThree10);
                        break;
                    case 11:
                        numThree11 = numThree11 - 1;
                        numberView.setText("" + numThree11);
                        allPriceThreeAdd11 = (Double.parseDouble(foodNumber.getText().toString()) * numThree11);
                        break;
                    case 12:
                        numThree12 = numThree12 - 1;
                        numberView.setText("" + numThree12);
                        allPriceThreeAdd12 = (Double.parseDouble(foodNumber.getText().toString()) * numThree12);
                        break;
                    case 13:
                        numThree13 = numThree13 - 1;
                        numberView.setText("" + numThree13);
                        allPriceThreeAdd13 = (Double.parseDouble(foodNumber.getText().toString()) * numThree13);
                        break;
                    case 14:
                        numThree14 = numThree14 - 1;
                        numberView.setText("" + numThree14);
                        allPriceThreeAdd14 = (Double.parseDouble(foodNumber.getText().toString()) * numThree14);
                        break;
                }
                numberThreeList.set(0,numThree0);
                numberThreeList.set(1,numThree1);
                numberThreeList.set(2,numThree2);
                numberThreeList.set(3,numThree3);
                numberThreeList.set(4,numThree4);
                numberThreeList.set(5,numThree5);
                numberThreeList.set(6,numThree6);
                numberThreeList.set(7,numThree7);
                numberThreeList.set(8,numThree8);
                numberThreeList.set(9,numThree9);
                numberThreeList.set(10,numThree10);
                numberThreeList.set(11,numThree11);
                numberThreeList.set(12,numThree12);
                numberThreeList.set(13,numThree13);

                allThree = allPriceThreeAdd0 + allPriceThreeAdd1 + allPriceThreeAdd2 + allPriceThreeAdd3 + allPriceThreeAdd4 + allPriceThreeAdd5 + allPriceThreeAdd6
                        + allPriceThreeAdd7 + allPriceThreeAdd8 + allPriceThreeAdd9 + allPriceThreeAdd10 + allPriceThreeAdd11 + allPriceThreeAdd12 + allPriceThreeAdd13
                        + allPriceThreeAdd14;
            }

            all = allOne + allThree + allTwo;

            BreakFastFragment.price.setText(""  + all);

        }

    }
    public abstract void convert(ViewHolder holder, T item, int position);
}
