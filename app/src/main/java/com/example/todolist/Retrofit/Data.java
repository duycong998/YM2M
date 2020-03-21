package com.example.todolist.Retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Data {

    @GET("/api/v1/employees")
    Call<List<Datum>> getAll();
}
