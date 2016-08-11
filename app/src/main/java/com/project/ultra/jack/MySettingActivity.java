package com.project.ultra.jack;

import android.os.Bundle;

public class MySettingActivity extends AppCompatPreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_my_setting);
        android.app.FragmentTransaction ft= getFragmentManager().beginTransaction();

        ft.replace(android.R.id.content,new MyPrefFragment()).commit();

    }
}
