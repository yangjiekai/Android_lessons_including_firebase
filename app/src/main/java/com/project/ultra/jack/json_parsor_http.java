package com.project.ultra.jack;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.project.ultra.myapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class json_parsor_http extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_parsor_http);

        RequestQueue queue = Volley.newRequestQueue(json_parsor_http.this);
        String url = "http://data.ntpc.gov.tw/od/data/api/B1464EF0-9C7C-4A6F-ABF7-6BDF32847E68?$format=json";
        StringRequest request = new UTF8StringRequest(url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        Log.d("NET", response);
                        try {
                            JSONArray array = new JSONArray(response);
                             for(int i=0;i<array.length();i++)
                             {
                                 JSONObject obj=array.getJSONObject(i);
                                 Log.d("NET","NAME:"+obj.getString("NAME")+"Addr:"+obj.getString("ADDRESS"));
                             }

//                            JSONObject obj = array.getJSONObject(0);
//                            Log.d("NET", "Name:" + obj.getString("NAME"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("NET", "Error:" + error.toString());
            }
        });

    queue.add(request);
        queue.start();
        Log.d("NET","Volley started");
    }

    }

