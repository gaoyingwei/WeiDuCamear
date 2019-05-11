package com.bw.movie.util;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {

    public static RetrofitUtil retrofitUtil;
    Retrofit retrofit;
    private RetrofitUtil(){
        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .readTimeout(5,TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();
        retrofit=new Retrofit.Builder()
                .baseUrl(UrlCrl.BASEURL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static RetrofitUtil getInstance(){
        if (retrofitUtil==null){
            retrofitUtil=new RetrofitUtil();
        }
        return  retrofitUtil;
    }
    public <T>T setRetrofit(Class<T> tClass){
        return  retrofit.create(tClass);
    }
}
