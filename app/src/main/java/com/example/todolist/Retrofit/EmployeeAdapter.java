package com.example.todolist.Retrofit;


import android.content.Context;
import android.graphics.Picture;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.todolist.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {
    private Context context;
    private List<Employee> employeeList;

    Data onClick;


    public void setOnClick(Data onClick) {
        this.onClick = onClick;
    }

    public EmployeeAdapter(Context context, List<Employee> employeeList) {
        this.context = context;
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.custom_row,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Employee employee = employeeList.get(position);
        holder.txtAlbum.setText("AlbumID : " + employee.getAlbumId());
        holder.txtId.setText("ID : " + employee.getId());
        holder.txtTitle.setText("Title : " + employee.getTitle());


        Picasso.get().load(employee.getThumbnailUrl()).into(holder.imgThum);
        Picasso.get().load(employee.getUrl()).into(holder.imgUrl);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.onClick(employee);
            }
        });



    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgUrl,imgThum;
        TextView txtAlbum,txtId,txtTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtAlbum = itemView.findViewById(R.id.txtAlbum);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtId    = itemView.findViewById(R.id.txtId);
            imgThum  = itemView.findViewById(R.id.idThumbnail);
            imgUrl   = itemView.findViewById(R.id.idImgUrl);
        }
    }

}
