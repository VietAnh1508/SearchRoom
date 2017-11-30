package com.searchroom.repository.impl;

import com.searchroom.mapper.RoomTypeMapper;
import com.searchroom.model.entities.RoomType;
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
        jdbcTemplate.update(sql, description);
    }

    public void updateRoomType(RoomType roomType) {
        String sql = "update room_types set description = ? where type_id = ?";
        jdbcTemplate.update(sql, roomType.getDescription(), roomType.getId());
    }

    public void deleteRoomType(int id) {
        String sql = "delete from room_types where type_id = ?";
        jdbcTemplate.update(sql, id);
    }

    public RoomType getRoomTypeById(int id) {
        String sql = "select * from room_types where type_id = ?";

        List<RoomType> result = jdbcTemplate.query(sql, new Object[] { id }, new RoomTypeMapper());
        if (result.size() == 1) {
            return result.get(0);
        }
        return null;
    }

    public List<RoomType> getRoomTypeList() {
        String sql = "select t.type_id, t.description, count(i.info_id) as post_amount "
                + "from room_types t "
                + "left join room_infos i "
                + "on i.type_id = t.type_id "
                + "group by i.type_id";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            int id = resultSet.getInt("type_id");
            String description = resultSet.getString("description");
            int roomAmount = resultSet.getInt("post_amount");
            return new RoomType(id, description, roomAmount);
        });
    }

}
