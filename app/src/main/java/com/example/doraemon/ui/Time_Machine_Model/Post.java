package com.example.doraemon.ui.Time_Machine_Model;

import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("date")
    private String date;

    @SerializedName("data")
    private Data data;

    public Data getData() {
        return data;
    }

    public String getDate() {
        return date;
    }
}
