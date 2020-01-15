package com.example.doraemon.ui.Time_Machine_Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @SerializedName("Events")
    private List<Event> events;

    public List<Event> getEvents() {
        return events;
    }
}