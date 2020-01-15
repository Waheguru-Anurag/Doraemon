package com.example.doraemon.ui;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Time_Machine_Client {
        private static final String baseURl = "https://history.muffinlabs.com/";
        private static Retrofit retrofit = null;
        static final OkHttpClient okHttpClient = new OkHttpClient.Builder().
        readTimeout(30, TimeUnit.SECONDS).
        connectTimeout(30, TimeUnit.SECONDS).build();

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
