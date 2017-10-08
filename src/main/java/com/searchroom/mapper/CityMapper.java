package com.searchroom.mapper;

import com.searchroom.model.City;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CityMapper implements RowMapper<City> {

    public City mapRow(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt("city_id");
        String name = resultSet.getString("city_name");
        return new City(id, name);
    }

}
