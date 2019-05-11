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
        public void toRegist(String nickName,int sex,String birthday,String phone,String email,String pwd,String pwd2);
        public void toLogin(String phone,String pwd,String pwd2);
    }
    //登录view层接口
    public interface LoginViewIntface{
        public void ShowLogin(LoginBean loginBean);
    }
}
