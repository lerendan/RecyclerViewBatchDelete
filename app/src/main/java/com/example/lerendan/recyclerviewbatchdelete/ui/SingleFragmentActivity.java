package com.example.lerendan.recyclerviewbatchdelete.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.lerendan.recyclerviewbatchdelete.R;

/**
 * Created by lerendan on 2016/8/4.
 */

public abstract class SingleFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.container);

        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction().add(R.id.container, fragment).commit();
        }
    }

    protected abstract Fragment createFragment();
}
