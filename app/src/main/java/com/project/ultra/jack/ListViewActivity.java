package com.project.ultra.jack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.project.ultra.myapplication.R;

public class ListViewActivity extends AppCompatActivity {
    String[] str={"aaa","BBB","CCC"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(ListViewActivity.this,
                android.R.layout.simple_list_item_1,
                str);
        ListView lv=(ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s=str[position];
                Toast.makeText(ListViewActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
