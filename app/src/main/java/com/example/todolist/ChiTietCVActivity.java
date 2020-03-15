package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ChiTietCVActivity extends AppCompatActivity {
    TextView txtHienthi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_c_v);
        txtHienthi = (TextView) findViewById(R.id.txtChiTietCV);

        Intent intent = getIntent();
        CongViec congViec = (CongViec) intent.getSerializableExtra("congdeptrai");

        txtHienthi.setText(congViec.getTenCV());
    }
}
