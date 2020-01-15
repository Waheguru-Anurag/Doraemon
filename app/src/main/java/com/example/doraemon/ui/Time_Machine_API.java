package com.example.doraemon.ui;

import com.example.doraemon.ui.Time_Machine_Model.Post;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Time_Machine_API{

    @GET("/date{extra}")
    Call<Post> getpostData(@Path(value = "extra",encoded=true) String extra);

}
