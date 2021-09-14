package com.example.falokaapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.falokaapp.Adapter.BestBrandAdapter;
import com.example.falokaapp.Adapter.CategoryAdapter;
import com.example.falokaapp.Adapter.FLashSaleProductAdapter;
import com.example.falokaapp.Adapter.HotSaleAdapter;
import com.example.falokaapp.Adapter.ProductAdapter;
import com.example.falokaapp.Model.Brand;
import com.example.falokaapp.Model.Category;
import com.example.falokaapp.Model.Product;
import com.example.falokaapp.Model.Promo;
import com.google.android.material.tabs.TabLayout;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

public class FragmentHome extends Fragment {

    List<Integer> images;
    List<String> imagesTitle;
    List<String> kategori;

//    ConstraintLayout

    CarouselView carouselView;
    TabLayout tabLayout;

    RecyclerView rvCategory;
    List<Category> categoryList;
    CategoryAdapter categoryAdapter;

    RecyclerView rvFlashSale;
    List<Product> products;
    FLashSaleProductAdapter fLashSaleProductAdapter;

    RecyclerView rvHotSale;
    List<Promo> promos;
    HotSaleAdapter hotSaleAdapter;

    RecyclerView rvTrendingOutfit;
    ProductAdapter productAdapter;
//    List<Product> productsTending

    RecyclerView rvBestBrand;
    List<Brand> brands;
    BestBrandAdapter bestBrandAdapter ;

    RecyclerView rvStyleInspiration;
    List<Product> inspirationProducts;
    ProductAdapter inspirationProductAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        initDummyData();

        initTabLayout(view);
        initCarousal(view);
        initCategory(view);
        initFlashSale(view);
        initHotSale(view);
        initTrendingOutfit(view);
        initBestBrand(view);
        initStyleInspiration(view);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    public void initTabLayout(View view){
        tabLayout = view.findViewById(R.id.tab_kategori);

        for(String name : kategori){
            tabLayout.addTab(tabLayout.newTab().setText(name));
        }

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                for(String name : kategori){
                    if(tab.getText().equals(name)){
                        Toast.makeText(getContext(), name, Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void initCarousal(View view){
        carouselView = view.findViewById(R.id.home_carousel);
        carouselView.setPageCount(images.size());
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(images.get(position));
            }
        });
        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
//                Toast.makeText(FragmentHome.this, imagesTitle.get(position), Toast.LENGTH_SHORT).show();
//                    Toast.makeText(getContext(), imagesTitle.get(position), Toast.LENGTH_SHORT).show();
//                getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.container_fragment, fragment)
//                        .commit();

                Bundle bundle = new Bundle();
                bundle.putString("name", imagesTitle.get(position));

                Fragment searchFragment = new FragmentSearch();
                searchFragment.setArguments(bundle);

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container_fragment, searchFragment)
                        .commit();
            }
        });
    }

    public void initStyleInspiration(View view){
        rvStyleInspiration = view.findViewById(R.id.rv_style_inspiration);
        inspirationProducts = getListTrendingOutfit();
        inspirationProductAdapter = new ProductAdapter(getContext(), inspirationProducts);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        rvStyleInspiration.setLayoutManager(gridLayoutManager);
        rvStyleInspiration.setAdapter(inspirationProductAdapter);
    }

    public void initBestBrand(View view){
        rvBestBrand = view.findViewById(R.id.rv_best_brand);
        brands = getListBrands();
        bestBrandAdapter = new BestBrandAdapter(getContext(), brands);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1, GridLayoutManager.HORIZONTAL, false);
        rvBestBrand.setLayoutManager(gridLayoutManager);
        rvBestBrand.setAdapter(bestBrandAdapter);
    }

    public void initTrendingOutfit(View view){
        rvTrendingOutfit =  view.findViewById(R.id.rv_trending_outfit);
        products = getListTrendingOutfit();
        productAdapter = new ProductAdapter(getContext(), products);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        rvTrendingOutfit.setLayoutManager(gridLayoutManager);
        rvTrendingOutfit.setAdapter(productAdapter);
    }

    public void initHotSale(View view){
        rvHotSale = view.findViewById(R.id.rv_hot_sale);
        promos = getListPromos();
        hotSaleAdapter = new HotSaleAdapter(getContext(), promos);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1, GridLayoutManager.HORIZONTAL, false);
        rvHotSale.setLayoutManager(gridLayoutManager);
        rvHotSale.setAdapter(hotSaleAdapter);
    }

    public void initFlashSale(View view){
        rvFlashSale = view.findViewById(R.id.rv_flash_sale);
        products = getListFlashSale();
        fLashSaleProductAdapter = new FLashSaleProductAdapter(getContext(), products);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1, GridLayoutManager.HORIZONTAL, false);
        rvFlashSale.setLayoutManager(gridLayoutManager);
        rvFlashSale.setAdapter(fLashSaleProductAdapter);
    }

    public void initCategory(View view){
        categoryList = new ArrayList<>();
        categoryList.add(new Category("Rok", R.drawable.img_rok));
        categoryList.add(new Category("Rompi", R.drawable.img_rompi));
        categoryList.add(new Category("Jeans", R.drawable.img_jeans));
        categoryList.add(new Category("Vest", R.drawable.img_vest));
        categoryList.add(new Category("Sweeter", R.drawable.img_sweeter));
        categoryList.add(new Category("Jaket", R.drawable.img_jaket));
        categoryList.add(new Category("Blouse", R.drawable.img_blouse));
        categoryList.add(new Category("Lainnya", R.drawable.img_lainnya));

        rvCategory = view.findViewById(R.id.rv_kategori);

        categoryAdapter = new CategoryAdapter(getContext(), categoryList);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4, GridLayoutManager.VERTICAL, false);
        rvCategory.setLayoutManager(gridLayoutManager);
        rvCategory.setAdapter(categoryAdapter);
    }

    public void initDummyData(){
        images = new ArrayList<>();
        imagesTitle = new ArrayList<>();
        kategori = new ArrayList<>();

        images.add(R.drawable.hijab_collection);
        images.add(R.drawable.hijab_collection);
        images.add(R.drawable.hijab_collection);
        images.add(R.drawable.hijab_collection);

        imagesTitle.add("Hijab");
        imagesTitle.add("Elir");
        imagesTitle.add("Hji");
        imagesTitle.add(":D");

        kategori.add("Cowok");
        kategori.add("Cewek");
        kategori.add("Atasan");
        kategori.add("Bawahan");
    }

    public List<Product> getListFlashSale(){
        List<Product> products = new ArrayList<>();

        for(int i=0; i<20; i++){
            Product product = new Product();
            product.setQuantity(50);
            product.setName("Outfit OMG");
            product.setBrand("Korigore");
            product.setPrice("Rp 100.000");
            product.setPriceBefore("Rp 200.000");
            product.setImage(R.drawable.product1);
            products.add(product);
        }

        return products;
    }

    public List<Product> getListTrendingOutfit(){
        List<Product> products = new ArrayList<>();

        for(int i=0; i<4; i++){
            Product product = new Product();
            product.setQuantity(50);
            product.setName("Outfit OMG");
            product.setBrand("Korigore");
            product.setPrice("Rp 100.000");
            product.setPriceBefore("Rp 200.000");
            product.setImage(R.drawable.product1);
            products.add(product);
        }

        return products;
    }

    public List<Promo> getListPromos(){
        List<Promo> promos = new ArrayList<>();

        for(int i=0; i<10; i++){
            Promo promo = new Promo();
            promo.setImage(R.drawable.promo);
            promos.add(promo);
        }
        return promos;
    }

    public List<Brand> getListBrands(){
        List<Brand> brands = new ArrayList<>();

        for(int i=0; i<10; i++){
            Brand brand = new Brand();
            brand.setImage(R.drawable.origo_logo);
            brands.add(brand);
        }
        return brands;
    }
}
