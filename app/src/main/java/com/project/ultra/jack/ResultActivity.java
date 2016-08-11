package com.project.ultra.jack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.project.ultra.myapplication.R;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
    }
    public void click9(View v){
        Intent it = new Intent(ResultActivity.this, ResultSecActivity.class);
        startActivityForResult(it, 12);
//        Intent it = Intent (Result)
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK)
        {
            super.onActivityResult(requestCode, resultCode, data);
            TextView tv = (TextView) findViewById(R.id.textView5);
            String str = data.getStringExtra("mydata");
            tv.setText(str);
        }

    }
}
