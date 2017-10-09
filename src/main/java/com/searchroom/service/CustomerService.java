package com.searchroom.service;

import com.searchroom.model.Customer;

public interface CustomerService {

    void addCustomer(Customer customer);
    Customer getCustomerByUsername(String username);

}
