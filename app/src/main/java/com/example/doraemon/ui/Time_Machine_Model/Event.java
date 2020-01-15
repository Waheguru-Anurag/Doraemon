package com.example.doraemon.ui.Time_Machine_Model;

import com.google.gson.annotations.SerializedName;

public class Event{

    @SerializedName("year")
    private String year;
    @SerializedName("text")
    private String text;

    public String getYear() {
        return year;
    }

    public String getText() {
        return text;
    }
}
