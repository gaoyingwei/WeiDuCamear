package com.bw.movie.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.contarct.ContarctIntface;
import com.bw.movie.presenter.MyPresenter;

public class XiangQingActivity extends AppCompatActivity implements ContarctIntface.XiangQingViewIntface {
    ContarctIntface.PresenterIntface presenterIntface;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiangqing);
        presenterIntface=new MyPresenter<>(this);
    }
    @Override
    public void ShowXiangQing(Object obj) {

    }
}
