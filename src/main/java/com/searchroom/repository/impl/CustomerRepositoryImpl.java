package com.searchroom.repository.impl;

import com.searchroom.model.Customer;
import com.searchroom.repository.CustomerRepository;
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
public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addCustomer(Customer customer) {
        String sql = "insert into customers (full_name, phone_number, email, username) values (?, ?, ?, ?)";
        jdbcTemplate.update(sql, new Object[] {
                customer.getFullName(),
                customer.getPhoneNumber(),
                customer.getEmail(),
                customer.getUsername()
        });
    }

    public Customer getCustomerByUsername(String username) {
        String sql = "select * from customers where username = ?";

        List<Customer> customers = jdbcTemplate.query(sql, new Object[]{username}, new RowMapper<Customer>() {
            public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("customer_id"));
                customer.setUsername(resultSet.getString("username"));
                customer.setFullName(resultSet.getString("full_name"));
                customer.setPhoneNumber(resultSet.getString("phone_number"));
                customer.setEmail(resultSet.getString("email"));
                return customer;
            }
        });

        if (customers.size() == 1) {
            return customers.get(0);
        }

        return null;
    }

}