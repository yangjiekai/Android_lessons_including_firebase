package com.project.ultra.jack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.project.ultra.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListViewTwolineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_twoline);

        ListView lv = (ListView) findViewById(R.id.listView2);
        ArrayList<Map<String, String>> mylist = new ArrayList();

        HashMap<String, String> m1 = new HashMap();
        m1.put("city", "台北");
        m1.put("code", "02");
        mylist.add(m1);

        HashMap<String, String> m2 = new HashMap();
        m2.put("city", "台中");
        m2.put("code", "04");
        mylist.add(m2);

        HashMap<String, String> m3 = new HashMap();
        m3.put("city", "台南");
        m3.put("code", "06");
        mylist.add(m3);

        HashMap<String, String> m4 = new HashMap();
        m4.put("city", "高雄");
        m4.put("code", "07");
        mylist.add(m4);


        SimpleAdapter adapter = new SimpleAdapter(ListViewTwolineActivity.this,
                mylist,
                android.R.layout.simple_list_item_2,
                new String[] {"city", "code"},
                new int[] {android.R.id.text1, android.R.id.text2});
        lv.setAdapter(adapter);
    }
}
