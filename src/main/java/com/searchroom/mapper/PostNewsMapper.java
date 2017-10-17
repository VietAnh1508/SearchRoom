package com.searchroom.mapper;

import com.searchroom.model.PostNews;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostNewsMapper implements RowMapper<PostNews> {

    public PostNews mapRow(ResultSet resultSet, int i) throws SQLException {
        String title = resultSet.getString("title");
        String address = resultSet.getString("address");
        BigDecimal price = resultSet.getBigDecimal("price");
        String roomType = resultSet.getString("description");
        String image = resultSet.getString("file_name");

        return new PostNews(title, address, price, roomType, image);
    }

}
