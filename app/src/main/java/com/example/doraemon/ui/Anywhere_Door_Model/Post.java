package com.example.doraemon.ui.Anywhere_Door_Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Post {
    @SerializedName("results")
    List<results> results;

    public List<results> getResults() {
        return results;
    }
}
