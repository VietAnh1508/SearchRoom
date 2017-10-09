package com.searchroom.repository;

import com.searchroom.model.Customer;

import java.sql.SQLException;

public interface CustomerRepository {

    void addCustomer(Customer customer) throws SQLException;
    Customer getCustomerByUsername(String username);
    void updateCustomer(Customer customer) throws SQLException;

}
