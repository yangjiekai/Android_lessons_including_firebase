package com.project.ultra.jack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class LayoutsActivit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_layouts);

        LinearLayout layout=new LinearLayout(LayoutsActivit.this);
        Button btn1=new Button(LayoutsActivit.this);
        btn1.setText("程式建置的button");
        layout.addView(btn1);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        1.0f);
        Button btn2 = new Button(LayoutsActivit.this);
        btn2.setLayoutParams(params);
        btn2.setText("參數改變樣式");
        layout.addView(btn2);

        setContentView(layout);
    }
}
