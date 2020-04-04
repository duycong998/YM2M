package com.example.todolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import com.example.todolist.Retrofit.APIUtils;
import com.example.todolist.Retrofit.Data;
import com.example.todolist.Retrofit.Employee;
import com.example.todolist.Retrofit.EmployeeAdapter;
import com.example.todolist.Room.EmployeeDao;
import com.example.todolist.Room.EmployeeDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitActivity extends AppCompatActivity {
    RecyclerView rsview;
    ArrayList<Employee> arrayPicture = new ArrayList<>();
    EmployeeAdapter adapter;
    EmployeeDatabase pictureDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        initView();
        adapter = new EmployeeAdapter(getApplicationContext(), arrayPicture);
        rsview.setAdapter(adapter);
        testData();

        ItemTouchHelper delete = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT |ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int positon = viewHolder.getAdapterPosition();


                EmployeeDao pictureDao = pictureDatabase.employeeDao();
                pictureDao.deleteCV(arrayPicture.remove(positon));

                Toast.makeText(getApplicationContext(), "xóa thành công", Toast.LENGTH_SHORT).show();

                adapter.notifyDataSetChanged();
            }
        });
        delete.attachToRecyclerView(rsview);
        intentView();


       // getPicture();

    }


    private void getPicture() {
        Data data = APIUtils.getData();
        Call<List<Employee>> callBack = data.getAll();
        callBack.enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                arrayPicture = new ArrayList<>(response.body());
                adapter = new EmployeeAdapter(getApplicationContext(), arrayPicture);
                rsview.setAdapter(adapter);


                EmployeeDao pictureDao = pictureDatabase.employeeDao();
                pictureDao.insert(arrayPicture);
                testData();
                intentView();

                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
                Log.i("aaa", "Load fail: " + t.getMessage());
                Toast.makeText(getApplicationContext(), "Load fail", Toast.LENGTH_SHORT).show();
            }
        });
    }



    private void testData() {
        pictureDatabase = EmployeeDatabase.getDatabase(this);
        EmployeeDao pictureDao = pictureDatabase.employeeDao();

        arrayPicture.clear();
        arrayPicture.addAll(pictureDao.getAlphabetizedWords());


    }

    private void initView() {
        rsview = findViewById(R.id.rsview);
        rsview.setLayoutManager(new LinearLayoutManager(this));
        rsview.setHasFixedSize(true);
    }


    private void intentView() {
        adapter.setOnClick(new Data() {
            @Override
            public Call<List<Employee>> getAll() {
                return null;
            }


            @Override
            public void onClick(Employee picture) {
                Intent intent = new Intent(RetrofitActivity.this, ChiTietRetrofitActivity.class);
                intent.putExtra("congdeptrai", picture);
                startActivity(intent);
            }

        });

    }
}



