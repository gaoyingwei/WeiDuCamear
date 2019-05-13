package com.bw.movie.contarct;

import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.RegisterBean;

public interface ContarctIntface {
    //注册view层接口
    public interface RegistViewIntface{
        public void ShowRegist(RegisterBean registerBean);
    }
    //p层接口
    public interface PresenterIntface{
        //注册
        public void toRegist(String nickName,int sex,String birthday,String phone,String email,String pwd,String pwd2);
        //登录
        public void toLogin(String phone,String pwd,String pwd2);
        //轮播
        public void toBaner(int userId,String sessionId,int page,int count);
        //热门电影
        public void toHot(int userId,String sessionId,int page,int count);
        //正在热映
        public void toReYing(int userId,String sessionId,int page,int count);
        //即将上映
        public void toJjJiang(int userId,String sessionId,int page,int count);
        //详情
        public void toXiang(int userId,String sessionId,int movieId);
        //热门
        public void toRemen(int userId,String sessionId,int page,int count);
        //正在
        public void toNow(int userId,String sessionId,int page,int count);
        //即将
        public void toJi(int userId,String sessionId,int page,int count);
    }
    //登录view层接口
    public interface LoginViewIntface{
        public void ShowLogin(LoginBean loginBean);
    }
    //轮播
    public interface BanerViewIntface{
        public void ShowBaner(Object obj);
        public void ShowHot(Object obj);
        public void ShowReYing(Object obj);
        public void ShowJiJiang(Object obj);
    }
    //详情
    public interface XiangQingViewIntface{
        public void ShowXiangQing(Object obj);
    }
    //热门电影
    public interface HotMovieViewIntface{
        public void ShowRemen(Object obj);
    }
    //正在热映
    public interface NowMovieViewIntface{
        public void ShowNow(Object obj);
    }
    //即将上映
    public interface JiMovieViewIntface{
        public void ShowJi(Object obj);
    }

}
