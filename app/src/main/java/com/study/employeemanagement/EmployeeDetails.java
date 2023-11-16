package com.study.employeemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class EmployeeDetails extends AppCompatActivity {

    private ImageView imageView;
    private TextView name,age,phone,email;

    private Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);

        imageView=findViewById(R.id.avatar);
        name=findViewById(R.id.tvName);
        age=findViewById(R.id.tvAge);
        phone=findViewById(R.id.tvPhone);
        email=findViewById(R.id.tvEmail);

        Intent intent=this.getIntent();
        String imageLink = intent.getStringExtra("Image");
        Picasso.get().load(imageLink).into(imageView);
        name.setText(name.getText()+" "+intent.getStringExtra("Name"));
        age.setText(name.getText()+" "+(intent.getIntExtra("Age",0)+""));
        phone.setText(phone.getText()+" "+intent.getStringExtra("Phone"));
        email.setText(email.getText()+" "+intent.getStringExtra("Email"));

        backBtn=findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(EmployeeDetails.this, EmployeeListActivity.class);
                startActivity(intent);
            }
        });
    }
}