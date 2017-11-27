package com.example.zzz.xinhuarestaurant.bean;

/**
 * Created by zzz on 2017/10/27.
 */

public class FoodBean {

    public String foodName;

    public String foodPrice;

    public int foodImage;

    public void setFoodName (String foodName){
        this.foodName = foodName;
    }

    public String getFoodName(){
        return foodName;
    }

    public void setFoodPrice (String foodNumber){
        this.foodPrice = foodNumber;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public void setFoodImage(int foodImage){
        this.foodImage = foodImage;
    }

    public int getFoodImage(){
        return foodImage;
    }

}
