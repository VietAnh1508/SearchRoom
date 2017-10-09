package com.searchroom.service.impl;

import com.searchroom.model.Customer;
import com.searchroom.repository.CustomerRepository;
import com.searchroom.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void addCustomer(Customer customer) throws SQLException {
        customerRepository.addCustomer(customer);
    }

    public Customer getCustomerByUsername(String username) {
        return customerRepository.getCustomerByUsername(username);
    }

    public void updateCustomer(Customer customer) throws SQLException {
        customerRepository.updateCustomer(customer);
    }

}
