package com.searchroom.repository.impl;

import com.searchroom.model.RoomType;
import com.searchroom.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@Transactional
public class RoomTypeRepositoryImpl implements RoomTypeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addRoomType(String description) {
        String sql = "insert into room_types (description) values (?)";
        jdbcTemplate.update(sql, new Object[] { description });
    }

    public List<RoomType> getRoomTypeList() {
        String sql = "select * from room_types";

        List<RoomType> roomTypes = jdbcTemplate.query(sql, new RowMapper<RoomType>() {
            public RoomType mapRow(ResultSet resultSet, int i) throws SQLException {
                RoomType type = new RoomType();
                type.setId(resultSet.getInt("type_id"));
                type.setDescription(resultSet.getString("description"));
                return type;
            }
        });

        return roomTypes;
    }

}
