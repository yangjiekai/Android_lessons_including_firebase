package com.project.ultra.jack;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.project.ultra.myapplication.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class file_cache_for_internal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_cache_for_internal);

        File f= getCacheDir();
        Log.d("FILE",f.toString());
        String fName="mydata.txt";
        FileOutputStream fOut=null;

        try {
            fOut=openFileOutput(fName,MODE_PRIVATE);
            OutputStreamWriter osw=new OutputStreamWriter(fOut);
            osw.write("he us a opgf");
            osw.close();

            File readFile=new File(getFilesDir()+File.separator+fName);
            char[] buffer=new char[1];
            FileReader fr=null;
            StringBuilder sb=new StringBuilder();

            fr=new FileReader(readFile);
            while(fr.read(buffer)!=-1){
                sb.append(new String(buffer));

            }
            fr.close();
            Log.d("FILE",sb.toString());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    //    StudentDAO dao=new StudentDAOImpl (324,"sfd","sdf");
      //  dao.addStudent(new Student(2432,"123","12312"));


    }

    public void click111(View v)
    {
        JSONObject obj=new JSONObject();
        JSONArray array=new JSONArray();
        try {
           obj=new JSONObject();
            obj.put("name","john");
            obj.put("tel","13434");
            obj.put("addr","taipei");
            array.put(obj);

            obj=new JSONObject();
            obj.put("name","Mary");
            obj.put("tel","343f");
            obj.put("addr","taipei");
            array.put(obj);


            Log.d("JSON",obj.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public void click222(View v)
    {

        ArrayList<Student> mylist=new ArrayList();
        Student s1=new Student("23","aa","34");
        Student s2=new Student("435","aa","34");

        mylist.add(s1);
        mylist.add(s2);
        Gson gson=new Gson();

        String str=gson.toJson(mylist, new TypeToken<ArrayList<Student>>(){}.getType());
        Log.d("JSON",str);


    }
}
