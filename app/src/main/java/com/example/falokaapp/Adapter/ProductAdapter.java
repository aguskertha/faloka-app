package com.example.falokaapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.falokaapp.Model.Product;
import com.example.falokaapp.R;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> implements View.OnClickListener {

    List<Product> products;
    LayoutInflater inflater;

    public ProductAdapter(Context context, List<Product> products){
        this.products = products;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = this.inflater.inflate(R.layout.grid_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = this.products.get(position);

        holder.imgBagCart.setOnClickListener(this);
        holder.imgProduct.setImageResource(product.getImage());
        holder.tvBrand.setText(product.getBrand());
        holder.tvName.setText(product.getName());
        holder.tvPrice.setText(product.getPrice());

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    @Override
    public void onClick(View view) {

    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        ImageView imgProduct;
        ImageView imgBagCart;
        TextView tvBrand;
        TextView tvName;
        TextView tvPrice;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.img_product);
            tvBrand = itemView.findViewById(R.id.tv_brand_product);
            tvName = itemView.findViewById(R.id.tv_name_product);
            tvPrice = itemView.findViewById(R.id.tv_price_product);
            imgBagCart = itemView.findViewById(R.id.img_bag_cart);
        }
    }
}
