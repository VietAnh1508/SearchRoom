package com.searchroom.model;

public class Resource {

    private int id;
    private String fileName;
    private double fileSize;
    private int roomInfoId;

    public Resource(int id, String fileName, double fileSize, int roomInfoId) {
        this.id = id;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.roomInfoId = roomInfoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    public int getRoomInfoId() {
        return roomInfoId;
    }

    public void setRoomInfoId(int roomInfoId) {
        this.roomInfoId = roomInfoId;
    }

}
