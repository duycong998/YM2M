package com.example.todolist.Retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Data {

    @GET("posts")
    Call<List<Employee>> getAll();
}
