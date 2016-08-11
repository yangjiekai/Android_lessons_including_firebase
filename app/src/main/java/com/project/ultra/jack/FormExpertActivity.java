package com.project.ultra.jack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.project.ultra.myapplication.R;

public class FormExpertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_expert);

        String str[] = {"AAA","BBBB","AABBB","BBBCC"};
        AutoCompleteTextView act = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(FormExpertActivity.this,
                                                                android.R.layout.simple_spinner_item,
                                                                str);
        act.setAdapter(adapter);
        act.setThreshold(1); //輸入多少字開始查
    }
}
