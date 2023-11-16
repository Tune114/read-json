package com.study.employeemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.study.employeemanagement.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class EmployeeListActivity extends AppCompatActivity {

    EmployeeAdapter adapter;
    List<Employee> employees=new ArrayList<>();
    Employee employee;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);
        new ReadEmployeeJsons().execute("https://dummyjson.com/users");

//        String[] names={"Ten 1","Ten 2","Ten 3"};
//        int[] ages={19,20,26};
//        String[] emails={"email 1","email 2","email 3"};
//        String[] phones={"so 1","so 2","so 3"};
//        int[] images={R.drawable.employee,R.drawable.employee,R.drawable.employee};
//        for(int i=0;i<3;i++){
//            employee=new Employee(names[i],ages[i],emails[i],phones[i],images[i]);
//            employees.add(employee);
//        }

    }

    private class ReadEmployeeJsons extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            URL url= null;
            StringBuilder content=new StringBuilder();
            try {
                url = new URL(strings[0]);
                InputStreamReader inputStreamReader=new InputStreamReader(url.openConnection().getInputStream());
                BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                String line="";
                while((line=bufferedReader.readLine())!=null){
                    content.append(line);
                }
                bufferedReader.close();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return content.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject allUsers=new JSONObject(s);
                JSONArray users=allUsers.getJSONArray("users");
                for(int i=0;i<users.length();i++){
                    JSONObject user=users.getJSONObject(i);
                    String name=user.getString("firstName");
                    int age=user.getInt("age");
                    String email=user.getString("email");
                    String phone=user.getString("phone");
                    String imageLink=user.getString("image");
                    employee=new Employee(name,age,email,phone,imageLink);
                    employees.add(employee);
                }
                adapter=new EmployeeAdapter(EmployeeListActivity.this,employees);
                listView=findViewById(R.id.listViewEmployee);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent=new Intent(EmployeeListActivity.this,EmployeeDetails.class);
                        intent.putExtra("Name",employees.get(position).getName());
                        intent.putExtra("Age",employees.get(position).getAge());
                        intent.putExtra("Email",employees.get(position).getEmail());
                        intent.putExtra("Phone",employees.get(position).getPhone());
                        intent.putExtra("Image",employees.get(position).getImageLink());
                        startActivity(intent);
                    }
                });
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

}