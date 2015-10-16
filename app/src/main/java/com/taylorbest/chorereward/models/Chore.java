package com.taylorbest.chorereward.models;

import java.util.Date;
import java.util.UUID;

/**
 * Created by chadley on 10/14/2015.
 */
public class Chore {
    private UUID mId;
    private String mDescription;
    private String mTitle;
    private float mReward;
    private Date mDateCreated;
    private Boolean mCompleted;
    private Date mDateCompleted;
    private Boolean mRewardPaid;

    public Chore() {
        mId = UUID.randomUUID();
    }
    public Chore(String description, String title, float reward) {
        mId = UUID.randomUUID();
        mDescription = description;
        mTitle = title;
        mReward = reward;
    }

    private UUID mCompletedBy;
    private UUID mGroupAssigned;

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
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

    public UUID getCompletedBy() {
        return mCompletedBy;
    }

    public void setCompletedBy(UUID completedBy) {
        mCompletedBy = completedBy;
    }

    public UUID getGroupAssigned() {
        return mGroupAssigned;
    }

    public void setGroupAssigned(UUID groupAssigned) {
        mGroupAssigned = groupAssigned;
    }
}
