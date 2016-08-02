package com.example.lerendan.recyclerviewbatchdelete.bean;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2016/8/2.
 */

public class Crime {
    private UUID mId;
    private String mTitle;
    private Date mData;
    private boolean mSolved;

    public Crime(){
        mId = UUID.randomUUID();
        mData = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Date getData() {
        return mData;
    }

    public void setData(Date mData) {
        this.mData = mData;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean mSolved) {
        this.mSolved = mSolved;
    }
}
