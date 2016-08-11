package com.project.ultra.jack;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.ultra.myapplication.R;

import java.util.ArrayList;

/**
 * Created by albert on 2016/7/27.
 */
public class MyAdapter2 extends BaseAdapter
{
    Context context;
    ArrayList<Student> data;
    boolean chk[];
    LayoutInflater inflater;

    public MyAdapter2(Context c, ArrayList<Student> list)
    {
        context = c;
        data = list;
        chk= new boolean[data.size()];
     inflater= LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return data.size();
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


        final int p=position;


        Log.d("2701","Get View position"+p);

        ViewHolder holder;


        CheckBox chk1;


        if (convertView==null)
        {
         //   LayoutInflater inflater = LayoutInflater.from(context);
             convertView = inflater.inflate(R.layout.listitem, null);
            holder=new ViewHolder();
            holder.img1= (ImageView)convertView.findViewById(R.id.imageView);
            holder.tv1= (TextView) convertView.findViewById(R.id.textView);

            holder.tv2= (TextView) convertView.findViewById(R.id.textView2);
            holder.btn1= (Button) convertView.findViewById(R.id.button36);

            holder.chk1= (CheckBox) convertView.findViewById(R.id.checkBox2);
            convertView.setTag(holder);
        }
        else {

            holder= (ViewHolder) convertView.getTag();

        }
       // CheckBox chk1;
        chk1= (CheckBox) convertView.findViewById(R.id.checkBox2);


        holder.img1.setImageResource(data.get(position).photoid);
       // final TextView tv1 = (TextView) v.findViewById(R.id.textView);
        holder.tv1.setText(data.get(position).name);
        //TextView tv2 = (TextView) v.findViewById(R.id.textView2);
        holder.tv2.setText(data.get(position).phone);

        //Button btn= (Button) v.findViewById(R.id.button36);

        holder.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Toast.makeText(context,tv1.getText(), Toast.LENGTH_SHORT).show();

                Intent it=new Intent(context,ListViewMyAapterArrayListActivity_detail.class);
                Bundle b=new Bundle();

                b.putString("name",data.get(p).name);
                b.putString("phone",data.get(p).phone);
                b.putInt("photo",data.get(p).photoid);
                it.putExtras(b);

                context.startActivity(it);

            }
        });


      //  CheckBox chk1= (CheckBox) v.findViewById(R.id.checkBox2);
        //holder.chk1.setChecked(chk[p]);
        holder.chk1.setOnCheckedChangeListener(null);
        if (chk[p])
        {holder.chk1.setChecked(true);}
        else
        {holder.chk1.setChecked(false);}
        chk1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               // chk= new boolean[data.size()];
                chk[p]= isChecked;

            }
        });



        return convertView;
    }

    class ViewHolder{
        ImageView img1;
        TextView tv1;
        TextView tv2;
        Button btn1;
        CheckBox chk1;


    }
}
