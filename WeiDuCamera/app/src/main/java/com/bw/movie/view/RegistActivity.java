package com.bw.movie.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.contarct.ContarctIntface;
import com.bw.movie.presenter.MyPresenter;
import com.bw.movie.util.EncryptUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegistActivity extends AppCompatActivity implements ContarctIntface.RegistViewIntface {
    @BindView(R.id.reg_imagebg)
    ImageView regImagebg;
    @BindView(R.id.ppp)
    ImageView ppp;
    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.ppp1)
    ImageView ppp1;
    @BindView(R.id.sex)
    EditText sex;
    @BindView(R.id.ppp2)
    ImageView ppp2;
    @BindView(R.id.data)
    EditText data;
    @BindView(R.id.ppp3)
    ImageView ppp3;
    @BindView(R.id.mobile)
    EditText mobile;
    @BindView(R.id.ppp4)
    ImageView ppp4;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.ppp5)
    ImageView ppp5;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.lin2)
    LinearLayout lin2;
    @BindView(R.id.Regg)
    Button Regg;
    ContarctIntface.PresenterIntface presenterIntface;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        ButterKnife.bind(this);
        presenterIntface = new MyPresenter(this);

    }

    @OnClick({R.id.reg_imagebg, R.id.ppp, R.id.name, R.id.ppp1, R.id.sex, R.id.ppp2, R.id.data, R.id.ppp3, R.id.mobile, R.id.ppp4, R.id.email})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.reg_imagebg:
                break;
            case R.id.ppp:
                break;
            case R.id.name:
                break;
            case R.id.ppp1:
                break;
            case R.id.sex:
                break;
            case R.id.ppp2:
                break;
            case R.id.data:
                break;
            case R.id.ppp3:
                break;
            case R.id.mobile:
                break;
            case R.id.ppp4:
                break;
            case R.id.email:
                break;
        }
    }

    @Override
    public void ShowRegist(RegisterBean registerBean) {
        String message = registerBean.getMessage();
        Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();
        String mobiles = mobile.getText().toString();
        String pwd = password.getText().toString();
        Intent intent=new Intent();
        intent.putExtra("phone",mobiles);
        intent.putExtra("password",pwd);
        setResult(200,intent);
        finish();
    }

    @OnClick(R.id.Regg)
    public void onClick() {
        String nickName = this.name.getText().toString();
        int sex = (int)Double.parseDouble(this.sex.getText().toString());
        String data = this.data.getText().toString();
        String phone = this.mobile.getText().toString();
        String email = this.email.getText().toString();
        String password = this.password.getText().toString();
        String encrypt = EncryptUtil.encrypt(password);
        presenterIntface.toRegist(nickName,sex,data,phone,email,encrypt,encrypt);
    }
}
