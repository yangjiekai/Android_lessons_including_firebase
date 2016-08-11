package com.project.ultra.jack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.project.ultra.myapplication.R;

import java.util.ArrayList;

public class ListViewMyAapterArrayListActivity extends AppCompatActivity {
    ListView lv3;
    ArrayList<Student> mylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_my_adapter);

        mylist = new ArrayList<>();
        mylist.add(new Student(R.drawable.f1, "AA", "11111"));
        mylist.add(new Student(R.drawable.f2, "BB", "22222"));
        mylist.add(new Student(R.drawable.f3, "CC", "33333"));

        mylist.add(new Student(R.drawable.f1, "AAg", "11111"));
        mylist.add(new Student(R.drawable.f2, "BBg", "22222"));
        mylist.add(new Student(R.drawable.f3, "CCg", "33333"));


        mylist.add(new Student(R.drawable.f1, "GG", "77111"));
        mylist.add(new Student(R.drawable.f2, "HH", "88222"));
        mylist.add(new Student(R.drawable.f3, "II", "99333"));

        mylist.add(new Student(R.drawable.f1, "GG", "77111"));
        mylist.add(new Student(R.drawable.f2, "HH", "88222"));
        mylist.add(new Student(R.drawable.f3, "II", "99333"));


        lv3 = (ListView) findViewById(R.id.listView3);
        MyAdapter2 adapter = new MyAdapter2(ListViewMyAapterArrayListActivity.this, mylist);
        lv3.setAdapter(adapter);

        lv3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Bundle b=new Bundle();
                b.putString("name",mylist.get(position).name);
                b.putString("phone",mylist.get(position).phone);
                b.putInt("photo",mylist.get(position).photoid);

                Intent it=new Intent(ListViewMyAapterArrayListActivity.this,ListViewMyAapterArrayListActivity_detail.class);

              it.putExtras(b);
                startActivity(it);
            }
        });
    }
}
