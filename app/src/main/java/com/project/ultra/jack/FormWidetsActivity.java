package com.project.ultra.jack;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.project.ultra.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FormWidetsActivity extends AppCompatActivity {
    ToggleButton tb;
    Spinner spinner;
    Spinner spinner2;
    ArrayList<Map<String,String>> mylist = new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_widets);

        TextView tv = (TextView) findViewById(R.id.textView9) ;
        tv.setTextColor(Color.RED);

        //        檢查按鈕是否按下
        tb = (ToggleButton) findViewById(R.id.toggleButton);
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(FormWidetsActivity.this,"選擇:"+isChecked,Toast.LENGTH_SHORT).show();
            }
        });
        //抓下拉選單 spinner
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //抓resource 裡的 string.xml 轉成表單
                String[] c = getResources().getStringArray(R.array.cities);
                Toast.makeText(FormWidetsActivity.this,c[position],Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //動態選單
        String fruits[] = {"蘋果", "橘子", "檸檬"};
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(FormWidetsActivity.this,
                android.R.layout.simple_spinner_dropdown_item,
                fruits);
        spinner2.setAdapter(adapter);

        //有key跟name的sppiner選單
//        ArrayList<Map<String,String>> mylist = new ArrayList(); //有新增時用外層宣告

        HashMap<String, String > m1 = new HashMap();
        m1.put("city","台北");
        m1.put("code","02");
        mylist.add(m1);

        HashMap<String, String > m2 = new HashMap();
        m2.put("city", "台中");
        m2.put("code", "04");
//        Log.d("MAP",m2.get("city"));
        mylist.add(m2);

        Spinner spinner3= (Spinner) findViewById(R.id.spinner3);
        SimpleAdapter adapter1 = new SimpleAdapter(FormWidetsActivity.this,
                                                    mylist,
                                                    android.R.layout.simple_list_item_2,
                                                    new String[] {"city", "code"},
                                                    new int[] {android.R.id.text1, android.R.id.text2});
        spinner3.setAdapter(adapter1);

//        checkbox檢查
        CheckBox chk1=(CheckBox) findViewById(R.id.checkBox);
        chk1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(FormWidetsActivity.this,"勾選狀態："+isChecked, Toast.LENGTH_SHORT).show();
            }
        });

    }
    //送出前檢查 togglebutton按鈕
    public void click17(View v){
        if(tb.isChecked()){
            Toast.makeText(FormWidetsActivity.this,"選擇是",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(FormWidetsActivity.this,"選擇否",Toast.LENGTH_SHORT).show();
        }
    }
    //按鈕選擇sppiner
    public void click18(View v){
        String str=spinner.getSelectedItem().toString();
        Toast.makeText(FormWidetsActivity.this, "你選了"+str,Toast.LENGTH_SHORT).show();
    }
    //增加一筆
    public void  click19(View v){
        EditText ed1 = (EditText) findViewById(R.id.editText5);
        EditText ed2 = (EditText) findViewById(R.id.editText6);
        HashMap<String,String> m = new HashMap();
        m.put("city",ed1.getText().toString());
        m.put("code",ed2.getText().toString());
        mylist.add(m);
        Toast.makeText(FormWidetsActivity.this,"新增成功",Toast.LENGTH_SHORT).show();
    }

}
