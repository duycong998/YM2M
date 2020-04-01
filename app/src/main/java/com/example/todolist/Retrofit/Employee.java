package com.example.todolist.Retrofit;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;


import com.google.gson.annotations.Expose;

import java.io.Serializable;

@Entity (tableName = "employee")
public class Employee implements Serializable {

        @ColumnInfo(name = "userId")
        @SerializedName("userId")
        @Expose
        private int userId;

        @PrimaryKey
        @ColumnInfo(name = "id")
        @SerializedName("id")
        @Expose
        private Integer id;

        @ColumnInfo(name = "title")
        @SerializedName("title")
        @Expose
        private String title;

        @ColumnInfo(name = "body")
        @SerializedName("body")
        @Expose
        private String body;




//    public Employee(int userId, String title, String body) {
//        this.userId = userId;
//        this.title = title;
//        this.body = body;
//    }



    public Employee(int userId, Integer id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }


//    public Employee(Integer userId, Integer id, String title, String body) {
//        this.userId = userId;
//        this.id = id;
//        this.title = title;
//        this.body = body;
//    }

    public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

    }

