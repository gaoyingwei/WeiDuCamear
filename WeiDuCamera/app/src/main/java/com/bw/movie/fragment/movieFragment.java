package com.bw.movie.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.adapter.BanerAdapter;
import com.bw.movie.adapter.JiJiangAdapter;
import com.bw.movie.adapter.RemenAdapter;
import com.bw.movie.adapter.ShangYingAdapter;
import com.bw.movie.bean.Baner;
import com.bw.movie.contarct.ContarctIntface;
import com.bw.movie.presenter.MyPresenter;
import com.bw.movie.view.FilmActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class movieFragment extends Fragment implements ContarctIntface.BanerViewIntface {
    @BindView(R.id.recy)
    RecyclerView recy;
    @BindView(R.id.search_image)
    ImageView searchImage;
    @BindView(R.id.search_edname)
    EditText searchEdname;
    @BindView(R.id.search_textName)
    TextView searchTextName;
    @BindView(R.id.home_dingwei)
    ImageView homeDingwei;
    @BindView(R.id.home_text)
    TextView homeText;
    Unbinder unbinder;
    ContarctIntface.PresenterIntface presenterIntface;
    List<Baner> blist = new ArrayList<>();
    @BindView(R.id.tv_hotmovie)
    TextView tvHotmovie;
    @BindView(R.id.recycler_hotmovie)
    RecyclerView recyclerHotmovie;
    @BindView(R.id.tv_nowplaying)
    TextView tvNowplaying;
    @BindView(R.id.recycler_playingmovie)
    RecyclerView recyclerPlayingmovie;
    @BindView(R.id.tv_sooning)
    TextView tvSooning;
    @BindView(R.id.recycler_sooning)
    RecyclerView recyclerSooning;
    @BindView(R.id.ll_all)
    ScrollView llAll;
    private BanerAdapter banerAdapter;
    List<Baner>elist=new ArrayList<>();
    private RemenAdapter remenAdapter;
    List<Baner>ylist=new ArrayList<>();
    List<Baner>jlist=new ArrayList<>();
    private ShangYingAdapter shangYingAdapter;
    private JiJiangAdapter jiJiangAdapter;
    ImageView imageView_hot,imageView_now,imageView_soon;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        unbinder = ButterKnife.bind(this, view);
        imageView_hot=view.findViewById(R.id.img_hot_next);
        imageView_now=view.findViewById(R.id.img_now_next);
        imageView_soon=view.findViewById(R.id.img_soon_next);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SharedPreferences sp = getActivity().getSharedPreferences("config", Context.MODE_PRIVATE);
        int userId = (int) Double.parseDouble(sp.getString("userId", ""));
        String sessionId = sp.getString("sessionId", "");
        presenterIntface = new MyPresenter<>(this);
        presenterIntface.toBaner(userId, sessionId, 1, 10);
        banerAdapter = new BanerAdapter(blist, getActivity());
        recy.setAdapter(banerAdapter);
        //热门电影
        presenterIntface.toHot(userId,sessionId,1,10);
        remenAdapter = new RemenAdapter(elist, getActivity());
        recyclerHotmovie.setAdapter(remenAdapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerHotmovie.setLayoutManager(layoutManager);
        //正在热映
        presenterIntface.toReYing(userId, sessionId, 1, 10);
        shangYingAdapter = new ShangYingAdapter(ylist, getActivity());
        recyclerPlayingmovie.setAdapter(shangYingAdapter);
        LinearLayoutManager layoutManagers=new LinearLayoutManager(getActivity());
        layoutManagers.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerPlayingmovie.setLayoutManager(layoutManagers);
        //即将上映
        presenterIntface.toJjJiang(userId, sessionId, 1, 10);
        jiJiangAdapter = new JiJiangAdapter(jlist, getActivity());
        recyclerSooning.setAdapter(jiJiangAdapter);
        LinearLayoutManager layoutManageres=new LinearLayoutManager(getActivity());
        layoutManageres.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerSooning.setLayoutManager(layoutManageres);
        imageView_hot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FilmActivity.class);
                getActivity().startActivity(intent);
            }
        });
        imageView_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FilmActivity.class);
                getActivity().startActivity(intent);
            }
        });
        imageView_soon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FilmActivity.class);
                getActivity().startActivity(intent);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void ShowBaner(Object obj) {
        List<Baner> list = (List<Baner>) obj;
        blist.addAll(list);
        Log.e("mmm", "" + blist);
        banerAdapter.notifyDataSetChanged();
    }

    @Override
    public void ShowHot(Object obj) {
      List<Baner>list= (List<Baner>) obj;
      elist.addAll(list);
      remenAdapter.notifyDataSetChanged();
    }

    @Override
    public void ShowReYing(Object obj) {
        List<Baner>list= (List<Baner>) obj;
        ylist.addAll(list);
        shangYingAdapter.notifyDataSetChanged();
    }

    @Override
    public void ShowJiJiang(Object obj) {
        List<Baner>list= (List<Baner>) obj;
        jlist.addAll(list);
        jiJiangAdapter.notifyDataSetChanged();
    }
}
