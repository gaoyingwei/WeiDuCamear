package com.bw.movie.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import com.bw.movie.R;
import com.bw.movie.fragment.JiJiangFragment;
import com.bw.movie.fragment.RemenFragment;
import com.bw.movie.fragment.ZhengZaiFragment;
import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FilmActivity extends AppCompatActivity {

    @BindView(R.id.radio_men)
    RadioButton radioMen;
    @BindView(R.id.radio_ying)
    RadioButton radioYing;
    @BindView(R.id.radio_ji)
    RadioButton radioJi;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    private StatusBarUtil statusBarUtil;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        statusBarUtil.setTranslucentForImageViewInFragment(this, null);
        setContentView(R.layout.activity_film);
        getSupportActionBar().hide();
        ButterKnife.bind(this);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            Fragment fragment=null;
            @Override
            public Fragment getItem(int position) {
                switch (position){
                    case 0:
                        fragment=new RemenFragment();
                        break;
                    case 1:
                        fragment=new ZhengZaiFragment();
                        break;

                    case 2:
                        fragment=new JiJiangFragment();
                        break;
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return 3;
            }
        });
    }

    @OnClick({R.id.radio_men, R.id.radio_ying, R.id.radio_ji, R.id.view_pager})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.radio_men:
                viewPager.setCurrentItem(0,false);
                break;
            case R.id.radio_ying:
                viewPager.setCurrentItem(1,false);
                break;
            case R.id.radio_ji:
               viewPager.setCurrentItem(2,false);
                break;
            case R.id.view_pager:
                break;
        }
    }
}
