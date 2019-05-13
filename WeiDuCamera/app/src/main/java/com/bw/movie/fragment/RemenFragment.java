package com.bw.movie.fragment;

import android.content.Context;
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

import com.bw.movie.R;
import com.bw.movie.adapter.FirstAdapter;
import com.bw.movie.bean.Baner;
import com.bw.movie.contarct.ContarctIntface;
import com.bw.movie.presenter.MyPresenter;

import java.util.ArrayList;
import java.util.List;

public class RemenFragment extends Fragment implements ContarctIntface.HotMovieViewIntface {
    ContarctIntface.PresenterIntface presenterIntface;
    List<Baner>onelist=new ArrayList<>();
    RecyclerView recyclerView_hot;
    private FirstAdapter firstAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_remen, container, false);
        recyclerView_hot=view.findViewById(R.id.hot_recy);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SharedPreferences sp = getActivity().getSharedPreferences("config", Context.MODE_PRIVATE);
        int userId = (int) Double.parseDouble(sp.getString("userId", ""));
        String sessionId = sp.getString("sessionId", "");
        presenterIntface=new MyPresenter<>(this);
        presenterIntface.toRemen(userId,sessionId,1,10);
        //布局管理器
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView_hot.setLayoutManager(layoutManager);
        firstAdapter = new FirstAdapter(onelist, getActivity());
        recyclerView_hot.setAdapter(firstAdapter);
    }

    @Override
    public void ShowRemen(Object obj) {
        List<Baner> list= (List<Baner>) obj;
        onelist.addAll(list);
        Log.e("fff",""+onelist);
        firstAdapter.notifyDataSetChanged();
    }
}
