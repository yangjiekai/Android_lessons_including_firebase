package com.project.ultra.jack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.project.ultra.myapplication.R;

public class dao_add_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dao_add_activity);
    }

    public void click_add(View view) {

        EditText ed = (EditText) findViewById(R.id.editTextadd1);
        EditText ed2 = (EditText) findViewById(R.id.editTextadd2);
        EditText ed3 = (EditText) findViewById(R.id.editTextadd3);

        String n=ed.getText().toString();
        String a=ed2.getText().toString();
        String p=ed3.getText().toString();

        StudentDAOImpl dao=new StudentDAOImpl(dao_add_activity.this);
        dao.addStudent(new Student(n,a,p));
    }
}
