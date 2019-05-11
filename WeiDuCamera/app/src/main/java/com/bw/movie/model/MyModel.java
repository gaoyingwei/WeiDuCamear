package com.bw.movie.model;

import android.util.Log;

import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.util.Api;
import com.bw.movie.util.RetrofitUtil;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.ResponseBody;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MyModel {
    MyCallBack myCallBack;
    MyLoginCallBack myLoginCallBack;
    //注册
    public interface MyCallBack{
        public void successRegist(RegisterBean registerBean);
    }
    public void setMyCallBack(MyCallBack myCallBack){
    this.myCallBack=myCallBack;
    }
    //登录
    public interface MyLoginCallBack{
        public void successLogin(LoginBean loginBean);
    }
    public void setMyLoginCallBack(MyLoginCallBack myLoginCallBack){
        this.myLoginCallBack=myLoginCallBack;
    }
    public void getRegist(String nickName,int sex,String data,String phone,String email,String pwd,String pwd2){
        RetrofitUtil retrofitUtil=RetrofitUtil.getInstance();
        Api api=retrofitUtil.setRetrofit(Api.class);
        api.getRegist(nickName,sex,data,phone,email,pwd,pwd2)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String json=responseBody.string();
                            Gson gson=new Gson();
                            RegisterBean registerBean = gson.fromJson(json, RegisterBean.class);
                            myCallBack.successRegist(registerBean);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
    //登录
    public void getLogin(String phone,String pwd,String pwd2){
        RetrofitUtil retrofitUtil=RetrofitUtil.getInstance();
        Api api=retrofitUtil.setRetrofit(Api.class);
        api.getLogin(phone,pwd,pwd2)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String json=responseBody.string();
                            Gson gson=new Gson();
                            LoginBean loginBean = gson.fromJson(json, LoginBean.class);
                            myLoginCallBack.successLogin(loginBean);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
