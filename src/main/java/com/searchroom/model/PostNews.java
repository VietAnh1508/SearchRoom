package com.searchroom.model;

import java.math.BigDecimal;

public class PostNews {

    private String title;
    private String address;
    private BigDecimal price;
    private String roomType;
    private String image;

    public PostNews(String title, String address, BigDecimal price, String roomType, String image) {
        this.title = title;
        this.address = address;
        this.price = price;
        this.roomType = roomType;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
