package com.bw.movie.presenter;

import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.contarct.ContarctIntface;
import com.bw.movie.model.MyModel;

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
}
