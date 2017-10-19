package com.searchroom.repository.impl;

import com.searchroom.model.entities.RoomPost;
import com.searchroom.repository.RoomPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class RoomPostRepositoryImpl implements RoomPostRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addRoomPost(RoomPost roomPost) {
        String sql = "insert into room_posts (customer_id, info_id) values (?, ?)";
        jdbcTemplate.update(sql, new Object[]{ roomPost.getCustomerId(), roomPost.getRoomInfoId() });
    }

}
