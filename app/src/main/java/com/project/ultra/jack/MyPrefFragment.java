package com.project.ultra.jack;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.project.ultra.myapplication.R;

/**
 * Created by ultra-jack on 2016/8/3.
 */
public class MyPrefFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.mypref);
    }
}
