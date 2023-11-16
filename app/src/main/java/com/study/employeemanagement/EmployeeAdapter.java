package com.study.employeemanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.List;

public class EmployeeAdapter extends ArrayAdapter<Employee> {

    private ImageView avatar;
    private TextView name,age,phone,email;

    public EmployeeAdapter(@NonNull Context context,List<Employee> objects) {
        super(context, R.layout.list_item, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {

        Employee employee=getItem(position);
        LayoutInflater inflater=LayoutInflater.from(getContext());
        view= inflater.inflate(R.layout.list_item,parent,false);

        avatar=view.findViewById(R.id.avatar);
        name=view.findViewById(R.id.textViewName);
        age=view.findViewById(R.id.textViewAge);
        phone=view.findViewById(R.id.textViewPhone);
        email=view.findViewById(R.id.textViewEmail);

        name.setText(name.getText()+" "+employee.getName());
        age.setText(age.getText()+" "+(employee.getAge()+""));
        phone.setText(phone.getText()+" "+employee.getPhone());
        email.setText(email.getText()+" "+employee.getEmail());
//        avatar.setImageResource(employee.getImage());

        Picasso.get().load(employee.getImageLink()).into(avatar);
        return view;
    }
}
