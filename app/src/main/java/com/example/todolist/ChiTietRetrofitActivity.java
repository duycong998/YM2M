package com.example.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.todolist.Retrofit.Employee;

public class ChiTietRetrofitActivity extends AppCompatActivity {
 //  public static final String KEY = "employee_object";
    TextView txtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_retrofit);
        txtContent = findViewById(R.id.txtTT);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Employee employee = (Employee) bundle.getSerializable("congdeptrai");

        String content = "";
        content += "ID :" + employee.getId() + "\n";
        content += "User ID :" + employee.getUserId() + "\n";
        content += "Title :" + employee.getTitle() + "\n";
        content += "Text :" + employee.getTitle() + "\n";
        txtContent.append(content);


    }
}
