package com.example.falokaapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.falokaapp.Model.Promo;
import com.example.falokaapp.R;

import java.util.List;

public class HotSaleAdapter extends RecyclerView.Adapter<HotSaleAdapter.HotSaleViewHolder> {

    List<Promo> promos;
    LayoutInflater inflater;

    public HotSaleAdapter(Context context, List<Promo> promos){
        this.promos = promos;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public HotSaleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = this.inflater.inflate(R.layout.grid_hotsale, parent, false);


        return new HotSaleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotSaleViewHolder holder, int position) {
        Promo promo = this.promos.get(position);
        holder.imgPromo.setImageResource(promo.getImage() );
    }

    @Override
    public int getItemCount() {
        return promos.size();
    }

    public class HotSaleViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPromo;

        public HotSaleViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPromo = itemView.findViewById(R.id.img_product);
        }
    }
}
