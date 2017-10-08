package com.searchroom.model;

import java.util.Date;

public class RoomPost {

    private int id;
    private Date createdAt;
    private boolean isApproved;
    private Date approvedAt;
    private int approvedBy;
    private int roomInfoId;

    public RoomPost(int id, Date createdAt, boolean isApproved, Date approvedAt, int approvedBy, int roomInfoId) {
        this.id = id;
        this.createdAt = createdAt;
        this.isApproved = isApproved;
        this.approvedAt = approvedAt;
        this.approvedBy = approvedBy;
        this.roomInfoId = roomInfoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public Date getApprovedAt() {
        return approvedAt;
    }

    public void setApprovedAt(Date approvedAt) {
        this.approvedAt = approvedAt;
    }

    public int getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(int approvedBy) {
        this.approvedBy = approvedBy;
    }

    public int getRoomInfoId() {
        return roomInfoId;
    }

    public void setRoomInfoId(int roomInfoId) {
        this.roomInfoId = roomInfoId;
    }

}
