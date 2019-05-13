package com.bw.movie.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.bean.Baner;
import com.bw.movie.fragment.RemenFragment;
import com.bw.movie.view.FilmActivity;
import com.bw.movie.view.XiangQingActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class RemenAdapter extends RecyclerView.Adapter<RemenAdapter.Holder>{

    List<Baner>list;
    Context context;

    public RemenAdapter(List<Baner> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.fragment_remen_adapter,null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
            String imgUrl=list.get(position).getImageUrl();
            String name=list.get(position).getName();
            holder.simpleDraweeView.setImageURI(imgUrl);
            holder.textView.setText(name);
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
        public TextView textView;
        public Holder(View itemView) {
            super(itemView);
            simpleDraweeView=itemView.findViewById(R.id.img);
            textView=itemView.findViewById(R.id.populartextviewone);
        }
    }
}
