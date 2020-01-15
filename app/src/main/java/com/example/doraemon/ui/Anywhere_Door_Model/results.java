package com.example.doraemon.ui.Anywhere_Door_Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class results {
    @SerializedName("geometry")
    Geometry geometry;

    @SerializedName("place_id")
    String place_id;

    @SerializedName("photos")
    List<photos> photos;

    @SerializedName("vicinity")
    String vicinity;

    @SerializedName("name")
    String name;

    public Geometry getGeometry() {
        return geometry;
    }

    public String getPlace_id() {
        return place_id;
    }

    public List<photos> getPhotos() {
        return photos;
    }

    public String getVicinity() {
        return vicinity;
    }

    public String getName() {
        return name;
    }


}
