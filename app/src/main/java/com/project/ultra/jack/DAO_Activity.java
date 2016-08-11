package com.project.ultra.jack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.project.ultra.myapplication.R;

import java.util.ArrayList;

public class DAO_Activity extends AppCompatActivity {
    ArrayList<String> disp=new ArrayList<>();
    ListView lv;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dao_);

        StudentDAOImpl dao=new StudentDAOImpl(DAO_Activity.this);
//        dao.addStudent(new Student(12112,"fsdf","fdfdfff"));
//        dao.addStudent(new Student(213123,"343","sdfsdf"));
//        dao.addStudent(new Student(232,"22","34444"));

        for(Student s:StudentDAOImpl.mylist)
        {
            disp.add(s.name);
        }
        adapter=new ArrayAdapter<String>(
                DAO_Activity.this,
                android.R.layout.simple_list_item_1,
                disp
        );
        lv= (ListView) findViewById(R.id.listView_dao);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it=new Intent(DAO_Activity.this,dao_detail_activity.class);
                it.putExtra("pos",position);
                startActivity(it);
            }
        });



    }

    @Override
    protected void onResume() {
        super.onResume();
        disp.clear();
//        ArrayList<String> disp=new ArrayList<>();
//        for(Student s :StudentDAOImpl.mylist)
//        {
//            disp.add(s.name);
//        }
//
//        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
//                DAO_Activity.this,android.R.layout.simple_list_item_1,disp
//        );
//        ListView lv=(ListView)findViewById(R.id.listView_dao);
//        lv.setAdapter(adapter);
        for(Student s:StudentDAOImpl.mylist)
        {
            disp.add(s.name);
        }
    adapter.notifyDataSetChanged();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.action_add)
        {
            Intent it = new Intent(DAO_Activity.this, dao_add_activity.class);
            startActivity(it);
        }
        return super.onOptionsItemSelected(item);

    }
}
