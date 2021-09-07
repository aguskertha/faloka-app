package com.example.falokaapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Category implements Parcelable {

    private String name;
    private Integer image;

    public Category(String name, Integer image){
        this.name = name;
        this.image = image;
    }

    protected Category(Parcel in) {
        setName(in.readString());
        if (in.readByte() == 0) {
            setImage(null);
        } else {
            setImage(in.readInt());
        }
    }

    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getName());
        if (getImage() == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(getImage());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }
}
