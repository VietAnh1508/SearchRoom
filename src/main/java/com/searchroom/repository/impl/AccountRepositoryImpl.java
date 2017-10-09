package com.searchroom.repository.impl;

import com.searchroom.model.Account;
import com.searchroom.repository.AccountRepository;
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
public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addAccount(Account account) {
        String sql = "insert into accounts (username, password, role) values (?, ?, ?)";
        jdbcTemplate.update(sql, new Object[]{account.getUsername(), account.getPassword(), "CUSTOMER"});
    }

    public Account getAccount(Account account) {
        String sql = "select username, role from accounts where username = ? and password = ?";

        List<Account> result = jdbcTemplate.query(
                sql,
                new Object[] { account.getUsername(), account.getPassword() },
                new RowMapper<Account>() {
                    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
                        String username = resultSet.getString("username");
                        String role = resultSet.getString("role");
                        return new Account(username, role);
                    }
                });

        if (result.size() == 1) {
            return result.get(0);
        }
        return null;
    }

}