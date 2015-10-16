package com.taylorbest.chorereward.models;

import java.util.UUID;

/**
 * Created by chadley on 10/14/2015.
 */
public class Group {
    private int mId;
    private String mTitle;
    private String mDescription;


    public Group(String title) {
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

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }
}
