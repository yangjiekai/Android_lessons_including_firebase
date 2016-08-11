package com.project.ultra.jack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.project.ultra.myapplication.R;

public class MenuAddActivity extends AppCompatActivity {

    final int OPTION_C = 3;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_add);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.add(0, 0, Menu.NONE,"AA");
        menu.add(0, 1, Menu.NONE,"BB");
        menu.add(0, OPTION_C, Menu.NONE,"CC");
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == 1)
        {
            Toast.makeText(MenuAddActivity.this, "BB", Toast.LENGTH_SHORT).show();
            return true;
        }

        if (id == OPTION_C)
        {
            Toast.makeText(MenuAddActivity.this, "CC", Toast.LENGTH_SHORT).show();
            return true;
        }
        /*
        if (id == R.id.action_settings) {
            Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.action_about) {
            Toast.makeText(MainActivity.this, "About", Toast.LENGTH_SHORT).show();
            return true;
        }
*/
        return super.onOptionsItemSelected(item);
    }
}
