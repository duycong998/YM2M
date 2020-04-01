package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
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

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RetrofitActivity extends AppCompatActivity {
    RecyclerView rsview;

//    ListView lsv;
    ArrayList<Employee> arrayEmployee = new ArrayList<>();
    EmployeeAdapter adapter;
    EmployeeDatabase employeeDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        initView();
       testData();



      getEmployee();
    // createEmployee();
    // updateEmployee();
      // deleteEmployee();
    }



    private void deleteEmployee() {
        Data data = APIUtils.getData();
           Call<Employee> call = data.deleteEmployee(15);
        call.enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {
                Employee employeeDelete = response.body();
                arrayEmployee.add(employeeDelete);
                adapter = new EmployeeAdapter(arrayEmployee,getApplicationContext());
                rsview.setAdapter(adapter);

                EmployeeDao employeeDao = employeeDatabase.employeeDao();
                employeeDao.deleteCV(employeeDelete);

                adapter.setOnClick(new Data() {
                    @Override
                    public Call<List<Employee>> getAll() {
                        return null;
                    }

                    @Override
                    public Call<Employee> creatEmployee(Employee employee) {
                        return null;
                    }

                    @Override
                    public Call<Employee> saveEmployee(int userId, String title, String body) {
                        return null;
                    }

                    @Override
                    public Call<Employee> updateEmployee(int id, Employee employee) {
                        return null;
                    }

                    @Override
                    public Call<Employee> deleteEmployee(int id) {
                        return null;
                    }

                    @Override
                    public void onClick(Employee employee) {
                        Intent intent  = new Intent(RetrofitActivity.this,ChiTietRetrofitActivity.class);
                        intent.putExtra("congdeptrai",employee);
                        startActivity(intent);
                    }
                });
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {

            }
        });

    }

    private void updateEmployee() {
       final Employee employees  = new Employee(1,1,"no title","no text");
        Data data = APIUtils.getData();
        Call<Employee> callBack  = data.updateEmployee(1, employees);
        callBack.enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {

                Employee employee = response.body();
                arrayEmployee.add(employee);
                adapter = new EmployeeAdapter(arrayEmployee,getApplicationContext());
                rsview.setAdapter(adapter);

                EmployeeDao employeeDao = employeeDatabase.employeeDao();
                employeeDao.updateCV(employee);
                testData();

                adapter.setOnClick(new Data() {
                    @Override
                    public Call<List<Employee>> getAll() {
                        return null;
                    }

                    @Override
                    public Call<Employee> creatEmployee(Employee employee) {
                        return null;
                    }

                    @Override
                    public Call<Employee> saveEmployee(int userId, String title, String body) {
                        return null;
                    }

                    @Override
                    public Call<Employee> updateEmployee(int id, Employee employee) {
                        return null;
                    }

                    @Override
                    public Call<Employee> deleteEmployee(int id) {
                        return null;
                    }

                    @Override
                    public void onClick(Employee employee) {
                        Intent intent  = new Intent(RetrofitActivity.this,ChiTietRetrofitActivity.class);
                        intent.putExtra("congdeptrai",employee);
                        startActivity(intent);
                    }
                });

               adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {
                Log.i("aaa", "Load fail: " + t.getMessage());
                Toast.makeText(RetrofitActivity.this, "Load fail", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void createEmployee() {
        final Employee employee = new Employee(24, 101,"New title", "new body");
        Data data = APIUtils.getData();
        Call<Employee> calBack = data.saveEmployee(25,"new titele","new text ");
        calBack.enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {
                Employee employeeAdd =  response.body();
                arrayEmployee.add(employeeAdd);
                adapter = new EmployeeAdapter(arrayEmployee,getApplicationContext());
                rsview.setAdapter(adapter);

                EmployeeDao employeeDao = employeeDatabase.employeeDao();
                employeeDao.add(employeeAdd);
                testData();

                adapter.setOnClick(new Data() {
                    @Override
                    public Call<List<Employee>> getAll() {
                        return null;
                    }

                    @Override
                    public Call<Employee> creatEmployee(Employee employee) {
                        return null;
                    }

                    @Override
                    public Call<Employee> saveEmployee(int userId, String title, String body) {
                        return null;
                    }

                    @Override
                    public Call<Employee> updateEmployee(int id, Employee employee) {
                        return null;
                    }

                    @Override
                    public Call<Employee> deleteEmployee(int id) {
                        return null;
                    }

                    @Override
                    public void onClick(Employee employee) {
                        Intent intent  = new Intent(RetrofitActivity.this,ChiTietRetrofitActivity.class);
                        intent.putExtra("congdeptrai",employee);
                        startActivity(intent);
                    }
                });
               adapter.notifyDataSetChanged();
            }


            @Override
            public void onFailure(Call<Employee> call, Throwable t) {
                Log.i("aaa", "Load fail: " + t.getMessage());
                Toast.makeText(RetrofitActivity.this, "Load fail", Toast.LENGTH_SHORT).show();
            }

        });

    }

    private void getEmployee(){
        Data data = APIUtils.getData();
        Call<List<Employee>> callback = data.getAll();
        callback.enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                arrayEmployee = new ArrayList<>(response.body());
                adapter = new EmployeeAdapter(arrayEmployee,getApplicationContext());
                rsview.setAdapter(adapter);


                EmployeeDao employeeDao = employeeDatabase.employeeDao();
                employeeDao.insert(arrayEmployee);
                testData();

                adapter.setOnClick(new Data() {
                    @Override
                    public Call<List<Employee>> getAll() {
                        return null;
                    }

                    @Override
                    public Call<Employee> creatEmployee(Employee employee) {
                        return null;
                    }

                    @Override
                    public Call<Employee> saveEmployee(int userId, String title, String body) {
                        return null;
                    }

                    @Override
                    public Call<Employee> updateEmployee(int id, Employee employee) {
                        return null;
                    }

                    @Override
                    public Call<Employee> deleteEmployee(int id) {
                        return null;
                    }

                    @Override
                    public void onClick(Employee employee) {
                        Intent intent  = new Intent(RetrofitActivity.this,ChiTietRetrofitActivity.class);
                        intent.putExtra("congdeptrai",employee);
                        startActivity(intent);
                    }
                });
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
                Log.i("aaa", "Load fail: " + t.getMessage());
                Toast.makeText(RetrofitActivity.this, "Load fail", Toast.LENGTH_SHORT).show();
            }

        });





    }


    private void testData(){
        employeeDatabase = EmployeeDatabase.getDatabase(this);
        EmployeeDao employeeDao =employeeDatabase.employeeDao();

        arrayEmployee.clear();
        arrayEmployee.addAll(employeeDao.getAlphabetizedWords());

    }

    private void initView() {
        rsview = findViewById(R.id.rcView);
        rsview.setLayoutManager(new LinearLayoutManager(this));
        rsview.setHasFixedSize(true);

    }
}



