package com.example.todolist.Retrofit;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit  {
    private static retrofit2.Retrofit retrofit = null;
    public static retrofit2.Retrofit getClient(String baseurl){
        OkHttpClient builder = new OkHttpClient.Builder()
                .readTimeout(5000, TimeUnit.MILLISECONDS) // thời gian kết nối
                .writeTimeout(5000,TimeUnit.MILLISECONDS)
                .connectTimeout(10000,TimeUnit.MILLISECONDS)//thời gian kết nối với sever quá thì ngắt kết nối
                .retryOnConnectionFailure(true)//kết nối lại lần nữa
                .build();

        Gson gson = new GsonBuilder().setLenient().create();
        retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(baseurl)
               .client(builder)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit;
    }

}
