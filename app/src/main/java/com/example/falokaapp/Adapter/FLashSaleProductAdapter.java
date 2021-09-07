package com.example.falokaapp.Adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.falokaapp.Model.Product;
import com.example.falokaapp.R;

import java.util.List;

public class FLashSaleProductAdapter extends RecyclerView.Adapter<FLashSaleProductAdapter.FlashSaleProductViewHolder> {

    List<Product> productList;
    LayoutInflater inflater;

    public FLashSaleProductAdapter(Context context, List<Product> productList){
        this.productList = productList;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public FlashSaleProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = this.inflater.inflate(R.layout.grid_home_flashsale, parent, false);


        return new FlashSaleProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlashSaleProductViewHolder holder, int position) {
        Product product = this.productList.get(position);
        holder.tvPriceBefore.setText(product.getPriceBefore());
        holder.tvPriceBefore.setPaintFlags(holder.tvPriceBefore.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG );
        holder.tvPriceAfter.setText(product.getPrice());
        holder.tvQuantity.setText(Integer.toString(product.getQuantity()) +"/100 Terjual" );
        holder.imgProduct.setImageResource(product.getImage());
        holder.pbSale.setMax(100);
        holder.pbSale.setProgress(product.getQuantity());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class FlashSaleProductViewHolder extends RecyclerView.ViewHolder {

        TextView tvPriceBefore;
        TextView tvPriceAfter;
        TextView tvQuantity;
        ProgressBar pbSale;
        ImageView imgProduct;

        public FlashSaleProductViewHolder(@NonNull View itemView) {
            super(itemView);

            tvPriceAfter = itemView.findViewById(R.id.tv_sale_price_after);
            tvPriceBefore = itemView.findViewById(R.id.tv_sale_price_before);
            pbSale = itemView.findViewById(R.id.pb_quantity);
            tvQuantity = itemView.findViewById(R.id.tv_quantity);
            imgProduct = itemView.findViewById(R.id.img_flashsale);
        }
    }
}
