package com.example.zzz.xinhuarestaurant.bean;

/**
 * Created by zzz on 2017/11/3.
 */

public class SureBean {

    public String foodName;

    public String foodNumber;

    public String numberView;

    public void setFoodName (String foodName){
        this.foodName = foodName;
    }
    public void setfoodNumber (String foodNumber){
        this.foodNumber = foodNumber;
    }
    public void setnumberView (String numberView){
        this.numberView = numberView;
    }

    public String getFoodName(){
        return foodName;
    }

    public String getFoodNumber(){
        return foodNumber;
    }

    public String getNumberView(){
        return numberView;
    }

}
