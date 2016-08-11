package com.project.ultra.jack;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.ultra.myapplication.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ultra-jack on 2016/8/3.
 */
public class AsyncTask extends AppCompatActivity {
ImageView img;
    TextView tv;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        img =(ImageView)findViewById(R.id.imageView_async);
    tv= (TextView) findViewById(R.id.textView_async);
        MyTask task=new MyTask();
        task.execute("http://www.pcschool.com.tw/2015/images/logo.png");
    }

    class MyTask extends android.os.AsyncTask<String,Integer,Bitmap>
    {

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            tv.setText(String.valueOf(values[0]));

        }

        @Override
        protected Bitmap doInBackground(String... params) {
            String strurl= params[0];

            ByteArrayOutputStream bos =new ByteArrayOutputStream();
            byte b[]=new byte[64];
            Bitmap bitmap=null;
            try{
                URL url=new URL(strurl);
                HttpURLConnection conn= (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.connect();
                Log.d("IMG", "conected");
                InputStream is = conn.getInputStream();
                double totalLength = conn.getContentLength();
                double sum = 0;
                int readSize = 0;
                while ((readSize = is.read(b)) > 0) {
                    bos.write(b, 0, readSize);
                    sum += readSize;
                    publishProgress((int)sum);
                }
                byte[] result = bos.toByteArray();
                Log.d("IMG", "to byte array finished array length:" + result.length);
                bitmap = BitmapFactory.decodeByteArray(result, 0, result.length);


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            img.setImageBitmap(bitmap);
        }
    }
}

