package com.searchroom.repository;

import com.searchroom.model.City;

import java.util.List;

public interface CityRepository {

    void addCity(City city);
    void updateCity(City city);
    City getCityById(int cityId);
    List<City> getCities();
    void removeCity(int cityId);

}
