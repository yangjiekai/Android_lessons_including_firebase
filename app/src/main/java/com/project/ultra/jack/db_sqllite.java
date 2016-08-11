package com.project.ultra.jack;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.project.ultra.myapplication.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class db_sqllite extends AppCompatActivity {
    File DB_PATH;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_sqllite);
        CopyDatabase();
        SQLiteDatabase db=SQLiteDatabase.openOrCreateDatabase(DB_PATH.toString(),null);
        Cursor c=db.rawQuery("Select * from contacts",null);
        c.moveToFirst();
        do{

            String str=c.getString(1);
            Log.d("DB",str);
        }
        while(c.moveToNext());

    }

    private void CopyDatabase() {
        final int BUFFER_SIZE=400000;
        final String DB_NAME="test.sqlite";
        String PACKAGE_NAME=getPackageName();
         DB_PATH=getDatabasePath(DB_NAME);
      //  DB_PATH.mkdir();
        Log.d("DB","DB:"+DB_PATH.toString());
        if(!DB_PATH.exists())
        {
            File DIR=new File(getApplicationInfo().dataDir+"/databases");
            DIR.mkdir();
            Log.d("DB","DIR:"+DIR.toString());
            InputStream is= getResources().openRawResource(R.raw.test);
            try {
                FileOutputStream fos=new FileOutputStream(DB_PATH);
                byte[] buffer=new byte[BUFFER_SIZE];
                int count=0;
                while((count=is.read(buffer))>0)
                {
                    fos.write(buffer,0,count);

                }
                fos.close();
                is.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }
}
