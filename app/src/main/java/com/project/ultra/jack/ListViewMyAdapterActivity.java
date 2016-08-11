package com.project.ultra.jack;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.project.ultra.myapplication.R;

import java.util.ArrayList;

public class ListViewMyAdapterActivity extends AppCompatActivity {
    ListView lv3;
    String[] str = {"AA","BB","AA2","BB3","AA4","BB6"};
    ArrayList<Student> mylist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_my_adapter);
//        mylist =new ArrayList<>();
//        mylist.add(new Student(R.drawable.f1,"AA","56565df"));
//        mylist.add(new Student(R.drawable.f2,"BB","hello"));
//        mylist.add(new Student(R.drawable.f3,"cc","32423"));

        lv3 = (ListView) findViewById(R.id.listView3);
        MyAdapter adapter = new MyAdapter(ListViewMyAdapterActivity.this, str);
        lv3.setAdapter(adapter);
    }
}
