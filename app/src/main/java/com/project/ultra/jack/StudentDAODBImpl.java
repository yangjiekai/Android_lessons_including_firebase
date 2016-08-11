package com.project.ultra.jack;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ultra-jack on 2016/8/8.
 */
public class StudentDAODBImpl implements StudentDAO {

    SQLiteDatabase db;

    public StudentDAODBImpl (Context context){
     StudentDBHelper helper=new StudentDBHelper(context);
        db = helper.getWritableDatabase();


    }
    @Override
    public void addStudent(Student s) {
        ContentValues cv=new ContentValues();
        cv.put("name",s.name);
        cv.put("addr",s.addr);
        cv.put("tel",s.tel);
        long id=db.insert("student",null,cv);

    }

    @Override
    public void delStudent(Student s) {
        db.execSQL("Delete from student where name='" + s.name + "'");

    }

    @Override
    public void updateStudent(Student s) {

        db.execSQL("Update student set addr = '" + s.addr + "' ,tel='" + s.tel + "' Where name='" + s.name + "'");

    }

    @Override
    public List getAllStudent() {
        ArrayList<Student>mylist=new ArrayList<>();

        Cursor c=db.rawQuery("Select * from student",null);

        if(c.moveToFirst())
        {
            do{
                Student t=new Student (c.getString(1),c.getString(2),c.getString(3));
                mylist.add(t);
            }while(c.moveToNext());
        }
        return mylist;
    }
}
