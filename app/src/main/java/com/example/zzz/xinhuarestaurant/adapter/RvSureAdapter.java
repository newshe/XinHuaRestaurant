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
import com.example.zzz.xinhuarestaurant.fragment.LunchFragment;
import com.example.zzz.xinhuarestaurant.fragment.SureFragment;

import java.util.List;

import static com.example.zzz.xinhuarestaurant.application.MyApplication.numberListTwo;
import static com.example.zzz.xinhuarestaurant.application.MyApplication.numberThreeListTwo;
import static com.example.zzz.xinhuarestaurant.application.MyApplication.numberTwoList;
import static com.example.zzz.xinhuarestaurant.application.MyApplication.numberTwoListTwo;

/**
 * Created by zzz on 2017/10/27.
 */

public abstract class RvSureAdapter<T> extends RecyclerView.Adapter<RvSureAdapter.ViewHolder> {

    public String TAG = "ppt";

    public List<T> bean;

    public static double num0 = 0;
    public static double num1 = 0;
    public static double num2 = 0;
    public static double num3 = 0;
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

    public static double [] arrDouble = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    public Context context;//上下文

    public LayoutInflater inflater;//布局器



    public RvSureAdapter(Context context, List<T> foodBeen) {
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
    public void onBindViewHolder(final RvSureAdapter.ViewHolder holder, int position) {

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
            switch ((int) itemView.getTag()) {
                case 0:
                    arrDouble[0]++;
                    numberView.setText("" + arrDouble[0]);
                    allPriceAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * arrDouble[0]);
                    break;
                case 1:
                    arrDouble[1]++;
                    numberView.setText("" + arrDouble[1]);
                    allPriceAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * arrDouble[1]);
                    break;
                case 2:
                    arrDouble[2]++;
                    numberView.setText("" + arrDouble[2]);
                    allPriceAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * arrDouble[2]);
                    break;
                case 3:
                    arrDouble[3]++;
                    numberView.setText("" + arrDouble[3]);
                    allPriceAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * arrDouble[3]);
                    break;
                case 4:
                    arrDouble[4]++;
                    numberView.setText("" + arrDouble[4]);
                    allPriceAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * arrDouble[4]);
                    break;
                case 5:
                    arrDouble[5]++;
                    numberView.setText("" + arrDouble[5]);
                    allPriceAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * arrDouble[5]);
                    break;
                case 6:
                    arrDouble[6]++;
                    numberView.setText("" + arrDouble[0]);
                    allPriceAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * arrDouble[6]);
                    break;
                case 7:
                    arrDouble[7]++;
                    numberView.setText("" + arrDouble[7]);
                    allPriceAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * arrDouble[7]);
                    break;
                case 8:
                    arrDouble[8]++;
                    numberView.setText("" + arrDouble[8]);
                    allPriceAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * arrDouble[8]);
                    break;
                case 9:
                    arrDouble[9]++;
                    numberView.setText("" + arrDouble[9]);
                    allPriceAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * arrDouble[9]);
                    break;
                case 10:
                    arrDouble[10]++;
                    numberView.setText("" + arrDouble[10]);
                    allPriceAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * arrDouble[10]);
                    break;
                case 11:
                    arrDouble[11]++;
                    numberView.setText("" + arrDouble[11]);
                    allPriceAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * arrDouble[11]);
                    break;
                case 12:
                    arrDouble[12]++;
                    numberView.setText("" + arrDouble[12]);
                    allPriceAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * arrDouble[12]);
                    break;
                case 13:
                    arrDouble[13]++;
                    numberView.setText("" + arrDouble[13]);
                    allPriceAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * arrDouble[13]);
                    break;
                case 14:
                    arrDouble[14]++;
                    numberView.setText("" + arrDouble[14]);
                    allPriceAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * arrDouble[14]);
                    break;
            }
            numberListTwo.set(0, num0);
            numberListTwo.set(1, num1);
            numberListTwo.set(2, num2);
            numberListTwo.set(3, num3);
            numberListTwo.set(4, num4);
            numberListTwo.set(5, num5);
            numberListTwo.set(6, num6);
            numberListTwo.set(7, num7);
            numberListTwo.set(8, num8);
            numberListTwo.set(9, num9);
            numberListTwo.set(10, num10);
            numberListTwo.set(11, num11);
            numberListTwo.set(12, num12);
            numberListTwo.set(13, num13);

            allOne = allPriceAdd0 + allPriceAdd1 + allPriceAdd2 + allPriceAdd3 + allPriceAdd4 + allPriceAdd5 + allPriceAdd6
                    + allPriceAdd7 + allPriceAdd8 + allPriceAdd9 + allPriceAdd10 + allPriceAdd11 + allPriceAdd12 + allPriceAdd13
                    + allPriceAdd14;


            all = allOne + allThree + allTwo;

            SureFragment.sure_price.setText("" + all);
            Log.i("ppt", "add: " + BreakFastFragment.AllOne + "---" + BreakFastFragment.AllTwo + "---" + BreakFastFragment.AllThree);

        }

        public void less() {
            switch ((int) itemView.getTag()) {
                case 0:
                    arrDouble[0]--;
                    numberView.setText("" + arrDouble[0]);
                    allPriceAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * arrDouble[0]);
                    break;
                case 1:
                    arrDouble[1]--;
                    numberView.setText("" + arrDouble[1]);
                    allPriceAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * arrDouble[1]);
                    break;
                case 2:
                    arrDouble[2]--;
                    numberView.setText("" + arrDouble[2]);
                    allPriceAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * arrDouble[2]);
                    break;
                case 3:
                    arrDouble[3]--;
                    numberView.setText("" + arrDouble[3]);
                    allPriceAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * arrDouble[3]);
                    break;
                case 4:
                    arrDouble[4]--;
                    numberView.setText("" + arrDouble[4]);
                    allPriceAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * arrDouble[4]);
                    break;
                case 5:
                    arrDouble[5]--;
                    numberView.setText("" + arrDouble[5]);
                    allPriceAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * arrDouble[5]);
                    break;
                case 6:
                    arrDouble[6]--;
                    numberView.setText("" + arrDouble[6]);
                    allPriceAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * arrDouble[6]);
                    break;
                case 7:
                    arrDouble[7]--;
                    numberView.setText("" + arrDouble[7]);
                    allPriceAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * arrDouble[7]);
                    break;
                case 8:
                    arrDouble[8]--;
                    numberView.setText("" + arrDouble[8]);
                    allPriceAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * arrDouble[8]);
                    break;
                case 9:
                    arrDouble[9]++;
                    numberView.setText("" + arrDouble[9]);
                    allPriceAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * arrDouble[9]);
                    break;
                case 10:
                    arrDouble[10]--;
                    numberView.setText("" + arrDouble[10]);
                    allPriceAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * arrDouble[10]);
                    break;
                case 11:
                    arrDouble[11]--;
                    numberView.setText("" + arrDouble[11]);
                    allPriceAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * arrDouble[11]);
                    break;
                case 12:
                    arrDouble[12]--;
                    numberView.setText("" + arrDouble[12]);
                    allPriceAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * arrDouble[12]);
                    break;
                case 13:
                    arrDouble[13]--;
                    numberView.setText("" + arrDouble[13]);
                    allPriceAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * arrDouble[13]);
                    break;
                case 14:
                    arrDouble[14]--;
                    numberView.setText("" + arrDouble[14]);
                    allPriceAdd0 = (Double.parseDouble(foodNumber.getText().toString()) * arrDouble[14]);
                    break;
            }
            numberListTwo.set(0, num0);
            numberListTwo.set(1, num1);
            numberListTwo.set(2, num2);
            numberListTwo.set(3, num3);
            numberListTwo.set(4, num4);
            numberListTwo.set(5, num5);
            numberListTwo.set(6, num6);
            numberListTwo.set(7, num7);
            numberListTwo.set(8, num8);
            numberListTwo.set(9, num9);
            numberListTwo.set(10, num10);
            numberListTwo.set(11, num11);
            numberListTwo.set(12, num12);
            numberListTwo.set(13, num13);

            allOne = allPriceAdd0 + allPriceAdd1 + allPriceAdd2 + allPriceAdd3 + allPriceAdd4 + allPriceAdd5 + allPriceAdd6
                    + allPriceAdd7 + allPriceAdd8 + allPriceAdd9 + allPriceAdd10 + allPriceAdd11 + allPriceAdd12 + allPriceAdd13
                    + allPriceAdd14;

        all=allOne+allThree+allTwo;

        SureFragment.sure_price.setText(""+all);
        Log.i("ppt","add: "+BreakFastFragment.AllOne+"---"+BreakFastFragment.AllTwo+"---"+BreakFastFragment.AllThree);

    }

    }
    public abstract void convert(ViewHolder holder, T item, int position);
}
