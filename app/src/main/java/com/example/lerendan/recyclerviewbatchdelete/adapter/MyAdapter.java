package com.example.lerendan.recyclerviewbatchdelete.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.lerendan.recyclerviewbatchdelete.R;
import com.example.lerendan.recyclerviewbatchdelete.bean.Crime;
import com.example.lerendan.recyclerviewbatchdelete.ui.frame.ContentPagerActivity;

import java.util.List;


/**
 * Created by lerendan on 2016/8/2.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context mContext;
    private LayoutInflater inflater;
    private List<Crime> mData;

    public MyAdapter(Context context, List<Crime> data){
        mContext  = context;
        inflater =  LayoutInflater.from(context);
        mData = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(inflater.inflate(R.layout.item_main,parent,false));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Crime crime=mData.get(position);
        holder.bindCrime(crime);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setCrimes(List<Crime> crimes){
        mData = crimes;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTitleTextView;
        private TextView mDataTextView;
        private CheckBox mCheckBox;
        private Crime mCrime;
        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mTitleTextView = (TextView) itemView.findViewById(R.id.title);
            mDataTextView = (TextView) itemView.findViewById(R.id.date);
            mCheckBox = (CheckBox) itemView.findViewById(R.id.mCheckBox);
        }

        public void bindCrime(Crime crime){
            mCrime =crime;
            mTitleTextView.setText(mCrime.getTitle());
            mDataTextView.setText(mCrime.getDate().toString());
            mCheckBox.setChecked(mCrime.isSolved());
        }


        @Override
        public void onClick(View view) {
            Intent intent = ContentPagerActivity.newIntent(mContext,mCrime.getId());
            mContext.startActivity(intent);
//            Toast.makeText(mContext, mCrime.getTitle(), Toast.LENGTH_SHORT).show();
        }
    }

}

