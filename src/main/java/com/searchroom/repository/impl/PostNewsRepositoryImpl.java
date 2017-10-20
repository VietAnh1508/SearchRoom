package com.searchroom.repository.impl;

import com.searchroom.mapper.PostNewsMapper;
import com.searchroom.model.join.PostNews;
import com.searchroom.repository.PostNewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@Transactional
public class PostNewsRepositoryImpl implements PostNewsRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final int POSTS_ON_HOME_PAGE = 8;

    public List<PostNews> getNewestPost() {
        String sql = "select p.post_id, i.price, i.title, a.address, t.description, r.file_name"
                + " from room_posts p"
                + " join room_infos i"
                + " on p.info_id = i.info_id"
                + " join addresses a"
                + " on i.address_id = a.address_id"
                + " join room_types t"
                + " on t.type_id = i.type_id"
                + " join resources r"
                + " on r.room_info_id = i.info_id"
                + " order by p.created_at desc"
                + " limit " + POSTS_ON_HOME_PAGE;
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            int postId = resultSet.getInt("post_id");
            String title = resultSet.getString("title");
            String address = resultSet.getString("address");
            BigDecimal price = resultSet.getBigDecimal("price");
            String roomType = resultSet.getString("description");
            String image = resultSet.getString("file_name");

            return new PostNews(postId, title, address, price, roomType, image);
        });
    }

    @Override
    public List<PostNews> getPostForRoomsPage() {
        String sql = "select p.post_id, i.price, i.title, a.address, r.file_name"
                + " from room_posts p"
                + " join room_infos i"
                + " on p.info_id = i.info_Id"
                + " join addresses a"
                + " on i.address_id = a.address_id"
                + " join resources r"
                + " on r.room_info_id = i.info_id";
        return jdbcTemplate.query(sql, new PostNewsMapper());
    }

    @Override
    public List<PostNews> getCustomerPosts(int customerId) {
        String sql = "select p.post_id, i.price, i.title, a.address, r.file_name"
                + " from room_posts p"
                + " join room_infos i"
                + " on p.info_id = i.info_Id"
                + " join addresses a"
                + " on i.address_id = a.address_id"
                + " join resources r"
                + " on r.room_info_id = i.info_id"
                + " join customers c"
                + " on c.customer_id = p.customer_id"
                + " where c.customer_id = ?";
        return jdbcTemplate.query(sql, new Object[]{customerId}, new PostNewsMapper());
    }

}
