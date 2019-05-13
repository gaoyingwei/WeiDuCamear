package com.bw.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.Baner;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class ThirdAdapter extends RecyclerView.Adapter<ThirdAdapter.Holder>{

    List<Baner>list;
    Context context;

    public ThirdAdapter(List<Baner> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.item_ji_adapter,null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        String imgUrl=list.get(position).getImageUrl();
        String name=list.get(position).getName();
        String titles=list.get(position).getSummary();
        holder.simpleDraweeView.setImageURI(imgUrl);
        holder.textView_name.setText(name);
        holder.textView_title.setText(titles);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder{
        public SimpleDraweeView simpleDraweeView;
        public TextView textView_name,textView_title;
        public ImageView imageView;
        public Holder(View itemView) {
            super(itemView);
            simpleDraweeView=itemView.findViewById(R.id.sims_ji);
            textView_name=itemView.findViewById(R.id.names_ji);
            textView_title=itemView.findViewById(R.id.titles_ji);
            imageView=itemView.findViewById(R.id.guan_ji);
        }
    }
}
