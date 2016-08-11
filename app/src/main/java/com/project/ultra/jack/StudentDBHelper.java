package com.project.ultra.jack;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by ultra-jack on 2016/8/8.
 */
public class StudentDBHelper extends SQLiteOpenHelper {

    final static String DB_Name="student234.sqlite";
    final static int VERSION=1;
    final static String CREATE_TABLE_SQL = "CREATE  TABLE main.student (_id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , name VARCHAR,addr VARCHAR, tel VARCHAR)";
    public StudentDBHelper(Context context)
    {
        super(context,DB_Name, null,VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("DB","This is onCreate");
        db.execSQL(CREATE_TABLE_SQL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
