package com.bw.movie.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.contarct.ContarctIntface;
import com.bw.movie.presenter.MyPresenter;
import com.bw.movie.util.EncryptUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements ContarctIntface.LoginViewIntface {
    @BindView(R.id.login_image_bg)
    ImageView loginImageBg;
    @BindView(R.id.ed_phone)
    EditText edPhone;
    @BindView(R.id.ed_pwd)
    EditText edPwd;
    @BindView(R.id.show_pwd)
    ImageView showPwd;
    @BindView(R.id.che_pwd)
    CheckBox chePwd;
    @BindView(R.id.fly_reg)
    TextView flyReg;
    @BindView(R.id.lin1)
    LinearLayout lin1;
    @BindView(R.id.login)
    TextView login;
    @BindView(R.id.view_left)
    View viewLeft;
    @BindView(R.id.login_text_weixinlogin)
    TextView loginTextWeixinlogin;
    @BindView(R.id.view_right)
    View viewRight;
    @BindView(R.id.qqlogin)
    ConstraintLayout qqlogin;
    @BindView(R.id.weixinlogin)
    ImageView weixinlogin;
    ContarctIntface.PresenterIntface presenterIntface;
    String phone;
    String pwd;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        presenterIntface=new MyPresenter<>(this);
    }

    @OnClick({R.id.ed_phone, R.id.ed_pwd, R.id.show_pwd, R.id.che_pwd, R.id.fly_reg, R.id.lin1, R.id.login, R.id.view_left, R.id.login_text_weixinlogin, R.id.view_right, R.id.qqlogin, R.id.weixinlogin})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ed_phone:
                break;
            case R.id.ed_pwd:
                break;
            case R.id.show_pwd:
                break;
            case R.id.che_pwd:
                break;
            case R.id.fly_reg:
                Intent intent = new Intent(LoginActivity.this, RegistActivity.class);
                startActivityForResult(intent,100);
                break;
            case R.id.lin1:
                break;
            case R.id.login:
                String phone = edPhone.getText().toString();
                String pwd = edPwd.getText().toString();
                String encrypt = EncryptUtil.encrypt(pwd);
                presenterIntface.toLogin(phone,encrypt,encrypt);
                break;
            case R.id.view_left:
                break;
            case R.id.login_text_weixinlogin:
                break;
            case R.id.view_right:
                break;
            case R.id.qqlogin:
                break;
            case R.id.weixinlogin:
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==100&&resultCode==200){
            String phone = data.getStringExtra("phone");
            String pwd = data.getStringExtra("password");
            edPhone.setText(phone);
            edPwd.setText(pwd);
        }
    }

    @Override
    public void ShowLogin(LoginBean loginBean) {
        String message = loginBean.getMessage();
        Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();
    }
}
