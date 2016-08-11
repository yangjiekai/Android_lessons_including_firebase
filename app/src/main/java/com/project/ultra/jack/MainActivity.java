package com.project.ultra.jack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.project.ultra.myapplication.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button) findViewById(R.id.button4);

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(MainActivity.this, "按下按鈕", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void myclick(View v){
        Toast.makeText(MainActivity.this, "按下按鈕", Toast.LENGTH_SHORT).show();
    }
    public void click1(View v){
        TextView tv = (TextView) findViewById(R.id.textView6);
        Toast.makeText(MainActivity.this, "按下按鈕", Toast.LENGTH_SHORT).show();
        tv.setText("ＯＫ");
    }
    public void click2(View v){
        EditText ed = (EditText) findViewById(R.id.editText3);
        TextView tv = (TextView) findViewById(R.id.textView6);
        tv.setText(ed.getText().toString());
    }
    //下一頁 船參數
    public void click3(View v){
        Intent it = new Intent(MainActivity.this, SecActivity.class) ;
        it.putExtra("param1","Hihi");
        startActivity(it);
    }

}