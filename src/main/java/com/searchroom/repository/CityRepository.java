package com.searchroom.repository;

import com.searchroom.model.City;

import java.util.List;

public interface CityRepository {

    void addCity(String cityName);
    void updateCity(City city);
    void deleteCity(int id);
    City getCityById(int id);
    List<City> getCityList();

}
