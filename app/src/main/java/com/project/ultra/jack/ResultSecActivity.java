package com.project.ultra.jack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.project.ultra.myapplication.R;

public class ResultSecActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_sec);
    }
    public void click10(View v){
        EditText ed = (EditText)findViewById(R.id.editText4);
        String str = ed.getText().toString();
        Intent it = new Intent();
        it.putExtra("mydata",str);
        setResult(RESULT_OK, it);
        finish();


    }

}
