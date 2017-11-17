package com.example.zzz.xinhuarestaurant.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zzz.xinhuarestaurant.R;
import com.example.zzz.xinhuarestaurant.application.MyApplication;
import com.example.zzz.xinhuarestaurant.gson.WeatherJson;
import com.example.zzz.xinhuarestaurant.util.HttpRequest;
import com.example.zzz.xinhuarestaurant.util.ToastUtil;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by zzz on 2017/10/25.
 */

public class LeftFragment extends Fragment {

    public String TAG = "ppt";

    public TextView textCalendar;
    public TextView textWeather;
    public TextView textTemperature;

    public String cityName;
    public String weather;
    public String week;
    public String temperature;
    public String dateY;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.left_fragment,container,false);

        initControl(view);
        weatherView();
        Log.i(TAG, "onCreateView: " + System.currentTimeMillis());
        return view;
    }

    public void weatherView() {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String weatherPre = preferences.getString("weather",null);
        long year = preferences.getLong("time",0);

        if ( weatherPre == null && (System.currentTimeMillis() / 86400000) - year >= 1 ) {
            requestWeather();
        } else {
            handleWeatherJson(weatherPre);
            textCalendar.setText(dateY + "-" + week);
            textWeather.setText(weather);
            textTemperature.setText(temperature);
        }
    }

    public void requestWeather() {
        HttpRequest.request(MyApplication.getWeatherUrl("成都"), new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i(TAG, "onResponse: " );
                String res = response.body().string();
                SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(getContext()).edit();
                editor.putString("weather",res);
                long year = System.currentTimeMillis() / 86400000 ;
                editor.putLong("time",year);
                editor.apply();
                handleWeatherJson(res);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        weatherView();
                    }
                });
            }
        });
    }
    //解析json数据
    public void handleWeatherJson (String response){
        Gson gson = new Gson();
        WeatherJson weatherJson = gson.fromJson(response,WeatherJson.class);
        cityName = weatherJson.getResult().getToday().getCity();
        weather = weatherJson.getResult().getToday().getWeather();
        week = weatherJson.getResult().getToday().getWeek();
        temperature = weatherJson.getResult().getToday().getTemperature();
        //截取日月
        dateY = weatherJson.getResult().getToday().getDate_y().substring(5);

    }

    private void initControl(View view) {
        textCalendar = (TextView) view.findViewById(R.id.textCalendar);
        textWeather = (TextView) view.findViewById(R.id.textWeather);
        textTemperature = (TextView) view.findViewById(R.id.textTemperature);
    }
}
