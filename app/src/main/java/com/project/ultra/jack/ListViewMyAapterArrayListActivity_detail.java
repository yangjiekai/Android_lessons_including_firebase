package com.project.ultra.jack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.ultra.myapplication.R;

public class ListViewMyAapterArrayListActivity_detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_my_aapter_array_list_activity_detail);
        Intent it=getIntent();
        Bundle b=it.getExtras();
        TextView tv3= (TextView) findViewById(R.id.textView19);
        TextView tv4= (TextView) findViewById(R.id.textView20);
        tv3.setText(b.getString("name"));
        tv4.setText(b.getString("phone"));

        ImageView iv=(ImageView) findViewById(R.id.imageView2);
        iv.setImageResource(b.getInt("photo"));

    }
}
