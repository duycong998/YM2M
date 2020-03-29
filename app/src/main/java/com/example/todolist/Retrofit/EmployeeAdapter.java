package com.example.todolist.Retrofit;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {
    ArrayList<Employee> arrayEmployee;
    Context context;

    Data onClick;

    public void setOnClick(Data onClick) {
        this.onClick = onClick;
    }
    //    OnItemClick onClick;
//
//    public void setOnClick(OnItemClick onClick) {
//        this.onClick = onClick;
//    }

    public EmployeeAdapter(ArrayList<Employee> arrayEmployee, Context context) {
        this.arrayEmployee = arrayEmployee;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.custom_row,parent,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.txtID.setText("ID : " + arrayEmployee.get(position).getId().toString());
        holder.txtUserID.setText("User ID : " + arrayEmployee.get(position).getUserId().toString());
        holder.txtTitle.setText("Title : " + arrayEmployee.get(position).getTitle());
        holder.txtBody.setText("Body : " + arrayEmployee.get(position).getBody());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.onClick(arrayEmployee.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayEmployee.size();
    }

//    public void RemoveItem(int i){
//        arrayShop.remove(i);
//        notifyDataSetChanged();
//    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtID,txtUserID,txtTitle,txtBody;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtID = itemView.findViewById(R.id.txtID);
            txtUserID = itemView.findViewById(R.id.txtUserID);
            txtTitle= itemView.findViewById(R.id.txtTitle);
            txtBody = itemView.findViewById(R.id.txtBody);


        }
    }
}
