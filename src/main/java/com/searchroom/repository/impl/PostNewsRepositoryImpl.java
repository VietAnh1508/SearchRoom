package com.searchroom.repository.impl;

import com.searchroom.mapper.PostNewsMapper;
import com.searchroom.model.PostNews;
import com.searchroom.repository.PostNewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PostNewsRepositoryImpl implements PostNewsRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<PostNews> getNewestPost() {
        String sql = "select i.price, i.title, a.address, t.description, r.file_name"
                + " from room_infos i"
                + " join addresses a"
                + " on i.address_id = a.address_id"
                + " join room_types t"
                + " on t.type_id = i.type_id"
                + " join resources r"
                + " on r.room_info_id = i.info_id";
        return jdbcTemplate.query(sql, new PostNewsMapper());
    }

}
