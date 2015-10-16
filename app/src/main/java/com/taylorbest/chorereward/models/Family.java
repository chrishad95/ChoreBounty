package com.taylorbest.chorereward.models;

import java.util.UUID;

/**
 * Created by chadley on 10/14/2015.
 */
public class Family {
    int mId;
    private String mTitle;

    public Family(String title) {
        mTitle = title;
    }

    public int getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
