package com.searchroom.repository.impl;

import com.searchroom.mapper.CityMapper;
import com.searchroom.model.City;
import com.searchroom.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CityRepositoryImpl implements CityRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addCity(City city) {

    }

    public void updateCity(City city) {

    }

    public City getCityById(int cityId) {
        return null;
    }

    public List<City> getCities() {
        String sql = "select * from cities";

        List<City> cities = jdbcTemplate.query(sql, new CityMapper());
        return cities;
    }

    public void removeCity(int cityId) {

    }

}
