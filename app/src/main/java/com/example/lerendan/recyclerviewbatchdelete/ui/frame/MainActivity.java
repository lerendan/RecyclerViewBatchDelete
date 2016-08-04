package com.example.lerendan.recyclerviewbatchdelete.ui.frame;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lerendan.recyclerviewbatchdelete.R;
import com.example.lerendan.recyclerviewbatchdelete.ui.details.ListFragment;

/**
 * Created by lerendan on 2016/8/3.
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.container);

        if (fragment == null) {
            fragment = new ListFragment();
            fm.beginTransaction().add(R.id.container, fragment).commit();
        }
    }
}
