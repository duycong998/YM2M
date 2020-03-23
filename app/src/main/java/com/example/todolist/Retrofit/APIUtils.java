package com.example.todolist.Retrofit;

import retrofit2.converter.gson.GsonConverterFactory;

public class APIUtils {

    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    public static Data getData(){
return Retrofit.getClient(BASE_URL).create(Data.class);
    }
}
