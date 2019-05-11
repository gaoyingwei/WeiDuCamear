package com.bw.movie.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bw.movie.R;
import com.bw.movie.adapter.MyPictureAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecondActivity extends AppCompatActivity {
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.rb1)
    RadioButton rb1;
    @BindView(R.id.rb2)
    RadioButton rb2;
    @BindView(R.id.rb3)
    RadioButton rb3;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;
    @BindView(R.id.btn_tiyan)
    Button btnTiyan;
    @BindView(R.id.rb4)
    RadioButton rb4;
    public List<Integer> list;
    private SharedPreferences sp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        //获取sp对象
        sp = getSharedPreferences("config", MODE_PRIVATE);
        //取值
        boolean flags = sp.getBoolean("flags", false);
        if (flags) {
            Intent intent = new Intent(SecondActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
        //创建图片的数据集合
        list = new ArrayList<Integer>();
        list.add(R.drawable.fourth);
        list.add(R.drawable.third);
        list.add(R.drawable.first);
        list.add(R.drawable.second);
        MyPictureAdapter myPictureAdapter = new MyPictureAdapter(list, this);
        viewPager.setAdapter(myPictureAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {


            }

            @Override
            public void onPageSelected(int i) {
                radioGroup.check(radioGroup.getChildAt(i).getId());
                if (list.size() - 1 == i) {
                    btnTiyan.setVisibility(View.VISIBLE);
                } else {
                    btnTiyan.setVisibility(View.INVISIBLE);
                }

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        btnTiyan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                SharedPreferences.Editor edit = sp.edit();
                //存值
                edit.putBoolean("flags", true);
                edit.commit();
                Intent intent = new Intent(SecondActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @OnClick({R.id.rb1, R.id.rb2, R.id.rb3, R.id.btn_tiyan})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rb1:
                break;
            case R.id.rb2:
                break;
            case R.id.rb3:
                break;
            case R.id.btn_tiyan:
                break;
        }
    }
}
