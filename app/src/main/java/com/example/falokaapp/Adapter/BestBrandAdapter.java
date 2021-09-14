package com.example.falokaapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.falokaapp.Model.Brand;
import com.example.falokaapp.Model.Promo;
import com.example.falokaapp.R;

import java.util.List;

public class BestBrandAdapter extends RecyclerView.Adapter<BestBrandAdapter.BestBrandViewHolder> {

    List<Brand> brands;
    LayoutInflater inflater;

    public BestBrandAdapter(Context context, List<Brand> brands){
        this.brands = brands;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public BestBrandViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = this.inflater.inflate(R.layout.grid_bestbrand , parent, false);


        return new BestBrandViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BestBrandViewHolder holder, int position) {
        Brand brand = this.brands.get(position);
        holder.imgBrand.setImageResource(brand.getImage() );
    }

    @Override
    public int getItemCount() {
        return brands.size();
    }

    public class BestBrandViewHolder extends RecyclerView.ViewHolder {

        ImageView imgBrand;

        public BestBrandViewHolder(@NonNull View itemView) {
            super(itemView);
            imgBrand = itemView.findViewById(R.id.img_brand );
        }
    }
}
