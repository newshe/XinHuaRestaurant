package com.example.zzz.xinhuarestaurant.db;

import org.litepal.crud.DataSupport;

/**
 * Created by zzz on 2017/11/27.
 */

public class UserInfo extends DataSupport {
    private String token;

    public void setToken (String token){
        this.token = token;
    }

    public String getToken (){
        return token;
    }
}
