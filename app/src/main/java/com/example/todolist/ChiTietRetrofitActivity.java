package com.example.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.todolist.Retrofit.Employee;
import com.squareup.picasso.Picasso;

public class ChiTietRetrofitActivity extends AppCompatActivity {
    ImageView imgOne,imgTwo;
    TextView txtAlbumCT,txtIdCT,txtTitleCT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_retrofit);
        initView();
        Intent intent = getIntent();
        Employee picture = (Employee) intent.getSerializableExtra("congdeptrai");


        txtAlbumCT.setText("AlbumID " + picture.getAlbumId());
        txtIdCT.setText("ID " +picture.getId());
        txtTitleCT.setText("Title "+ picture.getTitle());
        Picasso.get().load(picture.getUrl()).into(imgOne);
        Picasso.get().load(picture.getThumbnailUrl()).into(imgTwo);

    }

    private void initView() {
        imgOne     = findViewById(R.id.idImgUrlCT);
        imgTwo     = findViewById(R.id.idThumbnailCT);
        txtAlbumCT = findViewById(R.id.txtAlbumCT);
        txtIdCT    = findViewById(R.id.txtIdCT);
        txtTitleCT = findViewById(R.id.txtTitleCT);
    }
}
