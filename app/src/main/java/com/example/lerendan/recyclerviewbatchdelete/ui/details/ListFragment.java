package com.example.lerendan.recyclerviewbatchdelete.ui.details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lerendan.recyclerviewbatchdelete.R;
import com.example.lerendan.recyclerviewbatchdelete.adapter.MyAdapter;
import com.example.lerendan.recyclerviewbatchdelete.bean.Crime;
import com.example.lerendan.recyclerviewbatchdelete.bean.CrimeLab;

import java.util.List;

/**
 * Created by lerendan on 2016/8/3.
 */

public class ListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private MyAdapter myAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.mRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        List<Crime> crimes = crimeLab.getCrimes();
        if(myAdapter==null){
            myAdapter = new MyAdapter(getActivity(), crimes);
            mRecyclerView.setAdapter(myAdapter);
        }else {
            myAdapter.notifyDataSetChanged();
        }


    }



}
