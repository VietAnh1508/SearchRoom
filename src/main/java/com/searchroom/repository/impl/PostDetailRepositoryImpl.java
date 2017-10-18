package com.searchroom.repository.impl;

import com.searchroom.model.PostDetail;
import com.searchroom.repository.PostDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Repository
@Transactional
public class PostDetailRepositoryImpl implements PostDetailRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public PostDetail getPostDetail(int postId) {
        String sql = "select i.title, i.area, i.price, i.description, a.address, a.latitude, a.longitude, "
                + "p.created_at, c.full_name, c.email, c.phone_number, r.file_name "
                + "from room_infos i "
                + "join addresses a "
                + "on i.address_id = a.address_id "
                + "join room_posts p "
                + "on p.info_id = i.info_id "
                + "join customers c "
                + "on c.customer_id = p.customer_id "
                + "join resources r "
                + "on r.room_info_id = i.info_id "
                + "where p.post_id = ?";
        List<PostDetail> detailList = jdbcTemplate.query(sql, new Object[]{postId}, new RowMapper<PostDetail>() {
            @Override
            public PostDetail mapRow(ResultSet resultSet, int i) throws SQLException {
                String title = resultSet.getString("title");
                float area = resultSet.getFloat("area");
                BigDecimal price = resultSet.getBigDecimal("price");
                String description = resultSet.getString("description");
                String address = resultSet.getString("address");
                String latitude = resultSet.getString("latitude");
                String longitude = resultSet.getString("longitude");
                String createdAt = resultSet.getTimestamp("created_at").toString();
                String fullName = resultSet.getString("full_name");
                String email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("phone_number");
                String fileName = resultSet.getString("file_name");

                LocalDateTime dateTime
                        = LocalDateTime.parse(createdAt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"));
                String formattedDate = dateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy"));

                return new PostDetail(title, area, price, description, address, latitude, longitude, formattedDate,
                        fullName, email, phoneNumber, fileName);
            }
        });

        if (detailList.size() > 0) {
            return detailList.get(0);
        }
        return null;
    }

}
