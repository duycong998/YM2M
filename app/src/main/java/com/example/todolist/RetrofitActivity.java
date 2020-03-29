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

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitActivity extends AppCompatActivity {
    RecyclerView rsview;
    String title,body;
    String userID;
    String iD;
//    ListView lsv;
    ArrayList<Employee> arrayEmployee;
    EmployeeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        initView();




        getEmployee();
    //  createEmployee();
     // updateEmployee();
      // deleteEmployee();
    }

    private void initView() {
        rsview = findViewById(R.id.rcView);
        rsview.setLayoutManager(new LinearLayoutManager(this));
       // rsview.setHasFixedSize(true);
       // employeesList = new ArrayList<>();
//        adapter = new EmployeeAdapter(employeesList,this);
//        rsview.setAdapter(adapter);

    }

//    private void deleteEmployee() {
//        Data data = APIUtils.getData();
//           Call<Employee> call = data.deleteEmployee(15);
//        call.enqueue(new Callback<Employee>() {
//            @Override
//            public void onResponse(Call<Employee> call, Response<Employee> response) {
//
//                String content = " ";
//                content += "Code : "  + response.code();
//
//                employeesList.add(content);
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onFailure(Call<Employee> call, Throwable t) {
//
//            }
//        });
//
//    }

//    private void updateEmployee() {
//        final Employee employee  = new Employee(12,"no title","no text");
//        Data data = APIUtils.getData();
//        Call<Employee> callBack  = data.updateEmployee(2, employee);
//        callBack.enqueue(new Callback<Employee>() {
//            @Override
//            public void onResponse(Call<Employee> call, Response<Employee> response) {
//                Employee employeeUpdate =  response.body();
//                String content = "";
//                content += "Code : " + response.code() + "\n";
//                content += "ID :" + employeeUpdate.getId() + "\n";
//                content += "User ID :" + employeeUpdate.getUserId() + "\n";
//                content += "Title :" + employeeUpdate.getTitle() + "\n";
//                content += "Text :" + employeeUpdate.getBody() + "\n";
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onFailure(Call<Employee> call, Throwable t) {
//                Log.i("aaa", "Load fail: " + t.getMessage());
//                Toast.makeText(RetrofitActivity.this, "Load fail", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

//
//    private void createEmployee() {
//        Employee employee = new Employee(24, "New title", "new body");
//        Data data = APIUtils.getData();
//        Call<Employee> calBack = data.saveEmployee(25,"new titele","new text ");
//        calBack.enqueue(new Callback<Employee>() {
//            @Override
//            public void onResponse(Call<Employee> call, Response<Employee> response) {
//                Employee employeeCreate =  response.body();
//                String content = " ";
//                content += "Code : " + response.code() + "\n";
//                content += "ID :" + employeeCreate.getId() + "\n";
//                content += "User ID :" + employeeCreate.getUserId() + "\n";
//                content += "Title :" + employeeCreate.getTitle() + "\n";
//                content += "Text :" + employeeCreate.getBody() + "\n\n";
//                employeesList.add(content);
//                adapter.notifyDataSetChanged();
//            }
//
//
//            @Override
//            public void onFailure(Call<Employee> call, Throwable t) {
//                Log.i("aaa", "Load fail: " + t.getMessage());
//                Toast.makeText(RetrofitActivity.this, "Load fail", Toast.LENGTH_SHORT).show();
//            }
//
//        });
//
//    }

    private void getEmployee(){
        Data data = APIUtils.getData();
        Call<List<Employee>> callback = data.getAll();
        callback.enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {


                arrayEmployee = new ArrayList<>(response.body());
                   // Toast.makeText(RetrofitActivity.this, ""+ iD + userID + title + body, Toast.LENGTH_SHORT).show()
                adapter = new EmployeeAdapter(arrayEmployee,getApplicationContext());
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
//                adapter.setOnClick(new OnItemClick() {
//                    @Override
//                    public void onClick(Employee employee) {
//                        Intent intent  = new Intent(RetrofitActivity.this,ChiTietRetrofitActivity.class);
//                        intent.putExtra("congdeptrai",employee);
//                        startActivity(intent);
//                      //  Toast.makeText(RetrofitActivity.this, "" + employee.getTitle()  , Toast.LENGTH_SHORT).show();
//                    }
//                });
                rsview.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
                Log.i("aaa", "Load fail: " + t.getMessage());
                Toast.makeText(RetrofitActivity.this, "Load fail", Toast.LENGTH_SHORT).show();
            }

        });




//        lsv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent  = new Intent(RetrofitActivity.this,ChiTietRetrofitActivity.class);
//                intent.putExtra("congdeptrai", employeesList.get(position));
//                startActivity(intent);
//            }
//        });
    }
    //    private void chiTietRitrofit(){
//        Intent intent  = new Intent(RetrofitActivity.this,ChiTietRetrofitActivity.class);
    //      intent.putExtra(ChiTietRetrofitActivity.KEY, employeesList.get(position));
//        startActivity(intent);
//    }
}


