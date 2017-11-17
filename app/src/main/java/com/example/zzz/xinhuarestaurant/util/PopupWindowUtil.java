package com.example.zzz.xinhuarestaurant.util;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.ProgressBar;

import com.example.zzz.xinhuarestaurant.R;

/**
 * Created by zzz on 2017/11/6.
 */

public class PopupWindowUtil {

    private PopupWindow popupWindowLoading = new PopupWindow();

    public PopupWindow showPopupWindowLoading(Context context){
        View view = LayoutInflater.from(context).inflate(R.layout.popupwindow_loading,null);
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.pb);
        popupWindowLoading.setContentView(view);
        popupWindowLoading.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindowLoading.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindowLoading.showAtLocation(view, Gravity.CENTER,0,0);

        return popupWindowLoading;
    }
    public void CloseLoadingPopupWindow(){
        popupWindowLoading.dismiss();
    }
}
