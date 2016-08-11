package com.project.ultra.jack;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.project.ultra.myapplication.R;

public class SecActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        Intent it = getIntent();
        String str = it.getStringExtra("param1");
        TextView tv5 = (TextView) findViewById(R.id.textView5);
        tv5.setText(str);

    }
    //上一頁
    public void click4(View v){
        Intent it = new Intent(SecActivity.this, MainActivity.class) ;
        startActivity(it);
    }
    public void click7(View v){
        Intent it = new Intent(SecActivity.this, webviewActivity.class);
        startActivity(it);
    }
//    可以指定連到另一個 APP的某頁面
    public void click11(View v){
        Intent it = new Intent();
        it.setAction("app2.SecActivity");//在app2的manifest要設定
        startActivity(it);
    }
//    連到網頁
    public void click12(View v){
        Uri uri = Uri.parse("http://tw.yahoo.com");
        Intent it = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(it);
    }
//    打電話
    public void click13(View v){
        Uri uri = Uri.parse("tel:02333333");
        Intent it = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(it);
    }
//    連地圖(經緯)
    public void click14(View v){
        Uri uri = Uri.parse("geo:25.0,121.056?z=15");
        Intent it = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(it);
    }
//    連地圖(地址)
    public void click15(View v){
        Uri uri = Uri.parse("geo:0,0?q=台北市三重區重新路二段60號");
        Intent it = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(it);
    }
    //分享文字
    public void click16(View v){
        Intent it = new Intent();
        it.setAction(Intent.ACTION_SEND);
        it.setType("text/plain");
        it.putExtra(Intent.EXTRA_TEXT, "要分享文字"); //分享文字
        startActivity(it);
    }
}

