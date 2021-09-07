package com.example.falokaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.falokaapp.Adapter.ProductAdapterExample;
import com.example.falokaapp.Model.Category;

import java.util.ArrayList;
import java.util.List;


public class ListProductActivity extends AppCompatActivity {

    public static final String EXTRA_USERNAME = "extra username";
    public static final String EXTRA_PASSWORD = "extra password";
    public final int SIZE = 6;
    RecyclerView rvProduct;
    List<Integer> image;

//    List<Product> products;
    ProductAdapterExample productAdapterExample;

    List<Category> categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);

        rvProduct = findViewById(R.id.rv_product);

        image = new ArrayList<Integer>();

        image.add(R.drawable.ic_baseline_3d_rotation_24);
        image.add(R.drawable.ic_baseline_4k_24);
        image.add(R.drawable.ic_baseline_5g_24);
        image.add(R.drawable.ic_baseline_360_24);
        image.add(R.drawable.ic_baseline_5g_24);
        image.add(R.drawable.ic_baseline_360_24);

        categoryList = new ArrayList<>();
        categoryList.add(new Category("Rok", R.drawable.img_rok));
        categoryList.add(new Category("Rompi", R.drawable.img_rompi));
        categoryList.add(new Category("Jeans", R.drawable.img_jeans));
        categoryList.add(new Category("Vest", R.drawable.img_vest));
        categoryList.add(new Category("Sweeter", R.drawable.img_sweeter));
        categoryList.add(new Category("Jaket", R.drawable.img_jaket));
        categoryList.add(new Category("Blouse", R.drawable.img_blouse));
        categoryList.add(new Category("Lainnya", R.drawable.img_lainnya));

//        this.products = this.getListProducts();

        productAdapterExample = new ProductAdapterExample(this, categoryList);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4, GridLayoutManager.VERTICAL, false);
        rvProduct.setLayoutManager(gridLayoutManager);
        rvProduct.setAdapter(productAdapterExample);


    }
//
//    public List<Product> getListProducts(){
//        List<Product> products = new ArrayList<>();
//
//        for(int i=0; i<SIZE; i++){
//            Product product = new Product();
//            product.setName("Name"+i);
//            product.setBrand("Brand"+i);
//            product.setPrice("Price"+i);
//            product.setImage(image.get(i));
//            products.add(product);
//        }
//
//        return products;
//    }

}