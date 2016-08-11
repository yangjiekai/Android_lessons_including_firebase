package com.project.ultra.jack;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.project.ultra.myapplication.R;

public class ThreadProgressbar extends AppCompatActivity {
    ProgressBar pb;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_progressbar);

        handler = new Handler();
        pb = (ProgressBar) findViewById(R.id.progressBar);
    }

    public void click20(View v){
        pb.setVisibility(View.VISIBLE);
        new Thread(){
            @Override
            public void run(){
                Log.d("PB","執行緒啟動");
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                       pb.setVisibility(View.INVISIBLE);
                    }
                });
                Log.d("PB","執行緒結束");
            }
        }.start();
        Log.d("PB","function結束");
    }

    //加百分比進度條
    public void click21(View v){
        ProgressBar pb2;
        pb2 = (ProgressBar)findViewById(R.id.progressBar2);
        pb2.setProgress(pb2.getProgress() + 10);
    }
}
