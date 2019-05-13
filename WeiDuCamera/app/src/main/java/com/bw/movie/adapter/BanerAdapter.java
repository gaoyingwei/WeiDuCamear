package com.bw.movie.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.R;
import com.bw.movie.bean.Baner;
import com.bw.movie.view.FilmActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import recycler.coverflow.RecyclerCoverFlow;

public class BanerAdapter extends RecyclerView.Adapter<BanerAdapter.Holder>{
    List<Baner>list;
    Context context;

    public BanerAdapter(List<Baner> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.fragment_item_baner,null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        String imgUrl=list.get(position).getImageUrl();
        holder.simpleDraweeView.setImageURI(imgUrl);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FilmActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder{
        public SimpleDraweeView simpleDraweeView;
        public Holder(View itemView) {
            super(itemView);
            simpleDraweeView=itemView.findViewById(R.id.simp_cinema_flow);
        }
    }
}
