package com.searchroom.service.impl;

import com.searchroom.model.City;
import com.searchroom.repository.CityRepository;
import com.searchroom.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    public void addCity(City city) {
        cityRepository.addCity(city);
    }

    public void updateCity(City city) {
        cityRepository.updateCity(city);
    }

    public City getCityById(int cityId) {
        return cityRepository.getCityById(cityId);
    }

    public List<City> getCities() {
        return cityRepository.getCities();
    }

    public void removeCity(int cityId) {
        cityRepository.removeCity(cityId);
    }

}
