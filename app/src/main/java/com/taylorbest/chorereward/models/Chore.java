package com.taylorbest.chorereward.models;

import java.util.Date;
import java.util.UUID;

/**
 * Created by chadley on 10/14/2015.
 */
public class Chore {
    private int mId;
    private String mDescription;
    private String mTitle;
    private float mReward;
    private Date mDateCreated;
    private Boolean mCompleted;
    private Date mDateCompleted;
    private Boolean mRewardPaid;

    public Chore () {

    }
    public Chore(int id) {
        this.mId = id;
    }
    public Chore(int id, String description, String title, float reward) {
        this.mId = id;
        mDescription = description;
        mTitle = title;
        mReward = reward;
    }

    private int mCompletedBy;
    private int mGroupAssigned;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public float getReward() {
        return mReward;
    }

    public void setReward(float reward) {
        mReward = reward;
    }

    public Date getDateCreated() {
        return mDateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        mDateCreated = dateCreated;
    }

    public Boolean isCompleted() {
        return mCompleted;
    }

    public void setCompleted(Boolean completed) {
        mCompleted = completed;
    }

    public Date getDateCompleted() {
        return mDateCompleted;
    }

    public void setDateCompleted(Date dateCompleted) {
        mDateCompleted = dateCompleted;
    }

    public Boolean isRewardPaid() {
        return mRewardPaid;
    }

    public void setRewardPaid(Boolean rewardPaid) {
        mRewardPaid = rewardPaid;
    }

    public int getCompletedBy() {
        return mCompletedBy;
    }

    public void setCompletedBy(int completedBy) {
        mCompletedBy = completedBy;
    }

    public int getGroupAssigned() {
        return mGroupAssigned;
    }

    public void setGroupAssigned(int groupAssigned) {
        mGroupAssigned = groupAssigned;
    }
}
