package com.searchroom.repository.impl;

import com.searchroom.mapper.AccountMapper;
import com.searchroom.model.Account;
import com.searchroom.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addAccount(Account account) {
        String sql = "insert into accounts (username, password, role) values (?, ?, ?)";
        jdbcTemplate.update(sql, new Object[] { account.getUsername(), account.getPassword(), "CUSTOMER" });
    }

    public Account getAccount(Account account) {
        String sql = "select username, role from accounts where username = ? and password = ?";

        Account result = jdbcTemplate.queryForObject(sql,
                new Object[] { account.getUsername(), account.getPassword() }, new AccountMapper());

        return result;
    }

}
