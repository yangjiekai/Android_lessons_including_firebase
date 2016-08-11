package com.project.ultra.jack;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.project.ultra.myapplication.R;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class DialogActivity extends AppCompatActivity {
    int w;  //單選項對話框 選擇項目
    boolean b[] = new boolean[3]; //多選項對話框
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void click22(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
        builder.setTitle("對話框");
        builder.setMessage("這是訊息");

        final EditText ed = new EditText(DialogActivity.this);
        builder.setView(ed);

        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = ed.getText().toString();
                Toast.makeText(DialogActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.setNeutralButton("忽略", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }

    //單選項對話框 setSingleChoiceItems
    public void click23(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
        builder.setTitle("對話框");
        final String fruits[] = {"APPLE", "香蕉", "草莓"};
        builder.setSingleChoiceItems(fruits, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                w = which; //選定項
            }
        });
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                TextView tv = (TextView) findViewById(R.id.textView14);
                tv.setText(fruits[w]);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();

    }

    //    多選項對話框
    public void click24(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
        builder.setTitle("對話框");
        final String[] sweets = {"花生", "紅豆", "綠豆"};
        //將選擇 b
        builder.setMultiChoiceItems(sweets, b, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
//                b[which] = isChecked;
            }
        });
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                TextView tv = (TextView) findViewById(R.id.textView15);
                String str = "";
                for (int i = 0; i <= 2; i++) {
                    if (b[i]) {
                        str = str + sweets[i];
                    }
                }
                tv.setText(str);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();

    }

    //列表型對話框
    public void click25(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
        builder.setTitle("列表型對話框");
        final String[] sweets = {"花生", "紅豆", "綠豆"};
        builder.setItems(sweets, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                TextView tv = (TextView) findViewById(R.id.textView16);
                tv.setText(sweets[which]);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.create().show();
    }

    //自訂布局對話框
    public void click27(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
        builder.setTitle("自訂布局對話框");

        LayoutInflater inflater = getLayoutInflater();
        View dv = inflater.inflate(R.layout.dialog_view, (ViewGroup) findViewById(R.id.root));
        builder.setView(dv);

        Button btn = (Button) dv.findViewById(R.id.button26);
        final TextView tv2 = (TextView) dv.findViewById(R.id.textView17);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int r = (int)(Math.random() * 100);
                String s = String.valueOf(r);
                tv2.setText(s);
            }
        });

        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.create().show();
    }
//    public void click26(View v)
//    {
//        final ProgressDialog pd = new ProgressDialog(DialogActivity.this);
//        pd.setTitle("請稍後");
//        pd.setMessage("請稍後視窗....");
//        pd.show();
//
//        new Thread(){public void run(){
//
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            pd.dismiss();
//        }}.start();
//
//    }

}
