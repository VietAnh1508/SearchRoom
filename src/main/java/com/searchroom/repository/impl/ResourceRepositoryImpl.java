package com.searchroom.repository.impl;

import com.searchroom.model.entities.Resource;
import com.searchroom.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ResourceRepositoryImpl implements ResourceRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addResource(Resource resource) {
        String sql = "insert into resources (file_name, room_info_id) values (?, ?)";
        jdbcTemplate.update(sql, new Object[]{
                resource.getFileName(),
                resource.getRoomInfoId()
        });
    }

}
