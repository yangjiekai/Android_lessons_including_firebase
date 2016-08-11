package com.project.ultra.jack;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.project.ultra.myapplication.R;

public class dao_db_add_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dao_db_add_activity);
    }

    public void click_add_db(View v)
    {
        EditText ed= (EditText) findViewById(R.id.editText7);
        EditText ed2= (EditText) findViewById(R.id.editText8);
        EditText ed3= (EditText) findViewById(R.id.editText9);

        String n=ed.getText().toString();
        String a=ed2.getText().toString();
        String p=ed3.getText().toString();

        StudentDAO dao=new StudentDAODBImpl(dao_db_add_activity.this);
        dao.addStudent(new Student(n,a,p));

    }
}
