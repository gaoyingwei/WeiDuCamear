package com.bw.movie.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.R;
import com.bw.movie.adapter.ThirdAdapter;
import com.bw.movie.bean.Baner;
import com.bw.movie.contarct.ContarctIntface;
import com.bw.movie.presenter.MyPresenter;

import java.util.ArrayList;
import java.util.List;

public class JiJiangFragment extends Fragment implements ContarctIntface.JiMovieViewIntface {
    ContarctIntface.PresenterIntface presenterIntface;
    List<Baner>glist=new ArrayList<>();
    RecyclerView recyclerView_ji;
    private ThirdAdapter thirdAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jijiang, container, false);
        recyclerView_ji=view.findViewById(R.id.recy_ji);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SharedPreferences sp = getActivity().getSharedPreferences("config", Context.MODE_PRIVATE);
        int userId = (int) Double.parseDouble(sp.getString("userId", ""));
        String sessionId = sp.getString("sessionId", "");
        presenterIntface=new MyPresenter<>(this);
        presenterIntface.toJi(userId,sessionId,1,10);
        //布局管理器
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView_ji.setLayoutManager(layoutManager);
        thirdAdapter = new ThirdAdapter(glist, getActivity());
        recyclerView_ji.setAdapter(thirdAdapter);
    }

    @Override
    public void ShowJi(Object obj) {
        List<Baner>list= (List<Baner>) obj;
        glist.addAll(list);
        thirdAdapter.notifyDataSetChanged();
    }
}
