package com.example.falokaapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.falokaapp.Model.Category;
import com.example.falokaapp.R;

import java.util.List;

public class ProductAdapterExample extends RecyclerView.Adapter<ProductAdapterExample.ProductViewHolder> {

    List<Category> categories;
    LayoutInflater inflater;

    public ProductAdapterExample(Context context, List<Category> categories){
        this.categories = categories;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.grid_home_category, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Category category = categories.get(position);
//        holder.imgProduct.setImageResource(product.getImage() );
//        holder.tvName.setText(product.getName() );
//        holder.tvBrand.setText(product.getBrand() );
//        holder.tvPrice.setText(product.getPrice() );

        holder.imgCategory.setImageResource(category.getImage());
        holder.tvCategory.setText(category.getName());

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

//        ImageView imgProduct;
//        TextView tvName;
//        TextView tvBrand;
//        TextView tvPrice;

        ImageView imgCategory;
        TextView tvCategory;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
//            imgProduct = itemView.findViewById(R.id.img_product);
//            tvName = itemView.findViewById(R.id.tv_name);
//            tvBrand = itemView.findViewById(R.id.tv_brand);
//            tvPrice = itemView.findViewById(R.id.tv_price);

            imgCategory = itemView.findViewById(R.id.img_category);
            tvCategory = itemView.findViewById(R.id.tv_category_name);

        }
    }
}
