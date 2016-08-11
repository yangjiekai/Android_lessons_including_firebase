package com.project.ultra.jack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.project.ultra.myapplication.R;

import java.util.List;

public class detail_db_dao_activity extends AppCompatActivity {
    TextView tv;
    EditText ed4, ed5;
    Student s;
    int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_db_dao_activity);
        Intent it=getIntent();
        pos = it.getIntExtra("pos", 0);

        tv = (TextView) findViewById(R.id.textView22);
        ed4 = (EditText) findViewById(R.id.editText10);
        ed5 = (EditText) findViewById(R.id.editText11);
        StudentDAO dao=new StudentDAODBImpl(detail_db_dao_activity.this);
        List<Student>mylist=dao.getAllStudent();
        s = mylist.get(pos);
        tv.setText(s.name);
        ed4.setText(s.addr);
        ed5.setText(s.tel);

    }
    public void click_update(View v)
    {
        StudentDAO dao=new StudentDAODBImpl(detail_db_dao_activity.this);
        Student s=new Student (tv.getText().toString(),ed4.getText().toString(),ed5.getText().toString());
        dao.updateStudent(s);
    }
    public void click_del(View v)
    {
        StudentDAO dao=new StudentDAODBImpl(detail_db_dao_activity.this);
        List<Student> mylist=dao.getAllStudent();
        s=mylist.get(pos);
        dao.delStudent(s);
        finish();
    }
}
