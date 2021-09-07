package com.example.falokaapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Promo implements Parcelable {
    private int image;

    public Promo (){

    }
    protected Promo(Parcel in) {
        setImage(in.readInt());
    }

    public static final Creator<Promo> CREATOR = new Creator<Promo>() {
        @Override
        public Promo createFromParcel(Parcel in) {
            return new Promo(in);
        }

        @Override
        public Promo[] newArray(int size) {
            return new Promo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(getImage());
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
