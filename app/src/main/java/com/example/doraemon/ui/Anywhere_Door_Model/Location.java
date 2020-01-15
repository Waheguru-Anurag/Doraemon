package com.example.doraemon.ui.Anywhere_Door_Model;

import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("lat")
    double lat;

    @SerializedName("lng")
    double lng;

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }
}
