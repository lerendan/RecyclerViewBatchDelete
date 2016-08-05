package com.example.lerendan.recyclerviewbatchdelete.ui.frame;

import android.support.v4.app.Fragment;

import com.example.lerendan.recyclerviewbatchdelete.ui.SingleFragmentActivity;
import com.example.lerendan.recyclerviewbatchdelete.ui.details.ListFragment;

/**
 * Created by lerendan on 2016/8/3.
 */
public class MainActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new ListFragment();
    }
}
