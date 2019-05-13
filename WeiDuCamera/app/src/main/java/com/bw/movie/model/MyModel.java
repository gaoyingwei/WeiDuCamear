package com.bw.movie.model;

import android.util.Log;

import com.bw.movie.bean.Baner;
import com.bw.movie.bean.BanerBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.util.Api;
import com.bw.movie.util.RetrofitUtil;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MyModel {
    MyCallBack myCallBack;
    MyLoginCallBack myLoginCallBack;
    BanerCallBack banerCallBack;
    HotCallBack hotCallBack;
    YingCallBack yingCallBack;
    JiCallBack jiCallBack;
    RemenCallBack remenCallBack;
    NowCallBack nowCallBack;
    JiangCallBacks jiangCallBacks;
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
    //轮播
    public interface BanerCallBack{
        public void showbaner(Object obj);
    }
    public void setBanerCallBack(BanerCallBack  banerCallBack){
        this.banerCallBack=banerCallBack;
    }
    //热门电影
    public interface HotCallBack{
        public void showhot(Object obj);
    }
    public void setHotCallBack(HotCallBack hotCallBack){
       this.hotCallBack=hotCallBack;
    }
    //正在热映
    public interface YingCallBack{
        public void showying(Object obj);
    }
    public void setYingCallBack(YingCallBack yingCallBack){
       this.yingCallBack=yingCallBack;
    }
    //即将上映
    public interface JiCallBack{
        public void ShowJi(Object obj);
    }
    public void setJiCallBack(JiCallBack jiCallBack){
        this.jiCallBack=jiCallBack;
    }
   public interface RemenCallBack{
        public void showremens(Object obj);
   }
   public void setRemenCallBack(RemenCallBack remenCallBack){
        this.remenCallBack=remenCallBack;
   }

   public interface NowCallBack{
        public void shownows(Object obj);
   }
   public void setNowCallBack(NowCallBack nowCallBack){
      this.nowCallBack=nowCallBack;
   }
   public interface JiangCallBacks{
        public void showjiang(Object obj);
   }
   public void setJiangCallBacks(JiangCallBacks jiangCallBacks){
       this.jiangCallBacks=jiangCallBacks;
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
    //轮播
    public void getBaner(int userId,String sessionId,int page,int count){
        RetrofitUtil retrofitUtil=RetrofitUtil.getInstance();
        Api api=retrofitUtil.setRetrofit(Api.class);
        api.getBaner(userId,sessionId,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String json=responseBody.string();
                            Log.e("baner",""+json);
                            Gson gson=new Gson();
                            BanerBean banerBean = gson.fromJson(json, BanerBean.class);
                            List<Baner> result = banerBean.getResult();
                            banerCallBack.showbaner(result);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
    //热门电影
    public void getHot(int userId,String sessionId,int page,int count){
        RetrofitUtil retrofitUtil=RetrofitUtil.getInstance();
        Api api=retrofitUtil.setRetrofit(Api.class);
        api.getHot(userId,sessionId,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String json=responseBody.string();
                            Gson gson=new Gson();
                            BanerBean banerBean = gson.fromJson(json, BanerBean.class);
                            List<Baner> result = banerBean.getResult();
                            hotCallBack.showhot(result);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
    //正在上映
    public void getYing(int userId,String sessionId,int page,int count){
        RetrofitUtil retrofitUtil=RetrofitUtil.getInstance();
        Api api=retrofitUtil.setRetrofit(Api.class);
        api.getYing(userId,sessionId,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String json=responseBody.string();
                            Gson gson=new Gson();
                            BanerBean banerBean = gson.fromJson(json, BanerBean.class);
                            List<Baner> result = banerBean.getResult();
                            yingCallBack.showying(result);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
    //即将上映
    public void getJiJiang(int userId,String sessionId,int page,int count){
        RetrofitUtil retrofitUtil=RetrofitUtil.getInstance();
        Api api=retrofitUtil.setRetrofit(Api.class);
        api.getJiJiang(userId,sessionId,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String json=responseBody.string();
                            Gson gson=new Gson();
                            BanerBean banerBean = gson.fromJson(json, BanerBean.class);
                            List<Baner> result = banerBean.getResult();
                            jiCallBack.ShowJi(result);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
    //电影详情
    public void getXiang(int userId,String sessionId,int movieId){
        RetrofitUtil retrofitUtil=RetrofitUtil.getInstance();
        Api api=retrofitUtil.setRetrofit(Api.class);
        api.getXiang(userId,sessionId,movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String json=responseBody.string();
                            Log.e("ttt",""+json);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
    //热门
    public void getRemen(int userId,String sessionId,int page,int count){
        RetrofitUtil retrofitUtil=RetrofitUtil.getInstance();
        Api api=retrofitUtil.setRetrofit(Api.class);
        api.getRemen(userId,sessionId,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String json=responseBody.string();
                            Log.e("ppp",""+json);
                            Gson gson=new Gson();
                            BanerBean banerBean = gson.fromJson(json, BanerBean.class);
                            List<Baner> results = banerBean.getResult();
                            remenCallBack.showremens(results);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
    //正在上映
    public void getNow(int userId,String sessionId,int page,int count){
        RetrofitUtil retrofitUtil=RetrofitUtil.getInstance();
        Api api=retrofitUtil.setRetrofit(Api.class);
        api.getNow(userId,sessionId,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String json=responseBody.string();
                            Gson gson=new Gson();
                            BanerBean banerBean = gson.fromJson(json, BanerBean.class);
                            List<Baner> result = banerBean.getResult();
                            nowCallBack.shownows(result);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
    //即将上映
    public void getJiang(int userId,String sessionId,int page,int count){
        RetrofitUtil retrofitUtil=RetrofitUtil.getInstance();
        Api api=retrofitUtil.setRetrofit(Api.class);
        api.getJi(userId,sessionId,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            String json=responseBody.string();
                            Gson gson=new Gson();
                            BanerBean banerBean = gson.fromJson(json, BanerBean.class);
                            List<Baner> result = banerBean.getResult();
                            jiangCallBacks.showjiang(result);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
