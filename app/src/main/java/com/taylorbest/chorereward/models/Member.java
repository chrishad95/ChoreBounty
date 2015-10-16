package com.taylorbest.chorereward.models;

import java.util.UUID;

/**
 * Created by chadley on 10/14/2015.
 */
public class Member {
    private UUID id;
    private String mName;

    public Member(String name) {
        this.id = UUID.randomUUID();
        mName = name;
    }

    public UUID getId() {
        return id;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }
}
