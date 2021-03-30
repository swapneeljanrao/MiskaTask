package com.mrcoder.retrofitexample.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.bumptech.glide.Glide;
import com.ahmadrosid.svgloader.SvgLoader;
import com.mrcoder.retrofitexample.R;
import com.mrcoder.retrofitexample.model.Hero;

import java.util.List;

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.HeroViewHolder> {

    Context mCtx;
    List<Hero> heroList;

    public HeroesAdapter(Context mCtx, List<Hero> heroList) {
        this.mCtx = mCtx;
        this.heroList = heroList;
    }

    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.single_item_layout, parent, false);
        return new HeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder holder, int position) {
        Hero hero = heroList.get(position);

        /*Glide.with(mCtx)
                .load(hero.getImageurl())
                .into(holder.imageView);*/

        SvgLoader.pluck()
                .with((Activity) mCtx)
                .setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher)
                .load(heroList.get(position).getImageurl(), holder.imageView);

        holder.textView.setText(hero.getName());
    }

    @Override
    public int getItemCount() {
        return heroList.size();
    }

    class HeroViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public HeroViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.iv_country_image);
            textView = itemView.findViewById(R.id.tv_country_name);
        }
    }
}