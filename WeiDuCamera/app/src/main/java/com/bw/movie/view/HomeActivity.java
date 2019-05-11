package com.bw.movie.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bw.movie.R;
import com.bw.movie.fragment.cameraFragment;
import com.bw.movie.fragment.movieFragment;
import com.bw.movie.fragment.userFragment;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class HomeActivity extends AppCompatActivity {
    @BindView(R.id.home_viewpager)
    com.bw.movie.view.CustomViewPager homeViewpager;
    @BindView(R.id.btn1)
    RadioButton btn1;
    @BindView(R.id.btn2)
    RadioButton btn2;
    @BindView(R.id.btn3)
    RadioButton btn3;
    @BindView(R.id.navigation_btn)
    RadioGroup navigationBtn;
    private ArrayList<Fragment> list_fragment;
    private StatusBarUtil statusBarUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        statusBarUtil.setTranslucentForImageViewInFragment(this, null);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        homeViewpager = findViewById(R.id.home_viewpager);
        navigationBtn = findViewById(R.id.navigation_btn);
        btn1 = findViewById(R.id.btn2);
        btn2 = findViewById(R.id.btn3);
        btn3 = findViewById(R.id.btn1);
        list_fragment = new ArrayList<>();
        list_fragment.add(new movieFragment());
        list_fragment.add(new cameraFragment());
        list_fragment.add(new userFragment());
        homeViewpager.setScanScroll(false);
    }

    private void initData() {
        homeViewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list_fragment.get(i);
            }

            @Override
            public int getCount() {
                return list_fragment.size();
            }
        });
        navigationBtn.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.btn1:
                        homeViewpager.setCurrentItem(0);
                        break;
                    case R.id.btn2:
                        homeViewpager.setCurrentItem(1);
                        break;
                    case R.id.btn3:
                        homeViewpager.setCurrentItem(2);
                        break;
                }
            }
        });

    }

    @OnClick({R.id.home_viewpager, R.id.btn1, R.id.btn2, R.id.btn3, R.id.navigation_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_viewpager:
                break;
            case R.id.btn1:
                break;
            case R.id.btn2:
                break;
            case R.id.btn3:
                break;
            case R.id.navigation_btn:
                break;
        }
    }
}
