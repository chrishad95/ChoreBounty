package com.taylorbest.chorebounty.models;

import java.util.Date;
import java.util.UUID;

/**
 * Created by chadley on 10/14/2015.
 */
public class Chore {
    private UUID mUUID;
    private String mDescription;
    private String mTitle;
    private float mBounty;
    private Date mDateCreated;
    private Boolean mCompleted;
    private Date mDateCompleted;
    private Boolean mBountyPaid;
    private UUID mCompletedBy;
    private UUID mGroupAssigned;

    public UUID getUUID() {
        return mUUID;
    }

    public void setUUID(UUID UUID) {
        mUUID = UUID;
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

    public float getBounty() {
        return mBounty;
    }

    public void setBounty(float bounty) {
        mBounty = bounty;
    }

    public Date getDateCreated() {
        return mDateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        mDateCreated = dateCreated;
    }

    public Boolean getCompleted() {
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

    public Boolean getBountyPaid() {
        return mBountyPaid;
    }

    public void setBountyPaid(Boolean bountyPaid) {
        mBountyPaid = bountyPaid;
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
