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
import com.bw.movie.adapter.SecondAdapter;
import com.bw.movie.bean.Baner;
import com.bw.movie.contarct.ContarctIntface;
import com.bw.movie.presenter.MyPresenter;

import java.util.ArrayList;
import java.util.List;

public class ZhengZaiFragment extends Fragment implements ContarctIntface.NowMovieViewIntface {
    ContarctIntface.PresenterIntface presenterIntface;
    List<Baner>nlist=new ArrayList<>();
    RecyclerView recyclerView_now;
    private SecondAdapter secondAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zhengzai, container, false);
        recyclerView_now=view.findViewById(R.id.recy_now);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SharedPreferences sp = getActivity().getSharedPreferences("config", Context.MODE_PRIVATE);
        int userId = (int) Double.parseDouble(sp.getString("userId", ""));
        String sessionId = sp.getString("sessionId", "");
        presenterIntface=new MyPresenter<>(this);
        presenterIntface.toNow(userId,sessionId,1,10);
        //布局管理器
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView_now.setLayoutManager(layoutManager);
        secondAdapter = new SecondAdapter(nlist, getActivity());
        recyclerView_now.setAdapter(secondAdapter);
    }

    @Override
    public void ShowNow(Object obj) {
        List<Baner>list= (List<Baner>) obj;
        nlist.addAll(list);
        secondAdapter.notifyDataSetChanged();
    }
}
