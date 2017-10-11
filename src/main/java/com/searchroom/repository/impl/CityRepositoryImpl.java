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

    public void addCity(String cityName) {
        String sql = "insert into cities (city_name) values (?)";
        jdbcTemplate.update(sql, new Object[] { cityName });
    }

    public void updateCity(City city) {
        String sql = "update cities set city_name = ? where city_id = ?";
        jdbcTemplate.update(sql, new Object[] { city.getName(), city.getId() });
    }

    public void deleteCity(int id) {
        String sql = "delete from cities where city_id = ?";
        jdbcTemplate.update(sql, new Object[] { id });
    }

    public City getCityById(int id) {
        String sql = "select * from cities where city_id = ?";

        List<City> result = jdbcTemplate.query(sql, new Object[] { id }, new CityMapper());
        if (result.size() == 1) {
            return result.get(0);
        }
        return null;
    }

    public List<City> getCityList() {
        String sql = "select * from cities";

        List<City> cityList = jdbcTemplate.query(sql, new CityMapper());
        return cityList;
    }

}
