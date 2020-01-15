package com.example.doraemon.ui;

import com.example.doraemon.ui.Anywhere_Door_Model.Post;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Anywhere_door_API {
    @GET("/maps/api/place/nearbysearch/json?key=AIzaSyANemTCtbjtJpJBuOOPDe1Jz4VEuF7x8XE")
    Call<Post> getData(@Query(value = "location",encoded = true) String location,@Query(value = "radius",encoded = true) int radius);
}
