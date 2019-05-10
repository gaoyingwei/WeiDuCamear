package com.wd.tech.util;

import retrofit2.Retrofit;

public class RetrofitUtil {

    public static RetrofitUtil retrofitUtil;
    Retrofit retrofit;
    private RetrofitUtil(){

    }
    public static RetrofitUtil getInstance(){
        if (retrofitUtil==null){
            retrofitUtil=new RetrofitUtil();
        }
        return  retrofitUtil;
    }
}
