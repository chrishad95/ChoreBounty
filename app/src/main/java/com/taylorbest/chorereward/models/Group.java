package com.taylorbest.chorereward.models;

import java.util.UUID;

/**
 * Created by chadley on 10/14/2015.
 */
public class Group {
    private UUID mId;
    private String mTitle;

    public Group(String title) {
        mTitle = title;
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
