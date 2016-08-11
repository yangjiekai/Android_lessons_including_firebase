package com.project.ultra.jack;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by albert on 2016/7/27.
 */
public class MyAdapter extends BaseAdapter {
    Context context;
    String[] str;
    public MyAdapter(Context c, String[] s){
        context = c;
        str = s;
    }
    @Override
    public int getCount() {
        return str.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tv = new TextView(context);
        tv.setText(str[position]);
        return tv;
    }
}
