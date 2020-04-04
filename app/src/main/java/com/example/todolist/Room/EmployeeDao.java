package com.example.todolist.Room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.todolist.Retrofit.Employee;

import java.util.ArrayList;
import java.util.List;

import static androidx.room.OnConflictStrategy.IGNORE;
import static androidx.room.OnConflictStrategy.REPLACE;
@Dao
public interface EmployeeDao {

    @Insert(onConflict = REPLACE)
    void insert(ArrayList<Employee> employee);

    @Insert(onConflict = IGNORE)
    void add(Employee... employees);

    @Update
    void updateCV(Employee... employee);

    @Delete
    void deleteCV(Employee... employee);

    @Query("SELECT * FROM picture")
    List<Employee> getAlphabetizedWords();
}
