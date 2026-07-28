package com.hotel.service;

import com.hotel.entity.Customer;
import java.util.List;

public interface CustomerService {

    List<Customer> getAll();

    Customer getById(Long id);

    Customer save(Customer customer);

    Customer update(Long id, Customer customer);

    void delete(Long id);
}