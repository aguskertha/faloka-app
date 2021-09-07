package com.example.falokaapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {

    private String name;
    private String brand;
    private String price;
    private String priceBefore;
    private int quantity;
    private int image;

    public Product(){

    }

    protected Product(Parcel in) {
        this.setName(in.readString());
        this.setBrand(in.readString());
        this.setPrice(in.readString());
        this.setImage(in.readInt());
        this.setPriceBefore(in.readString());
        this.setQuantity(in.readInt());
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.getName());
        parcel.writeString(this.getBrand());
        parcel.writeString(this.getPrice());
        parcel.writeInt(this.getImage());
        parcel.writeString(this.getPriceBefore());
        parcel.writeInt(this.getQuantity());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getPriceBefore() {
        return priceBefore;
    }

    public void setPriceBefore(String priceBefore) {
        this.priceBefore = priceBefore;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
