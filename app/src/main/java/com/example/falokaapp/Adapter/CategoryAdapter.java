package com.example.falokaapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.falokaapp.FragmentListProduct;
import com.example.falokaapp.FragmentSearch;
import com.example.falokaapp.Model.Category;
import com.example.falokaapp.R;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    List<Category> categories;
    LayoutInflater inflater;

    public CategoryAdapter(Context context, List<Category> categories){
        this.categories = categories;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.grid_home_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = categories.get(position);

        holder.imgCategory.setImageResource(category.getImage());
        holder.tvCategory.setText(category.getName());
        holder.cvCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), holder.tvCategory.getText(), Toast.LENGTH_SHORT).show();

                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                if(activity != null) {
                    activity.getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container_fragment, new FragmentListProduct(), FragmentListProduct.class.getSimpleName())
                            .addToBackStack(null)
                            .commit();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {

        ImageView imgCategory;
        TextView tvCategory;
        CardView cvCategory;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            cvCategory = itemView.findViewById(R.id.cv_category);
            imgCategory = itemView.findViewById(R.id.img_category);
            tvCategory = itemView.findViewById(R.id.tv_category_name);

        }
    }
}
