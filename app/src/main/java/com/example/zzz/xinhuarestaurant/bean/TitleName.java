package com.example.zzz.xinhuarestaurant.bean;

/**
 * Created by zzz on 2017/10/30.
 */

public class TitleName {

    public String breakFast[];

    public String lunch[];

    public String dinner[];


    public void setBreakFast(String breakFast[]){
        this.breakFast = breakFast;
    }

    public void setLunch(String lunch[]){
        this.lunch = lunch;
    }

    public void setDinner(String dinner[]){
        this.dinner = dinner;
    }

    public String[] getBreakFast(){
        return breakFast;
    }

    public String[] getLunch(){
        return lunch;
    }

    public String[] getDinner(){
        return dinner;
    }


}
