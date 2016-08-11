package com.project.ultra.jack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.project.ultra.myapplication.R;

public class webviewActivity extends AppCompatActivity {
    //***** 開啟連外部網頁權限 manifests/AndroidManifest.xml  =>uses-permission
    //        <manifest xmlns:android="http://schemas.android.com/apk/res/android" package="com.example.albert.myapplication">
    //        <!--開啟連外部網頁權限-->
    //        <uses-permission android:name="android.permission.INTERNET"></uses-permission>

    //*****  用內部網頁檔案 => 新增 assets資料夾

    //**** 上方應用程式Bar不顯示 values/style.xml => NoActionBar
    //      <style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar">

    //**** 邊界設0 values/demen.xml => 0dp
    //        <dimen name="activity_horizontal_margin">0dp</dimen>
    //        <dimen name="activity_vertical_margin">0dp</dimen>

    WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        wv = (WebView) findViewById(R.id.webView);
        wv.setWebViewClient(new WebViewClient()); //用內嵌瀏覽 不會開另開瀏覽器
        WebSettings ws = wv.getSettings();  ws.setJavaScriptEnabled(true);      //啟用JS功能
        ws.setSupportZoom(true);            //頁面放大縮小
        ws.setBuiltInZoomControls(true);    //是否支持手指縮放
        ws.setDisplayZoomControls(true);    //是否顯示縮放按鈕(內置縮放+/-按鈕)
//        wv.loadUrl("http://tw.yahoo.com");
        wv.loadUrl("file:///android_asset/index.html");  // 注意asset字尾沒s
    }

    //讓返回鈕可回上一頁
    @Override
    public void onBackPressed(){
        if(wv.getUrl().contains("index.html")){
            super.onBackPressed();
        }else{
            wv.goBack();
        }
    }
}
