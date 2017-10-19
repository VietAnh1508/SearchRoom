package com.searchroom.repository.impl;

import com.searchroom.model.entities.RoomInfo;
import com.searchroom.repository.RoomInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
@Transactional
public class RoomInfoRepositoryImpl implements RoomInfoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int addRoomInfo(final RoomInfo roomInfo) {
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                String sql = "insert into room_infos (type_id, title, area, price, description, address_id) values (?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, roomInfo.getTypeId());
                ps.setString(2, roomInfo.getTitle());
                ps.setFloat(3, roomInfo.getArea());
                ps.setBigDecimal(4, roomInfo.getPrice());
                ps.setString(5, roomInfo.getDescription());
                ps.setInt(6, roomInfo.getAddressId());
                return ps;
            }
        }, holder);

        return holder.getKey().intValue();
    }

}
