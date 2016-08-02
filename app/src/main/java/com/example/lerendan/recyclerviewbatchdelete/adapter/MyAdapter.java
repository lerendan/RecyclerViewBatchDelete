package com.example.lerendan.recyclerviewbatchdelete.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lerendan.recyclerviewbatchdelete.R;
import com.example.lerendan.recyclerviewbatchdelete.bean.MyBean;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by lerendan on 2016/8/2.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context mContext;
    private LayoutInflater inflater;
    private List<MyBean> mData;

    public MyAdapter(Context context, List<MyBean> data){
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
        holder.textView.setText(mData.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            textView = (TextView) itemView.findViewById(R.id.textview);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(mContext, "ggg", Toast.LENGTH_SHORT).show();
        }
    }

}

