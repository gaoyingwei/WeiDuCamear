package com.bw.movie.presenter;

import android.util.Log;

import com.bw.movie.bean.Baner;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.contarct.ContarctIntface;
import com.bw.movie.model.MyModel;

import java.util.List;

public class MyPresenter<T> implements ContarctIntface.PresenterIntface {
    T tt;
    MyModel myModel;
    public MyPresenter(T t){
        this.tt=t;
        myModel=new MyModel();
    }
    @Override
    public void toRegist(String nickName, int sex, String birthday, String phone, String email, String pwd,String pwd2) {
        myModel.setMyCallBack(new MyModel.MyCallBack() {
            @Override
            public void successRegist(RegisterBean registerBean) {
                ContarctIntface.RegistViewIntface registViewIntface= (ContarctIntface.RegistViewIntface) tt;
                registViewIntface.ShowRegist(registerBean);
            }
        });
        myModel.getRegist(nickName,sex,birthday,phone,email,pwd,pwd2);
    }

    @Override
    public void toLogin(String phone, String pwd, String pwd2) {
        myModel.setMyLoginCallBack(new MyModel.MyLoginCallBack() {
            @Override
            public void successLogin(LoginBean loginBean) {
                  ContarctIntface.LoginViewIntface loginViewIntface= (ContarctIntface.LoginViewIntface) tt;
                  loginViewIntface.ShowLogin(loginBean);
            }
        });
        myModel.getLogin(phone,pwd,pwd2);
    }

    @Override
    public void toBaner(int userId, String sessionId, int page, int count) {
    myModel.setBanerCallBack(new MyModel.BanerCallBack() {
        @Override
        public void showbaner(Object obj) {
            List<Baner>list= (List<Baner>) obj;
            ContarctIntface.BanerViewIntface banerViewIntface= (ContarctIntface.BanerViewIntface) tt;
            banerViewIntface.ShowBaner(list);
        }
    });
    myModel.getBaner(userId,sessionId,page,count);
    }

    @Override
    public void toHot(int userId, String sessionId, int page, int count) {
        myModel.setHotCallBack(new MyModel.HotCallBack() {
            @Override
            public void showhot(Object obj) {
                List<Baner>list= (List<Baner>) obj;
                ContarctIntface.BanerViewIntface banerViewIntface= (ContarctIntface.BanerViewIntface) tt;
                banerViewIntface.ShowHot(list);
            }
        });
        myModel.getHot(userId,sessionId,page,count);
    }

    @Override
    public void toReYing(int userId, String sessionId, int page, int count) {
        myModel.setYingCallBack(new MyModel.YingCallBack() {
            @Override
            public void showying(Object obj) {
                List<Baner>list= (List<Baner>) obj;
                ContarctIntface.BanerViewIntface banerViewIntface= (ContarctIntface.BanerViewIntface) tt;
                banerViewIntface.ShowReYing(list);
            }
        });
        myModel.getYing(userId,sessionId,page,count);
    }

    @Override
    public void toJjJiang(int userId, String sessionId, int page, int count) {
      myModel.setJiCallBack(new MyModel.JiCallBack() {
          @Override
          public void ShowJi(Object obj) {
              List<Baner>list= (List<Baner>) obj;
              ContarctIntface.BanerViewIntface banerViewIntface= (ContarctIntface.BanerViewIntface) tt;
              banerViewIntface.ShowJiJiang(list);
          }
      });
      myModel.getJiJiang(userId,sessionId,page,count);
    }

    @Override
    public void toXiang(int userId, String sessionId, int movieId) {
      myModel.getXiang(userId,sessionId,movieId);
    }

    @Override
    public void toRemen(int userId, String sessionId, int page, int count) {
        myModel.setRemenCallBack(new MyModel.RemenCallBack() {
            @Override
            public void showremens(Object obj) {
                List<Baner>list= (List<Baner>) obj;
                ContarctIntface.HotMovieViewIntface hotMovieViewIntface= (ContarctIntface.HotMovieViewIntface) tt;
                hotMovieViewIntface.ShowRemen(list);
            }
        });
       myModel.getRemen(userId,sessionId,page,count);
    }

    @Override
    public void toNow(int userId, String sessionId, int page, int count) {
    myModel.setNowCallBack(new MyModel.NowCallBack() {
        @Override
        public void shownows(Object obj) {
            List<Baner>list= (List<Baner>) obj;
            ContarctIntface.NowMovieViewIntface nowMovieViewIntface= (ContarctIntface.NowMovieViewIntface) tt;
            nowMovieViewIntface.ShowNow(list);
            Log.e("hhh",""+list);
        }
    });
    myModel.getNow(userId,sessionId,page,count);
    }

    @Override
    public void toJi(int userId, String sessionId, int page, int count) {
        myModel.setJiangCallBacks(new MyModel.JiangCallBacks() {
            @Override
            public void showjiang(Object obj) {
                List<Baner>list= (List<Baner>) obj;
                ContarctIntface.JiMovieViewIntface jiMovieViewIntface= (ContarctIntface.JiMovieViewIntface) tt;
                jiMovieViewIntface.ShowJi(list);
            }
        });
        myModel.getJiang(userId,sessionId,page,count);
    }
}
