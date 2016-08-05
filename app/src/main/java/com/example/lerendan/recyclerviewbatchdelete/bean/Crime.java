package com.example.lerendan.recyclerviewbatchdelete.bean;

import java.util.Date;
import java.util.UUID;

/**
 * Created by lerendan on 2016/8/2.
 */

public class Crime {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public Crime(){
        this(UUID.randomUUID());
    }

    public Crime(UUID id){
        mId = id;
        mDate = new Date();
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
        return mDate;
    }

    public void setData(Date mData) {
        this.mDate = mData;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean mSolved) {
        this.mSolved = mSolved;
    }
}
