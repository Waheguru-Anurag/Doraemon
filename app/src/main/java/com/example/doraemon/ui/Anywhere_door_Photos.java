package com.example.doraemon.ui;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Anywhere_door_Photos {
    private static final String baseURl = "https://maps.googleapis.com/maps/api/place/photo";
    private static Retrofit retrofit = null;
    static final OkHttpClient okHttpClient = new OkHttpClient.Builder().
            readTimeout(60, TimeUnit.SECONDS).
            connectTimeout(60, TimeUnit.SECONDS).build();

    static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().
                    baseUrl(baseURl).
                    client(okHttpClient).
                    addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
