package com.searchroom.repository;

import com.searchroom.model.Customer;

public interface CustomerRepository {

    void addCustomer(Customer customer);
    Customer getCustomerByUsername(String username);

}
