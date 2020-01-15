package com.example.doraemon.ui.Anywhere_Door_Model;

import com.google.gson.annotations.SerializedName;

public class Geometry {
    @SerializedName("location")
    Location location;

    public Location getLocation() {
        return location;
    }
}
