package com.searchroom.model;

public class District {

    private int id;
    private String districtName;
    private int cityId;

    public District(int id, String districtName, int cityId) {
        this.id = id;
        this.districtName = districtName;
        this.cityId = cityId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

}
