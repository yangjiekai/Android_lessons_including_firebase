package com.project.ultra.jack;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.project.ultra.myapplication.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class from_local_json extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_local_json);


        InputStream is=null;
        is=getResources().openRawResource(R.raw.anim);
        ByteArrayOutputStream result=new ByteArrayOutputStream();

        byte[] buffer= new byte[1024];

        int length;

        try {
            while((length=is.read(buffer))!=-1){
            result.write(buffer,0,length);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Log.d("READ",result.toString("UTF-8"));

            String str=result.toString("UTF-8");
            ///////////////////////////// JSON//////////////////////////////////////////////
//            JSONArray array =new JSONArray(str);
//            for(int i=0;i<array.length();i++)
//            {
//                JSONObject obj=array.getJSONObject(i);
//                Log.d("READ",obj.getString("district")+obj.getString("address")+obj.getString("tel"));
//
//
//            }
            ///////////////////////////// JSON//////////////////////////////////////////////

            /////////////////////////////GSON//////////////////////////////////////////////
            Gson gson=new Gson();
            ArrayList<Animal> mylist=gson.fromJson(str,new TypeToken<ArrayList<Animal>>(){}.getType());

            for(Animal p:mylist)
            {
                Log.d("NET",p.district+","+p.address+","+p.tel);


            }


            /////////////////////////////GSON//////////////////////////////////////////////


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

//        catch (JSONException e) {
//            e.printStackTrace();
//        }

    }
}
