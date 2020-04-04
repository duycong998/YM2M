package com.example.todolist.Retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Data {

//    @GET("posts")
//    Call<List<Employee>> getAll();
//
//
//    @POST("posts")
//    Call<Employee> creatEmployee(@Body Employee employee);
//
//    @POST("posts")
//    @FormUrlEncoded
//    Call<Employee> saveEmployee(@Field("userId") int userId,
//                        @Field("title") String title,
//                        @Field("body") String body);
//
//
//    @PUT("posts/{id}")
//    Call<Employee> updateEmployee(@Path("id") int id, @Body Employee employee);
//
//
//    @DELETE("posts/{id}")
//    void deleteEmployee(@Path("id") int  id);
    @GET("photos")
    Call<List<Employee>> getAll();


    void onClick(Employee employee);
}
