package com.example.lerendan.recyclerviewbatchdelete.ui.frame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lerendan.recyclerviewbatchdelete.R;
import com.example.lerendan.recyclerviewbatchdelete.adapter.MyAdapter;
import com.example.lerendan.recyclerviewbatchdelete.bean.MyBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MyAdapter myAdapter;
    private List<MyBean> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();

        setListener();
    }

    private void initData() {
        mData = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            MyBean myBean = new MyBean("title"+i);
            mData.add(myBean);
        }
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
        myAdapter = new MyAdapter(MainActivity.this,mData);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        mRecyclerView.setAdapter(myAdapter);
    }

    private void setListener() {
    }


}
