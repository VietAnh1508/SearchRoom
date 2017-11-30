package com.searchroom.model.entities;

import javax.validation.constraints.NotEmpty;

public class RoomType {

    private int id;

    @NotEmpty
    private String description;

    private int roomAmount;

    public RoomType() {
    }

    public RoomType(int id, @NotEmpty String description) {
        this.id = id;
        this.description = description;
    }

    public RoomType(int id, String description, int roomAmount) {
        this.id = id;
        this.description = description;
        this.roomAmount = roomAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRoomAmount() {
        return roomAmount;
    }

    public void setRoomAmount(int roomAmount) {
        this.roomAmount = roomAmount;
    }

}
